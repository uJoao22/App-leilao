package br.com.selecao.locadora.business;

import br.com.selecao.locadora.base.BaseBO;
import br.com.selecao.locadora.entity.Lote;
import br.com.selecao.locadora.entity.Unidade;
import br.com.selecao.locadora.exception.LoteException;
import br.com.selecao.locadora.exception.UnidadeException;
import br.com.selecao.locadora.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnidadeBO extends BaseBO<Unidade, Long> {

  @Autowired
  private UnidadeRepository repository;

  @Override
  public Unidade create(Unidade item) {
    return repository.save(item);
  }

  @Override
  public Unidade read(Long id) {
    return repository.findById(id).orElse(null);
  }

  @Override
  public Unidade update(Long id, Unidade item) {
    return repository.saveAndFlush(item);
  }

  @Override
  public void delete(Long id) {
    Unidade item = read(id);

    if (item == null)
      throw new UnidadeException("Unidade não encontrada.");

    repository.deleteById(id);
  }

  @Override
  public List<Unidade> list() {
    List<Unidade> list = repository.findAll();

    if (list == null || list.isEmpty())
      return null;

    return list.stream().sorted(Comparator.comparing(Unidade::getNome)).collect(Collectors.toList());
  }
}
