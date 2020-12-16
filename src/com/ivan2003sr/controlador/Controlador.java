package com.ivan2003sr.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ivan2003sr.controlador.entity.Cliente;
import com.ivan2003sr.dao.ClienteDAO;

@Controller
@RequestMapping("/cliente")
public class Controlador {

	@RequestMapping("/lista")
	public String listaClientes(Model elModelo) {
		
		//Obtener los clientes desde el DAO. hago inyección de objetos tipo clienteDAO
		List<Cliente> losClientes=clienteDAO.getClientes();
		
		//Agregar clientes al modelo
		
		elModelo.addAttribute("clientes",losClientes);
		
		return "lista-clientes";
	}
	
	@RequestMapping("/muestraFormularioAgregar")
	public String muestraFormularioAgregar (Model elModelo) {
		
		//Bind datos clientes
		
		Cliente elCliente=new Cliente();
		elModelo.addAttribute("cliente",elCliente);
		
		return "formularioCliente";
		
	}
	
	@PostMapping("/insertarCliente")
	public String insertaCliente (@ModelAttribute("cliente") Cliente elCliente) {
		
		//Insertar cliente en BBDD
		
		clienteDAO.insertarCliente(elCliente);
		
	return"redirect:/cliente/lista";
	}
	
	@Autowired //Permite usar inyección de dependencias de tipo ClienteDAO
	private ClienteDAO clienteDAO;
}



