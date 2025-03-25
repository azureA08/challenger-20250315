package com.backend.domain.enums;

/**
 * Tipo o clasificacion particular del transferencia de un grupo.
 */
public enum TypeTransferenciaEnum {

    INFO("transferencia Informativo", 0),
    ERROR("transferencia que dessribe Error", 1),
    SOLUCION("transferencia que dessribe SOLUCION", 2),
    PRUEBA("transferencia que dessribe PRUEBA", 3);

    private final String descripcion;
    private final int codigo;

    TypeTransferenciaEnum(String descripcion, int codigo) {
        this.descripcion = descripcion;
        this.codigo = codigo;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public int getCodigo() {
        return codigo;
    }
}
