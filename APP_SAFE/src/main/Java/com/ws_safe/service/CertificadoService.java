/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.entity.Certificado;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface CertificadoService {
        
    //Interfaces Llamadas a PROCEDURE
    public boolean addCertificadoSP(Certificado certificado);
    public List<Certificado> getByIdCertificadoSP(Long id);
    public List<Certificado> getAllCertificadoSP();
    public boolean updateCertificadoSP (Certificado certificado);
    public void deleteCertificadoSP(Long id, Long estado);
}

