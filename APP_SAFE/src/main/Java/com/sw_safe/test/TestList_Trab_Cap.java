package com.sw_safe.test;

import com.google.gson.Gson;
import com.ws_safe.entity.List_Trab_Cap;
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
public class TestList_Trab_Cap {
    Logger logger = Logger.getLogger(TestList_Trab_Cap.class);
    
    /**
     *
     */
    @Test
    public void testWSRest(){
        try {
            
            final String endPoint = "http://localhost:7101/app_safe";
            RestTemplate restTemplate = new RestTemplate();
            String resultGetLis = restTemplate.getForObject(endPoint+"/listaTrabajadoresCap/sw", String.class);
            Gson gson = new Gson();
            
            List_Trab_Cap[] data = gson.fromJson(resultGetLis, List_Trab_Cap[].class);
            
            for(List_Trab_Cap dat:data){
                System.out.println("Nombre id lista: " + dat.getIdlistrabcap());
            }
            
            //Agregar lista trabajadores cap
            
            List_Trab_Cap cap = new List_Trab_Cap();
            cap.setIdlistrabcap(3);
            cap.setPresenteCap(1);
            cap.setEstadoCap(1);
            cap.setUsuarioidusuario(1);
            cap.setLisasiscapidlistacap(2);
            cap.setCertificadoidcertificado(0);
            
            Gson request = new Gson();
            String datarequest = request.toJson(cap);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(datarequest.toString(), headers);
            ResponseEntity<String> lisResponse = restTemplate.exchange(endPoint+"/listaTrabajadoresCap/createListaTrabajadoresCap", HttpMethod.POST,entity,String.class);
            
            if(lisResponse.getStatusCode()==HttpStatus.OK){
                String resultadoAddLis = lisResponse.getBody();
                logger.info("1 : se agrego lista, 0 : resultado con error = "+ resultadoAddLis);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

