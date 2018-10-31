package com.sw_safe.test;

import com.google.gson.Gson;
import com.ws_safe.entity.ListTrabSalud;
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
public class TestListTrabSalud {
    Logger logger = Logger.getLogger(TestListTrabSalud.class);
    
    /**
     *
     */
    @Test
    public void testWSRest(){
        try {
            
            final String endPoint = "http://localhost:7101/app_safe";
            RestTemplate restTemplate = new RestTemplate();
            String resultGetLis = restTemplate.getForObject(endPoint+"/listaTrabajadoresSalud/sw", String.class);
            Gson gson = new Gson();
            
            ListTrabSalud[] data = gson.fromJson(resultGetLis, ListTrabSalud[].class);
            
            for(ListTrabSalud dat:data){
                System.out.println("Nombre lista trabajadores: " + dat.getIdlistrabsalud());
            }
            
            //Agregar lista trabajadores salud
            
            ListTrabSalud lis = new ListTrabSalud();
            lis.setIdlistrabsalud(1);
            lis.setPresenteSalud(1);
            lis.setEstadoSalud(1);
            lis.setUsuarioidusuario(1);
            lis.setLisasiscapidlistasalud(1);
            lis.setCertificadoidcertificado(1);
            
            Gson request = new Gson();
            String datarequest = request.toJson(lis);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(datarequest.toString(), headers);
            ResponseEntity<String> lisResponse = restTemplate.exchange(endPoint+"/listaTrabajadoresSalud/createListaTrabajadoresSalud", HttpMethod.POST,entity,String.class);
            
            if(lisResponse.getStatusCode()==HttpStatus.OK){
                String resultadoAddLis = lisResponse.getBody();
                logger.info("1 : se agrego lista, 0 : resultado con error = "+ resultadoAddLis);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

