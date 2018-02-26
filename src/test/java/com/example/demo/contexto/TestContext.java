package com.example.demo.contexto;

import com.example.demo.servicio.Servicio;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.demo.servicio.OtroServicio;

@Configuration
@ComponentScan(basePackages = "com.example.demo")
public class TestContext {

    @Bean
    public OtroServicio mockServicio(){
        return Mockito.mock(OtroServicio.class);
    }
}
