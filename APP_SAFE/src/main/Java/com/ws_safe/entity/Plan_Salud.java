
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
    private Date fechacreacion;
    
    @Column(name="ESTADO_PLAN_SALUD")
    private Long estadoplansalud;
    
    @Column(name="CLIENTE_ID_CLIENTE")
    private Long clienteidcliente;

    public long getIdplansalud() {
        return idplansalud;
    }

    public void setIdplansalud(long idplansalud) {
        this.idplansalud = idplansalud;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Long getEstadoplansalud() {
        return estadoplansalud;
    }

    public void setEstadoplansalud(Long estadoplansalud) {
        this.estadoplansalud = estadoplansalud;
    }

    public Long getClienteidcliente() {
        return clienteidcliente;
    }

    public void setClienteidcliente(Long clienteidcliente) {
        this.clienteidcliente = clienteidcliente;
    }

    @Override
    public String toString() {
        return "Plan_Salud{" + "idplansalud=" + idplansalud + ", fechacreacion=" + fechacreacion + ", estadoplansalud=" + estadoplansalud + ", clienteidcliente=" + clienteidcliente + '}';
    }
}
