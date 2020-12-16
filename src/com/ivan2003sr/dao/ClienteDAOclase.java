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
	@Transactional	//comienzo transaccion, begin, commit, rollback, etc. con esta anotaci�n no hace falta
	public List<Cliente> getClientes() {
		// TODO Auto-generated method stub
	
		// Obtener la sesi�n
		
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
		
		// Obtener la sesi�n
		
				Session miSession=sessionFactory.getCurrentSession();
		
		//Insertar por fin el cliente
				
				miSession.save(elCliente);
		
	}

}
