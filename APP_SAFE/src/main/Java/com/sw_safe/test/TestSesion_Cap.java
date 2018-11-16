package com.sw_safe.test;

import com.google.gson.Gson;
import com.ws_safe.entity.Sesion_Cap;
import java.time.Instant;
import java.util.Date;
import org.jboss.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Rodrigo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContextTest.xml"})
public class TestSesion_Cap {
    Logger logger = Logger.getLogger(TestSesion_Cap.class);
    
    /**
     *
     */
    @Test
    public void testWSRest(){
        try {
            
            final String endPoint = "http://localhost:7101/app_safe";
            RestTemplate restTemplate = new RestTemplate();
            String resultGetSes = restTemplate.getForObject(endPoint+"/sesionCap/sw", String.class);
            Gson gson = new Gson();
            
            Sesion_Cap[] data = gson.fromJson(resultGetSes, Sesion_Cap[].class);
            
            for(Sesion_Cap dat:data){
                System.out.println("id sesion: " + dat.getIdsesioncap());
            }
            
            //Agregar sesion cap
            
            Sesion_Cap ses = new Sesion_Cap();
            ses.setIdsesioncap(10);
            ses.setNumsesioncap(3);
            ses.setNombresesion("Artefactos");
            ses.setCupossesion(20);
            ses.setFechasesion("19-12-2018");
            ses.setHorainiciocap("19-12-2018");
            ses.setHoraterminocap("19-12-2018");
            ses.setDescripcionsesion("descripcion de artefactos explosivos");
            ses.setEstadosesioncap(1);
            ses.setCapacitacionidcap(1);
            ses.setExpositoridexpositor(1);
            
            Gson request = new Gson();
            String datarequest = request.toJson(ses);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(datarequest.toString(), headers);
            ResponseEntity<String> sesResponse = restTemplate.exchange(endPoint+"/sesionCap/createSesionCap", HttpMethod.POST,entity,String.class);
            
            if(sesResponse.getStatusCode()==HttpStatus.OK){
                String resultadoAddSes = sesResponse.getBody();
                logger.info("1 : se agrego sesion, 0 : resultado con error = "+ resultadoAddSes);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

