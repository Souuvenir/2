

CREATE OR REPLACE PROCEDURE sumador(ano IN NUMBER, mes IN NUMBER, sueldos OUT NUMBER, comisiones OUT NUMBER, total_a_pagar OUT NUMBER)
IS
cotizaciones number;
BEGIN 
	SELECT SUM(SUELDO_BASE) INTO sueldos 
	FROM VENDEDORES;

	SELECT coalesce(SUM(C.VALOR_COMISION), 0) INTO comisiones 
	FROM COMISIONES C 
	JOIN FACTURAS F ON F.FOLIO = C.FOLIO  
	WHERE EXTRACT(YEAR FROM F.FECHA) = ano AND EXTRACT(MONTH FROM F.FECHA) = mes;

	cotizaciones := (sueldos + comisiones) * 0.21;
	total_a_pagar := sueldos + comisiones + cotizaciones; 
END sumador;

DECLARE 
sueldos NUMBER;
comisiones NUMBER;
total_a_pagar NUMBER;
BEGIN 
	sumador(2015, 1, sueldos, comisiones, total_a_pagar);
	DBMS_OUTPUT.PUT_LINE('total a pagar:' || total_a_pagar);
END;
--2
CREATE OR REPLACE PROCEDURE jubil(p_jubil OUT NUMBER, p_jubil_t OUT NUMBER)
IS
BEGIN 
	SELECT COUNT(*) INTO p_jubil FROM PERSONAS p WHERE substr(((sysdate-5)-p.FECHA_NACIMIENTO)/365,1,2) > 65;

	SELECT COUNT(*) INTO p_jubil_t FROM PERSONAS p JOIN VENDEDORES v on v.RUT = p.RUT WHERE substr(((sysdate-5)-p.FECHA_NACIMIENTO)/365,1,2) > 65; 
END jubil;


DECLARE 
	p_jubil NUMBER;
	p_jubil_t NUMBER;
BEGIN
	jubil(p_jubil, p_jubil_t);
	DBMS_OUTPUT.PUT_LINE('PERSONAS CON 65 ANOS: ' || p_jubil || ' ---- CANTIDAD DE TRABAJADORES: ' || p_jubil_t);
END;


--3
CREATE OR REPLACE PROCEDURE cuenta_comunas(numero_de_comunas OUT NUMBER)
IS 
BEGIN 
	select sum(parasumar) into numero_de_comunas 
	from (select count(*), case when count(*) > 1 then 1 else 1 end parasumar
		from personas group by comuna);
END cuenta_comunas;

DECLARE 
	numero_de_comunas NUMBER;
BEGIN
	cuenta_comunas(numero_de_comunas);
	DBMS_OUTPUT.PUT_LINE('CANTIDAD DE COMUNAS DISTINTAS: ' || numero_de_comunas);
END;
--4
CREATE OR REPLACE PROCEDURE ins_persona(RUT NUMBER, DIGITO CHAR, P_NOMBRE VARCHAR2, S_NOMBRE VARCHAR2, P_APELLIDO VARCHAR2, S_APELLIDO VARCHAR2, F_NACIMIENTO DATE, DIRECCION VARCHAR2, COMUNA NUMBER, NACIONALIDAD VARCHAR2, TELEFONO VARCHAR2, EMAIL VARCHAR2)
IS 
BEGIN 
	INSERT INTO PERSONAS
	VALUES(RUT,DIGITO, P_NOMBRE, S_NOMBRE, P_APELLIDO, S_APELLIDO, F_NACIMIENTO, DIRECCION , COMUNA , NACIONALIDAD , TELEFONO , EMAIL);
END ins_persona;
 
BEGIN
	ins_persona(3,'5', 'Juana', 'Ana', 'Castro', 'Perez',TO_DATE('05/15/90','MM/DD/YY'), 'Avenida siempre viva', 1, 'ch', '+569123456', 'j.c.p@gmail.com');
END;

--5

