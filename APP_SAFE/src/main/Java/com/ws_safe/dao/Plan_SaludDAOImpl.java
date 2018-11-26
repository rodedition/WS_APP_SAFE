/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Plan_Salud;
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
@Repository("plan_SaludDAO")
@Transactional
public class Plan_SaludDAOImpl implements Plan_SaludDAO{
    Logger logger = Logger.getLogger(Plan_SaludDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
    //Llamadas a procedures

    @Override
    public List<Plan_Salud> addPlanSaludSP(Plan_Salud plan_Salud) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Plan_Salud>>() {
              @Override
              public List<Plan_Salud> execute(Connection connection) throws SQLException {
                String query = "{CALL PLAN_SALUD_PKG.plan_salud_agregar(?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);
                statement.setLong(1, plan_Salud.getIdplansalud());
                statement.setString(2, plan_Salud.getFechacreacion());
                statement.setLong(3, plan_Salud.getEstadoplansalud());
                statement.setLong(4, plan_Salud.getClienteidcliente());
                statement.registerOutParameter(5, OracleTypes.CURSOR);                                
                statement.executeUpdate();   
                ResultSet rs = (ResultSet) statement.getObject(5);
                List<Plan_Salud> plans;
                plans = new ArrayList<Plan_Salud>();
                while (rs.next()) {
                    Plan_Salud plan_Salud = new Plan_Salud();
                    plan_Salud.setIdplansalud(rs.getLong("ID_PLAN_SALUD"));
                    plan_Salud.setFechacreacion(rs.getString("FECHA_CREACION"));
                    plan_Salud.setEstadoplansalud(rs.getLong("ESTADO_PLAN_SALUD"));
                    plan_Salud.setClienteidcliente(rs.getLong("CLIENTE_ID_CLIENTE"));
                    plans.add(plan_Salud);
                }
                return plans;
            }
        });
    }

    @Override
    public List<Plan_Salud> getByIdPlanSaludSP(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Plan_Salud>>() {
            @Override
            public List<Plan_Salud> execute(Connection connection) throws SQLException {
                String query = "{CALL PLAN_SALUD_PKG.plan_salud_agregar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, id);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Plan_Salud> plans;
                plans = new ArrayList<Plan_Salud>();
                while (rs.next()) {
                    Plan_Salud plan_Salud = new Plan_Salud();
                    plan_Salud.setIdplansalud(rs.getLong("ID_PLAN_SALUD"));
                    plan_Salud.setFechacreacion(rs.getString("FECHA_CREACION"));
                    plan_Salud.setEstadoplansalud(rs.getLong("ESTADO_PLAN_SALUD"));
                    plan_Salud.setClienteidcliente(rs.getLong("CLIENTE_ID_CLIENTE"));
                    plans.add(plan_Salud);
                }
                return plans;
            }
        });
    }

    @Override
    public List<Plan_Salud> getAllPlanSaludSP() {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Plan_Salud>>() {
            @Override
            public List<Plan_Salud> execute(Connection connection) throws SQLException {
                String query = "{CALL PLAN_SALUD_PKG.All_plan_salud_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, 1L);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Plan_Salud> plans;
                plans = new ArrayList<Plan_Salud>();
                while (rs.next()) {
                    Plan_Salud plan_Salud = new Plan_Salud();
                    plan_Salud.setIdplansalud(rs.getLong("ID_PLAN_SALUD"));
                    plan_Salud.setFechacreacion(rs.getString("FECHA_CREACION"));
                    plan_Salud.setEstadoplansalud(rs.getLong("ESTADO_PLAN_SALUD"));
                    plan_Salud.setClienteidcliente(rs.getLong("CLIENTE_ID_CLIENTE"));
                    plans.add(plan_Salud);
                }
                return plans;
            }
        });
    }

    @Override
    public boolean updatePlanSaludSP(Plan_Salud plan_Salud) {
        boolean flagsave = false;
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL PLAN_SALUD_PKG.plan_salud_modificar(?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);                
                statement.setString(1, plan_Salud.getFechacreacion());
                statement.setLong(2, plan_Salud.getEstadoplansalud());
                statement.setLong(3, plan_Salud.getClienteidcliente());
                statement.setLong(4, plan_Salud.getIdplansalud());
                statement.executeUpdate();
            }
        });        
       
        flagsave=true;
        return flagsave;
    }

    @Override
    public void deletePlanSaludSP(Long id, Long estado) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL PLAN_SALUD_PKG.plan_salud_eliminar(:id_plan_sal, :est_plan_sal)").addEntity(Plan_Salud.class).
        setParameter("id_plan_sal", id).setParameter("est_plan_sal", estado);        
        query.executeUpdate();
    }
    
    
}
