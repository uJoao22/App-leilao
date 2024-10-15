package br.com.selecao.locadora.exception;

public class EmpresaException extends RuntimeException {

  public EmpresaException(String mensagem) {
    super(mensagem);
  }

  public EmpresaException() {
    super();
  }
}
