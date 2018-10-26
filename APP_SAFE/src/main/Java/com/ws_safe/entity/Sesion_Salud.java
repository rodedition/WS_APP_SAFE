
package com.ws_safe.entity;

import java.io.Serializable;
import javax.persistence.*;
import org.apache.tools.ant.types.resources.selectors.Date;

/**
 *
 * @author Rodrigo
 */

@Entity
@Table(name="SESION_SALUD",schema="SAFE")


public class Sesion_Salud implements Serializable{
    @Id
    @Column(name="ID_SESION_SALUD")
    private long idsesionsalud;
    
    @Column(name="NUM_SESION_SALUD")
    private long numsesionsalud;
    
    @Column(name="NOMBRE_SESION_SALUD")
    private String nombresesionsalud;
    
    @Column(name="CUPOS_SESION")
    private long cupossesion;
    
    @Column(name="FECHA_SESION")
    private Date fechasesion;
    
    @Column(name="HORA_INICIO_SALUD")
    private Date horainiciosalud;
    
    @Column(name="HORA_TERMINO_SALUD")
    private Date horaterminosalud;
    
    @Column(name="DESCRIPCION_SESION_SALUD")
    private String descripcionsesionsalud;
    
    @Column(name="MEDICO_ID_MEDICO")
    private Long medicoidmedico;
    
    @Column(name="EXAMENES_ID_EXAMEN")
    private Long examenesidexamenes;
    
    @Column(name="ESTADO")
    private Long estadosesionsalud;

    public long getIdsesionsalud() {
        return idsesionsalud;
    }

    public void setIdsesionsalud(long idsesionsalud) {
        this.idsesionsalud = idsesionsalud;
    }

    public long getNumsesionsalud() {
        return numsesionsalud;
    }

    public void setNumsesionsalud(long numsesionsalud) {
        this.numsesionsalud = numsesionsalud;
    }

    public String getNombresesionsalud() {
        return nombresesionsalud;
    }

    public void setNombresesionsalud(String nombresesionsalud) {
        this.nombresesionsalud = nombresesionsalud;
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

    public Date getHorainiciosalud() {
        return horainiciosalud;
    }

    public void setHorainiciosalud(Date horainiciosalud) {
        this.horainiciosalud = horainiciosalud;
    }

    public Date getHoraterminosalud() {
        return horaterminosalud;
    }

    public void setHoraterminosalud(Date horaterminosalud) {
        this.horaterminosalud = horaterminosalud;
    }

    public String getDescripcionsesionsalud() {
        return descripcionsesionsalud;
    }

    public void setDescripcionsesionsalud(String descripcionsesionsalud) {
        this.descripcionsesionsalud = descripcionsesionsalud;
    }

    public Long getMedicoidmedico() {
        return medicoidmedico;
    }

    public void setMedicoidmedico(Long medicoidmedico) {
        this.medicoidmedico = medicoidmedico;
    }

    public Long getExamenesidexamenes() {
        return examenesidexamenes;
    }

    public void setExamenesidexamenes(Long examenesidexamenes) {
        this.examenesidexamenes = examenesidexamenes;
    }

    public Long getEstadosesionsalud() {
        return estadosesionsalud;
    }

    public void setEstadosesionsalud(Long estadosesionsalud) {
        this.estadosesionsalud = estadosesionsalud;
    }

    @Override
    public String toString() {
        return "Sesion_Salud{" + "idsesionsalud=" + idsesionsalud + ", numsesionsalud=" + numsesionsalud + ", nombresesionsalud=" + nombresesionsalud + ", cupossesion=" + cupossesion + ", fechasesion=" + fechasesion + ", horainiciosalud=" + horainiciosalud + ", horaterminosalud=" + horaterminosalud + ", descripcionsesionsalud=" + descripcionsesionsalud + ", medicoidmedico=" + medicoidmedico + ", examenesidexamenes=" + examenesidexamenes + ", estadosesionsalud=" + estadosesionsalud + '}';
    }
    
    
}
