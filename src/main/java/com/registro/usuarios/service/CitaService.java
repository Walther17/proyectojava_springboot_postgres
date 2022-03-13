package com.registro.usuarios.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.usuarios.interfaceService.ICitaService;
import com.registro.usuarios.interfaces.ICita;
import com.registro.usuarios.modelo.Cita;


@Service
public class CitaService implements ICitaService{

	@Autowired
	private ICita data;
	
	@Override
	public Optional<Cita> listarIdCitas(int idCita) {
		return data.findById(idCita);
	}

	@Override
	public int savecita(Cita c) {
		int res=0;
		Cita cliente = data.save(c);
		if(!cliente.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void deleteCita(int idCita) {
		 data.deleteById(idCita);
		
	}
	
	

}

