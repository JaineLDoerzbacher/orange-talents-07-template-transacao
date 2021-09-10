package transacao.transacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import transacao.transacao.entities.Estabelecimento;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {
}
