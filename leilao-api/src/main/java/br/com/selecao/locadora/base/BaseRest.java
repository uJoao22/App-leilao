package br.com.selecao.locadora.base;

import br.com.selecao.locadora.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseRest<E, T> {
  @Autowired
  protected Message msg;

  @Autowired
  protected ResponseUtil<E> responseUtil;

  public abstract ResponseRest create(E item);

  public abstract ResponseRest read(T id);

  public abstract ResponseRest update(T id, E item);

  public abstract ResponseRest delete(T id);

  public abstract ResponseRest list();
}
