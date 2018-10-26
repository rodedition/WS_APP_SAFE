
package com.ws_safe.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Rodrigo
 */

@Entity
@Table(name="CERTIFICADO",schema="SAFE")


public class Certificado implements Serializable{
    @Id
    @Column(name="ID_CERTIFICADO")
    private long idcertificado;
    
    @Column(name="TIPO_CERTIFICADO")
    private String tipocertificado;
    
    @Column(name="COD_CERTIFICADO")
    private String codcertificado;
    
    @Column(name="ESTADO")
    private long estadocert;

    public long getIdcertificado() {
        return idcertificado;
    }

    public void setIdcertificado(long idcertificado) {
        this.idcertificado = idcertificado;
    }

    public String getTipocertificado() {
        return tipocertificado;
    }

    public void setTipocertificado(String tipocertificado) {
        this.tipocertificado = tipocertificado;
    }

    public String getCodcertificado() {
        return codcertificado;
    }

    public void setCodcertificado(String codcertificado) {
        this.codcertificado = codcertificado;
    }

    public long getEstadocert() {
        return estadocert;
    }

    public void setEstadocert(long estadocert) {
        this.estadocert = estadocert;
    }

    @Override
    public String toString() {
        return "Certificado{" + "idcertificado=" + idcertificado + ", tipocertificado=" + tipocertificado + ", codcertificado=" + codcertificado + ", estadocert=" + estadocert + '}';
    }
    
              
}
