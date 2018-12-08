
package com.ws_safe.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Rodrigo
 */

@Entity
@Table(name="LISTASISSALUD",schema="SAFE")


public class List_Asis_Salud implements Serializable{
    @Id
    @Column(name="ID_LIST_SALUD")
    private long idlistsalud;
    
    @Column(name="ESTADO_ASIST_SALUD")
    private Long estadoasistsalud;
    
    @Column(name="SESION_SALUD_ID_SESION_SALUD")
    private Long sesionsaludidsesionsalud;
    
    @Column(name="FECHACREACION")
    private String fechacreacion;

    public long getIdlistsalud() {
        return idlistsalud;
    }

    public void setIdlistsalud(long idlistsalud) {
        this.idlistsalud = idlistsalud;
    }

    public Long getEstadoasistsalud() {
        return estadoasistsalud;
    }

    public void setEstadoasistsalud(Long estadoasistsalud) {
        this.estadoasistsalud = estadoasistsalud;
    }

    public Long getSesionsaludidsesionsalud() {
        return sesionsaludidsesionsalud;
    }

    public void setSesionsaludidsesionsalud(Long sesionsaludidsesionsalud) {
        this.sesionsaludidsesionsalud = sesionsaludidsesionsalud;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    @Override
    public String toString() {
        return "List_Asis_Salud{" + "idlistsalud=" + idlistsalud + ", estadoasistsalud=" + estadoasistsalud + ", sesionsaludidsesionsalud=" + sesionsaludidsesionsalud + ", fechacreacion=" + fechacreacion + '}';
    }
    
    

}
