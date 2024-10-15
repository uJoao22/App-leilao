package br.com.selecao.locadora.infra;

import br.com.selecao.locadora.base.BodyResponse;
import br.com.selecao.locadora.base.Message;
import br.com.selecao.locadora.base.ResponseRest;
import br.com.selecao.locadora.util.ResponseUtil;
import br.com.selecao.locadora.base.TypeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenericExceptionHandler {
  private static final String EXCEPTION_INTERNA = "br.com.selecao.locadora.exception";

  @Autowired
  private Message msg;

  @Autowired
  private ResponseUtil<Object> responseUtil;

  @ExceptionHandler(Exception.class)
  public ResponseRest handleErro500(Exception ex) {
    boolean isExctApp = isExceptionApplication(ex);

    msg.error(isExctApp ? ex.getLocalizedMessage() : TypeMessage.erroInterno);
    BodyResponse body = isExctApp ? new BodyResponse(msg) : BodyResponse.buildError(ex.getLocalizedMessage(), msg);

    return responseUtil.buildError500(body);
  }

  private boolean isExceptionApplication(Throwable ex) {
    return ex.getClass().getCanonicalName().contains(EXCEPTION_INTERNA);
  }
}
