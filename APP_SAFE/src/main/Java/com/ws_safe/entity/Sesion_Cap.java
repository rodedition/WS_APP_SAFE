
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
    private Date fechasesion;
    
    @Column(name="HORA_INICIO_CAP")
    private Date horainiciocap;
    
    @Column(name="HORA_TERMINO_CAP")
    private Date horaterminocap;
    
    @Column(name="DESCRIPCION_SESION")
    private String descripcionsesion;
    
    @Column(name="ESTADO")
    private Long estadosesioncap;
    
    @Column(name="CAPACITACION_ID_CAP")
    private Long capacitacionidcap;
    
    @Column(name="EXPOSITOR_ID_EXPOSITOR")
    private Long expositoridexpositor;

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

    public Date getFechasesion() {
        return fechasesion;
    }

    public void setFechasesion(Date fechasesion) {
        this.fechasesion = fechasesion;
    }

    public Date getHorainiciocap() {
        return horainiciocap;
    }

    public void setHorainiciocap(Date horainiciocap) {
        this.horainiciocap = horainiciocap;
    }

    public Date getHoraterminocap() {
        return horaterminocap;
    }

    public void setHoraterminocap(Date horaterminocap) {
        this.horaterminocap = horaterminocap;
    }

    public String getDescripcionsesion() {
        return descripcionsesion;
    }

    public void setDescripcionsesion(String descripcionsesion) {
        this.descripcionsesion = descripcionsesion;
    }

    public Long getEstadosesioncap() {
        return estadosesioncap;
    }

    public void setEstadosesioncap(Long estadosesioncap) {
        this.estadosesioncap = estadosesioncap;
    }

    public Long getCapacitacionidcap() {
        return capacitacionidcap;
    }

    public void setCapacitacionidcap(Long capacitacionidcap) {
        this.capacitacionidcap = capacitacionidcap;
    }

    public Long getExpositoridexpositor() {
        return expositoridexpositor;
    }

    public void setExpositoridexpositor(Long expositoridexpositor) {
        this.expositoridexpositor = expositoridexpositor;
    }

    @Override
    public String toString() {
        return "Sesion_Cap{" + "idsesioncap=" + idsesioncap + ", numsesioncap=" + numsesioncap + ", nombresesion=" + nombresesion + ", cupossesion=" + cupossesion + ", fechasesion=" + fechasesion + ", horainiciocap=" + horainiciocap + ", horaterminocap=" + horaterminocap + ", descripcionsesion=" + descripcionsesion + ", estadosesioncap=" + estadosesioncap + ", capacitacionidcap=" + capacitacionidcap + ", expositoridexpositor=" + expositoridexpositor + '}';
    }
    
    

}
