package backend.model;

import com.soft.backend.domain.model.ApiTransaccionDetalle;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ApiTransaccionDetalleTest {

    private int nuevaFechaAdhesion = 20250315;
    private int nuevaFechaTransaccion = 20250315;

    @Test
    void testApiTransaccionDetalleConstructorYGetters() {

        int fechaAdhesion = 20250315;
        int fechaTransaccion = 20250315;

        ApiTransaccionDetalle detalle = initApiTransaccionDetalle();

        assertEquals("30-12345678-9", detalle.getCuit());
        assertEquals("Nueva Empresa", detalle.getRazonSocial());

        assertEquals(fechaAdhesion, detalle.getFechaAdhesion());
        assertEquals(BigDecimal.valueOf(200.000), detalle.getImporte());
        assertEquals("30-12345678-9", detalle.getCuit());
        assertEquals("CuentaD", detalle.getCuentaDebito());
        assertEquals("CuentaC", detalle.getCuentaCredito());

        assertEquals(fechaTransaccion, detalle.getFechaTransaccion());
    }

    @Test
    void testApiTransaccionDetalleSetters() {

        ApiTransaccionDetalle detalle = initApiTransaccionDetalle();

        assertEquals("30-12345678-9", detalle.getCuit());
        assertEquals("Nueva Empresa", detalle.getRazonSocial());
        assertEquals(nuevaFechaAdhesion, detalle.getFechaAdhesion());
        assertEquals(BigDecimal.valueOf(200.00), detalle.getImporte());
        assertEquals("30-12345678-9", detalle.getCuit());
        assertEquals("CuentaD", detalle.getCuentaDebito());
        assertEquals("CuentaC", detalle.getCuentaCredito());
        assertEquals(nuevaFechaTransaccion, detalle.getFechaTransaccion());
    }

    private ApiTransaccionDetalle initApiTransaccionDetalle() {

        ApiTransaccionDetalle detalle = new ApiTransaccionDetalle();


        detalle.setRazonSocial("Nueva Empresa");
        detalle.setFechaAdhesion(nuevaFechaAdhesion);
        detalle.setImporte(BigDecimal.valueOf(200.00));
        detalle.setCuit("30-12345678-9");
        detalle.setCuentaDebito("CuentaD");
        detalle.setCuentaCredito("CuentaC");
        detalle.setFechaTransaccion(nuevaFechaTransaccion);
        return detalle;
    }
}