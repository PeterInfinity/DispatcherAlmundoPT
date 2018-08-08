package co.com.almundo.model;
/**
 * 
 * @author Peter
 *
 */
public class Cliente {

	private String nombre;

	/**
	 * 
	 * @param nombre
	 */
	public Cliente(String nombre) {
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
}
