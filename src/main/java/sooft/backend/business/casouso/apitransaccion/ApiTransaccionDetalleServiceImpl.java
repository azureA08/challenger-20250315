package sooft.backend.business.casouso.apitransaccion;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sooft.backend.domain.model.ApiTransaccionDetalle;
import sooft.backend.infrastructure.adapters.apitransacciondetalle.ApiTransaccionDetalleJpaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ApiTransaccionDetalleServiceImpl implements ApiTransaccionDetalleService {


    @Autowired
    private ApiTransaccionDetalleJpaRepository apiTransaccionDetalleRepository;

    @Override
    public List<ApiTransaccionDetalle> findAll() {
        return apiTransaccionDetalleRepository.findAll();
    }


    @Override
    public Optional<ApiTransaccionDetalle> findById(Long id) {
        return apiTransaccionDetalleRepository.findById(id);
    }


    @Override
    public ApiTransaccionDetalle save(ApiTransaccionDetalle ApiTransaccionDetalle) {
        return apiTransaccionDetalleRepository.save(ApiTransaccionDetalle);
    }

    @Override
    public void deleteById(Long id) {
        apiTransaccionDetalleRepository.deleteById(id);
    }


}