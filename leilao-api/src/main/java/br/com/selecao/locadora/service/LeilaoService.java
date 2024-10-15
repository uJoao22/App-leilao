package br.com.selecao.locadora.service;

import br.com.selecao.locadora.base.BaseRest;
import br.com.selecao.locadora.base.ResponseRest;
import br.com.selecao.locadora.base.TypeMessage;
import br.com.selecao.locadora.business.LeilaoBO;
import br.com.selecao.locadora.entity.Leilao;
import br.com.selecao.locadora.exception.LeilaoException;
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
@RequestMapping(value = "/leiloes")
public class LeilaoService extends BaseRest<Leilao, Long> {

  @Autowired
  private LeilaoBO leilaoBO;

  @Override
  @PostMapping
  public ResponseRest create(@RequestBody Leilao item) {
    try {
      return responseUtil.buildSuccess(leilaoBO.create(item), TypeMessage.criadoSucesso);
    } catch(LeilaoException e) {
      return responseUtil.buildError(TypeMessage.criadoFalha);
    }
  }

  @Override
  @GetMapping("/{id}")
  public ResponseRest read(@PathVariable Long id) {
    return responseUtil.buildSuccess(leilaoBO.read(id));
  }

  @Override
  @PutMapping("/{id}")
  public ResponseRest update(@PathVariable Long id, @RequestBody Leilao item) {
    try {
      return responseUtil.buildSuccess(leilaoBO.update(id, item), TypeMessage.atualizadoSucesso);
    } catch(LeilaoException e) {
      return responseUtil.buildError(TypeMessage.atualizadoFalha);
    }
  }

  @Override
  @DeleteMapping("/{id}")
  public ResponseRest delete(@PathVariable Long id) {
    try {
      leilaoBO.delete(id);
      return responseUtil.buildSuccess(TypeMessage.excluidoSucesso);
    } catch(LeilaoException e) {
      return responseUtil.buildError(TypeMessage.excluidoFalha);
    }
  }

  @Override
  @GetMapping
  public ResponseRest list() {
    return responseUtil.buildSuccess(leilaoBO.list());
  }
}
