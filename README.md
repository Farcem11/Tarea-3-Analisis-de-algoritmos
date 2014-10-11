##Instituto Tecnológico de Costa Rica
##(TEC)

##Escuela de computación

##Curso: Análisis de algoritmos

##Tarea 3

##Profesor: Mauricio Rojas

##Estudiante: Fabian Arce Molina

##2013012811

##11/Octubre/2014
___
###Profe le adjunto el proyecto de NetBeans donde hice la tarea por cualquier cosa.
___
	1) La idea es resolver un problema hipotético donde se tienen tanto misioneros como caníbales en una isla, y deben llevarse en bote hasta otra isla. 
	El bote puede llevar como máximo 2 personas, como mínimo 1. 
	El bote no puede ir solo. 
	En cada isla no puede haber en un momento dado más caníbales que misioneros, porque si no los caníbales se los devoran. La tarea consiste en realizar una implementación en Java, usando las técnicas de backtracking para resolver el problema.

##Explicación del algoritmo:
___
> **CLASE BARCO:**
___
> Solo tiene un atributo booleano que me dice en que isla está el barco, si es true el barco está en la isla de la izquierda, si es false está en la derecha.
___
> **CLASE ISLA:**
___
> Tiene dos atributos de tipo int que representan la cantidad de caníbales y misioneros que tiene la isla.
___
> **CLASE ESTADO:**
___
> Tiene 4 atributos un barco, dos islas, que representan el estado en cual está el juego actualmente y un array de estados donde se guardan los estados visitados.
___
> **Métodos de la clase estado:**
___
> **Mostrar:** 

> Imprime un estado con la forma: 

> **II(C:3 M:3) ID(C:0 M:0) B:D**

> **II** es isla izquierda y dice que tiene 3 caníbales y 3 misioneros.

> **ID** es isla derecha y dice que no tiene ni caníbales ni misioneros.

> **B** es el barco cuando dice "D" es que esta en la isla derecha y cuando dice "I" es que esta en la izquierda.
___
> **MismosEstados:**

> Toma dos estados y los compara a ver si son iguales.
___
> **EstadoYaVisitado:**

> Verifica que un estado no esté en el array de estados ya visitados, es decir que sea un estado sin verificar.
___
> **CrearPosiblesSoluciones:**

> Toma un estado y genera un array de estados de todos los posibles caminos que se pueden generar a partir de este, se valida si el estado ya está visitado.
___

> **CLASE JUEGO:**

> Tiene los atributos resuelto que es un booleano que me indica si el juego ya se resolvió, estado inicial que sería el estado en cual inicia el juego, el usuario lo crea y estado final que se crea a partir del estado inicial.
___
> **Métodos de la clase juego:**
___

> El constructor recibe dos ints, que son la cantidad de caníbales y misioneros, respectivamente, con los que se va iniciar el juego.

> El juego empieza en la isla izquierda.

> A partir de la cantidad de caníbales y misioneros se crean los estados inicial - final y resuelto se inicializa a false.
___
> **MostrarEstados:**

> Recibe un array de estados y los muestra en pantalla.
___

> **ValidarEstado:**

> Verifica que en un estado no hayan más caníbales que misioneros en una isla, devuelve un true si es válido y un false es caso de que no.
___

> **BackTracking:**

> Recibe un estado, lo compara con el estado final si es igual el juego termina y resuelto se cambia a true.

> .

> Si no es una solución se crean todos los posibles caminos a partir de ese estado (mover 2 caníbales, mover 2 misioneros, uno y uno, mover solo uno de los 2) y se ingresa el estado raíz a la lista de estados ya visitados, se procede a llamar recursivamente a la función de BackTracking con todos los posibles caminos que se crearon y a su vez crear a partir de estos más caminos posibles.

> .

> En caso de que en uno de esos posibles estados se dé el caso de que hayan más caníbales que misioneros, ese estado se anula, es decir no se crean posibles soluciones a partir de este y se procede a continuar en la siguiente solución del array, representando como si se devolviera en el "árbol de soluciones", haciendo referencia al prueba y error.

> .

> En caso de que el array con los posibles nuevos caminos este vacío, significa que se llegó a un estado en cual todos los posibles caminos que se generaron ya fueron visitados, por lo que se llega a una pared o "hoja" en el árbol de soluciones, por lo que se continua con los demás estados en el array de posibles soluciones.

> .

> Se puede dar el caso en cual no se pueda solucionar el juego, es decir que todos los caminos fueron rechazados ya sea porque son hojas o porque hacen que los caníbales se coman a los misioneros en cualquier posible movimiento, por lo que no se pueden generar más caminos y la recursión termina, indicando que no se pudo solucionar el juego con esa cantidad de caníbales y misioneros.
