package br.com.selecao.locadora.service;

import br.com.selecao.locadora.base.BaseRest;
import br.com.selecao.locadora.base.ResponseRest;
import br.com.selecao.locadora.base.TypeMessage;
import br.com.selecao.locadora.business.CompradorBO;
import br.com.selecao.locadora.entity.Comprador;
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
@RequestMapping(value = "/compradores")
public class CompradorService extends BaseRest<Comprador, Comprador.CompradorId> {

  @Autowired
  private CompradorBO compradorBO;

  @Override
  @PostMapping
  public ResponseRest create(@RequestBody Comprador item) {
    try {
      return responseUtil.buildSuccess(compradorBO.create(item), TypeMessage.criadoSucesso);
    } catch(UnidadeException e) {
      return responseUtil.buildError(TypeMessage.criadoFalha);
    }
  }

  @Override
  @GetMapping("/{id}")
  public ResponseRest read(@PathVariable Comprador.CompradorId id) {
    return responseUtil.buildSuccess(compradorBO.read(id));
  }

  @Override
  @PutMapping("/{id}")
  public ResponseRest update(@PathVariable Comprador.CompradorId id, @RequestBody Comprador item) {
    try {
      return responseUtil.buildSuccess(compradorBO.update(id, item), TypeMessage.atualizadoSucesso);
    } catch(UnidadeException e) {
      return responseUtil.buildError(TypeMessage.atualizadoFalha);
    }
  }

  @Override
  @DeleteMapping("/{id}")
  public ResponseRest delete(@PathVariable Comprador.CompradorId id) {
    try {
      compradorBO.delete(id);
      return responseUtil.buildSuccess(TypeMessage.excluidoSucesso);
    } catch(UnidadeException e) {
      return responseUtil.buildError(TypeMessage.excluidoFalha);
    }
  }

  @Override
  @GetMapping
  public ResponseRest list() {
    return responseUtil.buildSuccess(compradorBO.list());
  }
}
