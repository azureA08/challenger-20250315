package sooft.backend.infrastructure.adapters.transferecia;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sooft.backend.domain.model.Transferencia;

@Repository
public interface TransferenciaJpaRepository extends JpaRepository<Transferencia, Long> {
}