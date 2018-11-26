/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Obs_Ingeniero;
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
@Repository("obs_IngenieroDAO")
@Transactional
public class Obs_IngenieroDAOImpl implements Obs_IngenieroDAO{
    Logger logger = Logger.getLogger(Obs_IngenieroDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
    
    //Llamadas a procedures

    @Override
    public List<Obs_Ingeniero> addObsIngSP(Obs_Ingeniero obs_Ingeniero) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Obs_Ingeniero>>() {
              @Override
              public List<Obs_Ingeniero> execute(Connection connection) throws SQLException {
                String query = "{CALL OBS_INGENIERO_PKG.obs_ingeniero_agregar(?, ?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);
                statement.setLong(1, obs_Ingeniero.getIdobsingeniero());
                statement.setString(2, obs_Ingeniero.getFechahoraobsing());
                statement.setString(3, obs_Ingeniero.getObsing());
                statement.setLong(4, obs_Ingeniero.getEvalterridevalterr());
                statement.setLong(5, obs_Ingeniero.getEstadoObsIng());
                statement.registerOutParameter(6, OracleTypes.CURSOR);                                
                statement.executeUpdate();   
                ResultSet rs = (ResultSet) statement.getObject(6);
                List<Obs_Ingeniero> obs;
                obs = new ArrayList<Obs_Ingeniero>();
                while (rs.next()) {
                    Obs_Ingeniero obs_Ingeniero = new Obs_Ingeniero();
                    obs_Ingeniero.setIdobsingeniero(rs.getLong("ID_OBS_INGENIERO"));
                    obs_Ingeniero.setFechahoraobsing(rs.getString("FECHA_HORA_OBS_ING"));
                    obs_Ingeniero.setObsing(rs.getString("OBS_ING"));
                    obs_Ingeniero.setEvalterridevalterr(rs.getLong("EVAL_TERR_ID_EVAL_TERR"));
                    obs_Ingeniero.setEstadoObsIng(rs.getLong("ESTADO"));
                    obs.add(obs_Ingeniero);
                }
                return obs;
            }
        });
    }

    @Override
    public List<Obs_Ingeniero> getByIdObsIngSP(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Obs_Ingeniero>>() {
            @Override
            public List<Obs_Ingeniero> execute(Connection connection) throws SQLException {
                String query = "{CALL OBS_INGENIERO_PKG.obs_ingeniero_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, id);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Obs_Ingeniero> obs;
                obs = new ArrayList<Obs_Ingeniero>();
                while (rs.next()) {
                    Obs_Ingeniero obs_Ingeniero = new Obs_Ingeniero();
                    obs_Ingeniero.setIdobsingeniero(rs.getLong("ID_OBS_INGENIERO"));
                    obs_Ingeniero.setFechahoraobsing(rs.getString("FECHA_HORA_OBS_ING"));
                    obs_Ingeniero.setObsing(rs.getString("OBS_ING"));
                    obs_Ingeniero.setEvalterridevalterr(rs.getLong("EVAL_TERR_ID_EVAL_TERR"));
                    obs_Ingeniero.setEstadoObsIng(rs.getLong("ESTADO"));
                    obs.add(obs_Ingeniero);
                }
                return obs;
            }
        });
    }

    @Override
    public List<Obs_Ingeniero> getAllObsIngSP() {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Obs_Ingeniero>>() {
            @Override
            public List<Obs_Ingeniero> execute(Connection connection) throws SQLException {
                String query = "{CALL OBS_INGENIERO_PKG.All_obs_ingeniero_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, 1L);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Obs_Ingeniero> obs;
                obs = new ArrayList<Obs_Ingeniero>();
                while (rs.next()) {
                    Obs_Ingeniero obs_Ingeniero = new Obs_Ingeniero();
                    obs_Ingeniero.setIdobsingeniero(rs.getLong("ID_OBS_INGENIERO"));
                    obs_Ingeniero.setFechahoraobsing(rs.getString("FECHA_HORA_OBS_ING"));
                    obs_Ingeniero.setObsing(rs.getString("OBS_ING"));
                    obs_Ingeniero.setEvalterridevalterr(rs.getLong("EVAL_TERR_ID_EVAL_TERR"));
                    obs_Ingeniero.setEstadoObsIng(rs.getLong("ESTADO"));
                    obs.add(obs_Ingeniero);
                }
                return obs;
            }
        });
    }

    @Override
    public boolean updateObsIngSP(Obs_Ingeniero obs_Ingeniero) {
        boolean flagsave = false;
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL OBS_INGENIERO_PKG.obs_ingeniero_modificar(?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);                
                statement.setString(1, obs_Ingeniero.getFechahoraobsing());
                statement.setString(2, obs_Ingeniero.getObsing());
                statement.setLong(3, obs_Ingeniero.getEvalterridevalterr());
                statement.setLong(4, obs_Ingeniero.getEstadoObsIng());
                statement.setLong(5, obs_Ingeniero.getIdobsingeniero());
                statement.executeUpdate();
            }
        });        
       
        flagsave=true;
        return flagsave;
    }

    @Override
    public void deleteObsIngSP(Long id, Long estado) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL OBS_INGENIERO_PKG.obs_ingeniero_eliminar(:id_obs_ing, :est_obs)").addEntity(Obs_Ingeniero.class).
        setParameter("id_obs_ing", id).setParameter("est_obs", estado);        
        query.executeUpdate();
    }
}
