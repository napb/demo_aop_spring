package com.example.demo.servicio;

import org.springframework.stereotype.Service;

@Service("otroServicio")
public class OtroServicioImpl implements OtroServicio{

	@Override
	public String getSaludo(String saludo) {
		return "saludo = ["+saludo+"]";
	}

	@Override
	public String getSaludoDos(String saludo) {
		return "saludo2 = ["+saludo+"]";
	}
}
