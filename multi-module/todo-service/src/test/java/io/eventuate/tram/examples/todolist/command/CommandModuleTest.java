package io.eventuate.tram.examples.todolist.command;


import io.eventuate.tram.examples.todolist.common.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {TodoCommandConfiguration.class})
@EnableAutoConfiguration
@ComponentScan
public class CommandModuleTest {

  @Autowired
  private TodoRepository todoRepository;

  @Autowired
  private TodoCommandService todoCommandService;

  @Test
  public void testCreate() throws ParseException {
    String title = Utils.generateUniqueString();
    
  	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
   		String effDate = sdf.format("18/06/2019"); 
   		String expDate = sdf.format("18/06/2020"); 
   		
   		Date effParsedDate = new Date();
   		Date expParsedDate = new Date();
   		try {
			effParsedDate = sdf.parse(effDate);
			expParsedDate = sdf.parse(expDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		    	    
    /*Long id = todoCommandService.create(new CreateTodoRequest(title, false, 0)).getId();*/
    Long id = todoCommandService.create(new CreateTodoRequest("test", "Auto", effParsedDate, expParsedDate, "creating policy")).getPolicyNumber();
    Todo todo = todoRepository.findOne(id);
    Assert.assertNotNull(todo);
    Assert.assertEquals(title, todo.getPolicyType());
  }

/*  @Test
  public void testUpdate() {
    Todo todo = todoRepository.save(new Todo(Utils.generateUniqueString(), false, 9));
    String title = Utils.generateUniqueString();
    todoCommandService.update(todo.getId(), new UpdateTodoRequest(title, false, 0));
    todo = todoRepository.findOne(todo.getId());
    Assert.assertNotNull(todo);
    Assert.assertEquals(title, todo.getTitle());
  }

  @Test
  public void testDelete() {
    Todo todo = todoRepository.save(new Todo(Utils.generateUniqueString(), false, 9));
    todoCommandService.delete(todo.getId());
    Assert.assertNull(todoRepository.findOne(todo.getId()));
  }*/
}
