
package com.ws_safe.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
//import org.apache.tools.ant.types.resources.comparators.Date;
//import org.apache.tools.ant.types.resources.selectors.Date;

/**
 *
 * @author Rodrigo
 */

@Entity
@Table(name="PLAN_SALUD",schema="SAFE")


public class Plan_Salud implements Serializable{
    @Id
    @Column(name="ID_PLAN_SALUD")
    private long idplansalud;
    
    @Column(name="FECHA_CREACION")
    private String fechacreacion;
    
    @Column(name="ESTADO_PLAN_SALUD")
    private long estadoplansalud;
    
    @Column(name="CLIENTE_ID_CLIENTE")
    private long clienteidcliente;

    public long getIdplansalud() {
        return idplansalud;
    }

    public void setIdplansalud(long idplansalud) {
        this.idplansalud = idplansalud;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public long getEstadoplansalud() {
        return estadoplansalud;
    }

    public void setEstadoplansalud(long estadoplansalud) {
        this.estadoplansalud = estadoplansalud;
    }

    public long getClienteidcliente() {
        return clienteidcliente;
    }

    public void setClienteidcliente(long clienteidcliente) {
        this.clienteidcliente = clienteidcliente;
    }

    @Override
    public String toString() {
        return "Plan_Salud{" + "idplansalud=" + idplansalud + ", fechacreacion=" + fechacreacion + ", estadoplansalud=" + estadoplansalud + ", clienteidcliente=" + clienteidcliente + '}';
    }

    
}
