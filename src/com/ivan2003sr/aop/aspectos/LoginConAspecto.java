package com.ivan2003sr.aop.aspectos;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginConAspecto {
	
	//@Before("execution(public void com.ivan2003sr.aop.dao.ClienteVipDAO.insertaCliente())")
	//@Before("execution(public void inserta*())")
	//@Before("execution(public String insertaCliente())")
	//@Before("execution(public * insertaCliente())")
	//@Before("execution(public * insertaCliente(com.ivan2003sr.aop.Cliente))")
	//@Before("execution(public * insertaCliente(com.ivan2003sr.aop.Cliente, ..))")
	@Before("execution(public * insertaCliente(..))")
	public void antesInsertarCliente() {
		System.out.println("El Usuario está logeado");
		System.out.println("El perfil para insertar clientes es correcto");
	}
	
	
	@After("execution(public void insertaCliente())")
	public void despuesInsertarCliente() {
		System.out.println("Anda el After");
		
	}

}
