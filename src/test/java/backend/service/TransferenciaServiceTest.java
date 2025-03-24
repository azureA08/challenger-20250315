package backend.service;

import com.soft.backend.business.casouso.transferencia.TransferenciaService;
import com.soft.backend.business.casouso.transferencia.TransferenciaServiceImpl;
import com.soft.backend.domain.model.Transferencia;
import com.soft.backend.infraestructure.adapters.transferecia.TransferenciaJpaRepository;
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
class TransferenciaServiceTest {

    @Mock
    private TransferenciaJpaRepository transferenciaRepository;

    @InjectMocks
    private TransferenciaServiceImpl transferenciaService;

    private Transferencia transferencia;

    private static Transferencia initTransferencia() {
        Transferencia transferencia = new Transferencia();

        transferencia.setImporte(BigDecimal.valueOf(200.00));
        transferencia.setIdEmpresa("30-12345678-9");
        transferencia.setCuentaDebito("CuentaD");
        transferencia.setCuentaCredito("CuentaC");
        return transferencia;
    }

    @BeforeEach
    void setUp() {
        transferencia = initTransferencia();
    }

    @Test
    void testSaveTransferencia() {
        when(transferenciaRepository.save(any(Transferencia.class))).thenReturn(transferencia);

        Transferencia savedTransferencia = transferenciaService.save(transferencia);

        assertEquals(transferencia, savedTransferencia);
        verify(transferenciaRepository, times(1)).save(transferencia);
    }

    @Test
    void testFindTransferenciaById_ExistingId() {
        long id = 1L;
        when(transferenciaRepository.findById(id)).thenReturn(Optional.of(transferencia));

        Optional<Transferencia> foundTransferencia = transferenciaService.findById(id);

        assertTrue(foundTransferencia.isPresent());
        assertEquals(transferencia, foundTransferencia.get());
        verify(transferenciaRepository, times(1)).findById(id);
    }

    @Test
    void testFindTransferenciaById_NonExistingId() {
        long id = 2L;
        when(transferenciaRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Transferencia> foundTransferencia = transferenciaService.findById(id);

        assertFalse(foundTransferencia.isPresent());
        verify(transferenciaRepository, times(1)).findById(id);
    }

    @Test
    void testFindAllTransferencias() {
        List<Transferencia> transferencias = Arrays.asList(transferencia, initTransferencia());
        when(transferenciaRepository.findAll()).thenReturn(transferencias);

        List<Transferencia> foundTransferencias = transferenciaService.findAll();

        assertEquals(transferencias, foundTransferencias);
        verify(transferenciaRepository, times(1)).findAll();
    }

    @Test
    void testDeleteTransferenciaById() {
        long id = 1L;
        doNothing().when(transferenciaRepository).deleteById(id);

        transferenciaService.deleteById(id);

        verify(transferenciaRepository, times(1)).deleteById(id);
    }

    @Test
    void testGetAllTransferencias() {
        List<Transferencia> transferencias = Arrays.asList(transferencia, initTransferencia());
        when(transferenciaRepository.findAll()).thenReturn(transferencias);

        List<Transferencia> foundTransferencias = transferenciaService.findAll();

        assertEquals(transferencias, foundTransferencias);
        verify(transferenciaRepository, times(1)).findAll();
    }
}