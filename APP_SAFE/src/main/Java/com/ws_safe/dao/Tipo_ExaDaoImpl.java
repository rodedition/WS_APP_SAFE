/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Tipo_Exa;
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
@Repository("tipo_ExaDAO")
@Transactional
public class Tipo_ExaDaoImpl implements Tipo_ExaDAO{

    Logger logger = Logger.getLogger(Tipo_ExaDaoImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;    
    
    //Llamadas a procedures

    @Override
    public List<Tipo_Exa> addTipoExaSP(Tipo_Exa tipo_Exa) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Tipo_Exa>>() {
              @Override
              public List<Tipo_Exa> execute(Connection connection) throws SQLException {
                String query = "{CALL TIPO_EXAMEN_PKG.tipo_exa_agregar(?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);
                statement.setLong(1, tipo_Exa.getIdtipoexam());
                statement.setString(2, tipo_Exa.getDescrip_exam());
                statement.setLong(3, tipo_Exa.getEstado());
                statement.registerOutParameter(4, OracleTypes.CURSOR);                                
                statement.executeUpdate();   
                ResultSet rs = (ResultSet) statement.getObject(4);
                List<Tipo_Exa> tips;
                tips = new ArrayList<Tipo_Exa>();
                while (rs.next()) {
                    Tipo_Exa tipo_Exa = new Tipo_Exa();
                    tipo_Exa.setIdtipoexam(rs.getLong("ID_TIPO_EXAM"));
                    tipo_Exa.setDescrip_exam(rs.getString("DESCRIP_EXAM"));
                    tipo_Exa.setEstado(rs.getLong("ESTADO"));
                    tips.add(tipo_Exa);
                    
                }
                return tips;
            }
        });
    }

    @Override
    public List<Tipo_Exa> getByIdTipoExaSP(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Tipo_Exa>>() {
            @Override
            public List<Tipo_Exa> execute(Connection connection) throws SQLException {
                String query = "{CALL TIPO_EXAMEN_PKG.tipo_exa_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, id);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Tipo_Exa> tips;
                tips = new ArrayList<Tipo_Exa>();
                while (rs.next()) {
                    Tipo_Exa tipo_Exa = new Tipo_Exa();
                    tipo_Exa.setIdtipoexam(rs.getLong("ID_TIPO_EXAM"));
                    tipo_Exa.setDescrip_exam(rs.getString("DESCRIP_EXAM"));
                    tipo_Exa.setEstado(rs.getLong("ESTADO"));
                    tips.add(tipo_Exa);
                }
                return tips;
            }
        });
    }

    @Override
    public List<Tipo_Exa> getAllTipoExaSP() {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Tipo_Exa>>() {
            @Override
            public List<Tipo_Exa> execute(Connection connection) throws SQLException {
                String query = "{CALL TIPO_EXAMEN_PKG.All_tipo_exa_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, 1L);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Tipo_Exa> tips;
                tips = new ArrayList<Tipo_Exa>();
                while (rs.next()) {
                    Tipo_Exa tipo_Exa = new Tipo_Exa();
                    tipo_Exa.setIdtipoexam(rs.getLong("ID_TIPO_EXAM"));
                    tipo_Exa.setDescrip_exam(rs.getString("DESCRIP_EXAM"));
                    tipo_Exa.setEstado(rs.getLong("ESTADO"));
                    tips.add(tipo_Exa);
                }
                return tips;
            }
        });
    }

    @Override
    public boolean updateTipoExaSP(Tipo_Exa tipo_Exa) {
        boolean flagsave = false;
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL TIPO_EXAMEN_PKG.tipo_exa_modificar(?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);                
                statement.setString(1, tipo_Exa.getDescrip_exam());
                statement.setLong(2, tipo_Exa.getEstado());
                statement.setLong(3, tipo_Exa.getIdtipoexam());
                statement.executeUpdate();
            }
        });        
       
        flagsave=true;
        return flagsave;
    }

    @Override
    public void deleteTipoExaSP(Long id, Long estado) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL TIPO_EXAMEN_PKG.tipo_exa_eliminar(:id_tipo_examen, :est_tipo_exa)").addEntity(Tipo_Exa.class).
        setParameter("id_tipo_examen", id).setParameter("est_tipo_exa", estado);        
        query.executeUpdate();
    }
    
    
    
}
