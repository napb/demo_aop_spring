package com.example.demo.servicio;

import org.springframework.stereotype.Service;

@Service("otroServicio")
public class OtroServicioImpl implements OtroServicio{

	@Override
	public String getSaludo(String saludo) {
		return "["+saludo+"]";
	}
}
