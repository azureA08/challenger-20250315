package backend.service;


import com.backend.business.casouso.transferenciadetalle.TransferenciaDetalleServiceImpl;
import com.backend.domain.model.TransferenciaDetalle;
import com.backend.infrastructure.repositories.TransferenciaDetalleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransaccionDetalleServiceTest {

    @Mock
    private TransferenciaDetalleRepository transfereciaDetalleRepository;

    @InjectMocks
    private TransferenciaDetalleServiceImpl transfereciaDetalleService;

    private TransferenciaDetalle detalle;

    @BeforeEach
    void setUp() {
        detalle = initTransferenciaDetalle();
    }

    @Test
    void testSaveTransfereciaDetalle() {
        when(transfereciaDetalleRepository.save(any(TransferenciaDetalle.class))).thenReturn(detalle);


        TransferenciaDetalle savedDetalle = transfereciaDetalleService.save(detalle);

        assertEquals(detalle, savedDetalle);
        verify(transfereciaDetalleRepository, times(1)).save(detalle);
    }

    @Test
    void testFindTransfereciaDetalleById_ExistingId() {
        long id = 1L;
        when(transfereciaDetalleRepository.findById(id)).thenReturn(Optional.of(detalle));

        Optional<TransferenciaDetalle> foundDetalle = transfereciaDetalleService.findById(id);

        assertTrue(foundDetalle.isPresent());
        assertEquals(detalle, foundDetalle.get());
        verify(transfereciaDetalleRepository, times(1)).findById(id);
    }

    @Test
    void testFindTransfereciaDetalleById_NonExistingId() {
        long id = 2L;
        when(transfereciaDetalleRepository.findById(id)).thenReturn(Optional.empty());

        Optional<TransferenciaDetalle> foundDetalle = transfereciaDetalleService.findById(id);

        assertFalse(foundDetalle.isPresent());
        verify(transfereciaDetalleRepository, times(1)).findById(id);
    }

    @Test
    void testFindAllTransfereciaDetalles() {

        List<TransferenciaDetalle> detalles = Arrays.asList(detalle, initTransferenciaDetalle());
        when(transfereciaDetalleRepository.findAll()).thenReturn(detalles);

        List<TransferenciaDetalle> foundDetalles = transfereciaDetalleService.findAll();

        assertEquals(detalles, foundDetalles);
        verify(transfereciaDetalleRepository, times(1)).findAll();
    }

    @Test
    void testDeleteRransfereciaDetalleById() {

        long id = 1L;
        doNothing().when(transfereciaDetalleRepository).deleteById(id);

        transfereciaDetalleService.deleteById(id);

        verify(transfereciaDetalleRepository, times(1)).deleteById(id);
    }

    private TransferenciaDetalle initTransferenciaDetalle() {

        TransferenciaDetalle detalle = new TransferenciaDetalle();

        detalle.setRazonSocial("Nueva Empresa");
        detalle.setFechaAdhesion(20250315);
        detalle.setImporte(BigDecimal.valueOf(200.00));
        detalle.setCuit("30-12345678-9");
        detalle.setCuentaDebito("CuentaD");
        detalle.setCuentaCredito("CuentaC");
        detalle.setFechaTransferencia(20250316);
        return detalle;
    }
}