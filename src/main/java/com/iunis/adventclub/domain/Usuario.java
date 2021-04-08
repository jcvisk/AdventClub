package com.iunis.adventclub.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

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
    private Datospersonales iddatospersonales;

    @ManyToOne
    @JoinColumn(name = "idestatus")
    private Estatus idestatus;

    @OneToOne
    @JoinColumn(name = "idrol")
    private Role idrol;
}
