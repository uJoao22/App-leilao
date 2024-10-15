package br.com.selecao.locadora.exception;

public class UnidadeException extends RuntimeException {

  public UnidadeException(String mensagem) {
    super(mensagem);
  }

  public UnidadeException() {
    super();
  }
}
