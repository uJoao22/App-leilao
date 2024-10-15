package br.com.selecao.locadora.service;

import br.com.selecao.locadora.base.BaseRest;
import br.com.selecao.locadora.base.ResponseRest;
import br.com.selecao.locadora.base.TypeMessage;
import br.com.selecao.locadora.business.EmpresaBO;
import br.com.selecao.locadora.entity.Empresa;
import br.com.selecao.locadora.exception.EmpresaException;
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
@RequestMapping(value = "/empresas")
public class EmpresaService extends BaseRest<Empresa, Long> {

  @Autowired
  private EmpresaBO empresaBO;

  @Override
  @PostMapping
  public ResponseRest create(@RequestBody Empresa item) {
    try {
      return responseUtil.buildSuccess(empresaBO.create(item), TypeMessage.criadoSucesso);
    } catch(EmpresaException e) {
      return responseUtil.buildError(TypeMessage.criadoFalha);
    }
  }

  @Override
  @GetMapping("/{id}")
  public ResponseRest read(@PathVariable Long id) {
    return responseUtil.buildSuccess(empresaBO.read(id));
  }

  @Override
  @PutMapping("/{id}")
  public ResponseRest update(@PathVariable Long id, @RequestBody Empresa item) {
    try {
      return responseUtil.buildSuccess(empresaBO.update(id, item), TypeMessage.atualizadoSucesso);
    } catch(EmpresaException e) {
      return responseUtil.buildError(TypeMessage.atualizadoFalha);
    }
  }

  @Override
  @DeleteMapping("/{id}")
  public ResponseRest delete(@PathVariable Long id) {
    try {
      empresaBO.delete(id);
      return responseUtil.buildSuccess(TypeMessage.excluidoSucesso);
    } catch(EmpresaException e) {
      return responseUtil.buildError(TypeMessage.excluidoFalha);
    }
  }

  @Override
  @GetMapping
  public ResponseRest list() {
    return responseUtil.buildSuccess(empresaBO.list());
  }
}
