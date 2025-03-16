package sooft.backend.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;

/*****
 * Informacion de la empresa
 */
@Table(name = "empresa")
@Entity
@Data
@NoArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cuit;
    @Column
    private String razonSocial;
    @Column
    private LocalDate fechaAdhesion;

}