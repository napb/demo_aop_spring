package com.example.demo.argumentresolver;

import com.example.demo.argumentresolver.classargumentresolver.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

public class UsuarioHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Value("usuarioargumentresolver.rut")
    private String rutParameter;

    @Value("usuarioargumentresolver.nombre")
    private String nombreParameter;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(Usuario.class);
    }

    @Override
    public Object resolveArgument(
            MethodParameter methodParameter,
            ModelAndViewContainer modelAndViewContainer,
            NativeWebRequest nativeWebRequest,
            WebDataBinderFactory webDataBinderFactory) throws Exception {

        HttpServletRequest request = (HttpServletRequest) nativeWebRequest.getNativeRequest();

        String rut = request.getHeader("rut-header");
        String nombre = nativeWebRequest.getParameter("nombre");

        if (rut == null) {
            rut = "defaultRut";
        }

        if (nombre == null) {
            nombre = "defaultNombre";
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setRut(rut);

        return usuario;

    }
}
