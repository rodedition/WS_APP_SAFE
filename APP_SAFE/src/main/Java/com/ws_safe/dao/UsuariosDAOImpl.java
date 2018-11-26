/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Usuarios;
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
@Repository("usuariosDAO")
@Transactional
public class UsuariosDAOImpl implements UsuariosDAO{
    Logger logger = Logger.getLogger(UsuariosDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
    //Llamadas a procedures

    @Override
    public List<Usuarios> addUsuarioSP(Usuarios usuarios) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Usuarios>>() {
              @Override
              public List<Usuarios> execute(Connection connection) throws SQLException {
                String query = "{CALL USUARIOS_PKG.usuarios_agregar(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);
                statement.setLong(1, usuarios.getIdusuario());
                statement.setString(2, usuarios.getRunusuario());
                statement.setString(3, usuarios.getNombresusuario());
                statement.setString(4, usuarios.getAppaterno());
                statement.setString(5, usuarios.getApmaterno());
                statement.setString(6, usuarios.getFnacimientousuario());
                statement.setString(7, usuarios.getSexousuario());
                statement.setString(8, usuarios.getTelusuario());
                statement.setString(9, usuarios.getMailusuario());
                statement.setLong(10, usuarios.getEstadousuario());
                statement.setString(11, usuarios.getClaveusuario());
                statement.setLong(12, usuarios.getPerfilidperfil());
                statement.setLong(13, usuarios.getClienteidcliente());
                statement.registerOutParameter(14, OracleTypes.CURSOR);                                
                statement.executeUpdate();   
                ResultSet rs = (ResultSet) statement.getObject(14);
                List<Usuarios> usus;
                usus = new ArrayList<Usuarios>();
                while (rs.next()) {
                    Usuarios usuarios = new Usuarios();
                    usuarios.setIdusuario(rs.getLong("ID_USUARIO"));
                    usuarios.setRunusuario(rs.getString("RUN_USUARIO"));
                    usuarios.setNombresusuario(rs.getString("NOMBRES_USUARIO"));
                    usuarios.setAppaterno(rs.getString("AP_PATERNO"));
                    usuarios.setApmaterno(rs.getString("AP_MATERNO"));
                    usuarios.setFnacimientousuario(rs.getString("F_NACIMIENTO_USUARIO"));
                    usuarios.setSexousuario(rs.getString("SEXO_USUARIO"));
                    usuarios.setTelusuario(rs.getString("TEL_USUARIO"));
                    usuarios.setMailusuario(rs.getString("MAIL_USUARIO"));
                    usuarios.setEstadousuario(rs.getLong("ESTADO_USUARIO"));
                    usuarios.setClaveusuario(rs.getString("CLAVE_USUARIO"));
                    usuarios.setPerfilidperfil(rs.getLong("PERFIL_ID_PERFIL"));
                    usuarios.setClienteidcliente(rs.getLong("CLIENTE_ID_CLIENTE"));
                    usus.add(usuarios);
                }
                return usus;
            }
        });
    }

    @Override
    public List<Usuarios> getByIdUsuarioSP(String rut) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Usuarios>>() {
            @Override
            public List<Usuarios> execute(Connection connection) throws SQLException {
                String query = "{CALL USUARIOS_PKG.usuarios_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setString(1, rut);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Usuarios> usus;
                usus = new ArrayList<Usuarios>();
                while (rs.next()) {
                    Usuarios usuarios = new Usuarios();
                    usuarios.setIdusuario(rs.getLong("ID_USUARIO"));
                    usuarios.setRunusuario(rs.getString("RUN_USUARIO"));
                    usuarios.setNombresusuario(rs.getString("NOMBRES_USUARIO"));
                    usuarios.setAppaterno(rs.getString("AP_PATERNO"));
                    usuarios.setApmaterno(rs.getString("AP_MATERNO"));
                    usuarios.setFnacimientousuario(rs.getString("F_NACIMIENTO_USUARIO"));
                    usuarios.setSexousuario(rs.getString("SEXO_USUARIO"));
                    usuarios.setTelusuario(rs.getString("TEL_USUARIO"));
                    usuarios.setMailusuario(rs.getString("MAIL_USUARIO"));
                    usuarios.setEstadousuario(rs.getLong("ESTADO_USUARIO"));
                    usuarios.setClaveusuario(rs.getString("CLAVE_USUARIO"));
                    usuarios.setPerfilidperfil(rs.getLong("PERFIL_ID_PERFIL"));
                    usuarios.setClienteidcliente(rs.getLong("CLIENTE_ID_CLIENTE"));
                    usus.add(usuarios);
                }
                return usus;
            }
        });
    }

    @Override
    public List<Usuarios> getAllUsuarioSP() {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Usuarios>>() {
            @Override
            public List<Usuarios> execute(Connection connection) throws SQLException {
                String query = "{CALL USUARIOS_PKG.All_usuarios_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, 1L);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Usuarios> usus;
                usus = new ArrayList<Usuarios>();
                while (rs.next()) {
                    Usuarios usuarios = new Usuarios();
                    usuarios.setIdusuario(rs.getLong("ID_USUARIO"));
                    usuarios.setRunusuario(rs.getString("RUN_USUARIO"));
                    usuarios.setNombresusuario(rs.getString("NOMBRES_USUARIO"));
                    usuarios.setAppaterno(rs.getString("AP_PATERNO"));
                    usuarios.setApmaterno(rs.getString("AP_MATERNO"));
                    usuarios.setFnacimientousuario(rs.getString("F_NACIMIENTO_USUARIO"));
                    usuarios.setSexousuario(rs.getString("SEXO_USUARIO"));
                    usuarios.setTelusuario(rs.getString("TEL_USUARIO"));
                    usuarios.setMailusuario(rs.getString("MAIL_USUARIO"));
                    usuarios.setEstadousuario(rs.getLong("ESTADO_USUARIO"));
                    usuarios.setClaveusuario(rs.getString("CLAVE_USUARIO"));
                    usuarios.setPerfilidperfil(rs.getLong("PERFIL_ID_PERFIL"));
                    usuarios.setClienteidcliente(rs.getLong("CLIENTE_ID_CLIENTE"));
                    usus.add(usuarios);
                }
                return usus;
            }
        });
    }

    @Override
    public boolean updateUsuarioSP(Usuarios usuarios) {
        boolean flagsave = false;
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL USUARIOS_PKG.usuarios_modificar(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);                 
                statement.setString(1, usuarios.getRunusuario());
                statement.setString(2, usuarios.getNombresusuario());
                statement.setString(3, usuarios.getAppaterno());
                statement.setString(4, usuarios.getApmaterno());
                statement.setString(5, usuarios.getFnacimientousuario());
                statement.setString(6, usuarios.getSexousuario());
                statement.setString(7, usuarios.getTelusuario());
                statement.setString(8, usuarios.getMailusuario());
                statement.setLong(9, usuarios.getEstadousuario());
                statement.setString(10, usuarios.getClaveusuario());
                statement.setLong(11, usuarios.getPerfilidperfil());
                statement.setLong(12, usuarios.getClienteidcliente());
                statement.setLong(13, usuarios.getIdusuario());
                statement.executeUpdate();
            }
        });        
       
        flagsave=true;
        return flagsave;
    }

    @Override
    public void deleteUsuarioSP(String run, Long estado) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL USUARIOS_PKG.usuarios_eliminar(:run_usu, :estado_usu)").addEntity(Usuarios.class).
        setParameter("run_usu", run).setParameter("estado_usu", estado);        
        query.executeUpdate();
    }
    
    
}
