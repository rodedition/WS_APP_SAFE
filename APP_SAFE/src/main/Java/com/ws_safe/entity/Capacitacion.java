
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
    private String nombre_capacitacion;
    
    @Column(name="NOMBRE_CAPACITACION")
    private long nombrecapacitacion;
    
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

    public String getNombre_capacitacion() {
        return nombre_capacitacion;
    }

    public void setNombre_capacitacion(String nombre_capacitacion) {
        this.nombre_capacitacion = nombre_capacitacion;
    }

    public long getNombrecapacitacion() {
        return nombrecapacitacion;
    }

    public void setNombrecapacitacion(long nombrecapacitacion) {
        this.nombrecapacitacion = nombrecapacitacion;
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
        return "Capacitacion{" + "idcap=" + idcap + ", nombre_capacitacion=" + nombre_capacitacion + ", nombrecapacitacion=" + nombrecapacitacion + ", plancapidplancap=" + plancapidplancap + ", tipocapidtipocap=" + tipocapidtipocap + '}';
    }
    
           
}
