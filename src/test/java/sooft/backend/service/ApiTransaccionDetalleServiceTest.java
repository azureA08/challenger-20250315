package sooft.backend.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sooft.backend.business.casouso.apitransaccion.ApiTransaccionDetalleServiceImpl;
import sooft.backend.domain.model.ApiTransaccionDetalle;
import sooft.backend.infrastructure.adapters.apitransacciondetalle.ApiTransaccionDetalleJpaRepository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ApiTransaccionDetalleServiceTest {

    @Mock
    private ApiTransaccionDetalleJpaRepository apiTransaccionDetalleRepository;

    @InjectMocks
    private ApiTransaccionDetalleServiceImpl apiTransaccionDetalleService;

    private ApiTransaccionDetalle detalle;

    @BeforeEach
    void setUp() {
        detalle = initApiTransaccionDetalle();
    }

    @Test
    void testSaveApiTransaccionDetalle() {
        when(apiTransaccionDetalleRepository.save(any(ApiTransaccionDetalle.class))).thenReturn(detalle);

        ApiTransaccionDetalle savedDetalle = apiTransaccionDetalleService.save(detalle);

        assertEquals(detalle, savedDetalle);
        verify(apiTransaccionDetalleRepository, times(1)).save(detalle);
    }

    @Test
    void testFindApiTransaccionDetalleById_ExistingId() {
        long id = 1L;
        when(apiTransaccionDetalleRepository.findById(id)).thenReturn(Optional.of(detalle));

        Optional<ApiTransaccionDetalle> foundDetalle = apiTransaccionDetalleService.findById(id);

        assertTrue(foundDetalle.isPresent());
        assertEquals(detalle, foundDetalle.get());
        verify(apiTransaccionDetalleRepository, times(1)).findById(id);
    }

    @Test
    void testFindApiTransaccionDetalleById_NonExistingId() {
        long id = 2L;
        when(apiTransaccionDetalleRepository.findById(id)).thenReturn(Optional.empty());

        Optional<ApiTransaccionDetalle> foundDetalle = apiTransaccionDetalleService.findById(id);

        assertFalse(foundDetalle.isPresent());
        verify(apiTransaccionDetalleRepository, times(1)).findById(id);
    }

    @Test
    void testFindAllApiTransaccionDetalles() {

        List<ApiTransaccionDetalle> detalles = Arrays.asList(detalle, initApiTransaccionDetalle());
        when(apiTransaccionDetalleRepository.findAll()).thenReturn(detalles);

        List<ApiTransaccionDetalle> foundDetalles = apiTransaccionDetalleService.findAll();

        assertEquals(detalles, foundDetalles);
        verify(apiTransaccionDetalleRepository, times(1)).findAll();
    }

    @Test
    void testDeleteApiTransaccionDetalleById() {

        long id = 1L;
        doNothing().when(apiTransaccionDetalleRepository).deleteById(id);

        apiTransaccionDetalleService.deleteById(id);

        verify(apiTransaccionDetalleRepository, times(1)).deleteById(id);
    }

    private ApiTransaccionDetalle initApiTransaccionDetalle() {

        ApiTransaccionDetalle detalle = new ApiTransaccionDetalle();

        detalle.setRazonSocial("Nueva Empresa");
        detalle.setFechaAdhesion(20250315);
        detalle.setImporte(BigDecimal.valueOf(200.00));
        detalle.setCuit("30-12345678-9");
        detalle.setCuentaDebito("CuentaD");
        detalle.setCuentaCredito("CuentaC");
        detalle.setFechaTransaccion(20250316);
        return detalle;
    }
}