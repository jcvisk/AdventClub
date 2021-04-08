package com.iunis.adventclub.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "datosadministracion")
public class Datosadministracion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "precidente")
    private String precidente;

    @Column(name = "secretario")
    private String secretario;

    @Column(name = "tesorero")
    private String tesorero;
}
