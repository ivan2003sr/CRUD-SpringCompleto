package com.ivan2003sr.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ivan2003sr.controlador.entity.Cliente;

@Repository //Para que sea la clase registrada como un bean
public class ClienteDAOclase implements ClienteDAO {

	@Override
	@Transactional	//comienzo transaccion, begin, commit, rollback, etc. con esta anotación no hace falta
	public List<Cliente> getClientes() {
		// TODO Auto-generated method stub
	
		// Obtener la sesión
		
		Session miSession=sessionFactory.getCurrentSession();
		
		//Crear la Query
		
		Query<Cliente> miQuery=miSession.createQuery("from Cliente",Cliente.class);
		
		//Ejecutar la Query y devolver resultados
		
		List<Cliente> clientes=miQuery.getResultList();
		
		return clientes;
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void insertarCliente(Cliente elCliente) {
		// TODO Auto-generated method stub
		
		// Obtener la sesión
		
				Session miSession=sessionFactory.getCurrentSession();
		
		//Insertar por fin el cliente
				
				//miSession.save(elCliente);
				miSession.saveOrUpdate(elCliente);
		
	}

	@Override
	@Transactional
	public Cliente getCliente(int id) {

		//Obtener la sesion
		
		Session miSession=sessionFactory.getCurrentSession();
		
		//Obtener la información del cliente seleccionado
		
		Cliente elCliente = miSession.get(Cliente.class,id);
		
		return elCliente;
	}

	@Override
	@Transactional
	public void eliminarCliente(int id) {


	//Obtener la sesion
		
	Session miSession=sessionFactory.getCurrentSession();
	
	//Borrar el cliente de la BBDD usando el ID
	
	Query consulta = miSession.createQuery("delete FROM Cliente where id=:IdDelCliente");
	consulta.setParameter("IdDelCliente", id);
	consulta.executeUpdate();
				
		
	}

}