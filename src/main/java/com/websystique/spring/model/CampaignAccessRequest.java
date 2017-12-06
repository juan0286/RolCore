/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TiranoJuan
 */

@Entity
@Table(name = "CampaignAccesRequest")
@XmlRootElement
public class CampaignAccessRequest  implements Serializable{
    
    public enum estado { ESPERA, ACEPTADA, RECHAZADA, NUEVA};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_car;
    
    @Column
    private Date fecha;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Campaign campaign;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Jugador jugador;
    
    @Column
    private estado status;

    public CampaignAccessRequest() {
    }

    public long getId_car() {
        return id_car;
    }

    public void setId_car(long id_car) {
        this.id_car = id_car;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public estado getStatus() {
        return status;
    }

    public void setStatus(estado status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CampaignAccessRequest other = (CampaignAccessRequest) obj;        
                
        if (!this.campaign.equals(other.campaign) || this.jugador.equals(other.jugador)) {
            return false;
        }
        
        if (this.id_car != other.id_car) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "CampaignAccessRequest{" + "id_car=" + id_car + ", fecha=" + fecha + ", campaign=" + campaign + ", jugador=" + jugador + ", status=" + status + '}';
    }

    
    
    
    
    
    
}
