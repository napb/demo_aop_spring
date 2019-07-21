package com.example.demo.servicio;

import com.example.demo.dto.RequestDto;
import com.example.demo.dto.ResponseDto;

public interface Servicio {
	ResponseDto getMethod(RequestDto requestDto);

	String orquestador();

}
