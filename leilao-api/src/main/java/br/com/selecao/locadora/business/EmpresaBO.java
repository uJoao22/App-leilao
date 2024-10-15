package br.com.selecao.locadora.business;

import br.com.selecao.locadora.base.BaseBO;
import br.com.selecao.locadora.entity.Empresa;
import br.com.selecao.locadora.exception.EmpresaException;
import br.com.selecao.locadora.exception.LeilaoException;
import br.com.selecao.locadora.repository.EmpresaRepository;
import br.com.selecao.locadora.repository.LeilaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaBO extends BaseBO<Empresa, Long> {

  @Autowired
  private EmpresaRepository repository;


  @Override
  public Empresa create(Empresa item) {
    return repository.save(item);
  }

  @Override
  public Empresa read(Long id) {
    return repository.findById(id).orElse(null);
  }

  @Override
  public Empresa update(Long id, Empresa item) {
    return repository.saveAndFlush(item);
  }

  @Override
  public void delete(Long id) {
    Empresa item = read(id);

    if (item == null)
      throw new EmpresaException("Empresa não encontrada");

    repository.deleteById(id);
  }

  @Override
  public List<Empresa> list() {
    return repository.findAll();
  }
}
