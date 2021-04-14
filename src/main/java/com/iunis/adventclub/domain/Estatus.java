package com.iunis.adventclub.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data
@Entity
@Table(name = "estatus")
public class Estatus implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    //mappedBy
    @OneToMany(mappedBy = "estatus")
    private Collection<Asociacion> asociacionCollection;
    @OneToMany(mappedBy = "estatus")
    private Collection<Distrito> distritoCollection;
    @OneToMany(mappedBy = "estatus")
    private Collection<Iglesia> iglesiaCollection;
    @OneToMany(mappedBy = "estatus")
    private Collection<Club> clubCollection;
    @OneToMany(mappedBy = "estatus")
    private Collection<Miembro> miembroCollection;
    @OneToMany(mappedBy = "estatus")
    private Collection<Clase> claseCollection;

    public Estatus() {
    }

    public Estatus(long idEstatus) {
        this.id = idEstatus;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
