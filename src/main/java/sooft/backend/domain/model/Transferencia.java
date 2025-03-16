package sooft.backend.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;

/***
 * Info de cada transferencia ;
 * que realiza una empresa
 */
@Table(name = "transferencia")
@Entity
@Data
@NoArgsConstructor
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private BigDecimal importe;
    // String cuitEmpresa; Relación con Empresa=>Transferencia
    @Column
    private String idEmpresa;
    @Column
    private String cuentaDebito;
    @Column
    private String cuentaCredito;
    @Column
    private LocalDate fechaTransaccion;

}
