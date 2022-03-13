package com.registro.usuarios.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.registro.usuarios.interfaceService.ICitaMicroServicio;
import com.registro.usuarios.interfaceService.ICitaService;
import com.registro.usuarios.interfaceService.IClienteService;
import com.registro.usuarios.modelo.Cita;
import com.registro.usuarios.modelo.Cliente;


@Controller
public class RegistroControlador {

	
	
	@Autowired
	private IClienteService icservice;
	
	
	
	@Autowired
	private ICitaService iciservice;
	
	@Autowired
	private ICitaMicroServicio icimicroservice;
	
	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}
	
	
	
	@GetMapping("/index")
	public String paginainicio() {
		return "index";
	}
	
	@GetMapping("/agregarCliente")
	public String agregar(Model model){
		model.addAttribute("cliente", new Cliente());
		return "agregarCliente";
	}
	
	@GetMapping("/agregarCita")
	public String agregarCita(Model model){
		List<Cliente>listaclientes=icservice.listar();
		model.addAttribute("listaclientes", listaclientes);
		model.addAttribute("cita", new Cita());
		return "agregarCita";
	}
	
	
	
	
	
	
	
	
	//lista de clientes
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Cliente>cliente=icservice.listar();
		model.addAttribute("cliente", cliente);
		return "tabla";
	}
	
	//lista de citas
	@GetMapping("/listaCitas")
	public String listarCitas(Model model) {
		List<Cita>cita=icimicroservice.listarCitas();
		model.addAttribute("cita", cita);
		return "listaCitas";
	}
	
	//lista 2 citas
	@GetMapping("/listaCitas2")
	public String listarCitas2(Model model) {
		List<Cita>cita=icimicroservice.listarCitas();
		model.addAttribute("cita", cita);
		return "listaCitas2";
	}
	
	
	@PostMapping("/save")
	public String save(@Validated Cliente c, Model model) {
		icservice.save(c);
		return "redirect:/index";
	}
	
	
	//agendar cita
	@PostMapping("/saveCita")
	public String save(@Validated Cita ci, Model model) {
		iciservice.savecita(ci);
		return "redirect:/index";
	}
	
	//EDITAR CLIENTE
	@GetMapping("/editarCliente/{idCliente}")
	public String editarcliente(@PathVariable int idCliente, Model model) {
		Optional<Cliente>cliente = icservice.listarId(idCliente);
		model.addAttribute("cliente", cliente);
		return "editarCliente";
	}
	
	//editar Cita
	@GetMapping("/editarCita/{idCita}")
	public String editarCita(@PathVariable int idCita, Model model) {
		Optional<Cita>cita = iciservice.listarIdCitas(idCita);
		List<Cliente>listaclientes=icservice.listar();
		model.addAttribute("listaclientes", listaclientes);
		model.addAttribute("cita", cita);
		return "editarCita";
	}
	
	@GetMapping("/eliminarCita/{idCita}")
	public String deleteCita(Model model, @PathVariable int idCita) {
		iciservice.deleteCita(idCita);
		return "redirect:/listaCitas2";
	}
	
	@GetMapping("/eliminarCliente/{idCliente}")
	public String delete(Model model, @PathVariable int idCliente) {
		icservice.delete(idCliente);
		return "redirect:/listar";
	}

}
