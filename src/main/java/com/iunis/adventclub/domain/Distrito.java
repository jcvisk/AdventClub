package com.iunis.adventclub.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data
@Entity
@Table(name = "distritos")
public class Distrito implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    //RELACIONES
    @JoinColumn(name = "idasociacion", referencedColumnName = "id")
    @ManyToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    private Asociacion asociacion;

    @JoinColumn(name = "iddatosadministracion", referencedColumnName = "id")
    @OneToOne(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
    private Datosadministracion datosadministracion;

    @JoinColumn(name = "idestatus", referencedColumnName = "id")
    @ManyToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    private Estatus estatus;

}
