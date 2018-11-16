
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
@Table(name="SESION_CAP",schema="SAFE")


public class Sesion_Cap implements Serializable{
    @Id
    @Column(name="ID_SESION_CAP")
    private long idsesioncap;
    
    @Column(name="NUM_SESION_CAP")
    private long numsesioncap;
    
    @Column(name="NOMBRE_SESION")
    private String nombresesion;
    
    @Column(name="CUPOS_SESION")
    private long cupossesion;
    
    @Column(name="FECHA_SESION")
    private String fechasesion;
    
    @Column(name="HORA_INICIO_CAP")
    private String horainiciocap;
    
    @Column(name="HORA_TERMINO_CAP")
    private String horaterminocap;
    
    @Column(name="DESCRIPCION_SESION")
    private String descripcionsesion;
    
    @Column(name="ESTADO")
    private long estadosesioncap;
    
    @Column(name="CAPACITACION_ID_CAP")
    private long capacitacionidcap;
    
    @Column(name="EXPOSITOR_ID_EXPOSITOR")
    private long expositoridexpositor;

    public long getIdsesioncap() {
        return idsesioncap;
    }

    public void setIdsesioncap(long idsesioncap) {
        this.idsesioncap = idsesioncap;
    }

    public long getNumsesioncap() {
        return numsesioncap;
    }

    public void setNumsesioncap(long numsesioncap) {
        this.numsesioncap = numsesioncap;
    }

    public String getNombresesion() {
        return nombresesion;
    }

    public void setNombresesion(String nombresesion) {
        this.nombresesion = nombresesion;
    }

    public long getCupossesion() {
        return cupossesion;
    }

    public void setCupossesion(long cupossesion) {
        this.cupossesion = cupossesion;
    }

    public String getFechasesion() {
        return fechasesion;
    }

    public void setFechasesion(String fechasesion) {
        this.fechasesion = fechasesion;
    }

    public String getHorainiciocap() {
        return horainiciocap;
    }

    public void setHorainiciocap(String horainiciocap) {
        this.horainiciocap = horainiciocap;
    }

    public String getHoraterminocap() {
        return horaterminocap;
    }

    public void setHoraterminocap(String horaterminocap) {
        this.horaterminocap = horaterminocap;
    }

    public String getDescripcionsesion() {
        return descripcionsesion;
    }

    public void setDescripcionsesion(String descripcionsesion) {
        this.descripcionsesion = descripcionsesion;
    }

    public long getEstadosesioncap() {
        return estadosesioncap;
    }

    public void setEstadosesioncap(long estadosesioncap) {
        this.estadosesioncap = estadosesioncap;
    }

    public long getCapacitacionidcap() {
        return capacitacionidcap;
    }

    public void setCapacitacionidcap(long capacitacionidcap) {
        this.capacitacionidcap = capacitacionidcap;
    }

    public long getExpositoridexpositor() {
        return expositoridexpositor;
    }

    public void setExpositoridexpositor(long expositoridexpositor) {
        this.expositoridexpositor = expositoridexpositor;
    }

    @Override
    public String toString() {
        return "Sesion_Cap{" + "idsesioncap=" + idsesioncap + ", numsesioncap=" + numsesioncap + ", nombresesion=" + nombresesion + ", cupossesion=" + cupossesion + ", fechasesion=" + fechasesion + ", horainiciocap=" + horainiciocap + ", horaterminocap=" + horaterminocap + ", descripcionsesion=" + descripcionsesion + ", estadosesioncap=" + estadosesioncap + ", capacitacionidcap=" + capacitacionidcap + ", expositoridexpositor=" + expositoridexpositor + '}';
    }   

}
