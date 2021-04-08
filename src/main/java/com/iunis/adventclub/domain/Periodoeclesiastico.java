package com.iunis.adventclub.domain;

import lombok.Data;

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
    private String descripcion;
    private Long idusuario;
    private Date inicioano;
    private Date finano;
    private Date inicioinscripcion;
    private Date fininscripcion;
}
