
SELECT * FROM DEPARTMENTS d  ;
SELECT * FROM EMPLOYEES e  ;

-----------------------------------------------------------------------------------------------------------------------------------------------------------
--requerimiento 1
DECLARE 
V_TOTAL_DEP NUMBER (3);
V_DEP CHAR (40);
BEGIN
SELECT COUNT(*)
INTO V_TOTAL_DEP
FROM EMPLOYEES e
WHERE e.DEPARTMENT_ID = 100;
SELECT d.DEPARTMENT_NAME  
INTO V_DEP
FROM DEPARTMENTS d 
WHERE DEPARTMENT_ID = 100;
DBMS_OUTPUT.PUT_LINE('En el departamento '|| TRIM (V_DEP) ||' trabajan ' || TRIM (V_TOTAL_DEP) || ' empleados');
END;

SELECT COUNT(*)
FROM EMPLOYEES e
WHERE e.DEPARTMENT_ID = 100;

--requerimiento 2
DECLARE
    V_EMP_ID NUMBER(3);
    V_SALARY NUMBER(6);
    V_COUNT NUMBER(3) := 100;
BEGIN
    WHILE V_COUNT <= 130 LOOP
        SELECT EMPLOYEE_ID, SALARY
        INTO V_EMP_ID, V_SALARY
        FROM EMPLOYEES
        WHERE EMPLOYEE_ID = V_COUNT;
        IF V_SALARY > 10000 THEN
            dbms_output.put_line('El salario actual del empleado ' || V_EMP_ID || ' es de ' || V_SALARY || '. ' || 'Es un buen sueldo');
        ELSIF V_SALARY <= 10000 AND V_SALARY >= 9000 THEN
            dbms_output.put_line('El salario actual del empleado ' || V_EMP_ID || ' es de ' || V_SALARY || '. ' || 'Es un salario normal');
        ELSIF V_SALARY < 9000 THEN
            dbms_output.put_line('El salario actual del empleado ' || V_EMP_ID || ' es de ' || V_SALARY || '. ' || 'Es un salario que se debe aumentar');
        ELSE  dbms_output.put_line('error' || V_SALARY);
        END IF;
        V_COUNT := V_COUNT +1;
    END LOOP;
END;

--requerimiento 3
DECLARE
    V_MSJ VARCHAR2(10);
    V_PROM NUMBER(4);
    V_NOMBRE VARCHAR(10); -- SE DECLARA LA VARIABLE CON EL FORMATO CORRECTO VARCHAR
    V_COUNT NUMBER; 
BEGIN

    SELECT ROUND(AVG(SALARY),0), DEPARTMENT_NAME, SUM(SALARY)
        INTO V_PROM, V_NOMBRE, V_COUNT
        FROM EMPLOYEES JOIN DEPARTMENTS
        USING (DEPARTMENT_ID)
        GROUP BY  DEPARTMENT_NAME,DEPARTMENT_ID
        HAVING DEPARTMENT_ID =:INGRESE_ID_DEPARTAMENTO; -- SE CAMBIA SIMBOLO '&' CAMBIADO A ':' 

        IF SQL%FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Se seleccionaron: ' || SQL%ROWCOUNT || ' filas');
            ELSE
            DBMS_OUTPUT.PUT_LINE('No se ha seleccionado nada');
        END IF;
       DBMS_OUTPUT.PUT_LINE(' '|| V_PROM);
      
	V_MSJ := CASE --SE ELIMINA EL NOMBRE DE LA VARIABLE EN EL COMIENZO DE LA DECLARACION DEL CASE
                WHEN V_PROM<5000 THEN 'Excelente'
                WHEN V_PROM<3000 THEN 'Bueno'
                WHEN V_PROM<1000 THEN 'Inaceptable'
                ELSE '-'
            END;
    DBMS_OUTPUT.PUT_LINE ('Su valoracion es: ' || V_MSJ || chr(10) ||' ,el valor promedio es: '
                        || TO_CHAR(V_PROM,'$99,999.99') || chr(10) --SE AGREGA TO CHAR PARA EL FORMATO CORRECTO DE LOS NUMEROS
                        || ' , el nombre del departamento es:  '
                        || V_NOMBRE);

END;

--requerimiento 4
DECLARE
    CANT_EMPLEADOS NUMBER(10);
    MEN_SAL_EMP VARCHAR2(10);
    PROM NUMBER(19);
    ID_DPTO NUMBER(19);
    NOM_DPTO VARCHAR2(10);
    ID_JEFE NUMBER(10);
    UBICACION NUMBER(19);
    
BEGIN
       
	SELECT COUNT(DEPARTMENT_ID)
        INTO  CANT_EMPLEADOS
        FROM EMPLOYEES WHERE DEPARTMENT_ID = 50;
       
    SELECT FIRST_NAME ||  ' ' || LAST_NAME 
        INTO MEN_SAL_EMP
        FROM EMPLOYEES WHERE SALARY = (SELECT MIN(SALARY) FROM EMPLOYEES);
       
    SELECT ROUND(AVG(SALARY * NVL(COMMISSION_PCT,0)))
        INTO PROM
        FROM EMPLOYEES;
       
    SELECT ID_DEPTO
    	INTO ID_DPTO
		FROM CANT_EMP_DEPTO
		WHERE CANTIDAD_EMPLEADOS =(SELECT MAX (CANTIDAD_EMPLEADOS)
		FROM (SELECT DEPARTMENT_ID AS ID_DEPTO, COUNT(*) AS CANTIDAD_EMPLEADOS
    	FROM EMPLOYEES
    	GROUP BY DEPARTMENT_ID
    	HAVING COUNT(*)>1
    	ORDER BY COUNT(*) DESC));

    SELECT DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID 
    INTO NOM_DPTO, ID_JEFE, UBICACION
    FROM DEPARTMENTS d 
    WHERE DEPARTMENT_ID  = ID_DPTO;
   
    DBMS_OUTPUT.PUT_LINE('En el departamento Shipping trabajan ' || CANT_EMPLEADOS || ' empleados.');
    DBMS_OUTPUT.PUT_LINE(MEN_SAL_EMP || ' es el empleado con el salario mas bajo');
    DBMS_OUTPUT.PUT_LINE('El promedio de las comisiones es' || TO_CHAR(PROM,'$99,999'));
    DBMS_OUTPUT.PUT_LINE('La informacion del departamento con mayor cantidad de empleados es la siguiente: ' || chr(10) ||
                         ' Identificacion: ' || ID_DPTO || chr(10) ||
                         ' Nombre: ' || NOM_DPTO || chr(10) ||
                         ' Jefe: ' || ID_JEFE || chr(10) ||
                         ' Ubicacion: ' || UBICACION
        );
END;