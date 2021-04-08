package com.iunis.adventclub.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "datosfamiliares")
public class Datosfamiliares implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "nombrepadre")
    private String nombrepadre;

    @Column(name = "apellidopaternopadre")
    private String apellidopaternopadre;

    @Column(name = "apellidomaternopadre")
    private String apellidomaternopadre;

    @Column(name = "nombremadre")
    private String nombremadre;

    @Column(name = "apellidopaternomadre")
    private String apellidopaternomadre;

    @Column(name = "apellidomaternomadre")
    private String apellidomaternomadre;

    //mappedBy
    @OneToOne(mappedBy = "datosfamiliares")
    private Miembro miembro;
}
