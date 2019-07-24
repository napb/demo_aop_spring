package com.example.demo.servicio;

import com.example.demo.aop.Loggeable;
import com.example.demo.aop.LoggeableReturn;
import org.springframework.stereotype.Service;

@Service("otroServicio")
public class OtroServicioImpl implements OtroServicio{

	@Override
	@Loggeable
	public String getSaludo(String saludo) {
		return "saludo = ["+saludo+"]";
	}

	@Override
	@Loggeable
	@LoggeableReturn
	public String getSaludoDos(String saludo) {
		return "saludo2 = ["+saludo+"]";
	}
}
