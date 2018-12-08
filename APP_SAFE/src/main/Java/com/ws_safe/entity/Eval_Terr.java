
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
    
    @Column(name="FECHAVISITA")
    private String fechavisita;
    
    @Column(name="ESTADO")
    private Long estado;
    
    @Column(name="SOLIEVALTER_ID_SOLICITUD")
    private Long solievalteridsolicitud;
    
    @Column(name="ESTADO_EVAL_TERR_ID_ESTADO")
    private Long estadoevalterridestado;
    
    @Column(name="CERTIFICADO_ID_CERTIFICADO")
    private long certificadoidcertificado;
    
    @Column(name="USUARIOS_ID_USUARIO")
    private long usuariosidusuarios;
    
    @Column(name="FECHACREACION")
    private String fechacreacion;

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

    public String getFechavisita() {
        return fechavisita;
    }

    public void setFechavisita(String fechavisita) {
        this.fechavisita = fechavisita;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

    public Long getSolievalteridsolicitud() {
        return solievalteridsolicitud;
    }

    public void setSolievalteridsolicitud(Long solievalteridsolicitud) {
        this.solievalteridsolicitud = solievalteridsolicitud;
    }

    public Long getEstadoevalterridestado() {
        return estadoevalterridestado;
    }

    public void setEstadoevalterridestado(Long estadoevalterridestado) {
        this.estadoevalterridestado = estadoevalterridestado;
    }

    public long getCertificadoidcertificado() {
        return certificadoidcertificado;
    }

    public void setCertificadoidcertificado(long certificadoidcertificado) {
        this.certificadoidcertificado = certificadoidcertificado;
    }

    public long getUsuariosidusuarios() {
        return usuariosidusuarios;
    }

    public void setUsuariosidusuarios(long usuariosidusuarios) {
        this.usuariosidusuarios = usuariosidusuarios;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    @Override
    public String toString() {
        return "Eval_Terr{" + "idevalterr=" + idevalterr + ", obsvisita=" + obsvisita + ", fechavisita=" + fechavisita + ", estado=" + estado + ", solievalteridsolicitud=" + solievalteridsolicitud + ", estadoevalterridestado=" + estadoevalterridestado + ", certificadoidcertificado=" + certificadoidcertificado + ", usuariosidusuarios=" + usuariosidusuarios + ", fechacreacion=" + fechacreacion + '}';
    }    
}
