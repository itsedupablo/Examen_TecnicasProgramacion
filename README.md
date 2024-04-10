# Examen_TecnicasProgramacion
### AVISO: En el zip faltan el código java y diagramas UML de los ejercicios 5, 6 y 7 ya que se añadieron al repositorio pasada la fecha de entrega establecida.
### Enlace al repositorio: https://github.com/itsedupablo/Examen_TecnicasProgramacion
## Ejercicio 5 
### Descipción
Se propone una extensión del juego hundir la flota en la que, en vez de jugar con un solo tipo de barco, se pueda jugar con tres tipos de barcos diferentes. Estos tres tipos diferentes de barcos van a ser acorazados (Battleship), fragatas (Frigates), y canoas (Canoes).
En base a estas especificaciones se solicita que:
Programe una clase Battleship. Este barco es grande y fuerte con un tamaño fijo (es decir, su tamaño va a ser igual a 5 posiciones del tablero). Además, este barco especial tiene contenedores aislados, por lo tanto, necesita que toquen todas sus posiciones aisladas para hundirlo y requiere de la creación de los atributos correspondientes para controlar esta casuística. La implementación al ser atacado deberá ser modificada.
Programe una clase Frigate. Este barco es mediano con un tamaño fijo (es decir, su tamaño va a ser igual a 3 posiciones del tablero).
Programe una clase Canoe. Este barco es pequeño con un tamaño fijo (es decir, su tamaño va a ser igual a 1 posiciones del tablero).
Reutilize tanto código como sea posible del ejercicio 4 para hacer esta extensión del juego.
No es necesario implementar el docString correspondiente a las funciones y métodos desarrollados, aunque se recomienda hacerlo para facilitar la comprensión por parte del 
estudiante.
## Ejercicio 6 
### Descipción
En este ejercicio se pide que se implemente el módulo principal del juego hundir la flota. Este módulo va a implementar la partida que van a jugar los jugadores.
En este módulo main, lo primero que se hace es obtener la configuración deseada de los barcos por parte de cada usuario sobre el tablero. Hay que tener en cuenta, que cada usuario solamente va a tener como máximo tres barcos en el tablero al iniciar la partida. La configuración de cada usuario va a ser introducida por consola
Seguidamente, una vez que se tienen las configuraciones, el juego puede comenzar entre los jugadores. En cada turno cada jugador va a atacar al otro jugador en una posición aleatoria. Cuando uno de los dos usuarios tenga ya todos sus barcos hundidos al acabar el turno, se acaba el juego y se indica quien es el ganador. En el caso de que los dos acaben sin barcos en el mismo turno, el juego indicará un empate. En cada turno los dos usuarios atacan con independencia de si sus barcos están hundidos.
Recuerde utilizar las clases implementadas tanto en el ejercicio 4 como en el ejercicio 5 para implementar todos los componentes de este juego.
El diagrama de flujo de este módulo principal le ha sido proporcionado a modo de guía.
### Implementación código ejercicios 5 y 6.
Para realizar este ejercicio he reciclado el ejercicio de hundir la flota que hice en una de las entregas, que contaba con las siguientes clases:
1. Barco. Clase que permite crear instancias de tipo barco
2. Jugador. Clase que permite crear instancias de tipo jugador
3. Tablero. Clase que permite crear un tablero para cada jugador de la partida.
En primer lugar modificamos la clase barco y la hacemos de tipo abstracto para impedir la creación de instancias de ese tipo y poder hacer subclases que hereden.
A continuación creamos las clases Battleship, Frigate y Canoe que nos permiten crear instancias especializadas de tipo Barco.
Para crear las instancias de cada tipo de barco se ha decidido la utilización del modelo creacional "Abstract Factory", con lo que se ha creado un interfaz **ShipFactory** que será implementada por las clases **BattleshipFactory**, **FrigateFactory** y **CanoeFactory**, que son fábricas concretas que crearán cada tipo de barco según se necesite.
Finalmente se ha creado la clase **HundirLaFlota**, la cual contiene el método main y permite al usuario jugar partidas del juego introduciendo las coordenadas del tablero del contrincante.
### Pseudocódigo del main:
```
Función main(String[] args):
   Crear e inicializar instancias de jugadores (1 y 2)
   Crear e inicializar instancias de tableros (1 y 2)
   Crear barcos para cada jugador --> Función crearBarcos(Jugador jugador)
   Colocar barcos en el tablero de cada jugador
   Mientras niguno de los jugadores haya perdido --> Función realizarMovimiento(Jugador atacante, Tablero tableroOponente)
   Si uno de los jugadores ha perdido:
        Mostrar "¡El Jugador X ha ganado!"
        Mostrar "Tablero del jugador Y"

Función crearBarcos(Jugador jugador):
    Crear e inicializar "concrete factories"
    Crear e inicializar Lista: barcos
    # Crear 1 battleship, 2 frigates y 3 canoes:
    barcos.add(factoriasConcretas.crearBarco())
      para cada barco en barcos:
           jugador.addBarco(barco)

Función realizarMovimiento(atacante, tableroOponente):
    Mostrar tableroOponente
    Mientras no haya una entrada válida:
        Intentar:
            Mostrar "Ingresa las coordenadas del ataque (fila columna): "
            Leer fila y columna desde la entrada estándar
            inputValido = Verdadero
        Capturar InputMismatchException:
            Mostrar "Entrada inválida. Debe ingresar números enteros."
            Leer y descartar la entrada incorrecta
        
    Si la fila o columna están fuera del rango del tablero:
        Mostrar "Coordenadas inválidas (se salen de rango). Inténtalo de nuevo."
        Realizar un nuevo movimiento(atacante, tableroOponente)
        Devolver
        
    tableroOponenteArray = Obtener el array de tablero de tableroOponente
    Si el elemento en la fila y columna del tableroOponenteArray está OCUPADO:
        Mostrar "¡Impacto! El ataque fue exitoso."
        Por cada barco en los barcos de atacante:
            Si el barco recibe el ataque en la fila y columna:
                Salir del bucle
    Sino:
        Mostrar "¡Agua! El ataque fue fallido."
        Marcar el elemento en la fila y columna del tableroOponenteArray como 'O'
        Actualizar el tableroOponente con tableroOponenteArray
```
### Enlace a código y diagramas UML: https://github.com/itsedupablo/Examen_TecnicasProgramacion/tree/main/Ejercicios5-6
## Ejercicio 7
### Descipción
Escribir un algoritmo que permita utilizar tres tablas hash para guardar los datos de barcos, que contemple las siguientes actividades:
a. En la primera tabla hash la función hash debe ser sobre el tipo de barco, en la segunda tabla la función hash deberá utilizar el número del barco como clave, mientras que en la tercera el campo clave de la función hash será por el nombre del barco.
b. El tamaño de la primera tabla debe ser lo suficientemente grande como para que pueda almacenar todos los distintos tipos de barcos, debe manejar las colisiones con alguna función de sondeo.
c. El tamaño de cada una de las segundas tablas debe ser 15.
d. El algoritmo debe permitir cargar tipos de barcos en la primera tabla y crear su respectiva segunda tabla, en el caso de que no exista.
e. Si el barco es de más de un tipo deberá cargarlo en cada una de las tablas que indiquen estos tipos.
f. Deberá permitir cargar barcos de los cuales se dispone de su número, nombre, tipo y nivel.
### Implementación código
Para realizar este ejercicio se ha reciclado el código del ejercicio de hundir la flota pero se le hacen algunas modificaciones.
1. Se añaden los atributos tipo, número de barco, nombre y nivel a la clase **Barco**.
2. Se hace instanciable la clase barco para poder crear barcos sin tipo específico.
3. Se añade el método toString a la clase **Barco**.
4. Se eliminan los atributos y métodos que no van a usarse (getters, setters, etc)
Además se añade la clase **GestionBarcos** donde se crean y utilizan las tablas indicadas en el enunciado. Se crean además 3 métodos:
- **funcionHash**. Genera un número entero que determinará el índice una tabla determinada donde se cargará un barco, según la clave.
- **addBarco**. Permite añadir un barco a todas las tablas según distintos criterios.
Además se cuenta con un método **main** para poder probar el funcionamiento del programa.
### Pseudocódigo del algoritmo (función hash)
```
funcionHash(Objecto clave, int tamaño de la tabla):
	    entero hash <- 0

	    si clave es null:
	        devolver 0; 
	     si clave es un número entero:
            hash <- clave
	     si clave es una cadena str:
	        desde i = 0 hasta longitud de la cadena, incrementando i en 1:
	            hash <- 31 * hash + caracter de la cadena en cada it
        si no:
	        hash <- clave.hashCode()
	    
       devolver hash % tamaño de la tabla	
```
### Enlace a código y diagramas UML:
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
