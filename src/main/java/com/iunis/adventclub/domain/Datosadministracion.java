package com.iunis.adventclub.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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

    @NotEmpty
    @Column(name = "precidente")
    private String precidente;

    @NotEmpty
    @Column(name = "secretario")
    private String secretario;

    @NotEmpty
    @Column(name = "tesorero")
    private String tesorero;
}
