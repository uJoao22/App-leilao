package br.com.selecao.locadora.util;

import br.com.selecao.locadora.base.BodyResponse;
import br.com.selecao.locadora.base.Message;
import br.com.selecao.locadora.base.ResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResponseUtil<E> {
  @Autowired
  private Message msg;

  public ResponseRest buildError(String message) {
    msg.error(message);
    return build(null, HttpStatus.BAD_REQUEST);
  }

  public ResponseRest buildError500(E item) {
    return ResponseRest.build(new ResponseEntity<>(item, HttpStatus.INTERNAL_SERVER_ERROR));
  }

  public ResponseRest buildSuccess(List<E> item) {
    return build(item, HttpStatus.OK);
  }

  public ResponseRest buildSuccess(E item) {
    return build(item, HttpStatus.OK);
  }

  public ResponseRest buildSuccess(String message) {
    msg.success(message);
    return build(null, HttpStatus.OK);
  }

  public ResponseRest buildSuccess(Object item, String message) {
    msg.success(message);
    return build(item, HttpStatus.OK);
  }

  public ResponseRest buildNotFound() {
    return ResponseRest.build(ResponseEntity.notFound().build());
  }

  private ResponseRest build(Object item, HttpStatus status) {
    return ResponseRest.build(new ResponseEntity<>(new BodyResponse(item, msg), status));
  }
}
