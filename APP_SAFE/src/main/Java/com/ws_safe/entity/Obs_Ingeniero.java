
package com.ws_safe.entity;

import java.io.Serializable;
import javax.persistence.*;
import org.apache.tools.ant.types.resources.selectors.Date;

/**
 *
 * @author Rodrigo
 */

@Entity
@Table(name="OBS_INGENIERO",schema="SAFE")


public class Obs_Ingeniero implements Serializable{
    @Id
    @Column(name="ID_OBS_INGENIERO")
    private long idobsingeniero;
    
    @Column(name="FECHA_HORA_OBS_ING")
    private Date fechahoraobsing;
    
    @Column(name="OBS_ING")
    private String obsing;
    
    @Column(name="EVAL_TERR_ID_EVAL_TERR")
    private Long evalterridevalterr;
    
    @Column(name="ESTADO")
    private Long estadoObsIng;

    public long getIdobsingeniero() {
        return idobsingeniero;
    }

    public void setIdobsingeniero(long idobsingeniero) {
        this.idobsingeniero = idobsingeniero;
    }

    public Date getFechahoraobsing() {
        return fechahoraobsing;
    }

    public void setFechahoraobsing(Date fechahoraobsing) {
        this.fechahoraobsing = fechahoraobsing;
    }

    public String getObsing() {
        return obsing;
    }

    public void setObsing(String obsing) {
        this.obsing = obsing;
    }

    public Long getEvalterridevalterr() {
        return evalterridevalterr;
    }

    public void setEvalterridevalterr(Long evalterridevalterr) {
        this.evalterridevalterr = evalterridevalterr;
    }

    public Long getEstadoObsIng() {
        return estadoObsIng;
    }

    public void setEstadoObsIng(Long estadoObsIng) {
        this.estadoObsIng = estadoObsIng;
    }

    @Override
    public String toString() {
        return "Obs_Ingeniero{" + "idobsingeniero=" + idobsingeniero + ", fechahoraobsing=" + fechahoraobsing + ", obsing=" + obsing + ", evalterridevalterr=" + evalterridevalterr + ", estadoObsIng=" + estadoObsIng + '}';
    }   
    
}
