
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
@Table(name="USUARIOS",schema="SAFE")


public class Usuarios implements Serializable{
    @Id
    @Column(name="ID_USUARIO")
    private long idusuario;
    
    @Column(name="RUN_USUARIO")
    private String runusuario;
    
    @Column(name="NOMBRES_USUARIO")
    private String nombresusuario;
    
    @Column(name="AP_PATERNO")
    private String appaterno;
    
    @Column(name="AP_MATERNO")
    private String apmaterno;
    
    @Column(name="F_NACIMIENTO_USUARIO")
    private String fnacimientousuario;
    
    @Column(name="SEXO_USUARIO")
    private String sexousuario;

    @Column(name="TEL_USUARIO")
    private String telusuario;
    
    @Column(name="MAIL_USUARIO")
    private String mailusuario;
    
    @Column(name="ESTADO_USUARIO")
    private long estadousuario;
    
    @Column(name="CLAVE_USUARIO")
    private String claveusuario;
    
    @Column(name="PERFIL_ID_PERFIL")
    private long perfilidperfil;
    
    @Column(name="CLIENTE_ID_CLIENTE")
    private long clienteidcliente;

    public long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(long idusuario) {
        this.idusuario = idusuario;
    }

    public String getRunusuario() {
        return runusuario;
    }

    public void setRunusuario(String runusuario) {
        this.runusuario = runusuario;
    }

    public String getNombresusuario() {
        return nombresusuario;
    }

    public void setNombresusuario(String nombresusuario) {
        this.nombresusuario = nombresusuario;
    }

    public String getAppaterno() {
        return appaterno;
    }

    public void setAppaterno(String appaterno) {
        this.appaterno = appaterno;
    }

    public String getApmaterno() {
        return apmaterno;
    }

    public void setApmaterno(String apmaterno) {
        this.apmaterno = apmaterno;
    }

    public String getFnacimientousuario() {
        return fnacimientousuario;
    }

    public void setFnacimientousuario(String fnacimientousuario) {
        this.fnacimientousuario = fnacimientousuario;
    }

    public String getSexousuario() {
        return sexousuario;
    }

    public void setSexousuario(String sexousuario) {
        this.sexousuario = sexousuario;
    }

    public String getTelusuario() {
        return telusuario;
    }

    public void setTelusuario(String telusuario) {
        this.telusuario = telusuario;
    }

    public String getMailusuario() {
        return mailusuario;
    }

    public void setMailusuario(String mailusuario) {
        this.mailusuario = mailusuario;
    }

    public long getEstadousuario() {
        return estadousuario;
    }

    public void setEstadousuario(long estadousuario) {
        this.estadousuario = estadousuario;
    }

    public String getClaveusuario() {
        return claveusuario;
    }

    public void setClaveusuario(String claveusuario) {
        this.claveusuario = claveusuario;
    }

    public long getPerfilidperfil() {
        return perfilidperfil;
    }

    public void setPerfilidperfil(long perfilidperfil) {
        this.perfilidperfil = perfilidperfil;
    }

    public long getClienteidcliente() {
        return clienteidcliente;
    }

    public void setClienteidcliente(long clienteidcliente) {
        this.clienteidcliente = clienteidcliente;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "idusuario=" + idusuario + ", runusuario=" + runusuario + ", nombresusuario=" + nombresusuario + ", appaterno=" + appaterno + ", apmaterno=" + apmaterno + ", fnacimientousuario=" + fnacimientousuario + ", sexousuario=" + sexousuario + ", telusuario=" + telusuario + ", mailusuario=" + mailusuario + ", estadousuario=" + estadousuario + ", claveusuario=" + claveusuario + ", perfilidperfil=" + perfilidperfil + ", clienteidcliente=" + clienteidcliente + '}';
    }   
}
