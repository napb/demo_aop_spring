package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RequestDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.servicio.Servicio;

@RestController
@RequestMapping("/controlador")
public class Controlador {

	@Autowired
	@Qualifier("servicio")
	private Servicio servicio;
	
	@GetMapping(value = "/getMethod")
	public ResponseDto getMethodController(){
		
		RequestDto requestDto = new RequestDto();
		requestDto.setTexto("ABCDEF123456");
				
		return servicio.getMethod(requestDto);
	}
}
