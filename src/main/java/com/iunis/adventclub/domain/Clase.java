package com.iunis.adventclub.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "clases")
public class Clase implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @JoinColumn(name = "idclub", referencedColumnName = "id")
    @ManyToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    private Club club;

    @JoinColumn(name = "idestatus", referencedColumnName = "id")
    @ManyToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    private Estatus estatus;
}
