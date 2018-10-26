
package com.ws_safe.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Rodrigo
 */

@Entity
@Table(name="EXAMENES",schema="SAFE")


public class Examenes implements Serializable{
    @Id
    @Column(name="ID_EXAMEN")
    private long idexamen;
    
    @Column(name="NOMBRE_EXAMEN")
    private String nombreexamen;
    
    @Column(name="ESTADO_EXAMEN")
    private long estadoexamen;
    
    @Column(name="PLAN_SALUD_ID_PLAN_SALUD")
    private long plansaludidplansalud;
    
    @Column(name="TIPO_EXAMEN_ID_TIPO_EXAM")
    private long tipoexamenidtipoexam;

    public long getIdexamen() {
        return idexamen;
    }

    public void setIdexamen(long idexamen) {
        this.idexamen = idexamen;
    }

    public String getNombreexamen() {
        return nombreexamen;
    }

    public void setNombreexamen(String nombreexamen) {
        this.nombreexamen = nombreexamen;
    }

    public long getEstadoexamen() {
        return estadoexamen;
    }

    public void setEstadoexamen(long estadoexamen) {
        this.estadoexamen = estadoexamen;
    }

    public long getPlansaludidplansalud() {
        return plansaludidplansalud;
    }

    public void setPlansaludidplansalud(long plansaludidplansalud) {
        this.plansaludidplansalud = plansaludidplansalud;
    }

    public long getTipoexamenidtipoexam() {
        return tipoexamenidtipoexam;
    }

    public void setTipoexamenidtipoexam(long tipoexamenidtipoexam) {
        this.tipoexamenidtipoexam = tipoexamenidtipoexam;
    }

    @Override
    public String toString() {
        return "Examenes{" + "idexamen=" + idexamen + ", nombreexamen=" + nombreexamen + ", estadoexamen=" + estadoexamen + ", plansaludidplansalud=" + plansaludidplansalud + ", tipoexamenidtipoexam=" + tipoexamenidtipoexam + '}';
    }        
}
