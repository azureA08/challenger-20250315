package sooft.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sooft.backend.business.casouso.empresa.EmpresaService;
import sooft.backend.domain.model.Empresa;
import sooft.backend.infrastructure.delivery.rest.EmpresaController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class EmpresaControllerTest {

    @Mock
    private EmpresaService empresaService;

    @InjectMocks
    private EmpresaController empresaController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private Empresa empresa;

    @BeforeEach
    void setUp() {
        openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(empresaController).build();
        objectMapper = new ObjectMapper();
        empresa = initEmpresa();
        empresa.setId(1L);
    }

    @Test
    void dado_unaNuevaEmpresa_cuando_seCreaLaEmpresa_entonces_deberiaRetornarCreado() throws Exception {
        // Arrange (Dado)
        when(empresaService.save(any(Empresa.class))).thenReturn(empresa);

        // Act (Cuando)
        mockMvc.perform(post("/api/empresa")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(empresa)))
                .andExpect(status().isCreated());

        // Assert (Entonces)
        verify(empresaService, times(1)).save(any(Empresa.class));
    }

    @Test
    void dado_unIdExistente_cuando_seObtieneLaEmpresaPorId_entonces_deberiaRetornarOk() throws Exception {
        // Arrange (Dado)
        when(empresaService.findById(1L)).thenReturn(Optional.of(empresa));

        // Act (Cuando)
        mockMvc.perform(get("/api/empresa/1"))
                .andExpect(status().isOk());

        // Assert (Entonces)
        verify(empresaService, times(1)).findById(1L);
    }

    @Test
    void dado_unIdNoExistente_cuando_seObtieneLaEmpresaPorId_entonces_deberiaRetornarNotFound() throws Exception {
        // Arrange (Dado)
        when(empresaService.findById(2L)).thenReturn(Optional.empty());

        // Act (Cuando)
        mockMvc.perform(get("/api/empresa/2"))
                .andExpect(status().isNotFound());

        // Assert (Entonces)
        verify(empresaService, times(1)).findById(2L);
    }

    @Test
    void dado_unIdExistente_cuando_seEliminaLaEmpresa_entonces_deberiaRetornarNoContent() throws Exception {
        // Arrange (Dado)
        when(empresaService.findById(1L)).thenReturn(Optional.of(empresa));
        doNothing().when(empresaService).deleteById(1L);

        // Act (Cuando)
        mockMvc.perform(delete("/api/empresa/1"))
                .andExpect(status().isNoContent());

        // Assert (Entonces)
        verify(empresaService, times(1)).deleteById(1L);
    }

    @Test
    void dado_unIdNoExistente_cuando_seEliminaLaEmpresa_entonces_deberiaRetornarNotFound() throws Exception {
        // Arrange (Dado)
        when(empresaService.findById(2L)).thenReturn(Optional.empty());

        // Act (Cuando)
        mockMvc.perform(delete("/api/empresa/2"))
                .andExpect(status().isNotFound());

        // Assert (Entonces)
        verify(empresaService, times(1)).findById(2L);
    }

    @Test
    void dado_empresasExistentes_cuando_seObtienenTodasLasEmpresas_entonces_deberiaRetornarOkYListaDeEmpresas() throws Exception {
        // Arrange (Dado)
        List<Empresa> empresas = Arrays.asList(empresa, initEmpresa());
        when(empresaService.findAll()).thenReturn(empresas);

        // Act (Cuando)
        mockMvc.perform(get("/api/empresa"))
                .andExpect(status().isOk());

        // Assert (Entonces)
        verify(empresaService, times(1)).findAll();
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