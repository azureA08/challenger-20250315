package backend.model;

import com.backend.domain.model.TransferenciaDetalle;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TransaccionDetalleTest {


    @Test
    void testTransferenciaDetalleConstructorYGetters() {

        int fechaAdhesion = 20250325;
        int fechaTransferencia = 20250325;

        TransferenciaDetalle detalle = initTransferenciaDetalle();

        assertEquals("30-12345678-9", detalle.getCuit());
        assertEquals("Nueva Empresa", detalle.getRazonSocial());

        assertEquals(fechaAdhesion, detalle.getFechaAdhesion());
        assertEquals(BigDecimal.valueOf(200.000), detalle.getImporte());
        assertEquals("30-12345678-9", detalle.getCuit());
        assertEquals("CuentaD", detalle.getCuentaDebito());
        assertEquals("CuentaC", detalle.getCuentaCredito());

        assertEquals(fechaTransferencia, detalle.getFechaTransferencia());
    }

    @Test
    void testTransferenciaDetalleSetters() {

        TransferenciaDetalle detalle = initTransferenciaDetalle();

        assertEquals("30-12345678-9", detalle.getCuit());
        assertEquals("Nueva Empresa", detalle.getRazonSocial());
        assertEquals(20250325, detalle.getFechaAdhesion());
        assertEquals(BigDecimal.valueOf(200.00), detalle.getImporte());
        assertEquals("30-12345678-9", detalle.getCuit());
        assertEquals("CuentaD", detalle.getCuentaDebito());
        assertEquals("CuentaC", detalle.getCuentaCredito());
        assertEquals(20250325, detalle.getFechaTransferencia());
    }

    private TransferenciaDetalle initTransferenciaDetalle() {

        TransferenciaDetalle detalle = new TransferenciaDetalle();


        detalle.setRazonSocial("Nueva Empresa");
        detalle.setFechaAdhesion(20250325);
        detalle.setImporte(BigDecimal.valueOf(200.00));
        detalle.setCuit("30-12345678-9");
        detalle.setCuentaCredito("CuentaC");
        detalle.setCuentaDebito("CuentaD");
        detalle.setFechaTransferencia(20250325);
        return detalle;
    }
}