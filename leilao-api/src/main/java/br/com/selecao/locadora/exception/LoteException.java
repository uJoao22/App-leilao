package br.com.selecao.locadora.exception;

public class LoteException extends RuntimeException {

  public LoteException(String mensagem) {
    super(mensagem);
  }

  public LoteException() {
    super();
  }
}
