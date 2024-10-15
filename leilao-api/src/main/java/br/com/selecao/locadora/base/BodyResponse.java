package br.com.selecao.locadora.base;

public class BodyResponse {
  private Object result;
  private Object error;
  private Message messages;

  public BodyResponse() {

  }

  public BodyResponse(Message messages) {
    this.messages = messages;
  }

  public BodyResponse(Object result, Message messages) {
    this.result = result;
    this.messages = messages;
  }

  public static BodyResponse buildError(Object error, Message messages) {
    BodyResponse bodyResponse = new BodyResponse();

    bodyResponse.error = error;
    bodyResponse.messages = messages;

    return bodyResponse;
  }

  public Object getResult() {
    return result;
  }

  public void setResult(Object result) {
    this.result = result;
  }

  public Object getError() {
    return error;
  }

  public void setError(Object error) {
    this.error = error;
  }

  public Message getMessages() {
    return messages;
  }

  public void setMessages(Message messages) {
    this.messages = messages;
  }
}
