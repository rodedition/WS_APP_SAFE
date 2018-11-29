/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Eval_Terr;
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
@Repository("eval_TerrDao")
@Transactional
public class Eval_TerrDaoImpl implements Eval_TerrDao{
    
    Logger logger = Logger.getLogger(Eval_TerrDaoImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;   
    
    //Llamadas a procedures
     public List<Eval_Terr> addEval_TerrSP(Eval_Terr eval_Terr) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Eval_Terr>>() {
              @Override
              public List<Eval_Terr> execute(Connection connection) throws SQLException {
                String query = "{CALL Eval_TerrPKG.eval_terr_agregar(?, ?, ?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);
                statement.setLong(1, eval_Terr.getIdevalterr());
                statement.setString(2, eval_Terr.getObsvisita());
                statement.setLong(3, eval_Terr.getEstado());
                statement.setLong(4, eval_Terr.getSolievalteridsolicitud());
                statement.setLong(5, eval_Terr.getEstadoevalterridestado());
                statement.setLong(6, eval_Terr.getCertificadoidcertificado());
                statement.registerOutParameter(7, OracleTypes.CURSOR);                                
                statement.executeUpdate();   
                ResultSet rs = (ResultSet) statement.getObject(7);
                List<Eval_Terr> evals;
                evals = new ArrayList<Eval_Terr>();
                while (rs.next()) {
                    Eval_Terr eval_Terr = new Eval_Terr();
                    eval_Terr.setIdevalterr(rs.getLong("ID_EVAL_TERR"));
                    eval_Terr.setObsvisita(rs.getString("OBS_VISITA"));
                    eval_Terr.setEstado(rs.getLong("ESTADO"));
                    eval_Terr.setSolievalteridsolicitud(rs.getLong("SOLIEVALTER_ID_SOLICITUD"));
                    eval_Terr.setEstadoevalterridestado(rs.getLong("ESTADO_EVAL_TERR_ID_ESTADO"));
                    eval_Terr.setCertificadoidcertificado(rs.getLong("CERTIFICADO_ID_CERTIFICADO"));
                    evals.add(eval_Terr);
                }
                return evals;
            }
        });
    }  
    
    
    public List<Eval_Terr>getByIdEval_TerrSP(Long id) {
        
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Eval_Terr>>() {
            @Override
            public List<Eval_Terr> execute(Connection connection) throws SQLException {
                String query = "{CALL Eval_TerrPKG.eval_terr_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, id);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Eval_Terr> evals;
                evals = new ArrayList<Eval_Terr>();
                while (rs.next()) {
                    Eval_Terr eval_Terr = new Eval_Terr();
                    eval_Terr.setIdevalterr(rs.getLong("ID_EVAL_TERR"));
                    eval_Terr.setObsvisita(rs.getString("OBS_VISITA"));
                    eval_Terr.setEstado(rs.getLong("ESTADO"));
                    eval_Terr.setSolievalteridsolicitud(rs.getLong("SOLIEVALTER_ID_SOLICITUD"));
                    eval_Terr.setEstadoevalterridestado(rs.getLong("ESTADO_EVAL_TERR_ID_ESTADO"));
                    eval_Terr.setCertificadoidcertificado(rs.getLong("CERTIFICADO_ID_CERTIFICADO"));
                    evals.add(eval_Terr);
                }
                return evals;
            }
        });
    }  
    
    public List<Eval_Terr>getAllEval_TerrSP() {
        
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Eval_Terr>>() {
            @Override
            public List<Eval_Terr> execute(Connection connection) throws SQLException {
                String query = "{CALL Eval_TerrPKG.All_eval_terr_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, 1L);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Eval_Terr> evals;
                evals = new ArrayList<Eval_Terr>();
                while (rs.next()) {
                    Eval_Terr eval_Terr = new Eval_Terr();
                    eval_Terr.setIdevalterr(rs.getLong("ID_EVAL_TERR"));
                    eval_Terr.setObsvisita(rs.getString("OBS_VISITA"));
                    eval_Terr.setEstado(rs.getLong("ESTADO"));
                    eval_Terr.setSolievalteridsolicitud(rs.getLong("SOLIEVALTER_ID_SOLICITUD"));
                    eval_Terr.setEstadoevalterridestado(rs.getLong("ESTADO_EVAL_TERR_ID_ESTADO"));
                    eval_Terr.setCertificadoidcertificado(rs.getLong("CERTIFICADO_ID_CERTIFICADO"));
                    evals.add(eval_Terr);
                }
                return evals;
            }
        });
    }  
    
    @Override
    public boolean updateEval_TerrSP(Eval_Terr eval_Terr) {
        boolean flagsave = false;
         //try {
              Session session = sessionFactory.getCurrentSession();
              //session.beginTransaction();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                //CallableStatement statement = null;
                String query = "{CALL Eval_TerrPKG.eval_terr_modificar(?, ?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);                
                statement.setLong(1, eval_Terr.getIdevalterr());
                statement.setString(2, eval_Terr.getObsvisita());
                statement.setLong(3, eval_Terr.getEstado());
                statement.setLong(4, eval_Terr.getSolievalteridsolicitud());
                statement.setLong(5, eval_Terr.getEstadoevalterridestado());
                statement.setLong(6, eval_Terr.getCertificadoidcertificado());                               
                statement.executeUpdate(); 
            }
        });        
       
        flagsave=true;
        return flagsave;
    }
    
    public void deleteEval_TerrSP(Long id, Long estado) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL Eval_TerrPKG.eval_terr_eliminar(:id_eval_t, :estado_ev_ter)").addEntity(Eval_Terr.class).
        setParameter("id_eval_t", id).setParameter("estado_ev_ter", estado);        
        query.executeUpdate();
    }

    
}   
   