package com.sw_safe.test;

import com.google.gson.Gson;
import com.ws_safe.entity.Usuarios;
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
public class TestUsuario {
    Logger logger = Logger.getLogger(TestUsuario.class);
    
    /**
     *
     */
    @Test
    public void testWSRest(){
        try {
            
            final String endPoint = "http://localhost:7101/app_safe";
            RestTemplate restTemplate = new RestTemplate();
            String resultGetUsu = restTemplate.getForObject(endPoint+"/usuarios/sw", String.class);
            Gson gson = new Gson();
            
            Usuarios[] data = gson.fromJson(resultGetUsu, Usuarios[].class);
            
            for(Usuarios dat:data){
                System.out.println("Nombre usuario: " + dat.getNombresusuario());
            }
            
            //Agregar usuario
            
            Usuarios usu = new Usuarios();
            usu.setIdusuario(1);
            usu.setRunusuario("12.236.985-8");
            usu.setNombresusuario("Pedro");
            usu.setAppaterno("Vargas");
            usu.setApmaterno("Barrera");
            usu.setFnacimientousuario(Date.from(Instant.MIN));
            usu.setSexousuario("Masculino");
            usu.setTelusuario("985247852");
            usu.setMailusuario("a@a.cl");
            usu.setEstadousuario(1);
            usu.setClaveusuario("123");
            usu.setPerfilidperfil(1);
            usu.setClienteidcliente(1);
            
            Gson request = new Gson();
            String datarequest = request.toJson(usu);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(datarequest.toString(), headers);
            ResponseEntity<String> usuResponse = restTemplate.exchange(endPoint+"/usuarios/createUsuario", HttpMethod.POST,entity,String.class);
            
            if(usuResponse.getStatusCode()==HttpStatus.OK){
                String resultadoAddMed = usuResponse.getBody();
                logger.info("1 : se agrego usuario, 0 : resultado con error = "+ resultadoAddMed);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

