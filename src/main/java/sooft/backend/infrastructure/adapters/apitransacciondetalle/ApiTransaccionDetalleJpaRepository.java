package sooft.backend.infrastructure.adapters.apitransacciondetalle;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sooft.backend.domain.model.ApiTransaccionDetalle;

@Repository
public interface ApiTransaccionDetalleJpaRepository extends JpaRepository<ApiTransaccionDetalle, Long> {
}