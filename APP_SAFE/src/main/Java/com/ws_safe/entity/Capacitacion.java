
package com.ws_safe.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Rodrigo
 */

@Entity
@Table(name="CAPACITACION",schema="SAFE")


public class Capacitacion implements Serializable{
    @Id
    @Column(name="ID_CAP")
    private long idcap;
    
    @Column(name="NOMBRE_CAPACITACION")
    private String nombrecapacitacion;
    
    @Column(name="ESTADO_CAPACITACION")
    private long estadocapacitacion;
    
    @Column(name="PLAN_CAP_ID_PLAN_CAP")
    private long plancapidplancap;
    
    @Column(name="TIPO_CAP_ID_TIPO_CAP")
    private long tipocapidtipocap;

    public long getIdcap() {
        return idcap;
    }

    public void setIdcap(long idcap) {
        this.idcap = idcap;
    }

    public String getNombrecapacitacion() {
        return nombrecapacitacion;
    }

    public void setNombrecapacitacion(String nombrecapacitacion) {
        this.nombrecapacitacion = nombrecapacitacion;
    }

    public long getEstadocapacitacion() {
        return estadocapacitacion;
    }

    public void setEstadocapacitacion(long estadocapacitacion) {
        this.estadocapacitacion = estadocapacitacion;
    }

    public long getPlancapidplancap() {
        return plancapidplancap;
    }

    public void setPlancapidplancap(long plancapidplancap) {
        this.plancapidplancap = plancapidplancap;
    }

    public long getTipocapidtipocap() {
        return tipocapidtipocap;
    }

    public void setTipocapidtipocap(long tipocapidtipocap) {
        this.tipocapidtipocap = tipocapidtipocap;
    }

    @Override
    public String toString() {
        return "Capacitacion{" + "idcap=" + idcap + ", nombrecapacitacion=" + nombrecapacitacion + ", estadocapacitacion=" + estadocapacitacion + ", plancapidplancap=" + plancapidplancap + ", tipocapidtipocap=" + tipocapidtipocap + '}';
    }

    
           
}
