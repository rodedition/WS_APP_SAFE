
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
@Table(name="OBS_SUPERVISOR",schema="SAFE")


public class Obs_Supervisor implements Serializable{
    @Id
    @Column(name="ID_OBS_SUPERVISOR")
    private long idobssupervisor;
    
    @Column(name="FECHA_HORA_OBS_SUPERVISOR")
    private Date fechahoraobssupervisor;
    
    @Column(name="OBS_SUPERVISOR")
    private String obssupervisor;
    
    @Column(name="ESTADO")
    private Long estadoObsSupervisor;
    
    @Column(name="EVAL_TERR_ID_EVAL_TERR")
    private Long evalterridevalterr;

    public long getIdobssupervisor() {
        return idobssupervisor;
    }

    public void setIdobssupervisor(long idobssupervisor) {
        this.idobssupervisor = idobssupervisor;
    }

    public Date getFechahoraobssupervisor() {
        return fechahoraobssupervisor;
    }

    public void setFechahoraobssupervisor(Date fechahoraobssupervisor) {
        this.fechahoraobssupervisor = fechahoraobssupervisor;
    }

    public String getObssupervisor() {
        return obssupervisor;
    }

    public void setObssupervisor(String obssupervisor) {
        this.obssupervisor = obssupervisor;
    }

    public Long getEstadoObsSupervisor() {
        return estadoObsSupervisor;
    }

    public void setEstadoObsSupervisor(Long estadoObsSupervisor) {
        this.estadoObsSupervisor = estadoObsSupervisor;
    }

    public Long getEvalterridevalterr() {
        return evalterridevalterr;
    }

    public void setEvalterridevalterr(Long evalterridevalterr) {
        this.evalterridevalterr = evalterridevalterr;
    }

    @Override
    public String toString() {
        return "Obs_Supervisor{" + "idobssupervisor=" + idobssupervisor + ", fechahoraobssupervisor=" + fechahoraobssupervisor + ", obssupervisor=" + obssupervisor + ", estadoObsSupervisor=" + estadoObsSupervisor + ", evalterridevalterr=" + evalterridevalterr + '}';
    }
    
    
}
