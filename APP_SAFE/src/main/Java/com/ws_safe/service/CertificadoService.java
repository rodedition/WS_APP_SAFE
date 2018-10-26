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
    public List<Certificado> getListCertificado();
    public boolean addCertificado(Certificado certificado);
    public Certificado getByIdCertificado (Long id);
    public void deleteCertificado (Long id);
    public boolean updateCertificado (Certificado capacitacion);
}

