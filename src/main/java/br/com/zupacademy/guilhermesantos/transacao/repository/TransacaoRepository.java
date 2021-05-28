package br.com.zupacademy.guilhermesantos.transacao.repository;

import br.com.zupacademy.guilhermesantos.transacao.model.ModelTransacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<ModelTransacao, String> {

}
