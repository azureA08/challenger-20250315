package sooft.backend.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/****
 * Represento la informacion transaccinal,
 * que expone la API Tranasacciones.
 * Al almacenar en una sola tabla le informacion,
 * mejorar el tiempo de respuesta de la api
 */
@Table(name = "ApiTransaccionDetalle")
@Entity
@Data
@NoArgsConstructor
public class ApiTransaccionDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Informacion de la empresa

    @Column
    private String cuit;
    @Column
    private String razonSocial;
    //private Calendar fechaAdhesion;
    //Fecha int yyyyMMDDDhhmmss  para facilitar ordenamiento,
    // comparaciones y extraccion de info que expone la Api
    @Column
    private int fechaAdhesion;

    //Informacion de la transaccion asociada a una empresa
    @Column
    private BigDecimal importe;
    @Column
    private String cuentaDebito;
    @Column
    private String cuentaCredito;
    //private Calendar fechaTransaccion;
    //Fecha int yyyyMMDDDhhmmss  para facilitar ordenamiento,
    // comparaciones y extraccion de info que expone la Api
    @Column
    private int fechaTransaccion;
}
