# Examen_TecnicasProgramacion
### AVISO: En el zip faltan las clases de los ejercicios 5,6 y 7 ya que se añadieron al repositorio pasada la fecha de entrega
### Enlace al repositorio: https://github.com/itsedupablo/Examen_TecnicasProgramacion
## Ejercicio 8
### Descipción
Implementar un grafo no dirigido que permita cargar puertos y las aristas que conecten dichos puertos, que permita resolver las siguientes tareas:
a. cada arista debe tener la distancia que separa dichos puertos;
b. realizar un barrido en profundidad desde el primer puerto en el grafo;
c. determinar el camino más corto desde puerto Madero al puerto de Rodas;
d. determinar el puerto con mayor número de aristas y eliminarlo.
### Implementación código
Para realizar este ejercicio primero he creado un grafo, a partir de las clases **Puerto**, que hace la función de nodo y tiene almacena la información de un nodo particular (id, nombre), **Ruta**, que hace la función de arista y almacena la información de una arista particular (nodos de origen y destino y peso en distancia) y la propia clase **Grafo** que depende de las 2 anteriores, y cuenta con una matriz de adyacencia que representa las conexiones entre nodos, una tabla con los nombres de cada nodo y el número de nodos del grao. Además también cuenta con los métodos propios de la clase para poder acceder a sus atributos privados, y los métodos que implementan los algoritmos de DFS, Dijkstra y para eliminar el nodo con más aristas.
Finalmente la clase **Main** que cuenta con un menú deonde el usuario puede visualizar los resultados de la utilización de cada algoritmo.
### Enlace a código y diagramas UML: https://github.com/itsedupablo/Examen_TecnicasProgramacion/tree/main/Ejercicio8
