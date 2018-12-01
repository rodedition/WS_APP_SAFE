/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.List_Asis_Cap;
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
@Repository("list_Asis_CapDao")
@Transactional
public class List_Asis_CapDaoImpl implements List_Asis_CapDao{
    Logger logger = Logger.getLogger(List_Asis_CapDaoImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
    //Llamadas a procedures

    @Override
    public List<List_Asis_Cap> addList_Asis_CapSP(List_Asis_Cap list_Asis_Cap) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<List_Asis_Cap>>() {
              @Override
              public List<List_Asis_Cap> execute(Connection connection) throws SQLException {
                String query = "{CALL List_Asis_Cap_PKG.list_asis_cap_agregar(?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);
                statement.setLong(1, list_Asis_Cap.getIdlistacap());
                statement.setLong(2, list_Asis_Cap.getEstadoasistcap());
                statement.setLong(3, list_Asis_Cap.getSesioncapidsesioncap());
                statement.registerOutParameter(4, OracleTypes.CURSOR);                                
                statement.executeUpdate();   
                ResultSet rs = (ResultSet) statement.getObject(4);
                List<List_Asis_Cap> lists;
                lists = new ArrayList<List_Asis_Cap>();
                while (rs.next()) {
                    List_Asis_Cap list_Asis_Cap = new List_Asis_Cap();
                    list_Asis_Cap.setIdlistacap(rs.getLong("ID_LISTA_CAP"));
                    list_Asis_Cap.setEstadoasistcap(rs.getLong("ESTADO_ASIST_CAP"));
                    list_Asis_Cap.setSesioncapidsesioncap(rs.getLong("SESION_CAP_ID_SESION_CAP"));
                    lists.add(list_Asis_Cap);
                }
                return lists;
            }
        });
    }

    @Override
    public List<List_Asis_Cap> getByIdList_Asis_CapSP(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<List_Asis_Cap>>() {
            @Override
            public List<List_Asis_Cap> execute(Connection connection) throws SQLException {
                String query = "{CALL List_Asis_Cap_PKG.list_asis_cap_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, id);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<List_Asis_Cap> lists;
                lists = new ArrayList<List_Asis_Cap>();
                while (rs.next()) {
                    List_Asis_Cap list_Asis_Cap = new List_Asis_Cap();
                    list_Asis_Cap.setIdlistacap(rs.getLong("ID_LISTA_CAP"));
                    list_Asis_Cap.setEstadoasistcap(rs.getLong("ESTADO_ASIST_CAP"));
                    list_Asis_Cap.setSesioncapidsesioncap(rs.getLong("SESION_CAP_ID_SESION_CAP"));
                    lists.add(list_Asis_Cap);
                }
                return lists;
            }
        });
    }

    @Override
    public List<List_Asis_Cap> getAllList_Asis_CapSP() {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<List_Asis_Cap>>() {
            @Override
            public List<List_Asis_Cap> execute(Connection connection) throws SQLException {
                String query = "{CALL List_Asis_Cap_PKG.All_list_asis_cap_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, 1L);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<List_Asis_Cap> lists;
                lists = new ArrayList<List_Asis_Cap>();
                while (rs.next()) {
                    List_Asis_Cap list_Asis_Cap = new List_Asis_Cap();
                    list_Asis_Cap.setIdlistacap(rs.getLong("ID_LISTA_CAP"));
                    list_Asis_Cap.setEstadoasistcap(rs.getLong("ESTADO_ASIST_CAP"));
                    list_Asis_Cap.setSesioncapidsesioncap(rs.getLong("SESION_CAP_ID_SESION_CAP"));
                    lists.add(list_Asis_Cap);
                }
                return lists;
            }
        });
    }

    @Override
    public boolean updateList_Asis_CapSP(List_Asis_Cap list_Asis_Cap) {
        boolean flagsave = false;
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL List_Asis_Cap_PKG.list_asis_cap_modificar(?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);                
                statement.setLong(1, list_Asis_Cap.getEstadoasistcap());
                statement.setLong(2, list_Asis_Cap.getSesioncapidsesioncap());
                statement.setLong(3, list_Asis_Cap.getIdlistacap());
                statement.executeUpdate();
            }
        });        
       
        flagsave=true;
        return flagsave;
    }

    @Override
    public void deleteList_Asis_CapSP(Long id, Long estado) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL List_Asis_Cap_PKG.list_asis_cap_eliminar(:id_list_cap, :est_asist_cap)").addEntity(List_Asis_Cap.class).
        setParameter("id_list_cap", id).setParameter("est_asist_cap", estado);        
        query.executeUpdate();
    }

}
