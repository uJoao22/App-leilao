package br.com.selecao.locadora.entity.listener;

import br.com.selecao.locadora.entity.Empresa;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Calendar;

public class EmpresaListener {
  @PrePersist
  public void prePersist(Empresa item) {
    item.setCreatedAt(Calendar.getInstance().getTime());
    item.setUpdatedAt(Calendar.getInstance().getTime());
  }

  @PreUpdate
  public void preUpdate(Empresa item) {
    item.setUpdatedAt(Calendar.getInstance().getTime());
  }
}
