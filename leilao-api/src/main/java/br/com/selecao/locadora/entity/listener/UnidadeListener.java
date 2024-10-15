package br.com.selecao.locadora.entity.listener;

import br.com.selecao.locadora.entity.Unidade;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Calendar;

public class UnidadeListener {
  @PrePersist
  public void prePersist(Unidade item) {
    item.setCreatedAt(Calendar.getInstance().getTime());
    item.setUpdatedAt(Calendar.getInstance().getTime());
  }

  @PreUpdate
  public void preUpdate(Unidade item) {
    item.setUpdatedAt(Calendar.getInstance().getTime());
  }
}
