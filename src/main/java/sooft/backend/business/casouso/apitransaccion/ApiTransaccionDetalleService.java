package sooft.backend.business.casouso.apitransaccion;


import sooft.backend.domain.model.ApiTransaccionDetalle;

import java.util.List;
import java.util.Optional;

public interface ApiTransaccionDetalleService {

    List<ApiTransaccionDetalle> findAll();

    ApiTransaccionDetalle save(ApiTransaccionDetalle empresaAlta);

    Optional<ApiTransaccionDetalle> findById(Long id);

    void deleteById(Long id);
}
