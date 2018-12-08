/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.List_Trab_Cap;
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
@Repository("list_Trab_CapDAO")
@Transactional
public class List_Trab_CapDAOImpl implements List_Trab_CapDAO{
    Logger logger = Logger.getLogger(List_Trab_CapDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
       
    //Llamadas a procedures

    @Override
    public List<List_Trab_Cap> addListTrabCapSP(List_Trab_Cap list_Trab_Cap) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<List_Trab_Cap>>() {
              @Override
              public List<List_Trab_Cap> execute(Connection connection) throws SQLException {
                String query = "{CALL List_Trab_Cap_PKG.list_trab_cap_agregar(?, ?, ?, ?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);
                statement.setLong(1, list_Trab_Cap.getIdlistrabcap());
                statement.setLong(2, list_Trab_Cap.getPresenteCap());
                statement.setLong(3, list_Trab_Cap.getEstadoCap());
                statement.setLong(4, list_Trab_Cap.getUsuarioidusuario());
                statement.setLong(5, list_Trab_Cap.getLisasiscapidlistacap());
                statement.setLong(6, list_Trab_Cap.getCertificadoidcertificado());
                statement.setString(7, list_Trab_Cap.getFechacreacion());
                statement.registerOutParameter(8, OracleTypes.CURSOR);                                
                statement.executeUpdate();   
                ResultSet rs = (ResultSet) statement.getObject(8);
                List<List_Trab_Cap> lists;
                lists = new ArrayList<List_Trab_Cap>();
                while (rs.next()) {
                    List_Trab_Cap listTrabCap = new List_Trab_Cap();
                    listTrabCap.setIdlistrabcap(rs.getLong("ID_LIS_TRAB_CAP"));
                    listTrabCap.setPresenteCap(rs.getLong("PRESENTE"));
                    listTrabCap.setEstadoCap(rs.getLong("ESTADO"));
                    listTrabCap.setUsuarioidusuario(rs.getLong("USUARIOS_ID_USUARIO"));
                    listTrabCap.setLisasiscapidlistacap(rs.getLong("LIST_ASIS_CAP_ID_LISTA_CAP"));
                    listTrabCap.setCertificadoidcertificado(rs.getLong("CERTIFICADO_ID_CERTIFICADO"));
                    listTrabCap.setFechacreacion(rs.getString("FECHACREACION"));
                    lists.add(listTrabCap);
                }
                return lists;
            }
        });
    }

    @Override
    public List<List_Trab_Cap> getByIdListTrabCapSP(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<List_Trab_Cap>>() {
            @Override
            public List<List_Trab_Cap> execute(Connection connection) throws SQLException {
                String query = "{CALL List_Trab_Cap_PKG.list_trab_cap_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, id);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<List_Trab_Cap> lists;
                lists = new ArrayList<List_Trab_Cap>();
                while (rs.next()) {
                    List_Trab_Cap listTrabCap = new List_Trab_Cap();
                    listTrabCap.setIdlistrabcap(rs.getLong("ID_LIS_TRAB_CAP"));
                    listTrabCap.setPresenteCap(rs.getLong("PRESENTE"));
                    listTrabCap.setEstadoCap(rs.getLong("ESTADO"));
                    listTrabCap.setUsuarioidusuario(rs.getLong("USUARIOS_ID_USUARIO"));
                    listTrabCap.setLisasiscapidlistacap(rs.getLong("LIST_ASIS_CAP_ID_LISTA_CAP"));
                    listTrabCap.setCertificadoidcertificado(rs.getLong("CERTIFICADO_ID_CERTIFICADO"));
                    listTrabCap.setFechacreacion(rs.getString("FECHACREACION"));
                    lists.add(listTrabCap);
                }
                return lists;
            }
        });
    }

    @Override
    public List<List_Trab_Cap> getAllListTrabCapSP() {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<List_Trab_Cap>>() {
            @Override
            public List<List_Trab_Cap> execute(Connection connection) throws SQLException {
                String query = "{CALL List_Trab_Cap_PKG.All_list_trab_cap_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, 1L);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<List_Trab_Cap> lists;
                lists = new ArrayList<List_Trab_Cap>();
                while (rs.next()) {
                    List_Trab_Cap listTrabCap = new List_Trab_Cap();
                    listTrabCap.setIdlistrabcap(rs.getLong("ID_LIS_TRAB_CAP"));
                    listTrabCap.setPresenteCap(rs.getLong("PRESENTE"));
                    listTrabCap.setEstadoCap(rs.getLong("ESTADO"));
                    listTrabCap.setUsuarioidusuario(rs.getLong("USUARIOS_ID_USUARIO"));
                    listTrabCap.setLisasiscapidlistacap(rs.getLong("LIST_ASIS_CAP_ID_LISTA_CAP"));
                    listTrabCap.setCertificadoidcertificado(rs.getLong("CERTIFICADO_ID_CERTIFICADO"));
                    listTrabCap.setFechacreacion(rs.getString("FECHACREACION"));
                    lists.add(listTrabCap);
                }
                return lists;
            }
        });
    }

    @Override
    public boolean updateListTrabCapSP(List_Trab_Cap list_Trab_Cap) {
        boolean flagsave = false;
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL List_Trab_Cap_PKG.list_trab_cap_modificar(?, ?, ?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);                
                statement.setLong(1, list_Trab_Cap.getPresenteCap());
                statement.setLong(2, list_Trab_Cap.getEstadoCap());
                statement.setLong(3, list_Trab_Cap.getUsuarioidusuario());
                statement.setLong(4, list_Trab_Cap.getLisasiscapidlistacap());
                statement.setLong(5, list_Trab_Cap.getCertificadoidcertificado());
                statement.setString(6, list_Trab_Cap.getFechacreacion());
                statement.setLong(7, list_Trab_Cap.getIdlistrabcap());
                statement.executeUpdate();
            }
        });        
       
        flagsave=true;
        return flagsave;
    }

    @Override
    public void deleteListTrabCapSP(Long id, Long estado) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL List_Trab_Cap_PKG.list_trab_cap_eliminar(:id_list_trab_cap, :est_list_trab_cap)")
                .addEntity(List_Trab_Cap.class).
        setParameter("id_list_trab_cap", id).setParameter("est_list_trab_cap", estado);        
        query.executeUpdate();
    }
}
