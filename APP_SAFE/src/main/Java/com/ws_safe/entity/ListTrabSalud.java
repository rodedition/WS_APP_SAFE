
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

    public long getLisasiscapidlistasalud() {
        return lisasissaludidlistasalud;
    }

    public void setLisasiscapidlistasalud(long lisasiscapidlistasalud) {
        this.lisasissaludidlistasalud = lisasiscapidlistasalud;
    }

    public long getCertificadoidcertificado() {
        return certificadoidcertificado;
    }

    public void setCertificadoidcertificado(long certificadoidcertificado) {
        this.certificadoidcertificado = certificadoidcertificado;
    }

    @Override
    public String toString() {
        return "ListTrabSalud{" + "idlistrabsalud=" + idlistrabsalud + ", presenteSalud=" + presenteSalud + ", estadoSalud=" + estadoSalud + ", usuarioidusuario=" + usuarioidusuario + ", lisasissaludidlistasalud=" + lisasissaludidlistasalud + ", certificadoidcertificado=" + certificadoidcertificado + '}';
    }

       
}
