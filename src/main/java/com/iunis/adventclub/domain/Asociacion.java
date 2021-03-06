package com.iunis.adventclub.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Entity
@Table(name = "asociaciones")
public class Asociacion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotEmpty
    @Column(name = "nombre")
    private String nombre;

    //Relaciones
    @Valid
    @JoinColumn(name = "iddatosadministracion", referencedColumnName = "id")
    @OneToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    private Datosadministracion datosadministracion;

    @JoinColumn(name = "idestatus", referencedColumnName = "id")
    @ManyToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    private Estatus estatus;

}
