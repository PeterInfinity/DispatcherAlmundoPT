package co.com.almundo.main;

import java.util.ArrayList;
import java.util.List;

import co.com.almundo.dispatcher.executor.Dispatcher;
import co.com.almundo.model.Cliente;
/**
 * 
 * @author Peter
 *
 */
public class PrincipalExecutor {

	public static void main(String[] args) throws InterruptedException {

		List<Cliente> listClientes = new ArrayList<>();
		listClientes.add(new Cliente("Lorena"));
		listClientes.add(new Cliente("Pedro"));
		listClientes.add(new Cliente("German"));
		listClientes.add(new Cliente("Daniel"));
		listClientes.add(new Cliente("Oscar"));
		listClientes.add(new Cliente("Milu"));
		listClientes.add(new Cliente("Antonio"));

		Dispatcher dispatcher = new Dispatcher(2l, 1l, 1l);
		dispatcher.atenderClientes(listClientes);

	}

}
