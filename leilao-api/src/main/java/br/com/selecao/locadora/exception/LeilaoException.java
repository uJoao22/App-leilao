package br.com.selecao.locadora.exception;

public class LeilaoException extends RuntimeException {

  public LeilaoException(String mensagem) {
    super(mensagem);
  }

  public LeilaoException() {
    super();
  }
}
