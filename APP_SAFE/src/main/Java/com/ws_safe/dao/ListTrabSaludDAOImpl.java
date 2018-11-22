/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.ListTrabSalud;
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
@Repository("listTrabSaludDAO")
@Transactional
public class ListTrabSaludDAOImpl implements ListTrabSaludDAO{
    Logger logger = Logger.getLogger(ListTrabSaludDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
       
    //Llamadas a procedures

    @Override
    public boolean addListTrabSaludSP(ListTrabSalud listTrabSalud) {
        boolean flagsave = false;         
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL LISTTRABSALUD_PKG.listtrabsalud_agregar(?, ?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);
                statement.setLong(1, listTrabSalud.getIdlistrabsalud());
                statement.setLong(2, listTrabSalud.getPresenteSalud());
                statement.setLong(3, listTrabSalud.getEstadoSalud());
                statement.setLong(4, listTrabSalud.getUsuarioidusuario());
                statement.setLong(5, listTrabSalud.getLisasissaludidlistasalud());
                statement.setLong(6, listTrabSalud.getCertificadoidcertificado());
                statement.executeUpdate();
            }
        });
       
        flagsave=true;
        return flagsave;
    }

    @Override
    public List<ListTrabSalud> getByIdListTrabSaludSP(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<ListTrabSalud>>() {
            @Override
            public List<ListTrabSalud> execute(Connection connection) throws SQLException {
                String query = "{CALL LISTTRABSALUD_PKG.listtrabsalud_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, id);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<ListTrabSalud> lists;
                lists = new ArrayList<ListTrabSalud>();
                while (rs.next()) {
                    ListTrabSalud listTrabSalud = new ListTrabSalud();
                    listTrabSalud.setIdlistrabsalud(rs.getLong("ID_LIS_TRAB_SALUD"));
                    listTrabSalud.setPresenteSalud(rs.getLong("PRESENTE"));
                    listTrabSalud.setEstadoSalud(rs.getLong("ESTADO"));
                    listTrabSalud.setUsuarioidusuario(rs.getLong("USUARIOS_ID_USUARIO"));
                    listTrabSalud.setLisasissaludidlistasalud(rs.getLong("LISTASISSALUD_ID_LIST_SALUD"));
                    listTrabSalud.setCertificadoidcertificado(rs.getLong("CERTIFICADO_ID_CERTIFICADO"));
                    lists.add(listTrabSalud);
                }
                return lists;
            }
        });
    }

    @Override
    public List<ListTrabSalud> getAllListTrabSaludSP() {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<ListTrabSalud>>() {
            @Override
            public List<ListTrabSalud> execute(Connection connection) throws SQLException {
                String query = "{CALL LISTTRABSALUD_PKG.All_listtrabsalud_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, 1L);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<ListTrabSalud> lists;
                lists = new ArrayList<ListTrabSalud>();
                while (rs.next()) {
                    ListTrabSalud listTrabSalud = new ListTrabSalud();
                    listTrabSalud.setIdlistrabsalud(rs.getLong("ID_LIS_TRAB_SALUD"));
                    listTrabSalud.setPresenteSalud(rs.getLong("PRESENTE"));
                    listTrabSalud.setEstadoSalud(rs.getLong("ESTADO"));
                    listTrabSalud.setUsuarioidusuario(rs.getLong("USUARIOS_ID_USUARIO"));
                    listTrabSalud.setLisasissaludidlistasalud(rs.getLong("LISTASISSALUD_ID_LIST_SALUD"));
                    listTrabSalud.setCertificadoidcertificado(rs.getLong("CERTIFICADO_ID_CERTIFICADO"));
                    lists.add(listTrabSalud);
                }
                return lists;
            }
        });
    }

    @Override
    public boolean updateListTrabSaludSP(ListTrabSalud listTrabSalud) {
        boolean flagsave = false;
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL LISTTRABSALUD_PKG.listtrabsalud_modificar(?, ?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);                
                statement.setLong(1, listTrabSalud.getPresenteSalud());
                statement.setLong(2, listTrabSalud.getEstadoSalud());
                statement.setLong(3, listTrabSalud.getUsuarioidusuario());
                statement.setLong(4, listTrabSalud.getLisasissaludidlistasalud());
                statement.setLong(5, listTrabSalud.getCertificadoidcertificado());
                statement.setLong(6, listTrabSalud.getIdlistrabsalud());
                statement.executeUpdate();
            }
        });        
       
        flagsave=true;
        return flagsave;
    }

    @Override
    public void deleteListTrabSaludSP(Long id, Long estado) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL LISTTRABSALUD_PKG.listtrabsalud_eliminar(:id_list_trab_salud, :est_sal)")
                .addEntity(ListTrabSalud.class).
        setParameter("id_list_trab_salud", id).setParameter("est_sal", estado);        
        query.executeUpdate();
    }
    
    
}
