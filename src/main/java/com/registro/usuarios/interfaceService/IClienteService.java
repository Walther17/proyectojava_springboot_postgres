package com.registro.usuarios.interfaceService;

import java.util.List;
import java.util.Optional;

import com.registro.usuarios.modelo.Cliente;



public interface IClienteService {

	

	public List<Cliente>listar();
	public Optional<Cliente>listarId(int idCliente);
	public int save(Cliente c);
	public void delete(int idCliente);
}
