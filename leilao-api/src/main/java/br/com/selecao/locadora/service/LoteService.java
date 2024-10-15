package br.com.selecao.locadora.service;

import br.com.selecao.locadora.base.BaseRest;
import br.com.selecao.locadora.base.ResponseRest;
import br.com.selecao.locadora.base.TypeMessage;
import br.com.selecao.locadora.business.LoteBO;
import br.com.selecao.locadora.entity.Lote;
import br.com.selecao.locadora.exception.LoteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lotes")
public class LoteService extends BaseRest<Lote, Long> {

  @Autowired
  private LoteBO loteBO;

  @Override
  @PostMapping
  public ResponseRest create(@RequestBody Lote item) {
    try {
      return responseUtil.buildSuccess(loteBO.create(item), TypeMessage.criadoSucesso);
    } catch(LoteException e) {
      return responseUtil.buildError(TypeMessage.criadoFalha);
    }
  }

  @Override
  @GetMapping("/{id}")
  public ResponseRest read(@PathVariable Long id) {
    return responseUtil.buildSuccess(loteBO.read(id));
  }

  @Override
  @PutMapping("/{id}")
  public ResponseRest update(@PathVariable Long id, @RequestBody Lote item) {
    try {
      return responseUtil.buildSuccess(loteBO.update(id, item), TypeMessage.atualizadoSucesso);
    } catch(LoteException e) {
      return responseUtil.buildError(TypeMessage.atualizadoFalha);
    }
  }

  @Override
  @DeleteMapping("/{id}")
  public ResponseRest delete(@PathVariable Long id) {
    try {
      loteBO.delete(id);
      return responseUtil.buildSuccess(TypeMessage.excluidoSucesso);
    } catch(LoteException e) {
      return responseUtil.buildError(TypeMessage.excluidoFalha);
    }
  }

  @Override
  @GetMapping
  public ResponseRest list() {
    return responseUtil.buildSuccess(loteBO.list());
  }
}
