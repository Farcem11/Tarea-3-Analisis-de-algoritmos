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
> **Clase Barco:**
___
> Solo tiene un atributo booleano que me dice en que isla esta el barco, si es true el barco esta en la isla de la izquierda, si es false esta en la derecha.
___
> **Clase isla:**
___
> Tiene dos atributos de tipo int que representan la cantidad de canibales y misioneros que tiene la isla.
___
> **Clase estado:**
___
> Tiene 4 atributos un barco, dos islas y un array de estados donde se guardan los estados visitados, que representan el estado en cual esta el juego actualmente.

##Demostración:
>T(5000) = C * 5000^2 = 50

> <=> C * 25.000.000 = 50

> <=> C = 50 / 25.000.000

> <=> C = 2x10^-6 

> **Tardaría en procesar los datos un tiempo de 50ms, con C = 2x10^-6**


	3) Un algoritmo con una complejidad de tiempo O(f(n)) y un tiempo de procesamiento T(n) = c f(n) donde f(n) es una función conocida de n, tarda 10 segundos para procesar 1000 elementos de datos.  Cuanto tiempo tomara procesar 100000 elementos de datos si f(n) = n y si f(n) = n^3?

##Observaciones:
> Tarda 10 segundos en procesar 1000 elementos de datos, es decir cantidadDeElementosDeDatos  / 100 = tiempo en segundos, con algún C en específico, es decir: ∃ C ∈ R talque T(n) = n/100.

###Para f(n) = n:
> Si la complejidad del tiempo del algoritmo es O( f(n) ) y f(n) = n, entonces su complejidad de tiempo será de O(n) con la forma T(n) = c * n. 
-Debería tardar 1000 segundos en procesar 100.000, con algún C.

##Demostración:

> T(100.000) = c * 100.000 = 1000

> <=> c * 100.000 = 1000

> <=> c = 1000/100.000

> <=> c = 0.01

> **Tardará 1000 segundos en procesar 100.000 si C = 0.01**

###Para f(n) = n^3:
> Si la complejidad del tiempo del algoritmo es O( f(n) ) y f(n) = n^3, entonces su complejidad de tiempo será de O(n^3) con la forma T(n) = c * n^3. 
-Debería tardar 1000 segundos en procesar 100.000, con algún C.

##Demostración:
>T(100.000) = c * 100.000 ^3 = 1000

><=> c * 1.000.000.000.000.000 = 1000

><=> c = 1000/1.000.000.000.000.000

><=> c = 1x10^-12

>**Tardará 1000 segundos en procesar 100.000 si C = 1x10^-12**


	4) Se tienen dos paquetes de software A y B de complejidad O(n log n) y O(n) respectivamente. Y se tiene que T_A (n)=C_a n log_10⁡n y T_B (n)=C_b n expresan el tiempo en milisegundos de cada paquete. Durante una prueba, el tiempo promedio de procesamiento de n=〖10〗^4 elementos de datos con los paquetes A y B es de 100ms y 500ms respectivamente.  Establezca las condiciones en las cuales uno de los paquetes empieza a desempeñarse mejor que el otro y recomiendo la mejor opción si se van a procesar n=〖10〗^9

##Observaciones:
>**Con n = 10^4 el paquete A tarda 100ms , es decir T_A(10^4) = 100**

><=> C_A * 10^4 * log_10(10^4)   = 100

><=> C_A * 10.000 * 4 = 100

><=> C_A * 40.000 = 100

><=> C_A = 100 / 40.000

><=> C_A = 2.5x10-3

>**T_A(n) = 2.5x10-3 * n * log_10(n)**

>___

>**Con n = 10^4 el paquete B tarda 500ms , es decir T_B(10^4) = 500**

><=> C_B * 10^4 = 500

><=> C_B * 10.000 = 500

><=> C_B = 500 / 10.000

><=> C_B = 0.05

>**T_B(n) = 0.05 * n** 

**Basta con tomar un intervalo pequeño para ver como el paquete A avanza mucho más despacio que el paquete B:**

>Intervalo de 1 a 10, solo enteros

>T_A( 1 ) = 0ms

>T_A( 2 ) = 1.5x10-3ms

>T_A( 3 ) = 3.5x10-3ms

>T_A( 4 ) = 6x10-3ms

>T_A( 5 ) = 8.7x10-3ms

>T_A( 6 ) = 0.0116ms

>T_A( 7 ) = 0.0147ms

>T_A( 8 ) = 0.018ms

>T_A( 9 ) = 0.0214ms

>T_A(10) = 0.025ms

>___

>T_B( 1 ) =  0.05ms

>T_B( 2 ) =  0.1ms

>T_B( 3 ) =  0.15ms

>T_B( 4 ) =  0.20ms

>T_B( 5 ) =  0.25ms

>T_B( 6 ) =  0.3ms

>T_B( 7 ) =  0.35ms

>T_B( 8 ) =  0.40ms

>T_B( 9 ) =  0.45ms

>T_B(10) =  0.50ms

>___

>**T_A(10^9) = 22.500.000ms**

>**T_B(10^9) = 50.000.000ms**

>El paquete A dura menos procesando n