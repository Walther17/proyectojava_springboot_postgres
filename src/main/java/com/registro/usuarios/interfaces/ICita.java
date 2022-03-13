package com.registro.usuarios.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.modelo.Cita;



@Repository
public interface ICita  extends CrudRepository<Cita, Integer>{

}