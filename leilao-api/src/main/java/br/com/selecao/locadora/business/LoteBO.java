package br.com.selecao.locadora.business;

import br.com.selecao.locadora.base.BaseBO;
import br.com.selecao.locadora.entity.Lote;
import br.com.selecao.locadora.exception.LoteException;
import br.com.selecao.locadora.repository.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoteBO extends BaseBO<Lote, Long> {

  @Autowired
  private LoteRepository repository;

  @Override
  public Lote create(Lote item) {
    return repository.save(item);
  }

  @Override
  public Lote read(Long id) {
    return repository.findById(id).orElse(null);
  }

  @Override
  public Lote update(Long id, Lote item) {
    return repository.saveAndFlush(item);
  }

  @Override
  public void delete(Long id) {
    Lote item = read(id);

    if (item == null)
      throw new LoteException("Lote não encontrado");

    repository.deleteById(id);
  }

  @Override
  public List<Lote> list() {
    return repository.findAll();
  }
}
