package br.com.zupacademy.guilhermesantos.transacao.repository;

import br.com.zupacademy.guilhermesantos.transacao.model.ModelEstabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<ModelEstabelecimento, Long> {

}
