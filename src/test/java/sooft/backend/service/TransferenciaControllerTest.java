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
import sooft.backend.domain.model.Transferencia;
import sooft.backend.infrastructure.adapters.transferecia.TransferenciaJpaRepository;
import sooft.backend.infrastructure.delivery.rest.TransferenciaController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TransferenciaControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TransferenciaJpaRepository transferenciaRepository;

    @InjectMocks
    private TransferenciaController transferenciaController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(transferenciaController).build();
    }

    @Test
    public void testGetAllTransferencias() throws Exception {
        Transferencia transferencia1 = new Transferencia();
        transferencia1.setId(1L);
        transferencia1.setImporte(BigDecimal.valueOf(1000.0));
        transferencia1.setIdEmpresa("30-12345678-9");
        transferencia1.setCuentaDebito("123456789");
        transferencia1.setCuentaCredito("987654321");

        Transferencia transferencia2 = new Transferencia();
        transferencia2.setId(2L);
        transferencia2.setImporte(BigDecimal.valueOf(2000.0));
        transferencia2.setIdEmpresa("30-98765432-1");
        transferencia2.setCuentaDebito("111111111");
        transferencia2.setCuentaCredito("222222222");

        List<Transferencia> transferencias = Arrays.asList(transferencia1, transferencia2);

        when(transferenciaRepository.findAll()).thenReturn(transferencias);

        mockMvc.perform(get("/transferencias"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].id").value(2));
    }

    @Test
    public void testCreateTransferencia() throws Exception {
        Transferencia transferencia = new Transferencia();
        transferencia.setId(1L);
        transferencia.setImporte(BigDecimal.valueOf(1000.0));
        transferencia.setIdEmpresa("30-12345678-9");
        transferencia.setCuentaDebito("123456789");
        transferencia.setCuentaCredito("987654321");

        when(transferenciaRepository.save(any(Transferencia.class))).thenReturn(transferencia);

        mockMvc.perform(post("/transferencias")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(transferencia)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }
}