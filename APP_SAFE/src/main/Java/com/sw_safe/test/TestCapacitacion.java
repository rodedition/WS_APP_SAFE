package com.sw_safe.test;

import com.google.gson.Gson;
import com.ws_safe.entity.Capacitacion;
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
public class TestCapacitacion {
    Logger logger = Logger.getLogger(TestCapacitacion.class);
    
    /**
     *
     */
    @Test
    public void testWSRest(){
        try {
            
            final String endPoint = "http://localhost:7101/app_safe";
            RestTemplate restTemplate = new RestTemplate();
            String resultGetCap = restTemplate.getForObject(endPoint+"/capacitacion/getAllCapacitacion/", String.class);
            Gson gson = new Gson();
            
            Capacitacion[] data = gson.fromJson(resultGetCap, Capacitacion[].class);
            
            for(Capacitacion dat:data){
                System.out.println("Nombre Capacitación: " + dat.getNombrecapacitacion());
            }
            
            //Agregar capacitacion
            
            Capacitacion cap = new Capacitacion();
            cap.setIdcap(100);
            cap.setNombrecapacitacion("Prueba Test");
            cap.setEstadocapacitacion(1);
            cap.setPlancapidplancap(1);
            cap.setTipocapidtipocap(1);     
            
            Gson request = new Gson();
            String datarequest = request.toJson(cap);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(datarequest.toString(), headers);
            ResponseEntity<String> capResponse = restTemplate.exchange(endPoint+"/capacitacion/createCapacitacionSP", HttpMethod.POST,entity,String.class);
            
            if(capResponse.getStatusCode()==HttpStatus.OK){
                String resultadoAddCap = capResponse.getBody();
                logger.info("1 : se agrego cap, 0 : resultado con error = "+ resultadoAddCap);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

