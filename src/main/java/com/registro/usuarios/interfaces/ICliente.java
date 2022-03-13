package com.registro.usuarios.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.modelo.Cliente;



@Repository
public interface ICliente extends CrudRepository<Cliente, Integer> {

}
