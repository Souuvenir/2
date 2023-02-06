
--prueba 3
SELECT EMPLOYEE_ID AS "NUMERO EMPLEADO", FIRST_NAME AS "PRIMER NOMBRE", LAST_NAME AS "APELLIDO", REPLACE(J.JOB_TITLE,'Programmer','IT') AS "NOMBRE DEPARTAMENTO" 
FROM EMPLOYEES e JOIN JOBS j
ON e.JOB_ID = j.JOB_ID
WHERE e.JOB_ID = (SELECT JOB_ID FROM JOBS j WHERE JOB_TITLE = 'Programmer')
ORDER BY EMPLOYEE_ID DESC;


CREATE VIEW V_EMPLEADOS_110 AS SELECT EMPLOYEE_ID AS "ID_EMPLEADO", (first_name| |'  '| | last_name) AS "NOMBRE COMPLETO", j.JOB_TITLE AS "NOMBRE_TRABAJO", SALARY AS "SALARIO"
FROM EMPLOYEES e JOIN JOBS j
ON e.JOB_ID = j.JOB_ID
WHERE e.DEPARTMENT_ID = 110 ;

SELECT * FROM V_EMPLEADOS_110;

SELECT r.REGION_NAME AS "REGION GEOGRAFICA", COUNTRY_ID AS "IDENTIFICADOR PAIS" ,COUNTRY_NAME AS "NOMBRE PAIS"
FROM COUNTRIES c NATURAL JOIN REGIONS r
WHERE r.REGION_NAME = 'Americas' AND c.COUNTRY_ID IN (SELECT COUNTRY_ID  FROM DEPARTMENTS d NATURAL JOIN LOCATIONS l WHERE l.CITY != 'Mexico City');


SELECT DEPARTMENT_ID AS " NUMERO DEPARTAMENTO", DEPARTMENT_NAME AS "NOMBRE DEPARTAMENTO", l.STREET_ADDRESS "DIRECCION", l.CITY "CIUDAD" 
FROM DEPARTMENTS d NATURAL JOIN LOCATIONS l   
WHERE l.CITY != 'Seattle';


SELECT DEPARTMENT_NAME AS "GERENTE DEPARTAMENTO", CASE 
													WHEN e.FIRST_NAME IS NOT NULL AND e.LAST_NAME IS NOT NULL THEN e.FIRST_NAME | |' '| | e.LAST_NAME
													ELSE 'VACANTE' 
												  END AS "NOMBRE COMPLETO"
FROM DEPARTMENTS d LEFT JOIN EMPLOYEES e 
ON d.MANAGER_ID = e.EMPLOYEE_ID;


SELECT * FROM DEPARTMENTS d  ;
SELECT * FROM LOCATIONS l  ;
SELECT * FROM COUNTRIES c ;
--SELECT * FROM EMPLOYEES e  ;

--examen 

--requerimiento 1
SELECT EMPLOYEE_ID AS "NUMERO EMPLEADO", FIRST_NAME AS "PRIMER NOMBRE", LAST_NAME AS "APELLIDO", REPLACE(J.JOB_TITLE,'Sales Manager','Sales') AS "NOMBRE DEPARTAMENTO" 
FROM EMPLOYEES e JOIN JOBS j
ON e.JOB_ID = j.JOB_ID
WHERE e.JOB_ID = (SELECT JOB_ID FROM JOBS j WHERE JOB_TITLE = 'Sales Manager')
ORDER BY EMPLOYEE_ID DESC;

--requerimiento 2

CREATE VIEW V_EMPLEADOS_80 AS SELECT EMPLOYEE_ID AS "ID_EMPLEADO", (first_name| |'  '| | last_name) AS "NOMBRE COMPLETO", j.JOB_TITLE AS "NOMBRE_TRABAJO", SALARY AS "SALARIO", EMAIL AS "EMAIL"
FROM EMPLOYEES e JOIN JOBS j
ON e.JOB_ID = j.JOB_ID
WHERE e.DEPARTMENT_ID = 80;

SELECT * FROM V_EMPLEADOS_80;

--requerimiento 3
SELECT r.REGION_NAME AS "REGION GEOGRAFICA", COUNTRY_ID AS "IDENTIFICADOR PAIS" ,COUNTRY_NAME AS "NOMBRE PAIS"
FROM COUNTRIES c NATURAL JOIN REGIONS r
WHERE r.REGION_NAME = 'Europe' AND c.COUNTRY_ID IN (SELECT COUNTRY_ID  FROM DEPARTMENTS d NATURAL JOIN LOCATIONS l WHERE l.CITY != 'Roma');

--requerimiento 4
SELECT DEPARTMENT_ID AS " NUMERO DEPARTAMENTO", DEPARTMENT_NAME AS "NOMBRE DEPARTAMENTO", l.STREET_ADDRESS "DIRECCION", l.CITY "CIUDAD" 
FROM DEPARTMENTS d NATURAL JOIN LOCATIONS l   
WHERE l.CITY != 'Seattle';

--requerimiento 5
SELECT DEPARTMENT_NAME  AS "NOMBRE DEPARTAMENTO", CASE 
													WHEN e.FIRST_NAME IS NOT NULL AND e.LAST_NAME IS NOT NULL THEN e.FIRST_NAME | |' '| | e.LAST_NAME
													ELSE 'VACANTE' 
												  END AS "GERENTE DEPARTAMENTO"
FROM DEPARTMENTS d LEFT JOIN EMPLOYEES e 
ON d.MANAGER_ID = e.EMPLOYEE_ID
ORDER BY d.MANAGER_ID DESC;