/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.List_Asis_Salud;
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
@Repository("list_Asis_SaludDao")
@Transactional
public class List_Asis_SaludDaoImpl implements List_Asis_SaludDao{
    Logger logger = Logger.getLogger(List_Asis_SaludDaoImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
    //Llamadas a procedures

    @Override
    public List<List_Asis_Salud> addList_Asis_SaludSP(List_Asis_Salud list_Asis_Salud) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<List_Asis_Salud>>() {
              @Override
              public List<List_Asis_Salud> execute(Connection connection) throws SQLException {
                String query = "{CALL LISTASISSALUD_PKG.listasissalud_agregar(?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);
                statement.setLong(1, list_Asis_Salud.getIdlistsalud());
                statement.setLong(2, list_Asis_Salud.getEstadoasistsalud());
                statement.setLong(3, list_Asis_Salud.getSesionsaludidsesionsalud());
                statement.registerOutParameter(4, OracleTypes.CURSOR);                                
                statement.executeUpdate();   
                ResultSet rs = (ResultSet) statement.getObject(4);
                List<List_Asis_Salud> lists;
                lists = new ArrayList<List_Asis_Salud>();
                while (rs.next()) {
                    List_Asis_Salud list_Asis_Salud = new List_Asis_Salud();
                    list_Asis_Salud.setIdlistsalud(rs.getLong("ID_LIST_SALUD"));
                    list_Asis_Salud.setEstadoasistsalud(rs.getLong("ESTADO_ASIST_SALUD"));
                    list_Asis_Salud.setSesionsaludidsesionsalud(rs.getLong("SESION_SALUD_ID_SESION_SALUD"));
                    lists.add(list_Asis_Salud);
                }
                return lists;
            }
        });
    }

    @Override
    public List<List_Asis_Salud> getByIdList_Asis_SaludSP(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<List_Asis_Salud>>() {
            @Override
            public List<List_Asis_Salud> execute(Connection connection) throws SQLException {
                String query = "{CALL LISTASISSALUD_PKG.listasissalud_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, id);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<List_Asis_Salud> lists;
                lists = new ArrayList<List_Asis_Salud>();
                while (rs.next()) {
                    List_Asis_Salud list_Asis_Salud = new List_Asis_Salud();
                    list_Asis_Salud.setIdlistsalud(rs.getLong("ID_LIST_SALUD"));
                    list_Asis_Salud.setEstadoasistsalud(rs.getLong("ESTADO_ASIST_SALUD"));
                    list_Asis_Salud.setSesionsaludidsesionsalud(rs.getLong("SESION_SALUD_ID_SESION_SALUD"));
                    lists.add(list_Asis_Salud);
                }
                return lists;
            }
        });
    }

    @Override
    public List<List_Asis_Salud> getAllList_Asis_SaludSP() {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<List_Asis_Salud>>() {
            @Override
            public List<List_Asis_Salud> execute(Connection connection) throws SQLException {
                String query = "{CALL LISTASISSALUD_PKG.All_listasissalud_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, 1L);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<List_Asis_Salud> lists;
                lists = new ArrayList<List_Asis_Salud>();
                while (rs.next()) {
                    List_Asis_Salud list_Asis_Salud = new List_Asis_Salud();
                    list_Asis_Salud.setIdlistsalud(rs.getLong("ID_LIST_SALUD"));
                    list_Asis_Salud.setEstadoasistsalud(rs.getLong("ESTADO_ASIST_SALUD"));
                    list_Asis_Salud.setSesionsaludidsesionsalud(rs.getLong("SESION_SALUD_ID_SESION_SALUD"));
                    lists.add(list_Asis_Salud);
                }
                return lists;
            }
        });
    }

    @Override
    public boolean updateList_Asis_SaludSP(List_Asis_Salud list_Asis_Salud) {
        boolean flagsave = false;
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL LISTASISSALUD_PKG.listasissalud_modificar(?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);                
                statement.setLong(1, list_Asis_Salud.getEstadoasistsalud());
                statement.setLong(2, list_Asis_Salud.getSesionsaludidsesionsalud());
                statement.setLong(3, list_Asis_Salud.getIdlistsalud());
                statement.executeUpdate();
            }
        });        
       
        flagsave=true;
        return flagsave;
    }

    @Override
    public void deleteList_Asis_SaludSP(Long id, Long estado) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL LISTASISSALUD_PKG.listasissalud_eliminar(:id_li_salud, :est_asis_salud)").addEntity(List_Asis_Salud.class).
        setParameter("id_li_salud", id).setParameter("est_asis_salud", estado);        
        query.executeUpdate();
    }

}
