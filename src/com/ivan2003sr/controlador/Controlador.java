package com.ivan2003sr.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ivan2003sr.controlador.entity.Cliente;
import com.ivan2003sr.dao.ClienteDAO;

@Controller
@RequestMapping("/cliente")
public class Controlador {

	@RequestMapping("/lista")
	public String listaClientes(Model elModelo) {
		
		//Obtener los clientes desde el DAO. hago inyecci�n de objetos tipo clienteDAO
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
	
	@GetMapping("/muestraFormularioActualizar")
	public String muestraFormularioActualizar(@RequestParam("clienteId") int Id, Model elModelo) {
		
		//Obtener el cliente cuyo id le estamos pasando por par�metro
		
		Cliente elCliente=clienteDAO.getCliente(Id);
		
		//Establecer el cliente como atributo del modelo
		
		elModelo.addAttribute("cliente",elCliente);
		
		
		// Enviar al formulario
		
		
		
		return "formularioCliente";
	}
	
	@GetMapping("/eliminar")
	public String eliminarCliente(@RequestParam("clienteId") int Id) {
		
		//Eliminar el cliente cuyo id le estamos pasando por par�metro
		
		clienteDAO.eliminarCliente(Id);
		
		//Redireccionar a la lista de clientes
		
		
		
		return"redirect:/cliente/lista";
	}
	
	
	
	@Autowired //Permite usar inyecci�n de dependencias de tipo ClienteDAO
	private ClienteDAO clienteDAO;
}
