package com.sw_safe.test;

import com.google.gson.Gson;
import com.ws_safe.entity.Plan_Cap;
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
public class TestPlan_Cap {
    Logger logger = Logger.getLogger(TestPlan_Cap.class);
    
    /**
     *
     */
    @Test
    public void testWSRest(){
        try {
            
            final String endPoint = "http://localhost:7101/app_safe";
            RestTemplate restTemplate = new RestTemplate();
            String resultGetPla = restTemplate.getForObject(endPoint+"/planCapacitacion/sw", String.class);
            Gson gson = new Gson();
            
            Plan_Cap[] data = gson.fromJson(resultGetPla, Plan_Cap[].class);
            
            for(Plan_Cap dat:data){
                System.out.println("id plan: " + dat.getIdplancap());
            }
            
            //Agregar Plan Medico
            
            Plan_Cap pla = new Plan_Cap();
            pla.setIdplancap(3);
            pla.setFechacreacion(Date.from(Instant.MIN));
            pla.setEstadoplancap(1);
            pla.setClienteidcliente(1);
            
            Gson request = new Gson();
            String datarequest = request.toJson(pla);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(datarequest.toString(), headers);
            ResponseEntity<String> plaResponse = restTemplate.exchange(endPoint+"/planCapacitacion/createPlanCapacitacion", HttpMethod.POST,entity,String.class);
            if(plaResponse.getStatusCode()==HttpStatus.OK){
                String resultadoAddPla = plaResponse.getBody();
                logger.info("1 : se agrego plan, 0 : resultado con error = "+ resultadoAddPla);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

