package br.com.selecao.locadora.business;

import br.com.selecao.locadora.base.BaseBO;
import br.com.selecao.locadora.entity.Leilao;
import br.com.selecao.locadora.exception.LeilaoException;
import br.com.selecao.locadora.repository.LeilaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeilaoBO extends BaseBO<Leilao, Long> {

  @Autowired
  private LeilaoRepository repository;


  @Override
  public Leilao create(Leilao item) {
    return repository.save(item);
  }

  @Override
  public Leilao read(Long id) {
    return repository.findById(id).orElse(null);
  }

  @Override
  public Leilao update(Long id, Leilao item) {
    return repository.saveAndFlush(item);
  }

  @Override
  public void delete(Long id) {
    Leilao item = read(id);

    if (item == null)
      throw new LeilaoException("Leilão não encontrado");

    repository.deleteById(id);
  }

  @Override
  public List<Leilao> list() {
    return repository.findAll();
  }
}
