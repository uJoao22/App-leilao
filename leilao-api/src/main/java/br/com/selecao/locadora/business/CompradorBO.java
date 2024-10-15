package br.com.selecao.locadora.business;

import br.com.selecao.locadora.base.BaseBO;
import br.com.selecao.locadora.entity.Comprador;
import br.com.selecao.locadora.entity.Lote;
import br.com.selecao.locadora.exception.CompradorException;
import br.com.selecao.locadora.exception.LoteException;
import br.com.selecao.locadora.repository.CompradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompradorBO extends BaseBO<Comprador, Comprador.CompradorId> {

  @Autowired
  private CompradorRepository repository;


  @Override
  public Comprador create(Comprador item) {
    return repository.save(item);
  }

  @Override
  public Comprador read(Comprador.CompradorId id) {
    return repository.findById(id).orElse(null);
  }

  @Override
  public Comprador update(Comprador.CompradorId id, Comprador item) {
    return repository.saveAndFlush(item);
  }

  @Override
  public void delete(Comprador.CompradorId id) {
    Comprador item = read(id);

    if (item == null)
      throw new CompradorException("Comprador não encontrado");

    repository.deleteById(id);
  }

  @Override
  public List<Comprador> list() {
    return repository.findAll();
  }
}
