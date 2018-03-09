package com.example.demo.controlador;

import com.example.demo.argumentresolver.classargumentresolver.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class MethodArgumentResolverController {

    @GetMapping(value = "/testArgumentResolver")
    public void processUsuario(Usuario usuario) {

        System.out.print("Usuario: ["+usuario.getNombre()+" - "+usuario.getRut()+"}]");

    }
}
