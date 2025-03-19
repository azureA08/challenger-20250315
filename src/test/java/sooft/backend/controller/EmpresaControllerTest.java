package sooft.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sooft.backend.business.casouso.empresa.EmpresaService;
import sooft.backend.domain.model.Empresa;
import sooft.backend.infrastructure.delivery.rest.EmpresaController;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
        mockMvc = MockMvcBuilders.standaloneSetup(empresaController).build();
        objectMapper = new ObjectMapper();
        empresa = initEmpresa() ;
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
    void testObtenerTransferenciaPorId_ExistingId() throws Exception {
        when(empresaService.findById(1L)).thenReturn(Optional.of(empresa));

        mockMvc.perform(get("/api/empresa/1"))
                .andExpect(status().isOk());

        verify(empresaService, times(1)).findById(1L);
    }

    @Test
    void testObtenerTransferenciaPorId_NonExistingId() throws Exception {
        when(empresaService.findById(2L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/empresa/2"))
                .andExpect(status().isNotFound());

        verify(empresaService, times(1)).findById(2L);
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