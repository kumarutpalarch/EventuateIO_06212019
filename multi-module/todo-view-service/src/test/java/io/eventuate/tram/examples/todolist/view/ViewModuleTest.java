package io.eventuate.tram.examples.todolist.view;

import io.eventuate.tram.examples.todolist.common.Utils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {TodoViewConfiguration.class})
@EnableAutoConfiguration
@ComponentScan
public class ViewModuleTest {

  @Autowired
  private TodoViewService todoViewService;

  @Test
  public void testIndexSearchAndRemove() throws Exception {
    String id = Utils.generateUniqueString();
    //String title = "test";
    String policyDetails = "first policy";
    
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
	
    
    //TodoView todoView = new TodoView(id, title, false, 0);

    TodoView todoView = new TodoView(id, "test", "Auto", effParsedDate, expParsedDate, "creating policy");
    
    todoViewService.index(todoView);
    Thread.sleep(2000); //Elasticsearch by default refreshes each shard every 1s
    List<TodoView> todoViews = todoViewService.search(policyDetails);
    Assert.assertTrue(todoViews.stream().anyMatch(view -> id.equals(view.getPolicyNumber())));

    todoViewService.remove(id);
    Thread.sleep(2000);
    todoViews = todoViewService.search(policyDetails);
    Assert.assertFalse(todoViews.stream().anyMatch(view -> id.equals(view.getPolicyNumber())));
  }
}
