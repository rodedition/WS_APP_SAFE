/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Cliente;
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
@Repository("clienteDAO")
@Transactional
public class ClienteDAOImpl implements ClienteDAO{
    Logger logger = Logger.getLogger(ClienteDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
    
    //private EntityManager em;
    
    @Override
    public List<Cliente> getListCliente() {
        return (List<Cliente>)sessionFactory.getCurrentSession().createCriteria(Cliente.class).list();
    }
    
    @Override
    public boolean addCliente(Cliente cliente) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().save(cliente);
        flagsave=true;
        
        return flagsave;
    }

    public Cliente getByIdCliente(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Cliente as c WHERE c.idcliente=:id");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Cliente)queryList.get(0);
        }else{
            return null;
        }
    }

    public void deleteCliente(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete FROM Cliente as c WHERE c.idcliente=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public boolean updateCliente(Cliente cliente) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().update(cliente);
        flagsave=true;
        
        return flagsave;
    }

    /*@PersistenceContext
    private EntityManager em
    public Cliente cap_consultar(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("BEGIN cap_consulta(:id); END");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Cliente)queryList.get(0);
        }else{
            return null;
        }
        
         
        this.em.createNativeQuery("BEGIN cap_consulta(:id); END")
                .setParameter("id", id)
                .executeUpdate(); 
        
    }
*/
   /* private EntityManagerFactory emf;
    public Cliente cliente_consultar(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        StoredProcedureQuery spQuery = this.em.createNamedStoredProcedureQuery("Cliente_Consultar");
                spQuery.setParameter("id", id)
                .executeUpdate(); */
        
        
        
        
        
        /*Query query = sessionFactory.getCurrentSession().createQuery("BEGIN Cliente_Consultar(:id); END;");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Cliente)queryList.get(0);
        }else{
            return null;
        }
    }*/

       
    /*public Cliente cliente_consultar(Long id, String rut) {
        
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Cliente_Consultar").setParameter("id_cliente", id).setParameter("rut_cliente", rut);
        
        //StoredProcedureQuery query = entityManager.createStoredProcedureQuery("")
        //Query query = sessionFactory.getCurrentSession().getNamedQuery("Cliente_Consultar");
        //query.setParameter("id", id);
        //query.setParameter("rut", rut);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Cliente)queryList.get(0);
            
        }else{
            return null;
        }
    }*/

    /*@SuppressWarnings("unchecked")
    public List<Cliente> cliente_consultar(String rut) {
        
        return em.createNativeQuery("Cliente_Consultar").setParameter("id_cliente", rut).getResultList();
    }*/

   
    
    
    
}
