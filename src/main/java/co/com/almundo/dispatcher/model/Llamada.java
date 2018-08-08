package co.com.almundo.dispatcher.model;

/**
 * 
 * @author Peter
 *
 */
public class Llamada implements Runnable {

	private Atencion atencion;

	/**
	 * 
	 * @param atencion
	 */
	public Llamada(Atencion atencion) {
		super();
		this.atencion = atencion;
	}

	@Override
	public void run() {
		try {
			// simula el tiempo de atencion de la llamada
			Thread.sleep(atencion.getTiempoAtencion());
			System.out.println("Llamada finalizada con " + this.atencion.getCliente().getNombre());
			// desocupa al empleado cambiando su estado
			atencion.getEmpleado().setOcupado(false);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
