package com.registro.usuarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.registro.usuarios.modelo.Cita;
import com.registro.usuarios.service.CitaMicroservicio;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@SpringBootApplication
public class RegistroUsuariosSpringSecurityApplication {
	
	
	@Autowired
	private static CitaMicroservicio citaService;

	 
	


	public static void main(String[] args) {
		
		SpringApplication.run(RegistroUsuariosSpringSecurityApplication.class, args);

		try {
			 Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/logindb", "postgres", "admin");
			 String query = "SELECT fecha_cita FROM public.cita where fecha_cita = '2022-03-17'";
			 
		} catch (Exception e) {
			System.out.println(e);
			
		}
		

		
		//List<Cita>listacitaS = citaService.listarCitas();
	     String fecha = "16:42:00 11/03/2022";

		while (true) {
			Date fechaActual = new Date();
			DateFormat format = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

			if (format.format(fechaActual).equals(fecha)) {
				Twilio.init("AC92ba086012fb42d1e1a814ab660bebe8", "256b469009ea00ecc8c54770ab184c40");
				Message message = Message.creator(new com.twilio.type.PhoneNumber("whatsapp:+593990911377"), // este hay
																												// q
																												// modificar
						new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
						"Si te llego dime x mi numero soy kelv").create();
				System.out.print(message.getSid());

			}
		}
	}

}
