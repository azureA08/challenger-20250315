package backend.service;


import com.backend.business.casouso.empresa.EmpresaServiceImpl;
import com.backend.domain.model.Empresa;
import com.backend.infrastructure.repositories.EmpresaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmpresaServiceTest {

    @Mock
    private EmpresaRepository empresaRepository;

    @InjectMocks
    private EmpresaServiceImpl empresaService;

    private Empresa empresa;

    @BeforeEach
    void setUp() {
        empresa = initEmpresa();
    }

    @Test
    void testSaveEmpresa() {
        when(empresaRepository.save(any(Empresa.class))).thenReturn(empresa);

        Empresa savedEmpresa = empresaService.save(empresa);

        assertEquals(empresa, savedEmpresa);
        verify(empresaRepository, times(1)).save(empresa);
    }

    @Test
    void testFindEmpresaById_ExistingId() {
        long id = 1L;
        when(empresaRepository.findById(id)).thenReturn(Optional.of(empresa));

        Optional<Empresa> foundEmpresa = empresaService.findById(id);

        assertTrue(foundEmpresa.isPresent());
        assertEquals(empresa, foundEmpresa.get());
        verify(empresaRepository, times(1)).findById(id);
    }

    @Test
    void testFindEmpresaById_NonExistingId() {
        long id = 2L;
        when(empresaRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Empresa> foundEmpresa = empresaService.findById(id);

        assertFalse(foundEmpresa.isPresent());
        verify(empresaRepository, times(1)).findById(id);
    }

    @Test
    void testFindAllEmpresas() {
        List<Empresa> empresas = Arrays.asList(empresa, initEmpresa());
        when(empresaRepository.findAll()).thenReturn(empresas);

        List<Empresa> foundEmpresas = empresaService.findAll();

        assertEquals(empresas, foundEmpresas);
        verify(empresaRepository, times(1)).findAll();
    }

    @Test
    void testDeleteEmpresaById() {
        long id = 1L;
        doNothing().when(empresaRepository).deleteById(id);

        empresaService.deleteById(id);

        verify(empresaRepository, times(1)).deleteById(id);
    }

    @Test
    void testFindEmpresasConTransferenciasUltimoMes() {
        List<Empresa> empresas = Arrays.asList(empresa);
        when(empresaRepository.findEmpresasConTransferenciasUltimoMes()).thenReturn(empresas);

        List<Empresa> foundEmpresas = empresaService.findEmpresasConTransferenciasUltimoMes();

        assertEquals(empresas, foundEmpresas);
        verify(empresaRepository, times(1)).findEmpresasConTransferenciasUltimoMes();
    }

    @Test
    void testAdherirEmpresa() {

        empresa.setId(Long.valueOf(1L));
        when(empresaRepository.save(any(Empresa.class))).thenReturn(empresa);

        Empresa adheridaEmpresa = empresaService.adherirEmpresa(empresa);

        assertEquals(empresa, adheridaEmpresa);
        verify(empresaRepository, times(1)).save(empresa);
    }

    /***
     *
     * @return dato Empresa
     */
    private Empresa initEmpresa() {
        Empresa empresa = new Empresa();
        empresa.setCuit("30-12345678-9");
        empresa.setRazonSocial("Nueva Empresa");
        empresa.setFechaAdhesion(LocalDate.now());
        return empresa;
    }
}