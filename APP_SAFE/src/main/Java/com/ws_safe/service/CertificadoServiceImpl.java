/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.dao.CertificadoDAO;
import com.ws_safe.entity.Certificado;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo
 */

@Service("certificadoService")
public class CertificadoServiceImpl implements CertificadoService{
    
    Logger logger = Logger.getLogger(CertificadoServiceImpl.class);
    
    @Autowired
    @Qualifier("certificadoDAO")
    
    CertificadoDAO certificadoDAOImpl;

    //Servicios para llamadas a base de datos directa
    
    public List<Certificado> getListCertificado() {
        return certificadoDAOImpl.getListCertificado();
    }

   
    public boolean addCertificado(Certificado certificado) {
        return certificadoDAOImpl.addCertificado(certificado);
    }

    public Certificado getByIdCertificado(Long id) {
        return certificadoDAOImpl.getByIdCertificado(id);
    }

    public void deleteCertificado(Long id) {
        certificadoDAOImpl.deleteCertificado(id);
    }

    public boolean updateCertificado(Certificado certificado) {
        return certificadoDAOImpl.updateCertificado(certificado);
    }    

    //Servicios para llamadas a PROCEDURE
    
    @Override
    public boolean addCertificadoSP(Certificado certificado) {
        return certificadoDAOImpl.addCertificadoSP(certificado);
    }

    @Override
    public List<Certificado> getByIdCertificadoSP(Long id) {
        return certificadoDAOImpl.getByIdCertificadoSP(id);
    }

    @Override
    public List<Certificado> getAllCertificadoSP() {
        return certificadoDAOImpl.getAllCertificadoSP();
    }

    @Override
    public boolean updateCertificadoSP(Certificado certificado) {
        return certificadoDAOImpl.updateCertificadoSP(certificado);
    }

    @Override
    public void deleteCertificadoSP(Long id, Long estado) {
        certificadoDAOImpl.deleteCertificadoSP(id, estado);
    }
    
}
