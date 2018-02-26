package com.example.demo.servicio;

import com.example.demo.dto.ResponseDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.contexto.TestContext;
import com.example.demo.dto.RequestDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestContext.class)
public class ServicioTest {

    @Mock
    OtroServicio otroServicio;

    @Autowired
	@InjectMocks
	Servicio servicio;

    @Before
    public void setUp()throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void initTest(){

    	Mockito.when(otroServicio.getSaludo(Mockito.anyString()))
                .thenReturn("SALUDO DE PRUEBA");
    	
    	RequestDto requestDto = new RequestDto();
    	requestDto.setTexto("QAWSEDRF");

        ResponseDto responseDto = new ResponseDto();
        responseDto = servicio.getMethod(requestDto);

        Assert.assertEquals(responseDto.getTexto(),"gfgfdf");
    }

}