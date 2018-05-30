/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model.campaign;

import com.websystique.spring.model.Campaign;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "Historia")
@XmlRootElement
public class Historia implements Serializable{
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id_historia;
    
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE}) 
    @JoinColumn(name = "ID_CAMPAIGN")
    Campaign campaign;
    
    @Column(nullable = false)
    String fabula;
    
    @OneToMany(fetch =FetchType.LAZY)
    Set<Partida> partidas;

    public long getId_historia() {
        return id_historia;
    }

    public void setId_historia(long id_historia) {
        this.id_historia = id_historia;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public String getFabula() {
        return fabula;
    }

    public void setFabula(String fabula) {
        this.fabula = fabula;
    }

    public Set<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(Set<Partida> partidas) {
        this.partidas = partidas;
    }
    
    
    
    
    
}
