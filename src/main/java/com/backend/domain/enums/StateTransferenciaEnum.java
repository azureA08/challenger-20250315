package com.backend.domain.enums;

/**
 * Estado particular del transferencia de un grupo.
 */
public enum StateTransferenciaEnum {

    VALIDO("transferencia ACTUAL VALIDO", 0),
    DEPRECADO("transferencia INVALIDO", 1),
    PENDIENTE("transferencia pendiente a VALIDAR", 2),
    ABIERTO("transferencia en DESAARROLLO", 3);

    private final String descripcion;
    private final int codigo;

    StateTransferenciaEnum(String descripcion, int codigo) {
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
