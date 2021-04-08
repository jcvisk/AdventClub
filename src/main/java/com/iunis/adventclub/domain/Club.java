package com.iunis.adventclub.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "clubes")
public class Club implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    //RELACIONES
    @JoinColumn(name = "idiglesia", referencedColumnName = "id")
    @ManyToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    private Iglesia iglesia;

    @JoinColumn(name = "iddatosadministracion", referencedColumnName = "id")
    @OneToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    private Datosadministracion datosadministracion;

    @JoinColumn(name = "idestatus", referencedColumnName = "id")
    @ManyToOne(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
    private Estatus estatus;
}
