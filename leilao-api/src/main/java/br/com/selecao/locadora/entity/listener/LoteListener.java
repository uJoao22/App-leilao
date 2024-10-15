package br.com.selecao.locadora.entity.listener;

import br.com.selecao.locadora.entity.Lote;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Calendar;

public class LoteListener {
  @PrePersist
  public void prePersist(Lote item) {
    item.setCreatedAt(Calendar.getInstance().getTime());
    item.setUpdatedAt(Calendar.getInstance().getTime());
  }

  @PreUpdate
  public void preUpdate(Lote item) {
    item.setUpdatedAt(Calendar.getInstance().getTime());
  }
}
