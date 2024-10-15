package br.com.selecao.locadora.entity.listener;

import br.com.selecao.locadora.entity.Endereco;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Calendar;

public class EnderecoListener {
  @PrePersist
  public void prePersist(Endereco item) {
    item.setCreatedAt(Calendar.getInstance().getTime());
    item.setUpdatedAt(Calendar.getInstance().getTime());
  }

  @PreUpdate
  public void preUpdate(Endereco item) {
    item.setUpdatedAt(Calendar.getInstance().getTime());
  }
}
