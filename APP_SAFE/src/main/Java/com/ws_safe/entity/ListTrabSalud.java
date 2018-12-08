
package com.ws_safe.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Rodrigo
 */

@Entity
@Table(name="LISTTRABSALUD",schema="SAFE")


public class ListTrabSalud implements Serializable{
    @Id
    @Column(name="ID_LIS_TRAB_SALUD")
    private long idlistrabsalud;
    
    @Column(name="PRESENTE")
    private long presenteSalud;
    
    @Column(name="ESTADO")
    private long estadoSalud;
    
    @Column(name="USUARIOS_ID_USUARIO")
    private long usuarioidusuario;
    
    @Column(name="LISTASISSALUD_ID_LIST_SALUD")
    private long lisasissaludidlistasalud;
    
    @Column(name="CERTIFICADO_ID_CERTIFICADO")
    private long certificadoidcertificado;
    
    @Column(name="FECHACREACION")
    private String fechacreacion;

    public long getIdlistrabsalud() {
        return idlistrabsalud;
    }

    public void setIdlistrabsalud(long idlistrabsalud) {
        this.idlistrabsalud = idlistrabsalud;
    }

    public long getPresenteSalud() {
        return presenteSalud;
    }

    public void setPresenteSalud(long presenteSalud) {
        this.presenteSalud = presenteSalud;
    }

    public long getEstadoSalud() {
        return estadoSalud;
    }

    public void setEstadoSalud(long estadoSalud) {
        this.estadoSalud = estadoSalud;
    }

    public long getUsuarioidusuario() {
        return usuarioidusuario;
    }

    public void setUsuarioidusuario(long usuarioidusuario) {
        this.usuarioidusuario = usuarioidusuario;
    }

    public long getLisasissaludidlistasalud() {
        return lisasissaludidlistasalud;
    }

    public void setLisasissaludidlistasalud(long lisasissaludidlistasalud) {
        this.lisasissaludidlistasalud = lisasissaludidlistasalud;
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
        return "ListTrabSalud{" + "idlistrabsalud=" + idlistrabsalud + ", presenteSalud=" + presenteSalud + ", estadoSalud=" + estadoSalud + ", usuarioidusuario=" + usuarioidusuario + ", lisasissaludidlistasalud=" + lisasissaludidlistasalud + ", certificadoidcertificado=" + certificadoidcertificado + ", fechacreacion=" + fechacreacion + '}';
    }
    
    

}
