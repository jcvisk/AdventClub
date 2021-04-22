package com.iunis.adventclub.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "password")
    private String password;

    //relaciones
    @ManyToOne
    @JoinColumn(name = "iddatospersonales")
    private Datospersonales datospersonales;

    @ManyToOne
    @JoinColumn(name = "idestatus")
    private Estatus estatus;

    /**
     * Relacion de muchos a muchos con la tabla roles por medio de una
     * tabla intermedia roles_usuarios que no esta mapeada como entity
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "roles_usuarios", joinColumns = @JoinColumn(name = "idusuario"), inverseJoinColumns = @JoinColumn(name = "idrol"))
    private Set<Rol> rol;

    /**
     * Relacion de muchos a muchos con la tabla clubes por medio de una
     * tabla intermedia clubes_usuarios que no esta mapeada como entity
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "clubes_usuarios", joinColumns = @JoinColumn(name = "idusuario"), inverseJoinColumns = @JoinColumn(name = "idclub"))
    private Set<Club> club;

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                '}';
    }
}
