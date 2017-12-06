/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model.objetos;

import com.websystique.spring.model.Info;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "PremioPregunta")
public class ObjetoPortado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_objPortado;

    @OneToOne
    private Objeto obj;

    @Column
    private boolean enPoder;

    @Column
    private boolean pesar;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Info> infos;

    public ObjetoPortado() {
    }

    public long getId_objPortado() {
        return id_objPortado;
    }

    public void setId_objPortado(long id_objPortado) {
        this.id_objPortado = id_objPortado;
    }

    public Objeto getObj() {
        return obj;
    }

    public void setObj(Objeto obj) {
        this.obj = obj;
    }

    public boolean isEnPoder() {
        return enPoder;
    }

    public void setEnPoder(boolean enPoder) {
        this.enPoder = enPoder;
    }

    public boolean isPesar() {
        return pesar;
    }

    public void setPesar(boolean pesar) {
        this.pesar = pesar;
    }

    public Set<Info> getInfos() {
        return infos;
    }

    public void setInfos(Set<Info> infos) {
        this.infos = infos;
    }

    public void addInfo(Info i) {
        if (this.infos == null) {
            this.infos = new HashSet<Info>();
        }
        this.infos.add(i);
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
        final ObjetoPortado other = (ObjetoPortado) obj;
        if (this.id_objPortado != other.id_objPortado) {
            return false;
        }
        return true;
    }

}
