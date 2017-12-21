/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model.objetos;

import com.websystique.spring.model.Info;
import java.io.Serializable;
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
import javax.persistence.Table;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "tipoobjeto")
public class TipoObjeto implements Serializable {    
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_tipoObjeto;

    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private float tam_stnd; // cm
    
    @Column(nullable = false)
    private float peso_stnd; // gramos
    
    @Column( nullable = false)
    private float degradado;  // pts de vida que pierde por dia
    
    @Column(nullable = false)
    private float durabilidad_stnd;  // ptos de vida del objeto > 100 integro. < a 100 el porcentaje de integridad

    @OneToMany(cascade={CascadeType.PERSIST,CascadeType.REMOVE}) 
    private Set<Info> informacion;
    
    public TipoObjeto() {
    }
    
    public long getId_tipoObjeto() {
        return id_tipoObjeto;
    }

    public void setId_tipoObjeto(long id_tipoObjeto) {
        this.id_tipoObjeto = id_tipoObjeto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getTam_stnd() {
        return tam_stnd;
    }

    public void setTam_stnd(float tam_stnd) {
        this.tam_stnd = tam_stnd;
    }

    public float getPeso_stnd() {
        return peso_stnd;
    }

    public void setPeso_stnd(float peso_stnd) {
        this.peso_stnd = peso_stnd;
    }

    public float getDegradado() {
        return degradado;
    }

    public void setDegradado(float degradado) {
        this.degradado = degradado;
    }

    public float getDurabilidad_stnd() {
        return durabilidad_stnd;
    }

    public void setDurabilidad_stnd(float durabilidad_stnd) {
        this.durabilidad_stnd = durabilidad_stnd;
    }

    public Set<Info> getInformacion() {
        return informacion;
    }

    public void setInformacion(Set<Info> informacion) {
        this.informacion = informacion;
    }
    
    public void addInfo(Info i){
        if (informacion == null)
            informacion =  new HashSet<Info>();
        informacion.add(i);
    }
    
    public void addInfo(boolean soloMaster,String texto, String titulo){
        if (informacion == null)
            informacion =  new HashSet<Info>();
        
        Info i = new Info();
        i.setSoloMaster(true);
        i.setTexto(texto);
        i.setTitulo(titulo);
        
        informacion.add(i);
    }
    

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TipoObjeto))
			return false;
		TipoObjeto other = (TipoObjeto) obj;		
		return id_tipoObjeto == other.getId_tipoObjeto();
	}

    @Override
    public String toString() {
        return "TipoObjeto{" + "id_tipoObjeto=" + id_tipoObjeto + ", nombre=" + nombre + ", tam_stnd=" + tam_stnd + ", peso_stnd=" + peso_stnd + ", degradado=" + degradado + ", durabilidad_stnd=" + durabilidad_stnd + '}';
    }
    
    
}
