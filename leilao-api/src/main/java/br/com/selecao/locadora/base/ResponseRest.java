package br.com.selecao.locadora.base;

import org.springframework.http.ResponseEntity;

public class ResponseRest {
  private ResponseEntity<Object> response;

  public ResponseRest() {

  }

  public static ResponseRest build(ResponseEntity<Object> response) {
    return new ResponseRest(response);
  }

  public ResponseRest(ResponseEntity<Object> response) {
    this.response = response;
  }

  public ResponseEntity<Object> getResponse() {
    return response;
  }

  public void setResponse(ResponseEntity<Object> response) {
    this.response = response;
  }
}
