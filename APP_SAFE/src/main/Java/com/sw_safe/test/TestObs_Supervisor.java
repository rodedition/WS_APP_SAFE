package com.sw_safe.test;

import com.google.gson.Gson;
import com.ws_safe.entity.Obs_Supervisor;
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
public class TestObs_Supervisor {
    Logger logger = Logger.getLogger(Obs_Supervisor.class);
    
    /**
     *
     */
    @Test
    public void testWSRest(){
        try {
            
            final String endPoint = "http://localhost:7101/app_safe";
            RestTemplate restTemplate = new RestTemplate();
            String resultGetObs = restTemplate.getForObject(endPoint+"/obsSupervisor/sw", String.class);
            Gson gson = new Gson();
            
            Obs_Supervisor[] data = gson.fromJson(resultGetObs, Obs_Supervisor[].class);
            
            for(Obs_Supervisor dat:data){
                System.out.println("Observacion supervisor.: " + dat.getObssupervisor());
            }
            
            //Agregar obs. ingeniero
            
            Obs_Supervisor obs = new Obs_Supervisor();
            obs.setIdobssupervisor(3);
            obs.setFechahoraobssupervisor("12-05-2018");
            obs.setObssupervisor("Se aprueba visita en terreno");
            obs.setEstadoObsSupervisor(1);
            obs.setEvalterridevalterr(1);
            
            Gson request = new Gson();
            String datarequest = request.toJson(obs);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(datarequest.toString(), headers);
            ResponseEntity<String> obsResponse = restTemplate.exchange(endPoint+"/obsSupervisor/createObsSupervisor", HttpMethod.POST,entity,String.class);
            
            if(obsResponse.getStatusCode()==HttpStatus.OK){
                String resultadoAddObs = obsResponse.getBody();
                logger.info("1 : se agrego obs, 0 : resultado con error = "+ resultadoAddObs);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

