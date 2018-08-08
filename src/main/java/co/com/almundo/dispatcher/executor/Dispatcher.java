package co.com.almundo.dispatcher.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import co.com.almundo.dispatcher.model.Atencion;
import co.com.almundo.dispatcher.model.Llamada;
import co.com.almundo.model.Cliente;
import co.com.almundo.model.Director;
import co.com.almundo.model.Empleado;
import co.com.almundo.model.Operador;
import co.com.almundo.model.Supervisor;

/**
 * 
 * @author Peter
 *
 */
public class Dispatcher {

	private ExecutorService executorService;

	private List<Operador> listOperadores;
	private List<Supervisor> listSupervisores;
	private List<Director> listDirectores;

	/**
	 * 
	 * @param numeroOperadores
	 * @param numeroSupervisores
	 * @param numeroDirectores
	 */
	public Dispatcher(Long numeroOperadores, Long numeroSupervisores, Long numeroDirectores) {
		System.out.println("Creando Dispatcher para la administracion de las llamadas...");
		// se crean los operadores
		listOperadores = new ArrayList<>();
		for (int i = 0; i < numeroOperadores; i++) {
			final Operador operador = new Operador("Operador " + (i + 1));
			listOperadores.add(operador);
		}
		System.out.println("Se crean " + numeroOperadores + " operadores...");
		// se crean los supervisores
		listSupervisores = new ArrayList<>();
		for (int i = 0; i < numeroSupervisores; i++) {
			final Supervisor supervisor = new Supervisor("Supervisor " + (i + 1));
			listSupervisores.add(supervisor);
		}
		System.out.println("Se crean " + numeroSupervisores + " supervisores...");
		// se crean los directores
		listDirectores = new ArrayList<>();
		for (int i = 0; i < numeroDirectores; i++) {
			final Director director = new Director("Director " + (i + 1));
			listDirectores.add(director);
		}
		System.out.println("Se crean " + numeroDirectores + " directores...");

		// se establece el numero de hilos maximo que administrara el executorService
		Long numeroHilos = numeroOperadores + numeroSupervisores + numeroDirectores;
		System.out.println("Estableciendo numero maximo de hilos a manejar: " + numeroHilos);

		// se instancia el contenedor de hilos y recibe como parametro la cantidad
		// maxima de hilos que puede soportar
		executorService = Executors.newFixedThreadPool(numeroHilos.intValue());
		System.out.println("Contenedor de hilos concurrente creado.");
	}

	private void dispatchCall(Runnable runnable) {
		executorService.execute(runnable);
	}

	/**
	 * Metodo que devuelve el empleado que se encuentra libre para atender una
	 * llamada
	 * 
	 * @return
	 */
	private Empleado obtenerEmpleadoLibre() {
		// verifica si existe un operador libre para atender una llamada
		for (Operador operador : listOperadores) {
			if (!operador.isOcupado()) {
				System.out.println(operador.getNombre() + " esta libre para atender la llamada.");
				return operador;
			}
		}
		// verifica si existe un supervisor libre para atender una llamada
		for (Supervisor supervisor : listSupervisores) {
			if (!supervisor.isOcupado()) {
				System.out.println(supervisor.getNombre() + " esta libre para atender la llamada.");
				return supervisor;
			}
		}
		// verifica si existe un director libre para atender una llamada
		for (Director director : listDirectores) {
			if (!director.isOcupado()) {
				System.out.println(director.getNombre() + " esta libre para atender la llamada.");
				return director;
			}
		}
		return null;
	}

	/**
	 * Metodo que obtiene un tiempo aleatorio entre 5seg y 10seg
	 * 
	 * @return
	 */
	private Long obtenerTiempoAleatorio() {
		Random random = new Random();
		int limiteInferior = 5000;
		int limiteSuperior = 10000;
		int limiteSuperiorAbierto = limiteSuperior + 1;
		int numeroAleatorio = limiteInferior + random.nextInt(limiteSuperiorAbierto - limiteInferior);
		return new Long(numeroAleatorio);
	}

	/**
	 * Metodo que atiende los clientes
	 * 
	 * @param clientes
	 * @throws InterruptedException
	 */
	public void atenderClientes(List<Cliente> clientes) throws InterruptedException {
		// iteracion de clientes
		for (Cliente cliente : clientes) {
			// bucle que encuentra una llamada disponible para un cliente
			while (true) {
				Empleado empleado = obtenerEmpleadoLibre();
				if (empleado != null) {
					// cambia el estado de un empleado a ocupado cuando puede atender una llamada
					empleado.setOcupado(true);
					// obtiene un tiempo aleatorio
					Long tiempoAtencion = obtenerTiempoAleatorio();
					// crea un objeto atencion con la informacion de la llamada
					Atencion atencion = new Atencion(empleado, cliente, tiempoAtencion);

					System.out.println("Cliente '" + cliente.getNombre() + "' siendo atendido por el empleado: "
							+ empleado.getNombre() + ", tiempo estimado: " + (tiempoAtencion / 1000) + "segundos");
					// despacha la llamada dentro de un pool de hilos
					dispatchCall(new Llamada(atencion));
					// rompe el bucle cuando un cliente fue despachado para su llamada
					break;
				} else {
					System.out.println("No hay empleados libres para atender la llamada, esperando...");
					// duerme la iteracion 1 seg mientras se busca un nuevo empleado
					Thread.sleep(1000);
				}
			}
		}
	}

}
