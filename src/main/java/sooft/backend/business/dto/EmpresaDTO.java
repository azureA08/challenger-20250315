package sooft.backend.business.dto;

import lombok.Data;

import java.util.Calendar;

@Data
public class EmpresaDTO {
    private String cuit;
    private String razonSocial;
    private Calendar fechaAdhesion;
}
