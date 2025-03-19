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
import sooft.backend.business.casouso.transferencia.TransferenciaService;
import sooft.backend.domain.model.Transferencia;
import sooft.backend.infrastructure.delivery.rest.TransferenciaController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class TransferenciaControllerTest {

    @Mock
    private TransferenciaService transferenciaService;

    @InjectMocks
    private TransferenciaController transferenciaController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private Transferencia transferencia;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(transferenciaController).build();
        objectMapper = new ObjectMapper();
        transferencia =initTransferencia();
        transferencia.setId(1L);
    }

    @Test
    void testCrearTransferencia() throws Exception {
        when(transferenciaService.save(any(Transferencia.class))).thenReturn(transferencia);

        mockMvc.perform(post("/api/transferencia")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(transferencia)))
                .andExpect(status().isCreated());

        verify(transferenciaService, times(1)).save(any(Transferencia.class));
    }

    @Test
    void testObtenerTransferenciaPorId_ExistingId() throws Exception {
        when(transferenciaService.findById(1L)).thenReturn(Optional.of(transferencia));

        mockMvc.perform(get("/api/transferencia/1"))
                .andExpect(status().isOk());

        verify(transferenciaService, times(1)).findById(1L);
    }

    @Test
    void testObtenerTransferenciaPorId_NonExistingId() throws Exception {
        when(transferenciaService.findById(2L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/transferencia/2"))
                .andExpect(status().isNotFound());

        verify(transferenciaService, times(1)).findById(2L);
    }

    /***
     *
     * @return dato Trnasferencia
     */
    private static Transferencia initTransferencia() {

        Transferencia transferencia = new Transferencia();

        transferencia.setImporte(BigDecimal.valueOf(200.00));
        transferencia.setIdEmpresa("30-12345678-9");
        transferencia.setCuentaDebito("CuentaD");
        transferencia.setCuentaCredito("CuentaC");
        transferencia.setFechaTransaccion( LocalDate.now());

        return transferencia;
    }
}