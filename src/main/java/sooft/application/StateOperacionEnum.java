package sooft.application;

/**
 * Estado final del la operacion realizada..
 */
public enum StateOperacionEnum {

    VALIDO("Alta  VALIDA", 0),
    ERROR("Alta  FALLIDA", 1);

    private final String descripcion;
    private final int codigo;

    StateOperacionEnum(String descripcion, int codigo) {
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
