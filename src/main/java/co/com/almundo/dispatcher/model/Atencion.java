/**
 * 
 */
package co.com.almundo.dispatcher.model;

import co.com.almundo.model.Cliente;
import co.com.almundo.model.Empleado;

/**
 * @author Peter
 *
 */
public class Atencion {

	private Empleado empleado;
	private Cliente cliente;
	private Long tiempoAtencion;

	/**
	 * 
	 * @param empleado
	 * @param cliente
	 */
	public Atencion(Empleado empleado, Cliente cliente, Long tiempoAtencion) {
		this.cliente = cliente;
		this.empleado = empleado;
		this.tiempoAtencion = tiempoAtencion;
	}

	/**
	 * @return the empleado
	 */
	public Empleado getEmpleado() {
		return empleado;
	}

	/**
	 * @param empleado the empleado to set
	 */
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the tiempoAtencion
	 */
	public Long getTiempoAtencion() {
		return tiempoAtencion;
	}

	/**
	 * @param tiempoAtencion the tiempoAtencion to set
	 */
	public void setTiempoAtencion(Long tiempoAtencion) {
		this.tiempoAtencion = tiempoAtencion;
	}

}
