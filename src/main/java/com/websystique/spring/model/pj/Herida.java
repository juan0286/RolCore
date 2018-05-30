/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model.pj;

import com.websystique.spring.model.Personaje;
import com.websystique.spring.model.Tempo;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "Herida")
public class Herida {

    public static enum EstadoHerida {
        ACTIVA, CURADA, ANULADA
    }

    public static enum TipoHerida {
        MORTAL, MUSCULAR, FRACTURA, CORTE, HEMORRAGICA, QUEMADURA, CONGELAMIENTO
    }

    public static enum GravedadHerida {
        LEVE, NORMAL, GRAVE, MORTAL
    }

    public static enum LocacionHerida {
        CABEZA, TORSO, ABDOMEN, ESPALDA, BRAZO_I, HOMBRO_I,
        BRAZO_D, HOMBRO_D, ENTREPIERNA, MUSLO_I, PIERNA_I, PIE_I, MUSLO_D, PIERNA_D, PIE_D
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_herida;

    @ManyToOne(fetch = FetchType.EAGER)
//    @LazyCollection(LazyCollectionOption.FALSE)   
    Personaje pj;
    
    @ManyToMany(cascade = {CascadeType.ALL})
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Modifier> mods;

    @ManyToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<ModFisico> modFisicos;

    @Column
    private boolean anulacion_progresiva;

    @Column
    private String descripcion;    

    @Enumerated(EnumType.STRING)
    private TipoHerida tipoHerida;

    @Enumerated(EnumType.STRING)
    private GravedadHerida gravedad;

    @Enumerated(EnumType.STRING)
    private LocacionHerida locacionHerida;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoHerida estadoHerida;

    @OneToOne(cascade = CascadeType.ALL)
    private Tempo tempo;
    
    @Column
    private int pvAsalto;
    
    @Column
    private int restoActividad;
    
    @Formula("((SELECT 100 - (t.transcurso * 100) / t.caducidad FROM Tempo as t WHERE t.id_tempo = tempo_id_tempo)*restoActividad)/100")
    private int restoActActual;
    
    @Formula("((SELECT 100 - (t.transcurso * 100) / t.caducidad FROM Tempo as t WHERE t.id_tempo = tempo_id_tempo)*pvAsalto)/100")
    private int pvAsaltoActual;
    
    @Formula("(SELECT (100 - (t2.transcurso * 100) / t2.caducidad) FROM Tempo as t2 WHERE t2.id_tempo = tempo_id_tempo)")
    private int porcentajeActual;

    public int getPorcentajeActual() {
        return porcentajeActual;
    }

    public void setPorcentajeActual(int porcentajeActual) {
        this.porcentajeActual = porcentajeActual;
    }
    
    
    
    public Herida() {
    }

    public int getRestoActividad() {
        return restoActividad;
    }

    public void setRestoActividad(int restoActividad) {
        this.restoActividad = restoActividad;
    }

    
    public long getId_herida() {
        return id_herida;
    }

    public void setId_herida(long id_herida) {
        this.id_herida = id_herida;
    }

    public Personaje getPj() {
        return pj;
    }

    public void setPj(Personaje pj) {
        this.pj = pj;
    }

    
    public Set<Modifier> getMods() {
        return mods;
    }

    public void setMods(Set<Modifier> mods) {
        this.mods = mods;
    }

    public Set<ModFisico> getModFisicos() {
        return modFisicos;
    }

    public void setModFisicos(Set<ModFisico> modFisicos) {
        this.modFisicos = modFisicos;
    }

    public boolean isAnulacion_progresiva() {
        return anulacion_progresiva;
    }

    public void setAnulacion_progresiva(boolean anulacion_progresiva) {
        this.anulacion_progresiva = anulacion_progresiva;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPvAsalto() {
        return pvAsalto;
    }

    public void setPvAsalto(int pvAsalto) {
        this.pvAsalto = pvAsalto;
    }

    public TipoHerida getTipoHerida() {
        return tipoHerida;
    }

    public void setTipoHerida(TipoHerida tipoHerida) {
        this.tipoHerida = tipoHerida;
    }

    public GravedadHerida getGravedad() {
        return gravedad;
    }

    public void setGravedad(GravedadHerida gravedad) {
        this.gravedad = gravedad;
    }

    public LocacionHerida getLocacionHerida() {
        return locacionHerida;
    }

    public void setLocacionHerida(LocacionHerida locacionHerida) {
        this.locacionHerida = locacionHerida;
    }

    public EstadoHerida getEstadoHerida() {
        return estadoHerida;
    }

    public void setEstadoHerida(EstadoHerida estadoHerida) {
        this.estadoHerida = estadoHerida;
    }

    
    
    public void addMod(Modifier m) {
        if (mods == null) {
            mods = new HashSet<Modifier>();
        }
        mods.add(m);
    }

    public void addModFisico(ModFisico mf) {
        if (modFisicos == null) {
            modFisicos = new HashSet<ModFisico>();
        }
        modFisicos.add(mf);
    }

    public Tempo getTempo() {
        return tempo;
    }

    public void setTempo(Tempo tempo) {
        this.tempo = tempo;
    }

    public int getRestoActActual() {
        return restoActActual;
    }

    public void setRestoActActual(int restoActActual) {
        this.restoActActual = restoActActual;
    }

    public int getPvAsaltoActual() {
        return pvAsaltoActual;
    }

    public void setPvAsaltoActual(int pvAsaltoActual) {
        this.pvAsaltoActual = pvAsaltoActual;
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
        final Herida other = (Herida) obj;
        if (this.id_herida != other.id_herida) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Herida{" + "pj=" + pj + ", descripcion=" + descripcion + ", tipoHerida=" + tipoHerida + ", gravedad=" + gravedad + ", locacionHerida=" + locacionHerida + ", estadoHerida=" + estadoHerida + ", pvAsalto=" + pvAsalto + ", restoActividad=" + restoActividad + ", restoActActual=" + restoActActual + ", pvAsaltoActual=" + pvAsaltoActual + ", porcentajeActual=" + porcentajeActual + '}';
    }

}
