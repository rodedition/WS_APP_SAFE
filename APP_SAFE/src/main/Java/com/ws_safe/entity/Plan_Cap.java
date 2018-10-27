
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
@Table(name="PLAN_CAP",schema="SAFE")


public class Plan_Cap implements Serializable{
    @Id
    @Column(name="ID_PLAN_CAP")
    private long idplancap;
    
    @Column(name="FECHA_CREACION")
    private Date fechacreacion;
    
    @Column(name="ESTADO_PLAN_CAP")
    private Long estadoplancap;
    
    @Column(name="CLIENTE_ID_CLIENTE")
    private Long clienteidcliente;

    public long getIdplancap() {
        return idplancap;
    }

    public void setIdplancap(long idplancap) {
        this.idplancap = idplancap;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Long getEstadoplancap() {
        return estadoplancap;
    }

    public void setEstadoplancap(Long estadoplancap) {
        this.estadoplancap = estadoplancap;
    }

    public Long getClienteidcliente() {
        return clienteidcliente;
    }

    public void setClienteidcliente(Long clienteidcliente) {
        this.clienteidcliente = clienteidcliente;
    }

    @Override
    public String toString() {
        return "Plan_Cap{" + "idplancap=" + idplancap + ", fechacreacion=" + fechacreacion + ", estadoplancap=" + estadoplancap + ", clienteidcliente=" + clienteidcliente + '}';
    }  

}
