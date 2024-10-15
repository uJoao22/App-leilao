package br.com.selecao.locadora.repository;

import br.com.selecao.locadora.entity.Comprador;
import br.com.selecao.locadora.entity.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompradorRepository extends JpaRepository<Comprador, Comprador.CompradorId> {
}
