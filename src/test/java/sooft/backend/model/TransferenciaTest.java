package sooft.backend.model;

import org.junit.jupiter.api.Test;
import sooft.backend.domain.model.Transferencia;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TransferenciaTest {

    @Test
    void testTransferenciaConstructorYGetters() {

        Transferencia transferencia = initTransferencia();

        assertEquals(BigDecimal.valueOf(200.000), transferencia.getImporte());
        assertEquals("30-12345678-9", transferencia.getIdEmpresa());
        assertEquals("CuentaD", transferencia.getCuentaDebito());
        assertEquals("CuentaC", transferencia.getCuentaCredito());
    }

    @Test
    void testTransferenciaSetters() {
        
        Transferencia transferencia = initTransferencia();

        assertEquals(BigDecimal.valueOf(200.00), transferencia.getImporte());
        assertEquals("30-12345678-9", transferencia.getIdEmpresa());
        assertEquals("CuentaD", transferencia.getCuentaDebito());
        assertEquals("CuentaC", transferencia.getCuentaCredito());
    }

    private static Transferencia initTransferencia() {
        Transferencia transferencia = new Transferencia();

        transferencia.setImporte(BigDecimal.valueOf(200.00));
        transferencia.setIdEmpresa("30-12345678-9");
        transferencia.setCuentaDebito("CuentaD");
        transferencia.setCuentaCredito("CuentaC");
        return transferencia;
    }
}