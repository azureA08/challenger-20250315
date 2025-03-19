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
import sooft.backend.business.casouso.transferencia.TransferenciaService;
import sooft.backend.domain.model.Transferencia;
import sooft.backend.infrastructure.delivery.rest.TransferenciaController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
        openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(transferenciaController).build();
        objectMapper = new ObjectMapper();
        transferencia = initTransferencia();
        transferencia.setId(1L);
    }

    @Test
    void dado_datosDeTransferencia_cuando_seCreaTransferencia_entonces_deberiaRetornarCreado() throws Exception {
        when(transferenciaService.save(any(Transferencia.class))).thenReturn(transferencia);

        mockMvc.perform(post("/api/transferencia")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(transferencia)))
                .andExpect(status().isCreated());

        verify(transferenciaService, times(1)).save(any(Transferencia.class));
    }

    @Test
    void dado_unIdExistente_cuando_seObtieneTransferenciaPorId_entonces_deberiaRetornarOk() throws Exception {
        when(transferenciaService.findById(1L)).thenReturn(Optional.of(transferencia));

        mockMvc.perform(get("/api/transferencia/1"))
                .andExpect(status().isOk());

        verify(transferenciaService, times(1)).findById(1L);
    }

    @Test
    void dado_unIdNoExistente_cuando_seObtieneTransferenciaPorId_entonces_deberiaRetornarNotFound() throws Exception {
        when(transferenciaService.findById(2L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/transferencia/2"))
                .andExpect(status().isNotFound());

        verify(transferenciaService, times(1)).findById(2L);
    }

    @Test
    void dado_unIdExistente_cuando_seEliminaTransferenciaPorId_entonces_deberiaRetornarNoContent() throws Exception {
        when(transferenciaService.findById(1L)).thenReturn(Optional.of(transferencia));
        doNothing().when(transferenciaService).deleteById(1L);

        mockMvc.perform(delete("/api/transferencia/1"))
                .andExpect(status().isNoContent());

        verify(transferenciaService, times(1)).deleteById(1L);
    }

    @Test
    void dado_unIdNoExistente_cuando_seEliminaTransferenciaPorId_entonces_deberiaRetornarNotFound() throws Exception {
        when(transferenciaService.findById(2L)).thenReturn(Optional.empty());

        mockMvc.perform(delete("/api/transferencia/2"))
                .andExpect(status().isNotFound());

        verify(transferenciaService, times(1)).findById(2L);
    }

    @Test
    void dado_transferenciasExistentes_cuando_seObtienenTodasLasTransferencias_entonces_deberiaRetornarOkYListaDeTransferencias() throws Exception {
        List<Transferencia> transferencias = Arrays.asList(transferencia, initTransferencia());
        when(transferenciaService.findAll()).thenReturn(transferencias);

        mockMvc.perform(get("/api/transferencia"))
                .andExpect(status().isOk());

        verify(transferenciaService, times(1)).findAll();
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