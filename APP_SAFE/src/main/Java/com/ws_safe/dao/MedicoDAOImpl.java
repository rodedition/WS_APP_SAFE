/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Medico;
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
@Repository("medicoDAO")
@Transactional
public class MedicoDAOImpl implements MedicoDAO{
    Logger logger = Logger.getLogger(MedicoDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
    
    //Llamadas a procedures

    @Override
    public List<Medico> addMedicoSP(Medico medico) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Medico>>() {
              @Override
              public List<Medico> execute(Connection connection) throws SQLException {
                String query = "{CALL MEDICO_PKG.medico_agregar(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);
                statement.setLong(1, medico.getIdmedico());
                statement.setString(2, medico.getRunmedico());
                statement.setString(3, medico.getNombremedico());
                statement.setString(4, medico.getUniversidadMed());
                statement.setString(5, medico.getMailmedico());
                statement.setString(6, medico.getTelmedico());
                statement.setLong(7, medico.getEstadomedico());
                statement.setString(8, medico.getFechacreacion());
                statement.registerOutParameter(9, OracleTypes.CURSOR);                                
                statement.executeUpdate();   
                ResultSet rs = (ResultSet) statement.getObject(9);
                List<Medico> meds;
                meds = new ArrayList<Medico>();
                while (rs.next()) {
                    Medico medico = new Medico();
                    medico.setIdmedico(rs.getLong("ID_MEDICO"));
                    medico.setRunmedico(rs.getString("RUN_MEDICO"));
                    medico.setNombremedico(rs.getString("NOMBRE_MEDICO"));
                    medico.setUniversidadMed(rs.getString("UNIVERSIDAD"));
                    medico.setMailmedico(rs.getString("MAIL_MEDICO"));
                    medico.setTelmedico(rs.getString("TEL_MEDICO"));
                    medico.setEstadomedico(rs.getLong("ESTADO_MEDICO"));
                    medico.setFechacreacion(rs.getString("FECHACREACION"));
                    meds.add(medico);
                }
                return meds;
            }
        });
    }

    @Override
    public List<Medico> getByIdMedicoSP(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Medico>>() {
            @Override
            public List<Medico> execute(Connection connection) throws SQLException {
                String query = "{CALL MEDICO_PKG.medico_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, id);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Medico> meds;
                meds = new ArrayList<Medico>();
                while (rs.next()) {
                    Medico medico = new Medico();
                    medico.setIdmedico(rs.getLong("ID_MEDICO"));
                    medico.setRunmedico(rs.getString("RUN_MEDICO"));
                    medico.setNombremedico(rs.getString("NOMBRE_MEDICO"));
                    medico.setUniversidadMed(rs.getString("UNIVERSIDAD"));
                    medico.setMailmedico(rs.getString("MAIL_MEDICO"));
                    medico.setTelmedico(rs.getString("TEL_MEDICO"));
                    medico.setEstadomedico(rs.getLong("ESTADO_MEDICO"));
                    medico.setFechacreacion(rs.getString("FECHACREACION"));
                    meds.add(medico);
                }
                return meds;
            }
        });
    }

    @Override
    public List<Medico> getAllMedicoSP() {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Medico>>() {
            @Override
            public List<Medico> execute(Connection connection) throws SQLException {
                String query = "{CALL MEDICO_PKG.All_medico_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, 1L);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Medico> meds;
                meds = new ArrayList<Medico>();
                while (rs.next()) {
                    Medico medico = new Medico();
                    medico.setIdmedico(rs.getLong("ID_MEDICO"));
                    medico.setRunmedico(rs.getString("RUN_MEDICO"));
                    medico.setNombremedico(rs.getString("NOMBRE_MEDICO"));
                    medico.setUniversidadMed(rs.getString("UNIVERSIDAD"));
                    medico.setMailmedico(rs.getString("MAIL_MEDICO"));
                    medico.setTelmedico(rs.getString("TEL_MEDICO"));
                    medico.setEstadomedico(rs.getLong("ESTADO_MEDICO"));
                    medico.setFechacreacion(rs.getString("FECHACREACION"));
                    meds.add(medico);
                }
                return meds;
            }
        });
    }

    @Override
    public boolean updateMedicoSP(Medico medico) {
        boolean flagsave = false;
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL MEDICO_PKG.medico_modificar(?, ?, ?, ?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);                
                statement.setString(1, medico.getRunmedico());
                statement.setString(2, medico.getNombremedico());
                statement.setString(3, medico.getUniversidadMed());
                statement.setString(4, medico.getMailmedico());
                statement.setString(5, medico.getTelmedico());
                statement.setLong(6, medico.getEstadomedico());
                statement.setString(7, medico.getFechacreacion());
                statement.setLong(8, medico.getIdmedico());
                statement.executeUpdate();
            }
        });        
       
        flagsave=true;
        return flagsave;
    }

    @Override
    public void deleteMedicoSP(Long id, Long estado) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL MEDICO_PKG.medico_eliminar(:id_med, :est_med)").addEntity(Medico.class).
        setParameter("id_med", id).setParameter("est_med", estado);        
        query.executeUpdate();
    }
}
