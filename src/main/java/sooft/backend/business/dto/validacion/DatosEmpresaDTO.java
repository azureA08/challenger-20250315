package sooft.backend.business.dto.validacion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DatosEmpresaDTO {

    @NotBlank(message = "El CUIT no puede estar en blanco")
    @Pattern(regexp = "\\d{2}-\\d{8}-\\d{1}", message = "Formato de CUIT inválido")
    private String cuit;

    @NotBlank(message = "La razón social no puede estar en blanco")
    private String razonSocial;

    @NotNull(message = "La fecha de adhesión no puede ser nula")
    private LocalDate fechaAdhesion;

}