/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.entity;


import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Rodrigo
 */

@Entity
@Table(name="Tipo_Examen",schema="SAFE")
public class Tipo_Exa implements Serializable{
    @Id
    @Column(name="ID_TIPO_EXAM")
    private long idtipoexam;
    
    @Column(name="DESCRIP_EXAM")
    private String descrip_exam;
    
    @Column(name="ESTADO")
    private long estado;

    public long getIdtipoexam() {
        return idtipoexam;
    }

    public void setIdtipoexam(long idtipoexam) {
        this.idtipoexam = idtipoexam;
    }

    public String getDescrip_exam() {
        return descrip_exam;
    }

    public void setDescrip_exam(String descrip_exam) {
        this.descrip_exam = descrip_exam;
    }

    public long getEstado() {
        return estado;
    }

    public void setEstado(long estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Tipo_Exa{" + "idtipoexam=" + idtipoexam + ", descrip_exam=" + descrip_exam + ", estado=" + estado + '}';
    }   
    
}
