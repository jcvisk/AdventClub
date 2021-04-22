package com.iunis.adventclub.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "periodoeclesiastico")
public class Periodoeclesiastico implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "inicioanio")
    private Date inicioanio;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "finanio")
    private Date finanio;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "inicioinscripcion")
    private Date inicioinscripcion;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fininscripcion")
    private Date fininscripcion;

    //RELACIONES
    @JoinColumn(name = "idclub", referencedColumnName = "id")
    @ManyToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    private Club club;

    @JoinColumn(name = "idestatus", referencedColumnName = "id")
    @ManyToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    private Estatus estatus;
}
