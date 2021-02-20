package com.ivan2003sr.dao;
import java.util.List;
import com.ivan2003sr.controlador.entity.Cliente;

public interface ClienteDAO {
	
	public List<Cliente> getClientes();

	public void insertarCliente(Cliente elCliente);

	public Cliente getCliente(int id);

	public void eliminarCliente(int id);

	

}
