package br.com.selecao.locadora.entity.listener;

import br.com.selecao.locadora.entity.Leilao;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Calendar;

public class LeilaoListener {
  @PrePersist
  public void prePersist(Leilao item) {
    item.setCreatedAt(Calendar.getInstance().getTime());
    item.setUpdatedAt(Calendar.getInstance().getTime());
  }

  @PreUpdate
  public void preUpdate(Leilao item) {
    item.setUpdatedAt(Calendar.getInstance().getTime());
  }
}
