package br.com.selecao.locadora.base;

import java.util.List;

public abstract class BaseBO<E, T> {
  public abstract E create(E item);

  public abstract E read(T id);

  public abstract E update(T id, E item);

  public abstract void delete(T id);

  public abstract List<E> list();
}