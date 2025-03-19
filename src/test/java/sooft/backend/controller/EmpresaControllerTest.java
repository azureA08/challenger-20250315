package sooft.backend.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import sooft.backend.business.casouso.empresa.EmpresaService;
import sooft.backend.domain.model.Empresa;
import sooft.backend.infrastructure.delivery.rest.EmpresaController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmpresaControllerTest {

    @Mock
    private EmpresaService empresaService;

    @InjectMocks
    private EmpresaController empresaController;

    private Empresa empresa;

    @BeforeEach
    void setUp() {
        empresa = new Empresa();
        empresa.setId(1L);
        empresa.setRazonSocial("Empresa Ejemplo");
        // Configura otros atributos de la empresa según sea necesario
    }

    @Test
    void testSaveEmpresa() {
        when(empresaService.save(any(Empresa.class))).thenReturn(empresa);

        ResponseEntity<Empresa> response = empresaController.saveempresa(empresa);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(empresa, response.getBody());
        verify(empresaService, times(1)).save(any(Empresa.class));
    }

    @Test
    void testGetEmpresaById() {
        when(empresaService.findById(1L)).thenReturn(Optional.of(empresa));

        ResponseEntity<Empresa> response = empresaController.getempresa(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(empresa, response.getBody());
        verify(empresaService, times(1)).findById(1L);
    }

    @Test
    void testGetEmpresaById_NotFound() {
        when(empresaService.findById(1L)).thenReturn(Optional.empty());

        ResponseEntity<Empresa> response = empresaController.getempresa(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNull(response.getBody());
        verify(empresaService, times(1)).findById(1L);
    }

    @Test
    void testGetAllEmpresas() {
        List<Empresa> empresas = Arrays.asList(empresa, new Empresa());
        when(empresaService.findAll()).thenReturn(empresas);

        List<Empresa> response = empresaController.getempresas();

        assertEquals(empresas, response);
        verify(empresaService, times(1)).findAll();
    }

    @Test
    void testDeleteEmpresaById() {
        when(empresaService.findById(1L)).thenReturn(Optional.of(empresa));

        ResponseEntity<Empresa> response = empresaController.deleteempresa(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(empresa, response.getBody());
        verify(empresaService, times(1)).deleteById(1L);
    }

    @Test
    void testFindEmpresasConTransferenciasUltimoMes() {
        List<Empresa> empresas = Arrays.asList(empresa);
        when(empresaService.findEmpresasConTransferenciasUltimoMes()).thenReturn(empresas);

        List<Empresa> response = empresaController.findEmpresasConTransferenciasUltimoMes();

        assertEquals(empresas, response);
        verify(empresaService, times(1)).findEmpresasConTransferenciasUltimoMes();
    }

    @Test
    void testObtenerEmpresasAdheridasUltimoMes() {
        List<Empresa> empresas = Arrays.asList(empresa);
        when(empresaService.obtenerEmpresasAdheridasUltimoMes()).thenReturn(empresas);

        List<Empresa> response = empresaController.obtenerEmpresasAdheridasUltimoMes();

        assertEquals(empresas, response);
        verify(empresaService, times(1)).obtenerEmpresasAdheridasUltimoMes();
    }

    @Test
    void testAdherirEmpresa() {
        when(empresaService.adherirEmpresa(any(Empresa.class))).thenReturn(empresa);

        ResponseEntity<Empresa> response = empresaController.adherirEmpresa(empresa);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(empresa, response.getBody());
        verify(empresaService, times(1)).adherirEmpresa(any(Empresa.class));
    }
}