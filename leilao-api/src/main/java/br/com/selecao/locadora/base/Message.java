package br.com.selecao.locadora.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Message {
  private List<Alert> itens;

  @JsonIgnore
  private Object targetSource;

  public Message() {
  }

  @PostConstruct
  public void created() {
    itens = new ArrayList<Alert>(1);
  }

  public void warning(final String v) {
    itens.add(Alert.warning(v));
  }

  public void error(final String v) {
    itens.add(Alert.error(v));
  }

  public void success(final String v) {
    itens.add(Alert.success(v));
  }

  public void info(String v) {
    itens.add(Alert.info(v));
  }

  public List<Alert> getList() {
    return itens;
  }

  public void setList(List<Alert> itensList) {
    itens = itensList;
  }

  public void clear() {
    itens.clear();
  }
}
