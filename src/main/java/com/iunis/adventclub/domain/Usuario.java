package com.iunis.adventclub.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "userpassword")
    private String userpassword;

    //relaciones
    @JoinColumn(name = "iddatospersonales", referencedColumnName = "id")
    @OneToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    private Datospersonales datospersonales;

    @JoinColumn(name = "idestatus", referencedColumnName = "id")
    @ManyToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
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
                ", usuario='" + username + '\'' +
                ", password='" + userpassword + '\'' +
                ", datospersonales=" + datospersonales +
                ", estatus=" + estatus +
                ", rol=" + rol +
                ", club=" + club +
                '}';
    }
}
