package sooft.backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sooft.backend.domain.model.Empresa;
import sooft.backend.infrastructure.adapters.empresa.EmpresaJpaRepository;
import sooft.backend.infrastructure.delivery.rest.EmpresaController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EmpresaControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EmpresaJpaRepository empresaRepository;

    @InjectMocks
    private EmpresaController empresaController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(empresaController).build();
    }

    @Test
    public void testGetAllEmpresas() throws Exception {
        Empresa empresa1 = new Empresa();
        empresa1.setCuit("30-12345678-9");
        empresa1.setRazonSocial("Empresa Ejemplo 1");
        empresa1.setFechaAdhesion(LocalDate.of(2023, 10, 27));

        Empresa empresa2 = new Empresa();
        empresa2.setCuit("30-98765432-1");
        empresa2.setRazonSocial("Empresa Ejemplo 2");
        empresa2.setFechaAdhesion(LocalDate.of(2023, 10, 26));

        List<Empresa> empresas = Arrays.asList(empresa1, empresa2);

        when(empresaRepository.findAll()).thenReturn(empresas);

        mockMvc.perform(get("/empresas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].cuit").value("30-12345678-9"))
                .andExpect(jsonPath("$[1].cuit").value("30-98765432-1"));
    }

    @Test
    public void testCreateEmpresa() throws Exception {
        Empresa empresa = new Empresa();
        empresa.setCuit("30-12345678-9");
        empresa.setRazonSocial("Empresa Ejemplo");
        empresa.setFechaAdhesion(LocalDate.of(2023, 10, 27));

        when(empresaRepository.save(any(Empresa.class))).thenReturn(empresa);

        mockMvc.perform(post("/empresas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(empresa)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cuit").value("30-12345678-9"));
    }
}