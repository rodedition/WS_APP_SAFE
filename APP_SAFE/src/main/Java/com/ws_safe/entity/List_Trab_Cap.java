
package com.ws_safe.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Rodrigo
 */

@Entity
@Table(name="LIST_TRAB_CAP",schema="SAFE")


public class List_Trab_Cap implements Serializable{
    @Id
    @Column(name="ID_LIS_TRAB_CAP")
    private long idlistrabcap;
    
    @Column(name="PRESENTE")
    private long presenteCap;
    
    @Column(name="ESTADO")
    private long estadoCap;
    
    @Column(name="USUARIOS_ID_USUARIO")
    private long usuarioidusuario;
    
    @Column(name="LIST_ASIS_CAP_ID_LISTA_CAP")
    private long lisasiscapidlistacap;
    
    @Column(name="CERTIFICADO_ID_CERTIFICADO")
    private long certificadoidcertificado;
    
    @Column(name="FECHACREACION")
    private String fechacreacion;

    public long getIdlistrabcap() {
        return idlistrabcap;
    }

    public void setIdlistrabcap(long idlistrabcap) {
        this.idlistrabcap = idlistrabcap;
    }

    public long getPresenteCap() {
        return presenteCap;
    }

    public void setPresenteCap(long presenteCap) {
        this.presenteCap = presenteCap;
    }

    public long getEstadoCap() {
        return estadoCap;
    }

    public void setEstadoCap(long estadoCap) {
        this.estadoCap = estadoCap;
    }

    public long getUsuarioidusuario() {
        return usuarioidusuario;
    }

    public void setUsuarioidusuario(long usuarioidusuario) {
        this.usuarioidusuario = usuarioidusuario;
    }

    public long getLisasiscapidlistacap() {
        return lisasiscapidlistacap;
    }

    public void setLisasiscapidlistacap(long lisasiscapidlistacap) {
        this.lisasiscapidlistacap = lisasiscapidlistacap;
    }

    public long getCertificadoidcertificado() {
        return certificadoidcertificado;
    }

    public void setCertificadoidcertificado(long certificadoidcertificado) {
        this.certificadoidcertificado = certificadoidcertificado;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    @Override
    public String toString() {
        return "List_Trab_Cap{" + "idlistrabcap=" + idlistrabcap + ", presenteCap=" + presenteCap + ", estadoCap=" + estadoCap + ", usuarioidusuario=" + usuarioidusuario + ", lisasiscapidlistacap=" + lisasiscapidlistacap + ", certificadoidcertificado=" + certificadoidcertificado + ", fechacreacion=" + fechacreacion + '}';
    }

    
}
