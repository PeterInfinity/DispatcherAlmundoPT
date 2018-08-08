# DispatcherAlmundoPT
prueba tecnica java, simulador de call center para llamadas, Threads

Resolución de problema Ejercicio Java.

Definición del problema.

Existe un call center donde hay 3 tipos de empleados: operador, supervisor y director. 
El proceso de la atención de una llamada telefónica en primera instancia debe ser atendida por un operador, si no hay ninguno libre 
debe ser atendida por un supervisor, y de no haber tampoco supervisores libres debe ser atendida por un director.

Solución planteada.

Para dar solución al problema de concurrencia con hilos para el problema planteado, se opto por crear una clase Dispatcher que 
implementara como atributo propio de la clase, un ExecutorService de Java 8 el cual tiene la intención de mejorar la clase de 
Thread y delegar la administración y el manejo de un pool de threads a esta interface. El modelo se establece definiendo los 
objetos Operador, Supervisor y Director; estos heredan las características de un cuarto objeto llamado Empleado que define 
atributos básicos como el nombre y si este se encuentra ocupado o no en caso de atender una llamada. Se establecen como hilos las
llamadas como objetos Runnable que son creados por cada cliente enviado al Dispatcher, cada llamada define un objeto Atencion que
contiene la información del cliente, el operador y el tiempo de atención estimado para cada llamada.

Resolución de puntos extras:

1.	‘Dar alguna solución sobre qué pasa con una llamada cuando no hay ningún empleado libre’: cuando no hay ningún empleado libre 
    el hilo principal entra en un bucle infinito que verifica la disponibilidad de los empleados cada 1000ms, el primer empleado libre 
    atiende la llamada en espera, esta llamada en espera se encuentra encolada en una iteración de clientes.

2.	‘Dar alguna solución sobre qué pasa con una llamada cuando entran más de 10 llamadas concurrentes’: esto lo resuelve 
    automáticamente la ExecutorService cuando definimos el tipo de implementación podemos realizar, para el caso planteado 
    se resuelve con la implementación newFixedThreadPool(n hilos):
    
    Esta implementación tiene las siguientes características:
    
      a.	Crea un pool de hilo de ejecuciones con un tamaño fijo.
      b.	Si se trata de ejecutar una tarea nueva cuando todos los hilos de ejecución están trabajando, este último debe esperar.
      c.	Si algún hilo muere por una falla durante su ejecución, uno nuevo será creado en el pool cuando sea solicitado.
      
3.	‘Agregar los tests unitarios que se crean convenientes.’: aunque no se crearon pruebas unitarias como tal, 
    se creo un ejemplo fácil de observar en la clase PrincipalExecutor que ejecuta un ejemplo con 8 clientes a través de una java main, 
    se realizan impresiones de la simulación del call center asignando las llamadas entrantes de clientes a cada empleado por orden 
    jerarquico.

4.	‘Agregar documentación de código’: se agrego la documentación respectiva con JAutodoc y los comentarios explícitos se realizaron 
    a través de descripción literal.
