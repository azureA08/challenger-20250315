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
import sooft.backend.domain.model.ApiTransaccionDetalle;
import sooft.backend.infrastructure.adapters.apitransacciondetalle.ApiTransaccionDetalleJpaRepository;
import sooft.backend.infrastructure.delivery.rest.ApiTransferenciaDetalleController;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ApiTransaccionDetalleControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ApiTransaccionDetalleJpaRepository apiTransaccionDetalleRepository;

    @InjectMocks
    private ApiTransferenciaDetalleController apiTransaccionDetalleController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(apiTransaccionDetalleController).build();
    }

    @Test
    public void testGetAllDetalles() throws Exception {
        // 1. Crear datos de prueba (objetos ApiTransaccionDetalle)
        ApiTransaccionDetalle detalle1 = new ApiTransaccionDetalle();
        detalle1.setCuit("30-12345678-9");
        detalle1.setRazonSocial("Empresa Ejemplo 1");
        detalle1.setFechaAdhesion(20241007);
        detalle1.setImporte(BigDecimal.valueOf(1000.0));
        detalle1.setCuentaDebito("123456789");
        detalle1.setCuentaCredito("987654321");
        detalle1.setFechaTransaccion(20241020);

        ApiTransaccionDetalle detalle2 = new ApiTransaccionDetalle();
        detalle2.setCuit("30-98765432-1");
        detalle2.setRazonSocial("Empresa Ejemplo 2");
        detalle2.setFechaAdhesion(20241020);
        detalle2.setImporte(BigDecimal.valueOf(2000.0));
        detalle2.setCuentaDebito("111111111");
        detalle2.setCuentaCredito("222222222");
        detalle2.setFechaTransaccion(20241020);

        List<ApiTransaccionDetalle> detalles = Arrays.asList(detalle1, detalle2);

        // 2. Configurar el comportamiento del mock del repositorio
        when(apiTransaccionDetalleRepository.findAll()).thenReturn(detalles);

        // 3. Realizar la solicitud GET simulada al endpoint /detalles
        mockMvc.perform(get("/detalles"))
                // 4. Verificar el código de estado HTTP (200 OK)
                .andExpect(status().isOk())
                // 5. Verificar el contenido JSON de la respuesta
                .andExpect(jsonPath("$[0].cuit").value("30-12345678-9"))
                .andExpect(jsonPath("$[1].cuit").value("30-98765432-1"));
    }

    @Test
    public void testCreateDetalle() throws Exception {
        // 1. Crear un objeto ApiTransaccionDetalle para la solicitud POST
        ApiTransaccionDetalle detalle = new ApiTransaccionDetalle();
        detalle.setCuit("30-12345678-9");
        detalle.setRazonSocial("Empresa Ejemplo");
        detalle.setFechaAdhesion(20241029);
        detalle.setImporte(BigDecimal.valueOf(1000.0));
        detalle.setCuentaDebito("123456789");
        detalle.setCuentaCredito("987654321");
        detalle.setFechaTransaccion(20241029);

        // 2. Configurar el comportamiento del mock del repositorio
        when(apiTransaccionDetalleRepository.save(any(ApiTransaccionDetalle.class))).thenReturn(detalle);

        // 3. Realizar la solicitud POST simulada al endpoint /detalles
        mockMvc.perform(post("/detalles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(detalle)))
                // 4. Verificar el código de estado HTTP (200 OK)
                .andExpect(status().isOk())
                // 5. Verificar el contenido JSON de la respuesta
                .andExpect(jsonPath("$.cuit").value("30-12345678-9"));
    }
}