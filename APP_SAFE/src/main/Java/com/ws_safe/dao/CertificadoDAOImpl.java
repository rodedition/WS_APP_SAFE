/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Certificado;
import com.ws_safe.entity.Cliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.jdbc.Work;

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
    
    //Llamadas directas a base de datos
        
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
    
    //Llamadas a procedures
    
     public boolean addCertificadoSP(Certificado certificado) {
        boolean flagsave = false;         
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL CertificadoPKG.cetificado_agregar(?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);
                statement.setLong(1, certificado.getIdcertificado());
                statement.setString(2, certificado.getTipocertificado());
                statement.setString(3, certificado.getCodcertificado());
                statement.setLong(4, certificado.getEstadocert());
                statement.executeUpdate();
            }
        });
       
        flagsave=true;
        return flagsave;
    }  
    
    
    public List<Certificado>getByIdCertificadoSP(Long id) {
        
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Certificado>>() {
            @Override
            public List<Certificado> execute(Connection connection) throws SQLException {
                String query = "{CALL CertificadoPKG.certificado_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, id);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Certificado> certifs;
                certifs = new ArrayList<Certificado>();
                while (rs.next()) {
                    Certificado certificado = new Certificado();
                    certificado.setIdcertificado(rs.getLong("ID_CERTIFICADO"));
                    certificado.setTipocertificado(rs.getString("TIPO_CERTIFICADO"));
                    certificado.setCodcertificado(rs.getString("COD_CERTIFICADO"));
                    certificado.setEstadocert(rs.getLong("ESTADO"));
                    certifs.add(certificado);
                }
                return certifs;
            }
        });
    }  
    
    public List<Certificado>getAllCertificadoSP() {
        
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Certificado>>() {
            @Override
            public List<Certificado> execute(Connection connection) throws SQLException {
                String query = "{CALL CertificadoPKG.All_certificado_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, 1L);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Certificado> certifs;
                certifs = new ArrayList<Certificado>();
                while (rs.next()) {
                    Certificado certificado = new Certificado();
                    certificado.setIdcertificado(rs.getLong("ID_CERTIFICADO"));
                    certificado.setTipocertificado(rs.getString("TIPO_CERTIFICADO"));
                    certificado.setCodcertificado(rs.getString("COD_CERTIFICADO"));
                    certificado.setEstadocert(rs.getLong("ESTADO"));
                    certifs.add(certificado);
                }
                return certifs;
            }
        });
    }  
    
    @Override
    public boolean updateCertificadoSP(Certificado certificado) {
        boolean flagsave = false;
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL CertificadoPKG.certificado_modificar(?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);                
                statement.setString(1, certificado.getTipocertificado());
                statement.setString(2, certificado.getCodcertificado());
                statement.setLong(3, certificado.getEstadocert());
                statement.setLong(4, certificado.getIdcertificado());
                statement.executeUpdate();
            }
        });        
       
        flagsave=true;
        return flagsave;
    }
    
    public void deleteCertificadoSP(Long id, Long estado) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL CertificadoPKG.certificado_eliminar(:id_cer, :estado_cer)").addEntity(Certificado.class).
        setParameter("id_cer", id).setParameter("estado_cer", estado);        
        query.executeUpdate();
    }

}
