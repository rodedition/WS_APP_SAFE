/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Medico;
import com.ws_safe.entity.SoliEvalTer;
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
@Repository("soliEvalTerDAO")
@Transactional
public class SoliEvalTerDAOImpl implements SoliEvalTerDAO{
    Logger logger = Logger.getLogger(SoliEvalTerDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
    //Llamadas directas a base de datos
        
    @Override
    public List<SoliEvalTer> getListSoliEvalTer() {
        return (List<SoliEvalTer>)sessionFactory.getCurrentSession().createCriteria(SoliEvalTer.class).list();
    }
    
    @Override
    public boolean addSoliEvalTer(SoliEvalTer soliEvalTer) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().save(soliEvalTer);
        flagsave=true;
        
        return flagsave;
    }

    public SoliEvalTer getByIdSoliEvalTer(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM SoliEvalTer as c WHERE c.idsolicitud=:id");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (SoliEvalTer)queryList.get(0);
        }else{
            return null;
        }
    }

    public void deleteSoliEvalTer(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete FROM SoliEvalTer as c WHERE c.idsolicitud=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public boolean updateSoliEvalTer(SoliEvalTer soliEvalTer) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().update(soliEvalTer);
        flagsave=true;
        
        return flagsave;
    }   
    
    //Llamadas a procedures

    @Override
    public boolean addSoliEvalTerSP(SoliEvalTer soliEvalTer) {
        boolean flagsave = false;         
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL SOLIEVALTER_PKG.soliEvalTer_agregar(?, ?, ?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);
                statement.setLong(1, soliEvalTer.getIdsolicitud());
                statement.setString(2, soliEvalTer.getFechacreacion());
                statement.setString(3, soliEvalTer.getDireccionvisita());
                statement.setString(4, soliEvalTer.getDescripcionvisita());
                statement.setLong(5, soliEvalTer.getClienteidcliente());
                statement.setLong(6, soliEvalTer.getTipovisitteridtipovister());
                statement.setLong(7, soliEvalTer.getEstadosolievalter());
                statement.executeUpdate();
            }
        });
       
        flagsave=true;
        return flagsave;
    }

    @Override
    public List<SoliEvalTer> getByIdSoliEvalTerSP(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<SoliEvalTer>>() {
            @Override
            public List<SoliEvalTer> execute(Connection connection) throws SQLException {
                String query = "{CALL SOLIEVALTER_PKG.soliEvalTer_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, id);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<SoliEvalTer> sols;
                sols = new ArrayList<SoliEvalTer>();
                while (rs.next()) {
                    SoliEvalTer soliEvalTer = new SoliEvalTer();
                    soliEvalTer.setIdsolicitud(rs.getLong("ID_SOLICITUD"));
                    soliEvalTer.setFechacreacion(rs.getString("FECHA_CREACION"));
                    soliEvalTer.setDireccionvisita(rs.getString("DIRECCION_VISITA"));
                    soliEvalTer.setDescripcionvisita(rs.getString("DESCRIP_VISITA"));
                    soliEvalTer.setClienteidcliente(rs.getLong("CLIENTE_ID_CLIENTE"));
                    soliEvalTer.setTipovisitteridtipovister(rs.getLong("TIPOVISITTER_ID_TIPO_VISTER"));
                    soliEvalTer.setEstadosolievalter(rs.getLong("ESTADO"));
                    sols.add(soliEvalTer);
                }
                return sols;
            }
        });
    }

    @Override
    public List<SoliEvalTer> getAllSoliEvalTerSP() {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<SoliEvalTer>>() {
            @Override
            public List<SoliEvalTer> execute(Connection connection) throws SQLException {
                String query = "{CALL SOLIEVALTER_PKG.All_soliEvalTer_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, 1L);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<SoliEvalTer> sols;
                sols = new ArrayList<SoliEvalTer>();
                while (rs.next()) {
                    SoliEvalTer soliEvalTer = new SoliEvalTer();
                    soliEvalTer.setIdsolicitud(rs.getLong("ID_SOLICITUD"));
                    soliEvalTer.setFechacreacion(rs.getString("FECHA_CREACION"));
                    soliEvalTer.setDireccionvisita(rs.getString("DIRECCION_VISITA"));
                    soliEvalTer.setDescripcionvisita(rs.getString("DESCRIP_VISITA"));
                    soliEvalTer.setClienteidcliente(rs.getLong("CLIENTE_ID_CLIENTE"));
                    soliEvalTer.setTipovisitteridtipovister(rs.getLong("TIPOVISITTER_ID_TIPO_VISTER"));
                    soliEvalTer.setEstadosolievalter(rs.getLong("ESTADO"));
                    sols.add(soliEvalTer);
                }
                return sols;
            }
        });
    }

    @Override
    public boolean updateSoliEvalTerSP(SoliEvalTer soliEvalTer) {
        boolean flagsave = false;
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL SOLIEVALTER_PKG.soliEvalTer_eliminar(?, ?, ?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);                
                statement.setString(1, soliEvalTer.getFechacreacion());
                statement.setString(2, soliEvalTer.getDireccionvisita());
                statement.setString(3, soliEvalTer.getDescripcionvisita());
                statement.setLong(4, soliEvalTer.getClienteidcliente());
                statement.setLong(5, soliEvalTer.getTipovisitteridtipovister());
                statement.setLong(6, soliEvalTer.getEstadosolievalter());
                statement.setLong(7, soliEvalTer.getIdsolicitud());
                statement.executeUpdate();
            }
        });        
       
        flagsave=true;
        return flagsave;
    }

    @Override
    public void deleteSoliEvalTerSP(Long id, Long estado) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL SOLIEVALTER_PKG.soliEvalTer_eliminar(:id_soli, :est_soli_eval_ter)").addEntity(SoliEvalTer.class).
        setParameter("id_soli", id).setParameter("est_soli_eval_ter", estado);        
        query.executeUpdate();
    }
    
    
}
