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
}
