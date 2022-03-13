package com.registro.usuarios.interfaceService;

import java.util.Optional;

import com.registro.usuarios.modelo.Cita;



public interface ICitaService {

	
	public Optional<Cita>listarIdCitas(int idCita);
	public int savecita(Cita c);
	public void deleteCita(int idCita);
	
}
