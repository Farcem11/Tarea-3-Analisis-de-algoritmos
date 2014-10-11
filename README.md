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

	1) La idea es resolver un problema hipotético donde se tienen tanto misioneros como caníbales en una isla, y deben llevarse en bote hasta otra isla. 
	El bote puede llevar como máximo 2 personas, como mínimo 1. 
	El bote no puede ir solo. 
	En cada isla no puede haber en un momento dado mas caníbales que misioneros, porque sino los caníbales se los devoran. La tarea consiste en realizar una implementación en Java, usando las técnicas de backtracking para resolver el problema.

##Explicacion del algoritmo:
___
> **CLASE BARCO:**
___
> Solo tiene un atributo booleano que me dice en que isla esta el barco, si es true el barco esta en la isla de la izquierda, si es false esta en la derecha.
___
> **CLASE ISLA:**
___
> Tiene dos atributos de tipo int que representan la cantidad de canibales y misioneros que tiene la isla.
___
> **CLASE ESTADO:**
___
> Tiene 4 atributos un barco, dos islas, que representan el estado en cual esta el juego actualmente y un array de estados donde se guardan los estados visitados.

___
> **Metodos de la clase estado:**
___
> **Mostrar:** 

> Imprime un estado con la forma: 

> **II(C:3 M:3) ID(C:0 M:0) B:D**

> **II** es isla izquierda y dice que tiene 3 canibales y 3 misioneros.

> **ID** es isla derecha y dice que no tiene ni canibales ni misioneros.

> **B** es el barco cuando dice "D" es que esta en la isla derecha y cuando dice "I" es que esta en la izquierda.
___
> **MismosEstados:**

> Toma dos estados y los compara a ver si son iguales.
___
> **EstadoYaVisitado:**

> Verifica que un estado no este en el array de estados ya visitados, es decr que sea un estado sin verificar.
___
> **CrearPosiblesSoluciones:**

> Toma un estado y genera un array de estados de todos los posibles caminos que se pueden generar apartir de este, se valida si el estado ya esta visitado.
___

> **CLASE JUEGO:**

> Tiene los atributos resuelto que es un booleano que me indica si el juego ya se resolvio, estado inicial que seria el estado en cual inicia el juego, el usuario lo crea y estado final que se crea apartir del estado inicial.
___
> **Metodos de la clase juego:**
___

> El constructor recibe dos ints, que son la cantidad de canibales y misioneros, respectivamente, con los que se va iniciar el juego.

> El juego empieza en la isla izquierda.

> Apartir de la cantidad de canibales y misioneros se crean el estado inicial y final y
resuelto se inicializa a false;

___
> **MostrarEstados:**

> Recibe un array de estados y los muestra en pantalla.

___

> **ValidarEstado:**

> Verifica que en un estado no hayan mas canibales que misioneros en una isla, devuelve un true si es valido y un false es caso de que no.
___

> **BackTracking:**

> Recibe un estado, lo compara con el estado final si es igual el juego termina y resuelto se cambia a true.

> .

> Si no es una solucion se crean todos los posibles caminos apartir de ese estado (mover 2 canibales, mover 2 misioneros, uno y uno, mover solo uno de los 2) y se ingresa el estado raiz a la lista de estados ya visitados, se procede a llamar recursivamente a la funcion de BackTracking con todos lo posibles caminos que se crearon y a su vez crear apartir de estos mas caminos posibles.

> .

> En caso de que en uno de esos posibles estados se de el caso de que hayan mas canibales que misioneros, ese estado se anula, es decir no se crean posibles soluciones apartir de este y se procede a continuar el la siguiente solucion del array, representando como si se devolviera en el "arbol de soluciones", haciendo referencia a el prueba y error.

> .

> En caso de que el array con los posibles nuevos caminos este vacio, significa que se llego a un estado en cual todos los posibles caminos que se generaron ya fueron visitados, por lo que se llega a una pared o "hoja" en el arbol de soluciones, por lo que se continua con los demas estados en el array de posibles soluciones.

> .

> Se puede dar el caso en cual no se pueda solucionar el juego, es decir que todos los caminos fueron rechazados ya se porque son hojas o porque hacen que los canibales se coman a los misioneros en cualquier posible movimiento, por lo que no se pueden generar mas caminos y la recursion termina, indicando que no se pudo solucionar el juego con esa cantidad de canibales y misioneros.
