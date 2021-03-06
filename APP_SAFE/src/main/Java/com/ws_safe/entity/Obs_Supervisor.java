
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
    private String fechahoraobssupervisor;
    
    @Column(name="OBS_SUPERVISOR")
    private String obssupervisor;
    
    @Column(name="ESTADO")
    private long estadoObsSupervisor;
    
    @Column(name="EVAL_TERR_ID_EVAL_TERR")
    private long evalterridevalterr;
    
    @Column(name="EVAL_TERR_ID_USUARIO")
    private long evalterridusuario;

    public long getIdobssupervisor() {
        return idobssupervisor;
    }

    public void setIdobssupervisor(long idobssupervisor) {
        this.idobssupervisor = idobssupervisor;
    }

    public String getFechahoraobssupervisor() {
        return fechahoraobssupervisor;
    }

    public void setFechahoraobssupervisor(String fechahoraobssupervisor) {
        this.fechahoraobssupervisor = fechahoraobssupervisor;
    }

    public String getObssupervisor() {
        return obssupervisor;
    }

    public void setObssupervisor(String obssupervisor) {
        this.obssupervisor = obssupervisor;
    }

    public long getEstadoObsSupervisor() {
        return estadoObsSupervisor;
    }

    public void setEstadoObsSupervisor(long estadoObsSupervisor) {
        this.estadoObsSupervisor = estadoObsSupervisor;
    }

    public long getEvalterridevalterr() {
        return evalterridevalterr;
    }

    public void setEvalterridevalterr(long evalterridevalterr) {
        this.evalterridevalterr = evalterridevalterr;
    }

    public long getEvalterridusuario() {
        return evalterridusuario;
    }

    public void setEvalterridusuario(long evalterridusuario) {
        this.evalterridusuario = evalterridusuario;
    }

    @Override
    public String toString() {
        return "Obs_Supervisor{" + "idobssupervisor=" + idobssupervisor + ", fechahoraobssupervisor=" + fechahoraobssupervisor + ", obssupervisor=" + obssupervisor + ", estadoObsSupervisor=" + estadoObsSupervisor + ", evalterridevalterr=" + evalterridevalterr + ", evalterridusuario=" + evalterridusuario + '}';
    }

    
}
