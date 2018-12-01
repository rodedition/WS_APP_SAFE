
package com.ws_safe.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Rodrigo
 */

@Entity
@Table(name="LIST_ASIS_CAP",schema="SAFE")


public class List_Asis_Cap implements Serializable{
    @Id
    @Column(name="ID_LISTA_CAP")
    private long idlistacap;
    
    @Column(name="ESTADO_ASIST_CAP")
    private Long estadoasistcap;
    
    @Column(name="SESION_CAP_ID_SESION_CAP")
    private Long sesioncapidsesioncap;

    public long getIdlistacap() {
        return idlistacap;
    }

    public void setIdlistacap(long idlistacap) {
        this.idlistacap = idlistacap;
    }

    public Long getEstadoasistcap() {
        return estadoasistcap;
    }

    public void setEstadoasistcap(Long estadoasistcap) {
        this.estadoasistcap = estadoasistcap;
    }

    public Long getSesioncapidsesioncap() {
        return sesioncapidsesioncap;
    }

    public void setSesioncapidsesioncap(Long sesioncapidsesioncap) {
        this.sesioncapidsesioncap = sesioncapidsesioncap;
    }

    @Override
    public String toString() {
        return "List_Asis_Cap{" + "idlistacap=" + idlistacap + ", estadoasistcap=" + estadoasistcap + ", sesioncapidsesioncap=" + sesioncapidsesioncap + '}';
    }

    
}
