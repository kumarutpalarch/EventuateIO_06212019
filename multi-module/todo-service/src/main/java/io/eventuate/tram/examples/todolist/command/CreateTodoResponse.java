package io.eventuate.tram.examples.todolist.command;


public class CreateTodoResponse {
  private Long policyNumber;

  public CreateTodoResponse() {
  }

  public CreateTodoResponse(Long policyNumber) {
    this.policyNumber = policyNumber;
  }

  public Long getPolicyNumber() {
    return policyNumber;
  }

  public void setPolicyNumber(Long policyNumber) {
    this.policyNumber = policyNumber;
  }
}
