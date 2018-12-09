package com.sw_safe.test;

import com.google.gson.Gson;
import com.ws_safe.entity.Cliente;
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
public class TestCliente {
    Logger logger = Logger.getLogger(TestCliente.class);
    
    /**
     *
     */
    @Test
    public void testWSRest(){
        try {
            
            final String endPoint = "http://localhost:7101/app_safe";
            RestTemplate restTemplate = new RestTemplate();
            String resultGetCliente = restTemplate.getForObject(endPoint+"/cliente/getAllCliente/", String.class);
            Gson gson = new Gson();
            
            Cliente[] data = gson.fromJson(resultGetCliente, Cliente[].class);
            
            for(Cliente dat:data){
                System.out.println("Nombre Cliente: " + dat.getRazonsocial());
            }
            
            //Agregar cliente
            
            Cliente cliente = new Cliente();
            cliente.setIdcliente(1);
            cliente.setRazonsocial("Omar");
            cliente.setRutcliente("99.999.999-9");
            cliente.setGirocliente("Mineria");
            cliente.setDireccioncliente("Las Condes 1111");
            cliente.setTeloficina("224587968");
            cliente.setNombrecontacto("Norma");
            cliente.setFonocontacto("936982547");
            cliente.setMailcontacto("x@x.cl");
            cliente.setCargocontacto("administrador");
            cliente.setObservacionescliente("servicio de explosivos");
            cliente.setEstadocliente(1);
            cliente.setFechacreacion("09-12-2018");
            Gson request = new Gson();
            String datarequest = request.toJson(cliente);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(datarequest.toString(), headers);
            ResponseEntity<String> clienteResponse = restTemplate.exchange(endPoint+"/cliente/createClienteSP", HttpMethod.POST,entity,String.class);
            
            if(clienteResponse.getStatusCode()==HttpStatus.OK){
                String resultadoAddCliente = clienteResponse.getBody();
                logger.info("1 : se agrego cliente, 0 : resultado con error = "+ resultadoAddCliente);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
