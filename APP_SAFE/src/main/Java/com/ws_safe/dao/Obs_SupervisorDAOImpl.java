/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Obs_Supervisor;
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
@Repository("obs_SupervisorDAO")
@Transactional
public class Obs_SupervisorDAOImpl implements Obs_SupervisorDAO{
    Logger logger = Logger.getLogger(Obs_SupervisorDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
        
    //Llamadas a procedures

    @Override
    public boolean addObsSupSP(Obs_Supervisor obs_Supervisor) {
        boolean flagsave = false;         
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL OBS_SUPERVISOR_PKG.obs_supervisor_agregar(?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);
                statement.setLong(1, obs_Supervisor.getIdobssupervisor());
                statement.setString(2, obs_Supervisor.getFechahoraobssupervisor());
                statement.setString(3, obs_Supervisor.getObssupervisor());
                statement.setLong(4, obs_Supervisor.getEstadoObsSupervisor());
                statement.setLong(5, obs_Supervisor.getEvalterridevalterr());
                statement.executeUpdate();
            }
        });
       
        flagsave=true;
        return flagsave;
    }

    @Override
    public List<Obs_Supervisor> getByIdObsSupSP(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Obs_Supervisor>>() {
            @Override
            public List<Obs_Supervisor> execute(Connection connection) throws SQLException {
                String query = "{CALL OBS_SUPERVISOR_PKG.obs_supervisor_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, id);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Obs_Supervisor> obs;
                obs = new ArrayList<Obs_Supervisor>();
                while (rs.next()) {
                    Obs_Supervisor obs_Supervisor = new Obs_Supervisor();
                    obs_Supervisor.setIdobssupervisor(rs.getLong("ID_OBS_SUPERVISOR"));
                    obs_Supervisor.setFechahoraobssupervisor(rs.getString("FECHA_HORA_OBS_SUPERVISOR"));
                    obs_Supervisor.setObssupervisor(rs.getString("OBS_SUPERVISOR"));
                    obs_Supervisor.setEstadoObsSupervisor(rs.getLong("ESTADO"));
                    obs_Supervisor.setEvalterridevalterr(rs.getLong("EVAL_TERR_ID_EVAL_TERR"));
                    obs.add(obs_Supervisor);
                }
                return obs;
            }
        });
    }

    @Override
    public List<Obs_Supervisor> getAllObsSupSP() {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Obs_Supervisor>>() {
            @Override
            public List<Obs_Supervisor> execute(Connection connection) throws SQLException {
                String query = "{CALL OBS_SUPERVISOR_PKG.All_obs_supervisor_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, 1L);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Obs_Supervisor> obs;
                obs = new ArrayList<Obs_Supervisor>();
                while (rs.next()) {
                    Obs_Supervisor obs_Supervisor = new Obs_Supervisor();
                    obs_Supervisor.setIdobssupervisor(rs.getLong("ID_OBS_SUPERVISOR"));
                    obs_Supervisor.setFechahoraobssupervisor(rs.getString("FECHA_HORA_OBS_SUPERVISOR"));
                    obs_Supervisor.setObssupervisor(rs.getString("OBS_SUPERVISOR"));
                    obs_Supervisor.setEstadoObsSupervisor(rs.getLong("ESTADO"));
                    obs_Supervisor.setEvalterridevalterr(rs.getLong("EVAL_TERR_ID_EVAL_TERR"));
                    obs.add(obs_Supervisor);
                }
                return obs;
            }
        });
    }

    @Override
    public boolean updateObsSupSP(Obs_Supervisor obs_Supervisor) {
        boolean flagsave = false;
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL OBS_SUPERVISOR_PKG.obs_supervisor_modificar(?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);                
                statement.setString(1, obs_Supervisor.getFechahoraobssupervisor());
                statement.setString(2, obs_Supervisor.getObssupervisor());
                statement.setLong(3, obs_Supervisor.getEstadoObsSupervisor());
                statement.setLong(4, obs_Supervisor.getEvalterridevalterr());
                statement.setLong(5, obs_Supervisor.getIdobssupervisor());
                statement.executeUpdate();
            }
        });        
       
        flagsave=true;
        return flagsave;
    }

    @Override
    public void deleteObsSupSP(Long id, Long estado) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL OBS_SUPERVISOR_PKG.obs_supervisor_eliminar(:id_obs_sup, :est_obs)").addEntity(Obs_Supervisor.class).
        setParameter("id_obs_sup", id).setParameter("est_obs", estado);        
        query.executeUpdate();
    }
    
    
}
