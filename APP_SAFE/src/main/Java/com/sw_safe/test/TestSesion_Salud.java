package com.sw_safe.test;

import com.google.gson.Gson;
import com.ws_safe.entity.Sesion_Salud;
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
public class TestSesion_Salud {
    Logger logger = Logger.getLogger(TestSesion_Salud.class);
    
    /**
     *
     */
    @Test
    public void testWSRest(){
        try {
            
            final String endPoint = "http://localhost:7101/app_safe";
            RestTemplate restTemplate = new RestTemplate();
            String resultGetSes = restTemplate.getForObject(endPoint+"/sesionSalud/sw", String.class);
            Gson gson = new Gson();
            
            Sesion_Salud[] data = gson.fromJson(resultGetSes, Sesion_Salud[].class);
            
            for(Sesion_Salud dat:data){
                System.out.println("id sesion: " + dat.getIdsesionsalud());
            }
            
            //Agregar sesion salud
            
            Sesion_Salud ses = new Sesion_Salud();
            ses.setIdsesionsalud(20);
            ses.setNumsesionsalud(1);
            ses.setNombresesionsalud("Vías respiratorias");
            ses.setCupossesion(15);
            ses.setFechasesion(Date.from(Instant.MIN));
            ses.setHorainiciosalud(Date.from(Instant.MIN));
            ses.setHoraterminosalud(Date.from(Instant.MIN));
            ses.setDescripcionsesionsalud("Vías circulatorias de los humanos");
            ses.setMedicoidmedico(1);
            ses.setExamenesidexamenes(1);
            ses.setEstadosesionsalud(1);
            
            Gson request = new Gson();
            String datarequest = request.toJson(ses);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(datarequest.toString(), headers);
            ResponseEntity<String> sesResponse = restTemplate.exchange(endPoint+"/sesionSalud/createSesionSalud", HttpMethod.POST,entity,String.class);
            
            if(sesResponse.getStatusCode()==HttpStatus.OK){
                String resultadoAddSes = sesResponse.getBody();
                logger.info("1 : se agrego sesion, 0 : resultado con error = "+ resultadoAddSes);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

