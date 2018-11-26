package com.ws_safe.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Rodrigo
 */

@Entity
@Table(name="Tipo_Cap",schema="SAFE")


public class Tipo_Cap implements Serializable{
    @Id
    @Column(name="ID_TIPO_CAP")
    private long idtipocap;
    
    @Column(name="DESCRIP_CAP")
    private String descripcap;
    
    @Column(name="ESTADO")
    private long estado;

    public long getIdtipocap() {
        return idtipocap;
    }

    public void setIdtipocap(long idtipocap) {
        this.idtipocap = idtipocap;
    }

    public String getDescripcap() {
        return descripcap;
    }

    public void setDescripcap(String descripcap) {
        this.descripcap = descripcap;
    }

    public long getEstado() {
        return estado;
    }

    public void setEstado(long estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Tipo_Cap{" + "idtipocap=" + idtipocap + ", descripcap=" + descripcap + ", estado=" + estado + '}';
    }
    
           
}
