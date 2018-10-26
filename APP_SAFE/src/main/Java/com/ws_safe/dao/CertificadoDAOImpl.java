/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Certificado;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rodrigo
 */
@Repository("certificadoDAO")
@Transactional
public class CertificadoDAOImpl implements CertificadoDAO{
    Logger logger = Logger.getLogger(CertificadoDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
        
    @Override
    public List<Certificado> getListCertificado() {
        return (List<Certificado>)sessionFactory.getCurrentSession().createCriteria(Certificado.class).list();
    }
    
    @Override
    public boolean addCertificado(Certificado certificado) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().save(certificado);
        flagsave=true;
        
        return flagsave;
    }

    public Certificado getByIdCertificado(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Certificado as c WHERE c.idcertificado=:id");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Certificado)queryList.get(0);
        }else{
            return null;
        }
    }

    public void deleteCertificado(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete FROM Certificado as c WHERE c.idcertificado=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public boolean updateCertificado(Certificado certificado) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().update(certificado);
        flagsave=true;
        
        return flagsave;
    }   
}
