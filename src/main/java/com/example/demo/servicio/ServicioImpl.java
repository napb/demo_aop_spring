package com.example.demo.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RequestDto;
import com.example.demo.dto.ResponseDto;

@Service("servicio")
public class ServicioImpl implements Servicio{

	@Autowired
	@Qualifier("otroServicio")
	OtroServicio otroServicio;
	
	@Override
	public ResponseDto getMethod(RequestDto requestDto) {

		String saludo = otroServicio.getSaludo(requestDto.getTexto());

		ResponseDto responseDto = new ResponseDto();
		responseDto.setTexto("Texto Request:["+requestDto.getTexto()+"]"+" OtroServicio.getSaludo["+saludo+"]");
				
		return responseDto;
	}

	@Override
	public String orquestador() {
		String prueba = this.metodoUno() + " / " + this.metodoDos() + " / " + this.metodoTres();

		return prueba;
	}


	@Override
	public String metodoUno() {
		return "metodo uno";
	}

	@Override
	public String metodoDos() {
		//throw new RuntimeException("exceoption de metodo dos");

		return "metodo dos";
	}

	@Override
	public String metodoTres() {

		throw new RuntimeException("exceoption de metodo dos");
		//return "metodo tres";
	}
}
