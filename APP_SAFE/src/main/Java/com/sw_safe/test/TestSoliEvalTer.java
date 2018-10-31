package com.sw_safe.test;

import com.google.gson.Gson;
import com.ws_safe.entity.SoliEvalTer;
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
public class TestSoliEvalTer {
    Logger logger = Logger.getLogger(TestSoliEvalTer.class);
    
    /**
     *
     */
    @Test
    public void testWSRest(){
        try {
            
            final String endPoint = "http://localhost:7101/app_safe";
            RestTemplate restTemplate = new RestTemplate();
            String resultGetSol = restTemplate.getForObject(endPoint+"/SolicitudEvalTerreno/sw", String.class);
            Gson gson = new Gson();
            
            SoliEvalTer[] data = gson.fromJson(resultGetSol, SoliEvalTer[].class);
            
            for(SoliEvalTer dat:data){
                System.out.println("id solicitud: " + dat.getIdsolicitud());
            }
            
            //Agregar solicitud
            
            SoliEvalTer sol = new SoliEvalTer();
            sol.setIdsolicitud(10);
            sol.setFechacreacion(Date.from(Instant.MIN));
            sol.setDireccionvisita("Cerro el Plomo");
            sol.setDescripcionvisita("Evaluación personas");
            sol.setClienteidcliente(1);
            sol.setTipovisitteridtipovister(1);
            sol.setEstadosolievalter(1);
            
            Gson request = new Gson();
            String datarequest = request.toJson(sol);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(datarequest.toString(), headers);
            ResponseEntity<String> solResponse = restTemplate.exchange(endPoint+"/SolicitudEvalTerreno/createSoliEvalTer", HttpMethod.POST,entity,String.class);
            
            if(solResponse.getStatusCode()==HttpStatus.OK){
                String resultadoAddSol = solResponse.getBody();
                logger.info("1 : se agrego solicitud, 0 : resultado con error = "+ resultadoAddSol);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

