package br.com.zupacademy.guilhermesantos.transacao.repository;

import br.com.zupacademy.guilhermesantos.transacao.model.ModelCartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<ModelCartao, String> {

}
