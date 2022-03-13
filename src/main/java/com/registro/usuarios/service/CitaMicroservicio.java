package com.registro.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.usuarios.interfaceService.ICitaMicroServicio;
import com.registro.usuarios.interfaces.ICita;
import com.registro.usuarios.modelo.Cita;



@Service
public class CitaMicroservicio implements ICitaMicroServicio {

	
	@Autowired
	private ICita data;
	
	@Override
	public List<Cita> listarCitas() {
		
		return (List<Cita>)data.findAll();
	}

	

}