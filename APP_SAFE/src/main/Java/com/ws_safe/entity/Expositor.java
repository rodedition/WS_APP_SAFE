
package com.ws_safe.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Rodrigo
 */

@Entity
@Table(name="EXPOSITOR",schema="SAFE")


public class Expositor implements Serializable{
    @Id
    @Column(name="ID_EXPOSITOR")
    private long idexpositor;
    
    @Column(name="RUN_EXPOSITOR")
    private String runexpositor;
    
    @Column(name="NOMBRE_EXPOSITOR")
    private String nombreexpositor;
    
    @Column(name="TEL_EXPOSITOR")
    private String telexpositor;
    
    @Column(name="MAIL_EXPOSITOR")
    private String mailexpositor;
    
    @Column(name="ESTADO_EXPOSITOR")
    private long estadoexpositor;

    public long getIdexpositor() {
        return idexpositor;
    }

    public void setIdexpositor(long idexpositor) {
        this.idexpositor = idexpositor;
    }

    public String getRunexpositor() {
        return runexpositor;
    }

    public void setRunexpositor(String runexpositor) {
        this.runexpositor = runexpositor;
    }

    public String getNombreexpositor() {
        return nombreexpositor;
    }

    public void setNombreexpositor(String nombreexpositor) {
        this.nombreexpositor = nombreexpositor;
    }

    public String getTelexpositor() {
        return telexpositor;
    }

    public void setTelexpositor(String telexpositor) {
        this.telexpositor = telexpositor;
    }

    public String getMailexpositor() {
        return mailexpositor;
    }

    public void setMailexpositor(String mailexpositor) {
        this.mailexpositor = mailexpositor;
    }

    public long getEstadoexpositor() {
        return estadoexpositor;
    }

    public void setEstadoexpositor(long estadoexpositor) {
        this.estadoexpositor = estadoexpositor;
    }

    @Override
    public String toString() {
        return "Expositor{" + "idexpositor=" + idexpositor + ", runexpositor=" + runexpositor + ", nombreexpositor=" + nombreexpositor + ", telexpositor=" + telexpositor + ", mailexpositor=" + mailexpositor + ", estadoexpositor=" + estadoexpositor + '}';
    }
    
    
}
