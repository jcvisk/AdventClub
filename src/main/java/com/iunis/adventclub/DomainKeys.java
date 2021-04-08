package com.iunis.adventclub;



import com.iunis.adventclub.domain.Estatus;

import java.io.Serializable;

public final class DomainKeys implements Serializable {
    private DomainKeys() {
    }

    public static final Estatus ESTATUS_GENERAL_ACTIVO = new Estatus(1L);
    public static final Estatus ESTATUS_GENERAL_INACTIVO = new Estatus(2L);
    /*public static final Estatus ESTATUS_GENERAL_AGOTADO = new Estatus(3L);
    public static final Estatus ESTATUS_GENERAL_APARTADO = new Estatus(4L);*/
}