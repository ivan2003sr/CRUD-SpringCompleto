package com.ivan2003sr.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ivan2003sr.aop.dao.ClienteDAO;
import com.ivan2003sr.aop.dao.ClienteVipDAO;

public class ClasePrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Leer la configuración de Spring
		
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);
				
		
		//Obtener el bean del contenedor de Spring
		
		ClienteDAO elCliente = contexto.getBean("clienteDAO", ClienteDAO.class);
		ClienteVipDAO elClienteVip = contexto.getBean("clienteVipDAO", ClienteVipDAO.class);
		
		//Llamar al método
		
		Cliente cl1=new Cliente();
		elCliente.insertaCliente(cl1, "Normal");
		elClienteVip.insertaCliente();
				
		
		//Cerrar el contexto
		
		contexto.close();

	}

}
