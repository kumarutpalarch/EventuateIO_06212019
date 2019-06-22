package io.eventuate.tram.examples.todolist.common;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Utils {
  public static String generateUniqueString() {
    return UUID.randomUUID().toString();
  }
  
  public static Date getDateWithoutTimeUsingFormat(Date date){
		    SimpleDateFormat formatter = new SimpleDateFormat(
		      "MM/dd/yyyy");
		    Date returnDate = null;
		    
		    try {
		    	returnDate = formatter.parse(formatter.format(date));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return returnDate;
  }

}
