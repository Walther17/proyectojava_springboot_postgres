package com.registro.usuarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.usuarios.interfaceService.IClienteService;
import com.registro.usuarios.interfaces.ICliente;
import com.registro.usuarios.modelo.Cliente;



@Service
public class ClienteService implements IClienteService {

	
	@Autowired
	private ICliente data;
	
	@Override
	public List<Cliente> listar() {
		return (List<Cliente>)data.findAll();
	}


	@Override
	public int save(Cliente c) {
		int res=0;
		Cliente cliente = data.save(c);
		if(!cliente.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int idCliente) {
	data.deleteById(idCliente);
		
	}


	@Override
	public Optional<Cliente> listarId(int idCliente) {
		return data.findById(idCliente);
	}

}

