package com.sw_safe.test;

import com.google.gson.Gson;
import com.ws_safe.entity.Obs_Ingeniero;
import java.time.Instant;
import org.apache.tools.ant.types.resources.comparators.Date;
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
public class TestObs_Ingeniero {
    Logger logger = Logger.getLogger(TestObs_Ingeniero.class);
    
    /**
     *
     */
    @Test
    public void testWSRest(){
        try {
            
            final String endPoint = "http://localhost:7101/app_safe";
            RestTemplate restTemplate = new RestTemplate();
            String resultGetObs = restTemplate.getForObject(endPoint+"/obsIngeniero/sw", String.class);
            Gson gson = new Gson();
            
            Obs_Ingeniero[] data = gson.fromJson(resultGetObs, Obs_Ingeniero[].class);
            
            for(Obs_Ingeniero dat:data){
                System.out.println("Observacion Ing.: " + dat.getObsing());
            }
            
            //Agregar obs. ingeniero
            
            Obs_Ingeniero obs = new Obs_Ingeniero();
            obs.setIdobsingeniero(3);
            obs.setFechahoraobsing("15-08-2018");
            obs.setObsing("Se aprueba visita en terreno");
            obs.setEvalterridevalterr(1);
            obs.setEstadoObsIng(1);   
            
            Gson request = new Gson();
            String datarequest = request.toJson(obs);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(datarequest.toString(), headers);
            ResponseEntity<String> obsResponse = restTemplate.exchange(endPoint+"/obsIngeniero/createObsIngeniero", HttpMethod.POST,entity,String.class);
            
            if(obsResponse.getStatusCode()==HttpStatus.OK){
                String resultadoAddObs = obsResponse.getBody();
                logger.info("1 : se agrego obs, 0 : resultado con error = "+ resultadoAddObs);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

