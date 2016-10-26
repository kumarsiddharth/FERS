package com.accenture.adf.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accenture.adf.businesstier.dao.VisitorDAO;
import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.Visitor;

/**
 * JUnit test case for VisitorDAO class for testing all repository methods to
 * call database sub-routines
 * 
 */
public class TestVisitorDAO {
	
	private Visitor visitor;
	private VisitorDAO visitorDAO;
	private ArrayList<Event> registeredEvents;

	/**
	 * Setting up initial objects 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		visitor = new Visitor();
		visitorDAO = new VisitorDAO();
		registeredEvents = new ArrayList<Event>();
	}

	/**
	 * Deallocating objects after execution of every method
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
	}

	/**
	 * Test case for method insertData
	 */
	@Test
	public void testInsertData() {
		/**
		 * @TODO: Create visitor object by setting appropriate values
		 * Call insertData method by passing this visitor object
		 * Search this new visitor object by calling searchUser method
		 * Assert the values of username
		 */
		visitor.setAddress("address");   					//to be done later
		visitor.setEmail("email");		 					//to be done later
		visitor.setFirstName("firstName");					//to be done later
		visitor.setLastName("lastName");					//to be done later
		visitor.setPassword("password");					//to be done later
		visitor.setPhoneNumber("phoneNumber");				//to be done later
		visitor.setRegisteredEvents(registeredEvents);		//to be done later
		visitor.setUserName("userName");					//to be done later
		visitor.setVisitorId(1);							//to be done later
		
		boolean x=false;
		try {
			x = visitorDAO.insertData(visitor);
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
		assertEquals(x,false);
		
		
		
		
	}	

	/**
	 * Test case for method searchUser
	 */
	@Test
	public void testSearchUser() {
		/**
		 * @TODO: Call searchUser method for valid values of username
		 * and password and assert the value of username for the returned type of method
		 */
		Visitor v=new Visitor();
		try {
			v= visitorDAO.searchUser("abcd", "1234");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(v.getUserName(),"abcd" );
	}

	/**
	 * Test case for method registerVisitorToEvent
	 */
	@Test
	public void testRegisterVisitorToEvent() {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Pass this visitor object and valid eventid to registerVisitorToEvent method
		 * and assert the value
		 */
		
		Visitor v=new Visitor();
		try {
			v=visitorDAO.searchUser("abcd", "1234");
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			visitorDAO.registerVisitorToEvent(v, 1);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			registeredEvents=visitorDAO.registeredEvents(v);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(registeredEvents, 1);
	}	

	/**
	 * Test case for method registeredEvents
	 */
	@Test
	public void testRegisteredEvents() {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Pass this visitor object and valid eventid to registeredEvents method
		 * and assert the value
		 */	

		Visitor v=new Visitor();
		try {
			v=visitorDAO.searchUser("abcd", "1234");
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			visitorDAO.registeredEvents(v);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			registeredEvents=visitorDAO.registeredEvents(v);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(registeredEvents, 1);
	}

	/**
	 * Test case for method updateVisitor
	 */
	@Test
	public void testUpdateVisitor() {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Update the value in this visitor object
		 * Pass this visitor object to updateVisitor method
		 * and assert the value of changed value
		 */	
		Visitor v=new Visitor();
		try {
			v=visitorDAO.searchUser("abcd","1234");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			visitorDAO.updateVisitor(v);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(v.getUserName(),"abcd");
	}

	/**
	 * Test case for method registeredEvents
	 */
	@Test
	public void testUnregisterEvent() {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Pass this visitor object and valid eventid to unregisterEvent method
		 * and assert the value
		 */	
		Visitor v=new Visitor();
		try {
			v=visitorDAO.searchUser("abcd","1234");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			visitorDAO.unregisterEvent(v, 1);
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
		//unregisterEvent=visitorDAO.unregisterEvent(v, 1);
		assertEquals(v,1);
	}

}
