package com.sw_safe.test;

import com.google.gson.Gson;
import com.ws_safe.entity.Examenes;
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
public class TestExamenes {
    Logger logger = Logger.getLogger(TestExamenes.class);
    
    /**
     *
     */
    @Test
    public void testWSRest(){
        try {
            
            final String endPoint = "http://localhost:7101/app_safe";
            RestTemplate restTemplate = new RestTemplate();
            String resultGetExa = restTemplate.getForObject(endPoint+"/examenes/getAllExamenes/", String.class);
            Gson gson = new Gson();
            
            Examenes[] data = gson.fromJson(resultGetExa, Examenes[].class);
            
            for(Examenes dat:data){
                System.out.println("Nombre Examen: " + dat.getNombreexamen());
            }
            
            //Agregar examen
            
            Examenes exa = new Examenes();
            exa.setIdexamen(10);
            exa.setNombreexamen("Test examen");
            exa.setEstadoexamen(1);
            exa.setPlansaludidplansalud(3);
            exa.setTipoexamenidtipoexam(1);
            
            Gson request = new Gson();
            String datarequest = request.toJson(exa);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(datarequest.toString(), headers);
            ResponseEntity<String> exaResponse = restTemplate.exchange(endPoint+"/examenes/createExamenSP", HttpMethod.POST,entity,String.class);
            
            if(exaResponse.getStatusCode()==HttpStatus.OK){
                String resultadoAddExa = exaResponse.getBody();
                logger.info("1 : se agrego exa, 0 : resultado con error = "+ resultadoAddExa);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

