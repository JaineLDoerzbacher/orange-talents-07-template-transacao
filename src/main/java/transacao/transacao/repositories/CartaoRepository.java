package transacao.transacao.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import transacao.transacao.entities.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, String> {
}
