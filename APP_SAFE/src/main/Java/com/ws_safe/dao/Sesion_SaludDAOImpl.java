/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Sesion_Cap;
import com.ws_safe.entity.Sesion_Salud;
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
@Repository("sesion_SaludDAO")
@Transactional
public class Sesion_SaludDAOImpl implements Sesion_SaludDAO{
    Logger logger = Logger.getLogger(Sesion_SaludDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
    //Llamadas directas a base de datos
        
    @Override
    public List<Sesion_Salud> getListSesion_Salud() {
        return (List<Sesion_Salud>)sessionFactory.getCurrentSession().createCriteria(Sesion_Salud.class).list();
    }
    
    @Override
    public boolean addSesion_Salud(Sesion_Salud sesion_Salud) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().save(sesion_Salud);
        flagsave=true;
        
        return flagsave;
    }

    public Sesion_Salud getByIdSesion_Salud(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Sesion_Salud as c WHERE c.idsesionsalud=:id");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Sesion_Salud)queryList.get(0);
        }else{
            return null;
        }
    }

    public void deleteSesion_Salud(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete FROM Sesion_Salud as c WHERE c.idsesionsalud=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public boolean updateSesion_Salud(Sesion_Salud sesion_Salud) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().update(sesion_Salud);
        flagsave=true;
        
        return flagsave;
    }   
    
    //Llamadas a procedures

    @Override
    public boolean addSesionSaludSP(Sesion_Salud sesion_Salud) {
        boolean flagsave = false;         
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL SESION_SALUD_PKG.sesion_salud_agregar(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);
                statement.setLong(1, sesion_Salud.getIdsesionsalud());
                statement.setLong(2, sesion_Salud.getNumsesionsalud());
                statement.setString(3, sesion_Salud.getNombresesionsalud());
                statement.setLong(4, sesion_Salud.getCupossesion());
                statement.setString(5, sesion_Salud.getFechasesion());
                statement.setString(6, sesion_Salud.getHorainiciosalud());
                statement.setString(7, sesion_Salud.getHoraterminosalud());
                statement.setString(8, sesion_Salud.getDescripcionsesionsalud());
                statement.setLong(9, sesion_Salud.getMedicoidmedico());
                statement.setLong(10, sesion_Salud.getExamenesidexamenes());
                statement.setLong(11, sesion_Salud.getEstadosesionsalud());
                statement.executeUpdate();
            }
        });
       
        flagsave=true;
        return flagsave;
    }

    @Override
    public List<Sesion_Salud> getByIdSesionSaludSP(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Sesion_Salud>>() {
            @Override
            public List<Sesion_Salud> execute(Connection connection) throws SQLException {
                String query = "{CALL SESION_SALUD_PKG.sesion_salud_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, id);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Sesion_Salud> ses;
                ses = new ArrayList<Sesion_Salud>();
                while (rs.next()) {
                    Sesion_Salud sesion_Salud = new Sesion_Salud();
                    sesion_Salud.setIdsesionsalud(rs.getLong("ID_SESION_SALUD"));
                    sesion_Salud.setNumsesionsalud(rs.getLong("NUM_SESION_SALUD"));
                    sesion_Salud.setNombresesionsalud(rs.getString("NOMBRE_SESION_SALUD"));
                    sesion_Salud.setCupossesion(rs.getLong("CUPOS_SESION"));
                    sesion_Salud.setFechasesion(rs.getString("FECHA_SESION"));
                    sesion_Salud.setHorainiciosalud(rs.getString("HORA_INICIO_SALUD"));
                    sesion_Salud.setHoraterminosalud(rs.getString("HORA_TERMINO_SALUD"));
                    sesion_Salud.setDescripcionsesionsalud(rs.getString("DESCRIPCION_SESION_SALUD"));
                    sesion_Salud.setMedicoidmedico(rs.getLong("MEDICO_ID_MEDICO"));
                    sesion_Salud.setExamenesidexamenes(rs.getLong("EXAMENES_ID_EXAMEN"));
                    sesion_Salud.setEstadosesionsalud(rs.getLong("ESTADO"));
                    ses.add(sesion_Salud);
                }
                return ses;
            }
        });
    }

    @Override
    public List<Sesion_Salud> getAllSesionSaludSP() {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Sesion_Salud>>() {
            @Override
            public List<Sesion_Salud> execute(Connection connection) throws SQLException {
                String query = "{CALL SESION_SALUD_PKG.All_sesion_salud_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, 1L);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Sesion_Salud> ses;
                ses = new ArrayList<Sesion_Salud>();
                while (rs.next()) {
                    Sesion_Salud sesion_Salud = new Sesion_Salud();
                    sesion_Salud.setIdsesionsalud(rs.getLong("ID_SESION_SALUD"));
                    sesion_Salud.setNumsesionsalud(rs.getLong("NUM_SESION_SALUD"));
                    sesion_Salud.setNombresesionsalud(rs.getString("NOMBRE_SESION_SALUD"));
                    sesion_Salud.setCupossesion(rs.getLong("CUPOS_SESION"));
                    sesion_Salud.setFechasesion(rs.getString("FECHA_SESION"));
                    sesion_Salud.setHorainiciosalud(rs.getString("HORA_INICIO_SALUD"));
                    sesion_Salud.setHoraterminosalud(rs.getString("HORA_TERMINO_SALUD"));
                    sesion_Salud.setDescripcionsesionsalud(rs.getString("DESCRIPCION_SESION_SALUD"));
                    sesion_Salud.setMedicoidmedico(rs.getLong("MEDICO_ID_MEDICO"));
                    sesion_Salud.setExamenesidexamenes(rs.getLong("EXAMENES_ID_EXAMEN"));
                    sesion_Salud.setEstadosesionsalud(rs.getLong("ESTADO"));
                    ses.add(sesion_Salud);
                }
                return ses;
            }
        });
    }

    @Override
    public boolean updateSesionSaludSP(Sesion_Salud sesion_Salud) {
        boolean flagsave = false;
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL SESION_SALUD_PKG.sesion_salud_modificar(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);               
                statement.setLong(1, sesion_Salud.getNumsesionsalud());
                statement.setString(2, sesion_Salud.getNombresesionsalud());
                statement.setLong(3, sesion_Salud.getCupossesion());
                statement.setString(4, sesion_Salud.getFechasesion());
                statement.setString(5, sesion_Salud.getHorainiciosalud());
                statement.setString(6, sesion_Salud.getHoraterminosalud());
                statement.setString(7, sesion_Salud.getDescripcionsesionsalud());
                statement.setLong(8, sesion_Salud.getMedicoidmedico());
                statement.setLong(9, sesion_Salud.getExamenesidexamenes());
                statement.setLong(10, sesion_Salud.getEstadosesionsalud());
                statement.setLong(11, sesion_Salud.getIdsesionsalud());
                statement.executeUpdate();
            }
        });        
       
        flagsave=true;
        return flagsave;
    }

    @Override
    public void deleteSesionSaludSP(Long id, Long estado) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL SESION_SALUD_PKG.sesion_salud_eliminar(:id_ses_salud, :est_ses)").addEntity(Sesion_Salud.class).
        setParameter("id_ses_salud", id).setParameter("est_ses", estado);        
        query.executeUpdate();
    }
    
    
}
