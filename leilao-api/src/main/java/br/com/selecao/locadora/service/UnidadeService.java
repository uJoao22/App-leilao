package br.com.selecao.locadora.service;

import br.com.selecao.locadora.base.BaseRest;
import br.com.selecao.locadora.base.ResponseRest;
import br.com.selecao.locadora.base.TypeMessage;
import br.com.selecao.locadora.business.UnidadeBO;
import br.com.selecao.locadora.entity.Unidade;
import br.com.selecao.locadora.exception.UnidadeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/unidades")
public class UnidadeService extends BaseRest<Unidade, Long> {

  @Autowired
  private UnidadeBO unidadeBO;

  @Override
  @PostMapping
  public ResponseRest create(@RequestBody Unidade item) {
    try {
      return responseUtil.buildSuccess(unidadeBO.create(item), TypeMessage.criadoSucesso);
    } catch(UnidadeException e) {
      return responseUtil.buildError(TypeMessage.criadoFalha);
    }
  }

  @Override
  @GetMapping("/{id}")
  public ResponseRest read(@PathVariable Long id) {
    return responseUtil.buildSuccess(unidadeBO.read(id));
  }

  @Override
  @PutMapping("/{id}")
  public ResponseRest update(@PathVariable Long id, @RequestBody Unidade item) {
    try {
      return responseUtil.buildSuccess(unidadeBO.update(id, item), TypeMessage.atualizadoSucesso);
    } catch(UnidadeException e) {
      return responseUtil.buildError(TypeMessage.atualizadoFalha);
    }
  }

  @Override
  @DeleteMapping("/{id}")
  public ResponseRest delete(@PathVariable Long id) {
    try {
      unidadeBO.delete(id);
      return responseUtil.buildSuccess(TypeMessage.excluidoSucesso);
    } catch(UnidadeException e) {
      return responseUtil.buildError(TypeMessage.excluidoFalha);
    }
  }

  @Override
  @GetMapping
  public ResponseRest list() {
    return responseUtil.buildSuccess(unidadeBO.list());
  }
}
