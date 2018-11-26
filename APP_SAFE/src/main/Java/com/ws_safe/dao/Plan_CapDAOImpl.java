/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Plan_Cap;
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
@Repository("plan_CapDAO")
@Transactional
public class Plan_CapDAOImpl implements Plan_CapDAO{
    Logger logger = Logger.getLogger(Plan_CapDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
    //Llamadas a procedures

    @Override
    public List<Plan_Cap> addPlanCapSP(Plan_Cap plan_Cap) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Plan_Cap>>() {
              @Override
              public List<Plan_Cap> execute(Connection connection) throws SQLException {
                String query = "{CALL PLAN_CAP_PKG.plan_cap_agregar(?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);
                statement.setLong(1, plan_Cap.getIdplancap());
                statement.setString(2, plan_Cap.getFechacreacion());
                statement.setLong(3, plan_Cap.getEstadoplancap());
                statement.setLong(4, plan_Cap.getClienteidcliente());
                statement.registerOutParameter(5, OracleTypes.CURSOR);                                
                statement.executeUpdate();   
                ResultSet rs = (ResultSet) statement.getObject(5);
                List<Plan_Cap> plans;
                plans = new ArrayList<Plan_Cap>();
                while (rs.next()) {
                    Plan_Cap plan_Cap = new Plan_Cap();
                    plan_Cap.setIdplancap(rs.getLong("ID_PLAN_CAP"));
                    plan_Cap.setFechacreacion(rs.getString("FECHA_CREACION"));
                    plan_Cap.setEstadoplancap(rs.getLong("ESTADO_PLAN_CAP"));
                    plan_Cap.setClienteidcliente(rs.getLong("CLIENTE_ID_CLIENTE"));
                    plans.add(plan_Cap);
                }
                return plans;
            }
        });
    }

    @Override
    public List<Plan_Cap> getByIdPlanCapSP(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Plan_Cap>>() {
            @Override
            public List<Plan_Cap> execute(Connection connection) throws SQLException {
                String query = "{CALL PLAN_CAP_PKG.plan_cap_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, id);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Plan_Cap> plans;
                plans = new ArrayList<Plan_Cap>();
                while (rs.next()) {
                    Plan_Cap plan_Cap = new Plan_Cap();
                    plan_Cap.setIdplancap(rs.getLong("ID_PLAN_CAP"));
                    plan_Cap.setFechacreacion(rs.getString("FECHA_CREACION"));
                    plan_Cap.setEstadoplancap(rs.getLong("ESTADO_PLAN_CAP"));
                    plan_Cap.setClienteidcliente(rs.getLong("CLIENTE_ID_CLIENTE"));
                    plans.add(plan_Cap);
                }
                return plans;
            }
        });
    }

    @Override
    public List<Plan_Cap> getAllPlanCapSP() {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Plan_Cap>>() {
            @Override
            public List<Plan_Cap> execute(Connection connection) throws SQLException {
                String query = "{CALL PLAN_CAP_PKG.All_plan_cap_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, 1L);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Plan_Cap> plans;
                plans = new ArrayList<Plan_Cap>();
                while (rs.next()) {
                    Plan_Cap plan_Cap = new Plan_Cap();
                    plan_Cap.setIdplancap(rs.getLong("ID_PLAN_CAP"));
                    plan_Cap.setFechacreacion(rs.getString("FECHA_CREACION"));
                    plan_Cap.setEstadoplancap(rs.getLong("ESTADO_PLAN_CAP"));
                    plan_Cap.setClienteidcliente(rs.getLong("CLIENTE_ID_CLIENTE"));
                    plans.add(plan_Cap);
                }
                return plans;
            }
        });
    }

    @Override
    public boolean updatePlanCapSP(Plan_Cap plan_Cap) {
        boolean flagsave = false;
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL PLAN_CAP_PKG.plan_cap_modificar(?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);                
                statement.setString(1, plan_Cap.getFechacreacion());
                statement.setLong(2, plan_Cap.getEstadoplancap());
                statement.setLong(3, plan_Cap.getClienteidcliente());
                statement.setLong(4, plan_Cap.getIdplancap());
                statement.executeUpdate();
            }
        });        
       
        flagsave=true;
        return flagsave;
    }

    @Override
    public void deletePlanCapSP(Long id, Long estado) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL PLAN_CAP_PKG.plan_cap_eliminar(:id_plan_capacitacion, :est_plan_cap)").addEntity(Plan_Cap.class).
        setParameter("id_plan_capacitacion", id).setParameter("est_plan_cap", estado);        
        query.executeUpdate();
    }
    
    
}
