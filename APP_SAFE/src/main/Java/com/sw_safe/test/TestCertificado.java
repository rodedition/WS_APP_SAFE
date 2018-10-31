package com.sw_safe.test;

import com.google.gson.Gson;
import com.ws_safe.entity.Certificado;
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
public class TestCertificado {
    Logger logger = Logger.getLogger(TestCertificado.class);
    
    /**
     *
     */
    @Test
    public void testWSRest(){
        try {
            
            final String endPoint = "http://localhost:7101/app_safe";
            RestTemplate restTemplate = new RestTemplate();
            String resultGetCer = restTemplate.getForObject(endPoint+"/certificado/sw", String.class);
            Gson gson = new Gson();
            
            Certificado[] data = gson.fromJson(resultGetCer, Certificado[].class);
            
            for(Certificado dat:data){
                System.out.println("Nombre tipo Certificado: " + dat.getCodcertificado());
            }
            
            //Agregar certificado
            
            Certificado cer = new Certificado();
            cer.setIdcertificado(10);
            cer.setTipocertificado("Capacitación");
            cer.setCodcertificado("123asd");
            cer.setEstadocert(1);    
            
            Gson request = new Gson();
            String datarequest = request.toJson(cer);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(datarequest.toString(), headers);
            ResponseEntity<String> cerResponse = restTemplate.exchange(endPoint+"/certificado/createCertificado", HttpMethod.POST,entity,String.class);
            
            if(cerResponse.getStatusCode()==HttpStatus.OK){
                String resultadoAddCer = cerResponse.getBody();
                logger.info("1 : se agrego cer, 0 : resultado con error = "+ resultadoAddCer);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}