------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all they need to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: EVALUACION2  
PURPOSE OF PROJECT:
VERSION or DATE: 10/06/2022
HOW TO START THIS PROJECT:
AUTHORS:Nathalia Busnego
Descripcion: Para este encargo comencé como lo hago generalmente
leyendo cuidadosamente los enunciados y el contexto planteado. Debido
a que es un poco mas extenso el contexto que la prueba anterior fue
un poco mas complicado visualizar bien las soluciones logicas a cada 
unos de los requerimientos, pero como primera instancia para el método 
agregar material:
en lineas generales solo se pedian validar todos los casos posibles de las 
cantidades y contenedores, por lo que en primer lugar validé si es que ambas 
variables eran mayores que 0 y se retornara un mensaje diciendo que los 
parametros son validos.
Y por consiguiente en los casos contrarios usé un else y ifs anidados dentro 
de este, para validar si alguno de los 2 no son suficientes o que ninguno sea 
suficiente, y que especificara en el return cual parametro era insuficiente 
dependiendo del caso.

Para el segundo requerimiento metodo fabricar: se modificó la clase añadiendose
una variable llamada cantidadMinima de tipo int, que especificará el minimo de materiales necesarios para fabricar 
un producto (tiene un valor de 2). Con esta misma variable es que se pudo llevar
a cabo la validacion de la cracion o a su vez el fallo al momento de crear un producto.
Recorriendo el arreglo con un for each, al que tambien se le añadió la creacion de un numero aleatorio
entre 0 y 9 para efectos de probar si la logica aplicada efectivamente funcionaba.
Por lo que si el numero resultante del random era mayor que 2, se le añade
al stringBuilder estados y a salida la palabra exito, si en su defecto el resultado del random
es menor a 2, se le añadirá a las variables la palabra fallo, a estados se le añadira la cadena 
de texto: falló por cantidad insuficiente de metales. Por ultimo, se retorna en salida el resultado
de todos los intentos de fabricacion del ciclo.
Para los ultimos 2 requerimientos los cuales requieren de la misma logica ambos:
Recorrer una lista, comparar con su correspondiente palabra exito o fallo
los resultados e ir sumando 1 a sus respectivos contadores. 