CREATE OR REPLACE PACKAGE packa_prueba IS 
	PROCEDURE ins_producto(ID_PRODUCTO NUMBER, MARCA VARCHAR2, MODELO VARCHAR2, DESCRIPCION VARCHAR2, VALOR_UNITARIO NUMBER);
	PROCEDURE ins_vendedor(ID_V NUMBER, SUELDO_BASE NUMBER, RUT NUMBER, DIGITO_V CHAR, P_NOMBRE VARCHAR2, S_NOMBRE VARCHAR2, P_APELLIDO VARCHAR2, S_APELLIDO VARCHAR2, F_NACIMIENTO DATE, DIRECCION VARCHAR2, COMUNA NUMBER, NACIONALIDAD VARCHAR2, TELEFONO VARCHAR2, EMAIL VARCHAR2);
	FUNCTION funcion_vendedores RETURN NUMBER;
	FUNCTION funcion_personas RETURN NUMBER;
END packa_prueba;

CREATE OR REPLACE PACKAGE BODY packa_prueba IS 

PROCEDURE ins_producto(ID_PRODUCTO NUMBER, MARCA VARCHAR2, MODELO VARCHAR2, DESCRIPCION VARCHAR2, VALOR_UNITARIO NUMBER) IS
BEGIN 
	INSERT INTO HR.PRODUCTOS
	VALUES(ID_PRODUCTO, MARCA, MODELO, DESCRIPCION, VALOR_UNITARIO);
END ins_producto;

PROCEDURE ins_vendedor(ID_V NUMBER, SUELDO_BASE NUMBER, RUT NUMBER, DIGITO_V CHAR, P_NOMBRE VARCHAR2, S_NOMBRE VARCHAR2, P_APELLIDO VARCHAR2, S_APELLIDO VARCHAR2, F_NACIMIENTO DATE, DIRECCION VARCHAR2, COMUNA NUMBER, NACIONALIDAD VARCHAR2, TELEFONO VARCHAR2, EMAIL VARCHAR2) IS 
BEGIN 
	INSERT INTO PERSONAS
	VALUES(RUT, DIGITO_V, P_NOMBRE, S_NOMBRE, P_APELLIDO, S_APELLIDO, F_NACIMIENTO, DIRECCION , COMUNA , NACIONALIDAD , TELEFONO , EMAIL);
	INSERT INTO HR.VENDEDORES
	VALUES(ID_V, RUT, EMAIL, SUELDO_BASE);
END ins_vendedor;

FUNCTION funcion_vendedores
RETURN NUMBER IS 
vendedores_total number;
vendedores_con_ventas number;
vendedores_sin_ventas NUMBER;
BEGIN 
	select SUM(parasumar) into vendedores_con_ventas
	from (SELECT count(v.ID_VENDEDOR),  case when count(v.ID_VENDEDOR) > 1 then 1 else 1 end parasumar FROM VENDEDORES V JOIN COMISIONES c ON c.VENDEDOR = v.ID_VENDEDOR); 

	select count(*) into vendedores_total
	from VENDEDORES v2;
	vendedores_sin_ventas := vendedores_total - vendedores_con_ventas ;
RETURN vendedores_sin_ventas;
END funcion_vendedores;

FUNCTION funcion_personas
RETURN NUMBER IS
personas_totales number;
personas_con_compras number;
personas_sin_compras NUMBER;
BEGIN 
	select SUM(parasumar) into personas_con_compras
	from (SELECT count(p.rut), case when count(p.rut) > 1 then 1 else 1 end parasumar FROM PERSONAS p join FACTURAS f on f.CLIENTE = p.RUT group by rut); 
	
	select count(*) into personas_totales from PERSONAS p;

	personas_sin_compras := personas_totales - personas_con_compras;
RETURN personas_sin_compras;
END funcion_personas;


END packa_prueba;

DECLARE
vendedores_sin_ventas NUMBER;
personas_sin_compras NUMBER;
BEGIN
	packa_prueba.ins_producto(88, 'mitsubishi', '345a', 'sedan', 40000000);
	packa_prueba.ins_vendedor(99, 123, 77777777, 7, 'carlos', 'perez', 'perez', 'perez', SYSDATE, 'av aaaa', 1, 'ze', '123456789', 'carlosperezperez@sadas.com');
	vendedores_sin_ventas := packa_prueba.funcion_vendedores;
	DBMS_OUTPUT.PUT_LINE(' cantidad de vendedores que hay en la base de
datos que no hubieran realizado ventas: ' || vendedores_sin_ventas);
	personas_sin_compras := packa_prueba.funcion_personas;
	DBMS_OUTPUT.PUT_LINE('cantidad de personas que hay en la base de datos
que no han comprado: ' || personas_sin_compras);
END;

