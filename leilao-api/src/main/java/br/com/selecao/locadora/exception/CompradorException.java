package br.com.selecao.locadora.exception;

public class CompradorException extends RuntimeException {

  public CompradorException(String mensagem) {
    super(mensagem);
  }

  public CompradorException() {
    super();
  }
}
