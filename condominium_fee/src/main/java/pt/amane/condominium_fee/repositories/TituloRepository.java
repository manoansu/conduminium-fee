package pt.amane.condominium_fee.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.amane.condominium_fee.model.Titulo;

@Repository
public interface TituloRepository extends JpaRepository<Titulo, Long> {
}
