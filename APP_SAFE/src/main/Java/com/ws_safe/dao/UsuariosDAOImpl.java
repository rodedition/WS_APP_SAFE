/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Usuarios;
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
@Repository("usuariosDAO")
@Transactional
public class UsuariosDAOImpl implements UsuariosDAO{
    Logger logger = Logger.getLogger(UsuariosDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
        
    @Override
    public List<Usuarios> getListUsuarios() {
        return (List<Usuarios>)sessionFactory.getCurrentSession().createCriteria(Usuarios.class).list();
    }
    
    @Override
    public boolean addUsuarios(Usuarios usuarios) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().save(usuarios);
        flagsave=true;
        
        return flagsave;
    }

    public Usuarios getByIdUsuarios(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Usuarios as c WHERE c.idusuario=:id");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Usuarios)queryList.get(0);
        }else{
            return null;
        }
    }

    public void deleteUsuarios(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete FROM Usuarios as c WHERE c.idusuario=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public boolean updateUsuarios(Usuarios usuarios) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().update(usuarios);
        flagsave=true;
        
        return flagsave;
    }   
}
