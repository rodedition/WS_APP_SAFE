/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Examenes;
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
@Repository("examenesDAO")
@Transactional
public class ExamenesDAOImpl implements ExamenesDAO{
    Logger logger = Logger.getLogger(ExamenesDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
    //Llamadas a procedures

    @Override
    public boolean addExamenSP(Examenes examenes) {
        boolean flagsave = false;         
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL EXAMENESPKG.examen_agregar(?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);
                statement.setLong(1, examenes.getIdexamen());
                statement.setString(2, examenes.getNombreexamen());
                statement.setLong(3, examenes.getEstadoexamen());
                statement.setLong(4, examenes.getPlansaludidplansalud());
                statement.setLong(5, examenes.getTipoexamenidtipoexam());
                statement.executeUpdate();
            }
        });
       
        flagsave=true;
        return flagsave;
    }

    @Override
    public List<Examenes> getByIdExamenSP(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Examenes>>() {
            @Override
            public List<Examenes> execute(Connection connection) throws SQLException {
                String query = "{CALL EXAMENESPKG.examen_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, id);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Examenes> exams;
                exams = new ArrayList<Examenes>();
                while (rs.next()) {
                    Examenes examenes = new Examenes();
                    examenes.setIdexamen(rs.getLong("ID_EXAMEN"));
                    examenes.setNombreexamen(rs.getString("NOMBRE_EXAMEN"));
                    examenes.setEstadoexamen(rs.getLong("ESTADO_EXAMEN"));
                    examenes.setPlansaludidplansalud(rs.getLong("PLAN_SALUD_ID_PLAN_SALUD"));
                    examenes.setTipoexamenidtipoexam(rs.getLong("TIPO_EXAMEN_ID_TIPO_EXAM"));
                    exams.add(examenes);
                }
                return exams;
            }
        });
    }

    @Override
    public List<Examenes> getAllExamenesSP() {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Examenes>>() {
            @Override
            public List<Examenes> execute(Connection connection) throws SQLException {
                String query = "{CALL EXAMENESPKG.All_examen_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, 1L);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Examenes> examss;
                examss = new ArrayList<Examenes>();
                while (rs.next()) {
                    Examenes examenes = new Examenes();
                    examenes.setIdexamen(rs.getLong("ID_EXAMEN"));
                    examenes.setNombreexamen(rs.getString("NOMBRE_EXAMEN"));
                    examenes.setEstadoexamen(rs.getLong("ESTADO_EXAMEN"));
                    examenes.setPlansaludidplansalud(rs.getLong("PLAN_SALUD_ID_PLAN_SALUD"));
                    examenes.setTipoexamenidtipoexam(rs.getLong("TIPO_EXAMEN_ID_TIPO_EXAM"));
                    examss.add(examenes);
                }
                return examss;
            }
        });
    }

    @Override
    public boolean updateExamenSP(Examenes examenes) {
        boolean flagsave = false;
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL EXAMENESPKG.examen_modificar(?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);                
                statement.setString(1, examenes.getNombreexamen());
                statement.setLong(2, examenes.getEstadoexamen());
                statement.setLong(3, examenes.getPlansaludidplansalud());
                statement.setLong(4, examenes.getTipoexamenidtipoexam());
                statement.setLong(5, examenes.getIdexamen());
                statement.executeUpdate();
            }
        });        
       
        flagsave=true;
        return flagsave;
    }

    @Override
    public void deleteExamenSP(Long id, Long estado) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL EXAMENESPKG.examen_eliminar(:id_exa, :est_exa)").addEntity(Examenes.class).
        setParameter("id_exa", id).setParameter("est_exa", estado);        
        query.executeUpdate();
    }
}
