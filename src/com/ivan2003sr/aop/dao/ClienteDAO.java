package com.ivan2003sr.aop.dao;

import org.springframework.stereotype.Component;

import com.ivan2003sr.aop.Cliente;

@Component
public class ClienteDAO {
	
	//public String insertaCliente() {
	public void insertaCliente(Cliente elCliente, String tipo) {
		System.out.println("Cliente normal Insertado");
		//return "Cliente Insertado con éxito";
	}

}
