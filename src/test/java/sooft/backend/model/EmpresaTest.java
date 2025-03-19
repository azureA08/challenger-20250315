package sooft.backend.model;

import org.junit.jupiter.api.Test;
import sooft.backend.domain.model.Empresa;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmpresaTest {

    private LocalDate fechaAdhesion = LocalDate.now();
    @Test
    void testEmpresaConstructorYGetters() {

        Empresa empresa = initEmpresa();

        empresa.setRazonSocial("Empresa Ejemplo");

        assertEquals("30-12345678-9", empresa.getCuit());
        assertEquals("Empresa Ejemplo", empresa.getRazonSocial());
        assertEquals(fechaAdhesion, empresa.getFechaAdhesion());
    }

    @Test
    void testEmpresaSetters() {

        Empresa empresa = initEmpresa();

        assertEquals("30-12345678-9", empresa.getCuit());
        assertEquals("Nueva Empresa", empresa.getRazonSocial());
        assertEquals(fechaAdhesion, empresa.getFechaAdhesion());
    }

    /***
     *
     * @return dato Empresa
     */
    private Empresa initEmpresa() {
        Empresa empresa = new Empresa();
        empresa.setCuit("30-12345678-9");
        empresa.setRazonSocial("Nueva Empresa");
        empresa.setFechaAdhesion(fechaAdhesion);
        return empresa;
    }
}


