package com.sw_safe.test;

import com.google.gson.Gson;
import com.ws_safe.entity.Medico;
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
public class TestMedico {
    Logger logger = Logger.getLogger(TestMedico.class);
    
    /**
     *
     */
    @Test
    public void testWSRest(){
        try {
            
            final String endPoint = "http://localhost:7101/app_safe";
            RestTemplate restTemplate = new RestTemplate();
            String resultGetMed = restTemplate.getForObject(endPoint+"/medico/sw", String.class);
            Gson gson = new Gson();
            
            Medico[] data = gson.fromJson(resultGetMed, Medico[].class);
            
            for(Medico dat:data){
                System.out.println("Nombre Medico: " + dat.getNombremedico());
            }
            
            //Agregar medico
            
            Medico med = new Medico();
            med.setIdmedico(3);
            med.setRunmedico("10.236.587-9");
            med.setNombremedico("Andres");
            med.setUniversidadMed("Catolica");
            med.setMailmedico("a@a.cl");
            med.setTelmedico("995698741");
            med.setEstadomedico(1);
            
            Gson request = new Gson();
            String datarequest = request.toJson(med);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(datarequest.toString(), headers);
            ResponseEntity<String> medResponse = restTemplate.exchange(endPoint+"/medico/createMedico", HttpMethod.POST,entity,String.class);
            
            if(medResponse.getStatusCode()==HttpStatus.OK){
                String resultadoAddMed = medResponse.getBody();
                logger.info("1 : se agrego médico, 0 : resultado con error = "+ resultadoAddMed);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

