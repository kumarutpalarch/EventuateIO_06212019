package io.eventuate.tram.examples.todolist.command;

import io.eventuate.tram.events.publisher.DomainEventPublisher;
import io.eventuate.tram.examples.todolist.common.TodoCreated;
/*import io.eventuate.tram.examples.todolist.common.TodoDeleted;
import io.eventuate.tram.examples.todolist.common.TodoUpdated;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Collections;

@Service
@Transactional
public class TodoCommandService {

  @Autowired
  private TodoRepository todoRepository;

  @Autowired
  private DomainEventPublisher domainEventPublisher;

  public Todo create(CreateTodoRequest createTodoRequest) throws ParseException {
    /*Todo todo = new Todo(createTodoRequest.getTitle(), createTodoRequest.isCompleted(), createTodoRequest.getOrder());*/
	Todo todo = new Todo(createTodoRequest.getPolicyRequestor(), createTodoRequest.getPolicyType(), createTodoRequest.getPolicyEffectiveDate(), createTodoRequest.getPolicyExpirationDate(), createTodoRequest.getPolicyDetails());
    todo = todoRepository.save(todo);

    domainEventPublisher.publish(Todo.class,
            todo.getPolicyNumber(),
            Collections.singletonList(new TodoCreated(todo.getPolicyRequestor(), todo.getPolicyType(), todo.getPolicyEffectiveDate(), todo.getPolicyExpirationDate(), todo.getPolicyDetails())));

    return todo;
  }

/*  public void update(Long id, UpdateTodoRequest updateTodoRequest) {
    Todo todo = todoRepository.findOne(id);

    if (todo == null) {
      throw new TodoNotFoundException(id);
    }

    todo.setTitle(updateTodoRequest.getTitle());
    todo.setCompleted(updateTodoRequest.isCompleted());
    todo.setExecutionOrder(updateTodoRequest.getOrder());
    todoRepository.save(todo);

    domainEventPublisher.publish(Todo.class,
            id,
            Collections.singletonList(new TodoUpdated(todo.getTitle(), todo.isCompleted(), todo.getExecutionOrder())));
  }

  public void delete(Long id) {
    todoRepository.delete(id);
    domainEventPublisher.publish(Todo.class, id, Collections.singletonList(new TodoDeleted()));
  }*/
}
