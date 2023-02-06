SELECT LAST_NAME, FIRST_NAME, salary
FROM EMPLOYEES ORDER BY SALARY DESC;
SELECT LAST_NAME, FIRST_NAME, EMAIL
FROM EMPLOYEES WHERE EMPLOYEES_ID BETWEEN 150 AND 170; 
SELECT LAST_NAME, FIRST_NAME, EMAIL, PHONE_NUMBER
FROM EMPLOYEES WHERE FIRST_NAME LIKE 'K%';
SELECT FIRST_NAME AS "NOMBRES", LAST_NAME AS "APELLIDOS", EMAIL AS "CORREO", SALARY AS "SALARIO"
FROM EMPLOYEES WHERE SALARY < 15000  AND EMAIL NOT LIKE 'K%' ORDER BY SALARY ASC;

/*Para comenzar el proceso de resolucion de los requerimientos de la prueba lo primeor que hice fue lo siguiente:*/
/*1.- el primer paso fue resetear la contraseña del HR porque se me habia olvidado, edité el usuario desde system y puede cargarla a mi proyecto prueba.*/
/*2.-Leer los requerimientos e idenfitificar los comandos a utilizar e ir implementandolos para cumplir con lo que se pide en la prueba y en un formato ordenado.*/
/*3.- y como ultimo paso lo que hice fue revisar la escala de apreciacion a ver si es que me faltaba implementar alguna cosa.*/

