/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Expositor;
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
@Repository("expositorDAO")
@Transactional
public class ExpositorDAOImpl implements ExpositorDAO{
    Logger logger = Logger.getLogger(ExpositorDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
    //Llamadas a procedures

    @Override
    public List<Expositor> addExpositorSP(Expositor expositor) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Expositor>>() {
              @Override
              public List<Expositor> execute(Connection connection) throws SQLException {
                String query = "{CALL EXPOSITORPKG.expositor_agregar(?, ?, ?, ?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);
                statement.setLong(1, expositor.getIdexpositor());
                statement.setString(2, expositor.getRunexpositor());
                statement.setString(3, expositor.getNombreexpositor());
                statement.setString(4, expositor.getTelexpositor());
                statement.setString(5, expositor.getMailexpositor());
                statement.setLong(6, expositor.getEstadoexpositor());
                statement.setString(7, expositor.getFechacreacion());
                statement.registerOutParameter(8, OracleTypes.CURSOR);                                
                statement.executeUpdate();   
                ResultSet rs = (ResultSet) statement.getObject(8);
                List<Expositor> expos;
                expos = new ArrayList<Expositor>();
                while (rs.next()) {
                    Expositor expositor = new Expositor();
                    expositor.setIdexpositor(rs.getLong("ID_EXPOSITOR"));
                    expositor.setRunexpositor(rs.getString("RUN_EXPOSITOR"));
                    expositor.setNombreexpositor(rs.getString("NOMBRE_EXPOSITOR"));
                    expositor.setTelexpositor(rs.getString("TEL_EXPOSITOR"));
                    expositor.setMailexpositor(rs.getString("MAIL_EXPOSITOR"));
                    expositor.setEstadoexpositor(rs.getLong("ESTADO_EXPOSITOR"));
                    expositor.setFechacreacion(rs.getString("FECHACREACION"));
                    expos.add(expositor);
                }
                return expos;
            }
        });
    }

    @Override
    public List<Expositor> getByIdExpositorSP(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Expositor>>() {
            @Override
            public List<Expositor> execute(Connection connection) throws SQLException {
                String query = "{CALL EXPOSITORPKG.expositor_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, id);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Expositor> expos;
                expos = new ArrayList<Expositor>();
                while (rs.next()) {
                    Expositor expositor = new Expositor();
                    expositor.setIdexpositor(rs.getLong("ID_EXPOSITOR"));
                    expositor.setRunexpositor(rs.getString("RUN_EXPOSITOR"));
                    expositor.setNombreexpositor(rs.getString("NOMBRE_EXPOSITOR"));
                    expositor.setTelexpositor(rs.getString("TEL_EXPOSITOR"));
                    expositor.setMailexpositor(rs.getString("MAIL_EXPOSITOR"));
                    expositor.setEstadoexpositor(rs.getLong("ESTADO_EXPOSITOR"));
                    expositor.setFechacreacion(rs.getString("FECHACREACION"));
                    expos.add(expositor);
                }
                return expos;
            }
        });
    }

    @Override
    public List<Expositor> getAllExpositoresSP() {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Expositor>>() {
            @Override
            public List<Expositor> execute(Connection connection) throws SQLException {
                String query = "{CALL EXPOSITORPKG.All_expositor_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, 1L);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Expositor> expos;
                expos = new ArrayList<Expositor>();
                while (rs.next()) {
                    Expositor expositor = new Expositor();
                    expositor.setIdexpositor(rs.getLong("ID_EXPOSITOR"));
                    expositor.setRunexpositor(rs.getString("RUN_EXPOSITOR"));
                    expositor.setNombreexpositor(rs.getString("NOMBRE_EXPOSITOR"));
                    expositor.setTelexpositor(rs.getString("TEL_EXPOSITOR"));
                    expositor.setMailexpositor(rs.getString("MAIL_EXPOSITOR"));
                    expositor.setEstadoexpositor(rs.getLong("ESTADO_EXPOSITOR"));
                    expositor.setFechacreacion(rs.getString("FECHACREACION"));
                    expos.add(expositor);
                }
                return expos;
            }
        });
    }

    @Override
    public boolean updateExpositorSP(Expositor expositor) {
        boolean flagsave = false;
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL EXPOSITORPKG.expositor_modificar(?, ?, ?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);                
                statement.setString(1, expositor.getRunexpositor());
                statement.setString(2, expositor.getNombreexpositor());
                statement.setString(3, expositor.getTelexpositor());
                statement.setString(4, expositor.getMailexpositor());
                statement.setLong(5, expositor.getEstadoexpositor());
                statement.setString(6, expositor.getFechacreacion());
                statement.setLong(7, expositor.getIdexpositor());
                statement.executeUpdate();
            }
        });        
       
        flagsave=true;
        return flagsave;
    }

    @Override
    public void deleteExpositorSP(Long id, Long estado) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL EXPOSITORPKG.expositor_eliminar(:id_exp, :est_exp)").addEntity(Expositor.class).
        setParameter("id_exp", id).setParameter("est_exp", estado);        
        query.executeUpdate();
    }
}
