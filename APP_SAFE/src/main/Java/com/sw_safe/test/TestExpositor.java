package com.sw_safe.test;

import com.google.gson.Gson;
import com.ws_safe.entity.Expositor;
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
public class TestExpositor {
    Logger logger = Logger.getLogger(TestExpositor.class);
    
    /**
     *
     */
    @Test
    public void testWSRest(){
        try {
            
            final String endPoint = "http://localhost:7101/app_safe";
            RestTemplate restTemplate = new RestTemplate();
            String resultGetExp = restTemplate.getForObject(endPoint+"/expositor/getAllExpositor/", String.class);
            Gson gson = new Gson();
            
            Expositor[] data = gson.fromJson(resultGetExp, Expositor[].class);
            
            for(Expositor dat:data){
                System.out.println("Nombre Expositor: " + dat.getNombreexpositor());
            }
            
            //Agregar expositor
            
            Expositor exp = new Expositor();
            exp.setIdexpositor(2);
            exp.setRunexpositor("16.408.658-9");
            exp.setNombreexpositor("Javier Dominguez");
            exp.setTelexpositor("+569 58476321");
            exp.setMailexpositor("a@a.cl");
            exp.setEstadoexpositor(1);
            exp.setFechacreacion("09-12-2018");
            
            Gson request = new Gson();
            String datarequest = request.toJson(exp);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(datarequest.toString(), headers);
            ResponseEntity<String> expResponse = restTemplate.exchange(endPoint+"/expositor/createExpositorSP", HttpMethod.POST,entity,String.class);
            
            if(expResponse.getStatusCode()==HttpStatus.OK){
                String resultadoAddExp = expResponse.getBody();
                logger.info("1 : se agrego exp, 0 : resultado con error = "+ resultadoAddExp);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

