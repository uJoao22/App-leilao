package br.com.selecao.locadora.base;

import java.util.ArrayList;
import java.util.List;

public class MessageResult {
  private List<Alert> alerts;
  private int errorCode;

  public MessageResult() {
    alerts = new ArrayList<Alert>(1);
  }

  public List<Alert> getAlerts() {
    return alerts;
  }

  public void addAlert(Alert alert) {
    alerts.add(alert);
  }

  public void setAlerts(List<Alert> alerts) {
    this.alerts = alerts;
  }

  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }
}
