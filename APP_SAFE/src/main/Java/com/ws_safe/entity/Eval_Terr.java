
package com.ws_safe.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Rodrigo
 */

@Entity
@Table(name="EVAL_TERR",schema="SAFE")


public class Eval_Terr implements Serializable{
    @Id
    @Column(name="ID_EVAL_TERR")
    private long idevalterr;
    
    @Column(name="OBS_VISITA")
    private String obsvisita;
    
    @Column(name="ESTADO")
    private long estadovis;
    
    @Column(name="SOLIEVALTER_ID_SOLICITUD")
    private long solievalteridsolicitud;
    
    @Column(name="ESTADO_EVAL_TERR_ID_ESTADO")
    private long estadoevalterridestado;
    
    @Column(name="CERTIFICADO_ID_CERTIFICADO")
    private long certificadoidcertificado;

    public long getIdevalterr() {
        return idevalterr;
    }

    public void setIdevalterr(long idevalterr) {
        this.idevalterr = idevalterr;
    }

    public String getObsvisita() {
        return obsvisita;
    }

    public void setObsvisita(String obsvisita) {
        this.obsvisita = obsvisita;
    }

    public long getEstadovis() {
        return estadovis;
    }

    public void setEstadovis(long estadovis) {
        this.estadovis = estadovis;
    }

    public long getSolievalteridsolicitud() {
        return solievalteridsolicitud;
    }

    public void setSolievalteridsolicitud(long solievalteridsolicitud) {
        this.solievalteridsolicitud = solievalteridsolicitud;
    }

    public long getEstadoevalterridestado() {
        return estadoevalterridestado;
    }

    public void setEstadoevalterridestado(long estadoevalterridestado) {
        this.estadoevalterridestado = estadoevalterridestado;
    }

    public long getCertificadoidcertificado() {
        return certificadoidcertificado;
    }

    public void setCertificadoidcertificado(long certificadoidcertificado) {
        this.certificadoidcertificado = certificadoidcertificado;
    }

    @Override
    public String toString() {
        return "Eval_Terr{" + "idevalterr=" + idevalterr + ", obsvisita=" + obsvisita + ", estadovis=" + estadovis + ", solievalteridsolicitud=" + solievalteridsolicitud + ", estadoevalterridestado=" + estadoevalterridestado + ", certificadoidcertificado=" + certificadoidcertificado + '}';
    }
        
}
