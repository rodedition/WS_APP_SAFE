
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
@Table(name="SOLIEVALTER",schema="SAFE")


public class SoliEvalTer implements Serializable{
    @Id
    @Column(name="ID_SOLICITUD")
    private long idsolicitud;
    
    @Column(name="FECHA_CREACION")
    private Date fechacreacion;
    
    @Column(name="DIRECCION_VISITA")
    private String direccionvisita;
    
    @Column(name="DESCRIP_VISITA")
    private String descripcionvisita;
    
    @Column(name="CLIENTE_ID_CLIENTE")
    private long clienteidcliente;
    
    @Column(name="TIPOVISITTER_ID_TIPO_VISTER")
    private long tipovisitteridtipovister;
    
    @Column(name="ESTADO")
    private long estadosolievalter;

    public long getIdsolicitud() {
        return idsolicitud;
    }

    public void setIdsolicitud(long idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getDireccionvisita() {
        return direccionvisita;
    }

    public void setDireccionvisita(String direccionvisita) {
        this.direccionvisita = direccionvisita;
    }

    public String getDescripcionvisita() {
        return descripcionvisita;
    }

    public void setDescripcionvisita(String descripcionvisita) {
        this.descripcionvisita = descripcionvisita;
    }

    public long getClienteidcliente() {
        return clienteidcliente;
    }

    public void setClienteidcliente(long clienteidcliente) {
        this.clienteidcliente = clienteidcliente;
    }

    public long getTipovisitteridtipovister() {
        return tipovisitteridtipovister;
    }

    public void setTipovisitteridtipovister(long tipovisitteridtipovister) {
        this.tipovisitteridtipovister = tipovisitteridtipovister;
    }

    public long getEstadosolievalter() {
        return estadosolievalter;
    }

    public void setEstadosolievalter(long estadosolievalter) {
        this.estadosolievalter = estadosolievalter;
    }

    @Override
    public String toString() {
        return "SoliEvalTer{" + "idsolicitud=" + idsolicitud + ", fechacreacion=" + fechacreacion + ", direccionvisita=" + direccionvisita + ", descripcionvisita=" + descripcionvisita + ", clienteidcliente=" + clienteidcliente + ", tipovisitteridtipovister=" + tipovisitteridtipovister + ", estadosolievalter=" + estadosolievalter + '}';
    }    
    
}
