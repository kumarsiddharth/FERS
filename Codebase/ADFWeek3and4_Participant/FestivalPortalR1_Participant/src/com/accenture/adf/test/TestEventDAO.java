package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
 import static org.junit.Assert.assertTrue;
 import static org.junit.Assert.fail;

import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.After;
 import org.junit.AfterClass;
 import org.junit.Before;
 import org.junit.BeforeClass;
 import org.junit.Test;

import com.accenture.adf.businesstier.dao.EventDAO;
 import com.accenture.adf.businesstier.entity.Event;
 import com.accenture.adf.businesstier.entity.Visitor;
 import com.accenture.adf.exceptions.FERSGenericException;
import com.accenture.adf.helper.FERSDataConnection;

/**
  * Junit test class for EventDAO class
  *
  */
 public class TestEventDAO {

 private static Connection connection = null;
  private static PreparedStatement statement = null;
  private static ResultSet resultSet = null;
  private ArrayList<Event> showAllEvents;
  private EventDAO dao; 

 /**
   * Sets up database connection before other methods are executed in this class
   * @throws Exception
   */
  
  @BeforeClass
  public static void setUpDatabaseConnection() throws Exception {
   connection = FERSDataConnection.createConnection();
  }

 /**
   * Closes the database connection after all the methods are executed
   * @throws Exception
   */
  @AfterClass
  public static void tearDownDatabaseConnection() throws Exception {
   /**
    * @TODO: Close connection object here
    *   
    */
   connection.close();
  }

 /**
   * Sets up the objects required in other methods
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception {
   showAllEvents = new ArrayList<Event>();
   dao = new EventDAO();
  }

 /**
   * Deallocate the resources after execution of method
   * @throws Exception
   */
  @After
  public void tearDown() throws Exception {
   /**
    * @TODO: Release all the objects here by assigning them null  
    */
   showAllEvents=null;
   dao=null;
  }

 /**
   * Positive test case to test the method showAllEvents
 * @throws SQLException 
 * @throws ClassNotFoundException 
   */
  @Test
  public void testShowAllEvents_Positive() throws ClassNotFoundException, SQLException {
   /**
    * @TODO: Call showAllEvents method and assert it for
    * size of returned type list
    */ 
    
    showAllEvents=dao.showAllEvents();
    int length=showAllEvents.size();
    assert(length>0):"No events";
    System.out.println("showAllEvents Executed");
   
  }
 /**
   * Junit test case to test positive case for updateEventDeletions
   */
  @Test 
  public void testUpdateEventDeletions_Positive() {
   /**
    * @TODO: Find out seats available for an event by opening a connection
    * and calling the query SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = ?
    * Call the updateEventDeletions for eventId
    * Again find out the seats available for this event
    * testSeatsAvailableBefore should be 1 more then testSeatsAvailableAfter
    */ 
   try{
   //connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/festivaldatabase", "root", "abcd123");
	   
   statement=connection.prepareStatement("select seatsavailable from event where eventid=?");
   statement.setInt(1, 1003);
   //statement.execute();
   resultSet=statement.executeQuery();
   resultSet.next();
   int testSeatsAvailableBefore=resultSet.getInt(1);
   
   
   dao.updateEventDeletions(1003);
   
   statement=connection.prepareStatement("select seatsavailable from event where eventid=?");
   statement.setInt(1, 1003);
   resultSet=statement.executeQuery();
   resultSet.next();
   int testSeatsAvailableAfter=resultSet.getInt(1);
   
   assert(testSeatsAvailableBefore>testSeatsAvailableAfter):"Deletion did not take place";
   System.out.println("Successful deletion");
   
   }
   catch(SQLException e){
    e.printStackTrace();
   } catch (ClassNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
  }

 /**
   * Negative test case for method updateEventDeletions
   */
  @Test
  public void testUpdateEventDeletions_Negative() {
   /**
    * @TODO: Call updateEventDeletions for incorrect eventid and it should
    * throw an exception
    */ 
   try{
    dao.updateEventDeletions(9999);
   }
   catch(FERSGenericException e){
    System.out.println("Records not updated properly");
   } catch (ClassNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   } catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
  }

 /**
   * Positive test case for method updateEventNominations
   */
  @Test
  public void testUpdateEventNominations_Positive() {
   /**
    * @TODO: Find out seats available for an event by opening a connection
    * and calling the query SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = ?
    * Call the updateEventNominations for eventId
    * Again find out the seats available for this event
    * testSeatsAvailableBefore should be 1 less then testSeatsAvailableAfter
    */
   try{
    //connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/festivaldatabase", "root", "abcd123");
    statement=connection.prepareStatement("select seatsavailable from event where eventid=?");
    statement.setInt(1, 1003);
    //statement.execute();
    resultSet=statement.executeQuery();
    if(resultSet.next())
    {int testSeatsAvailableBefore=resultSet.getInt(1);
    
    
    dao.updateEventNominations(1003);
    
    statement=connection.prepareStatement("select seatsavailable from event where eventid=?");
    statement.setInt(1, 1003);
    resultSet=statement.executeQuery();
    resultSet.next();
    if(resultSet.next()){
    int testSeatsAvailableAfter=resultSet.getInt(1);
    
    assertEquals(testSeatsAvailableBefore, testSeatsAvailableAfter);
    
    }
    }
    }
    catch(SQLException e){
     e.printStackTrace();
    } catch (ClassNotFoundException e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
    } catch (Exception e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
    }
   
  }

 /**
   * Negative test case for method updateEventNominations
   */
  @Test
  public void testUpdateEventNominations_Negative() {
   /**
    * @TODO: Call updateEventNominations for incorrect eventid and it should
    * throw an exception
    */ 
   try{
    dao.updateEventNominations(9999);
   }
   catch(FERSGenericException e){
    System.out.println("Records not updated properly");
   } catch (ClassNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   } catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
  }

 /**
   * Positive test case for method checkEventsofVisitor
   */
  @Test
  public void testCheckEventsOfVisitor_Positive() {
   /**
    * @TODO: Create visitor object by setting appropriate values
    * Call checkEventsofVisitor method by passing this visitor object and
    * valid eventId
    * Assert the value of return type 
    */ 
   Visitor visitor=new Visitor();
   visitor.setVisitorId(1004);
   try {
	dao.checkEventsofVisitor(visitor, 1004);
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
   
  }

}
