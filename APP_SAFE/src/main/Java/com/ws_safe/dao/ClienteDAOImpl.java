/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.cedarsoftware.util.UrlUtilities;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import com.ws_safe.entity.Cliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.driver.DatabaseError;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.spi.JdbcConnectionAccess;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.jpa.internal.StoredProcedureQueryImpl;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.internal.ProcedureCallImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo
 */
@Repository("clienteDAO")
@Transactional
public class ClienteDAOImpl implements ClienteDAO{
    
    /*public static final String callCliente = "CLIENTEPKG.CLIENTE_CONSULTAR";
    
    @Autowired
    public ClienteDAOImpl(DataSource ds){
        super(ds, callCliente);
        declareParameter(new SqlParameter("id_cli", Types.INTEGER));
        declareParameter(new SqlOutParameter("clientes", OracleTypes.CURSOR, new RowMapper<Cliente>(){
            @Override
            public Cliente mapRow(ResultSet rs, int rowNumber) throws SQLException{
                Cliente cli = new Cliente();
                cli.setIdcliente(rs.getInt("id_cliente"));
                cli.setRazonsocial(rs.getString("razon_social"));
                
                return cli;
            }
        }));
        compile();
    }*/
    
    
    Logger logger = Logger.getLogger(ClienteDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
    
    
    
    @Override
    public List<Cliente> getListCliente() {
        return (List<Cliente>)sessionFactory.getCurrentSession().createCriteria(Cliente.class).list();
    }
    
    @Override
    public boolean addCliente(Cliente cliente) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().save(cliente);
        flagsave=true;
        
        return flagsave;
    }

    public Cliente getByIdCliente(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Cliente as c WHERE c.idcliente=:id");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Cliente)queryList.get(0);
        }else{
            return null;
        }
    }

    public void deleteCliente(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete FROM Cliente as c WHERE c.idcliente=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public boolean updateCliente(Cliente cliente) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().update(cliente);
        flagsave=true;
        
        return flagsave;
    }
    
    public void eliminarCliente(Long id, Long estado) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL CLIENTEPKG.CLIENTE_ELIMINAR(:id_cli, :est_cli)").addEntity(Cliente.class).
        setParameter("id_cli", id).setParameter("est_cli", estado);        
        query.executeUpdate();
    }
    
    
    
	/*public void getOneClienteSP(Long id) {
        Connection cn = null;
        
            try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:orcl12c", "SAFE", "safe");
            CallableStatement call = cn.prepareCall("{call ClientePKG.ClienteConsultar(?,?)}");
            call.setLong(1, 1);
            
            call.registerOutParameter(2, java.sql.Types.VARCHAR);
            
            call.execute();
            
            String razon = call.getString(2);
            
                System.out.println("RAzon Social:"+razon); 
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            /*final ProcedureCall 
             query = new ProcedureCallImpl()
            query.setParameter("id_cli", id);
            CallableStatement call = PreparedStatementCallback
            List queryList = query.list();
            if (queryList.size()>0) {
                return (Cliente)queryList.get(0);
            }else{
                return null;
            }*/
	/*}*/

    public List<Cliente>cap_consultar(Long id) {
        
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Cliente>>() {
            @Override
            public List<Cliente> execute(Connection connection) throws SQLException {
                String query = "{CALL CLIENTEPKG.Cliente_Consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, id);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Cliente> clients;
                clients = new ArrayList<Cliente>();
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setRazonsocial(rs.getString("RAZON_SOCIAL"));
                    clients.add(cliente);
                }
                return clients;
            }
        });
    }   
    
    
    
    
    
    
    
        
        /*List<Cliente> clientes = new ArrayList<Cliente>();
        Map<String, Object>result;
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("id_cli", id);
        result = execute(params);
        
        clientes = (List<Cliente>) result.get("clientes");
        
        return clientes;*/
        
        
        
        /*Query query =  sessionFactory.getCurrentSession().createSQLQuery("CALL CLIENTEPKG.CLIENTE_CONSULTAR(:id_cli)").addEntity(Cliente.class)
                .setParameter("id_cli", id);
        
        List result = query.list();
           
       
        return (List<Cliente>)(Cliente)result.get(0);*/
        
        
        /*Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL CLIENTEPKG.CLIENTE_CONSULTAR(:id_cli)").addEntity(Cliente.class).
        setParameter("id_cli", id);*/
        //System.out.println("listasize["+query.list().size()+"]");
        
        
        
        
        
        /*Session session = sessionFactory.getCurrentSession();
        List<Cliente> clientes = session.doReturningWork(new ReturningWork<List<Cliente>>() {
			@Override
			public List<Cliente> execute(Connection connection) throws SQLException {
				String query = "{CALL CLIENTEPKG.CLIENTE_CONSULTAR(?, ?)}";
                                CallableStatement callableStatement = connection.prepareCall(query);
                                callableStatement.setLong(1, 1);
                                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                                callableStatement.executeUpdate();
                                ResultSet rs = (ResultSet) callableStatement.getObject(1);
                                List<Cliente> list = new ArrayList<Cliente>();
  		                while (rs.next()) {
  		        	   list.add
			        }
                                return list;
			}
		});*/
    

    
}
    /*public Cliente cliente_consultar(Long id) {
    
        
        
      Query query = sessionFactory.getCurrentSession().getNamedQuery("Cliente_Consultar").setParameter("id_cli", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Cliente)queryList.get(0);
            
        }else{
            return null;
        }
    }

    @PersistenceContext
    private EntityManager em
    public Cliente cap_consultar(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("BEGIN cap_consulta(:id); END");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Cliente)queryList.get(0);
        }else{
            return null;
        }
        
         
        this.em.createNativeQuery("BEGIN cap_consulta(:id); END")
                .setParameter("id", id)
                .executeUpdate(); 
        
    }

   private EntityManagerFactory emf;
    public Cliente cliente_consultar(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        StoredProcedureQuery spQuery = this.em.createNamedStoredProcedureQuery("Cliente_Consultar");
                spQuery.setParameter("id", id)
                .executeUpdate(); 
        
        
        
        
        
        Query query = sessionFactory.getCurrentSession().createQuery("BEGIN Cliente_Consultar(:id); END;");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Cliente)queryList.get(0);
        }else{
            return null;
        }
    }

       
    public Cliente cliente_consultar(Long id) {
        
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Cliente_Consultar").setParameter("id_cli", id);
        
        //StoredProcedureQuery query = entityManager.createStoredProcedureQuery("")
        //Query query = sessionFactory.getCurrentSession().getNamedQuery("Cliente_Consultar");
        //query.setParameter("id", id);
        //query.setParameter("rut", rut);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Cliente)queryList.get(0);
            
        }else{
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Cliente> cliente_consultar(String rut) {
        
        return em.createNativeQuery("Cliente_Consultar").setParameter("id_cliente", rut).getResultList();
    }

    private static EntityManagerFactory factory = null;
    private static EntityManager entityManager = null;
 
    @BeforeClass
    public static void init() {
        factory = Persistence.createEntityManagerFactory("jpa-db");
        entityManager = factory.createEntityManager();
    }
    
    @Test
    public void cliente_consultar() {
        StoredProcedureQuery findByIdCliente = 
          entityManager.createNamedStoredProcedureQuery("Cliente_Consultar");
         
        StoredProcedureQuery storedProcedure = 
          findByIdCliente.setParameter("id_cliente", 1);
         
        storedProcedure.getResultList().forEach(action);
          .forEach(c -> Assert.assertEquals(new Long(1), ((Cliente) c).getRazonsocial())); 
    }
    
    
}*/
