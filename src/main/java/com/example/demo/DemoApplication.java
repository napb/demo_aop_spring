package com.example.demo;

import com.example.demo.argumentresolver.UsuarioHandlerMethodArgumentResolver;
import com.example.demo.servicio.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@SpringBootApplication
@EnableAspectJAutoProxy
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class DemoApplication extends WebMvcConfigurerAdapter implements CommandLineRunner {


	@Autowired
	@Qualifier("servicio")
	private Servicio servicio;


	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new UsuarioHandlerMethodArgumentResolver());
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		servicio.orquestador();
//		servicio.metodoUno();
	}
}
