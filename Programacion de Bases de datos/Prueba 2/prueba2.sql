
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
SELECT * 
FROM PERSONAS p ;
SELECT * FROM DETALLE_FACTURAS df;
DELETE FROM DETALLE_FACTURAS df WHERE df.FOLIO = 11;
select * from user_errors where type = 'TRIGGER' and name = 'NEWALERT'
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE OR REPLACE TRIGGER detalle_factura_ins  
BEFORE INSERT  
ON DETALLE_FACTURAS
FOR EACH ROW
DECLARE 
   V_NETO number;
   V_IVA number;
   V_TOTAL number;
BEGIN  
   SELECT VALOR_NETO 
	   INTO V_NETO  
	   FROM FACTURAS f
   WHERE f.FOLIO = :NEW.FOLIO ;
   V_NETO := V_NETO + :NEW.SUBTOTAL_DETALLE;
   V_IVA := V_NETO * 0.19;
   V_TOTAL := V_NETO + V_IVA;
   UPDATE FACTURAS 
   SET VALOR_NETO = V_NETO,
   	   IVA = V_IVA,
   	   TOTAL = V_TOTAL
   WHERE FOLIO = :NEW.FOLIO; 
END; 

INSERT 
INTO FACTURAS (FOLIO, FECHA, ID_VENDEDOR, CLIENTE, VALOR_NETO, IVA, DESCUENTO, TOTAL)
VALUES (11 ,SYSDATE, 4, 26624573, 0, 0, 0, 0);

INSERT 
INTO DETALLE_FACTURAS (FOLIO, ID_PRODUCTO, CANTIDAD, SUBTOTAL_DETALLE)
VALUES (11, 2, 1, 17866141);
----------------------------------------------------------------------------------requerimiento 2---------------------------------------------------------------------------------------------------------------------
DECLARE 
CURSOR p_comuna IS
	SELECT COMUNA AS ID_COMUNA, COUNT (*) AS C_PERSONAS
		FROM PERSONAS p 
	GROUP BY p.COMUNA ; 

V_COMUNAS NUMBER;
V_C_PERSONAS NUMBER;
N_COMUNAS VARCHAR(75);
N_REGIONES VARCHAR(75);

BEGIN
	OPEN p_comuna;
	LOOP	
		FETCH p_comuna INTO V_COMUNAS, V_C_PERSONAS;
		EXIT WHEN p_comuna%NOTFOUND;
		SELECT c.NOMBRE, r.NOMBRE 
		INTO N_COMUNAS, N_REGIONES
		FROM COMUNAS c
		INNER JOIN REGIONES r ON r.ID_REGION = c.ID_REGION
		WHERE c.ID_COMUNA = V_COMUNAS;
		DBMS_OUTPUT.PUT_LINE('COMUNA: ' || N_COMUNAS || ' REGION: ' || N_REGIONES || ' CANTIDAD REGISTRADOS: ' || V_C_PERSONAS);
	END LOOP;
CLOSE p_comuna;
END;
----------------------------------------------------------------------------------requerimiento 3------------------------------------------------------------------------------------------------
DECLARE 
CURSOR c_vendedores IS
	SELECT SUBSTR(PRIMER_NOMBRE, 1, 2) AS PRIMER_NOMBRE, PRIMER_APELLIDO, ID_VENDEDOR 
		FROM VENDEDORES v JOIN PERSONAS p 
		ON v.RUT = p.RUT; 

V_PRIMER_NOMBRE VARCHAR(2);
V_PRIMER_APELLIDO VARCHAR(75);
V_ID_VENDEDOR NUMBER;

BEGIN
	OPEN c_vendedores;
	LOOP	
		FETCH c_vendedores INTO V_PRIMER_NOMBRE, V_PRIMER_APELLIDO, V_ID_VENDEDOR;
		EXIT WHEN c_vendedores%NOTFOUND;
	UPDATE VENDEDORES
	SET EMAIL = V_PRIMER_NOMBRE||'.'||V_PRIMER_APELLIDO ||'@iplacex.cl'
	WHERE ID_VENDEDOR = V_ID_VENDEDOR;
	
	END LOOP;
CLOSE c_vendedores;
END;

SELECT * FROM VENDEDORES v;

-----------------------------------------------------------------------------------requerimiento 4--------------------------------------------------------------------------------------------------------
DECLARE 
CURSOR c_facturas IS
	SELECT FOLIO 
		FROM FACTURAS f
		WHERE f.VALOR_NETO = 0; 

	V_FOLIO NUMBER;
	V_VALOR_NETO NUMBER;
	V_IVA NUMBER;
	V_TOTAL NUMBER;

BEGIN
	OPEN c_facturas;
	LOOP	
		FETCH c_facturas INTO V_FOLIO;
		EXIT WHEN c_facturas%NOTFOUND;
		SELECT SUM (SUBTOTAL_DETALLE) INTO V_VALOR_NETO
		FROM DETALLE_FACTURAS df
		WHERE df.FOLIO = V_FOLIO;
		
		V_IVA := V_VALOR_NETO * 0.19;
		V_TOTAL := V_VALOR_NETO + V_IVA;
	
	UPDATE FACTURAS  
	SET VALOR_NETO = V_VALOR_NETO, IVA = V_IVA, TOTAL = V_TOTAL
	WHERE FOLIO = V_FOLIO;
	
	END LOOP;
CLOSE c_facturas;
END;

SELECT * FROM FACTURAS f ;
--Prueba3--
-----------------------------------------------------------------------------------requerimiento 1--------------------------------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE SP_SUELDOS(ANIO NUMBER, MES NUMBER)
IS
BEGIN 
END SP_CL_SUELDOS;

CREATE OR REPLACE PROCEDURE SP_INSERT_PERSONA(RUT NUMBER, NOMBRE NUMBER)
IS 
BEGIN 
	INSERT INTO HR.PERSONAS
	(RUT, DIGITO_V, PRIMER_NOMBRE, SEGUNDO_NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, FECHA_NACIMIENTO, DIRECCION, COMUNA, NACIONALIDAD, TELEFONO, EMAIL)
	VALUES(RUT, NOMBRE, '', '', '', '', '', '', 0, '', '', '');
END SP_INSERT_PERSONA;




SELECT * FROM COMISIONES c;
































