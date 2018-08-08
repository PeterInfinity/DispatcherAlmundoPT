/**
 * 
 */
package co.com.almundo.model;

/**
 * @author Peter
 *
 */
public class Empleado {

	private String nombre;
	private boolean ocupado;

	/**
	 * 
	 */
	public Empleado() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param nombre
	 */
	public Empleado(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the ocupado
	 */
	public boolean isOcupado() {
		return ocupado;
	}

	/**
	 * @param ocupado the ocupado to set
	 */
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
}
