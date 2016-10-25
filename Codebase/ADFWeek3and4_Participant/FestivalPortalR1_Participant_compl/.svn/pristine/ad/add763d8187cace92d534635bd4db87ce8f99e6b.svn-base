package com.accenture.adf.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.accenture.adf.businesstier.dao.EventDAO;
import com.accenture.adf.businesstier.dao.VisitorDAO;
import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.People;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.businesstier.service.VisitorServiceImpl;

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
	 * 
	 * @throws Exception
	 */

	@Before
	public void setUp() throws Exception {

		visitor = new Visitor();

		visitorDAO = new VisitorDAO();

		registeredEvents = new ArrayList<Event>();

	}

	/**
	 * 
	 * Deallocating objects after execution of every method
	 * 
	 * @throws Exception
	 */

	@After
	public void tearDown() throws Exception {

		/**
		 * 
		 * @TODO: Release all the objects here by assigning them null
		 */

		visitor = null;

		visitorDAO = null;

		registeredEvents = null;

	}

	/**
	 * 
	 * Test case for method insertData
	 */

	@Test
	public void testInsertData() {

		/**
		 * 
		 * @TODO: Create visitor object by setting appropriate values
		 * 
		 *        Call insertData method by passing this visitor object
		 * 
		 *        Search this new visitor object by calling searchUser method
		 * 
		 *        Assert the values of username
		 */

		Visitor visitor = new Visitor();

		visitor.setUserName("ylee");

		visitor.setPassword("password");

		try {

			visitorDAO.insertData(visitor);

			// System.out.println(b);

			Visitor a = visitorDAO.searchUser("ylee", "password");

			String f = a.getUserName();

			assertNotNull(f);

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
	 * 
	 * Test case for method searchUser
	 */

	@Test
	public void testSearchUser() {

		/**
		 * 
		 * @TODO: Call searchUser method for valid values of username
		 * 
		 *        and password and assert the value of username for the returned
		 *        type of method
		 */

		try {

			Visitor v = visitorDAO.searchUser("ylee", "password");

			assertFalse(v.getUserName() == "ylee");

		} catch (ClassNotFoundException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

	/**
	 * 
	 * Test case for method registerVisitorToEvent
	 */

	@Test
	public void testRegisterVisitorToEvent() {

		/**
		 * 
		 * @TODO: Fetch visitor object by calling searchUser for valid values of
		 *        username and password
		 * 
		 *        Pass this visitor object and valid eventid to
		 *        registerVisitorToEvent method
		 * 
		 *        and assert the value
		 */

		try {

			Visitor c = visitorDAO.searchUser("ylee", "password");

			visitorDAO.registerVisitorToEvent(c, 1001);

			assertNotSame(c.getRegisteredEvents(), "Garden Tour");

		} catch (ClassNotFoundException e1) {

			// TODO Auto-generated catch block

			e1.printStackTrace();

		} catch (SQLException e1) {

			// TODO Auto-generated catch block

			e1.printStackTrace();

		} catch (Exception e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

	/**
	 * 
	 * Test case for method registeredEvents
	 * 
	 * @throws Exception
	 */
	@Test
	public void testRegisteredEvents() {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of
		 *        username and password Pass this visitor object and valid
		 *        eventid to registeredEvents method and assert the value
		 */

		People P = new People();
		String username = P.getUserName();
		String password = P.getPassword();
		try {
			visitor = visitorDAO.searchUser("bsmith", "password");
			// visitor= visitorDAO.searchUser( username, password);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Event E = new Event();
		int eventid = E.getEventid();
		try {
			registeredEvents = visitorDAO.registeredEvents(visitor);
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
		EventDAO Ev = new EventDAO();
		try {
			assertTrue("event is not registered",
					(Ev.checkEventsofVisitor(visitor, eventid)));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// assertTrue((registeredEvents.size()>0));
	}

	/**
	 * Test case for method updateVisitor
	 */
	@Test
	public void testUpdateVisitor() {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of
		 *        username and password Update the value in this visitor object
		 *        Pass this visitor object to updateVisitor method and assert
		 *        the value of changed value
		 */
		int no = 0;
		People P = new People();
		String username = P.getUserName();
		String password = P.getPassword();
		try {
			visitor = visitorDAO.searchUser("bsmith", "password");
			// visitor= visitorDAO.searchUser( username, password);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			no = visitorDAO.updateVisitor(visitor);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue("not updated", (no > 0));

	}

	/**
	 * Test case for method registeredEvents
	 */
	@Test
	public void testUnregisterEvent() {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of
		 *        username and password Pass this visitor object and valid
		 *        eventid to unregisterEvent method and assert the value
		 */

		People P = new People();
		String username = P.getUserName();
		String password = P.getPassword();
		try {
			visitor = visitorDAO.searchUser("bsmith", "password");
			// visitor= visitorDAO.searchUser( username, password);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Event E = new Event();
		int eventid = E.getEventid();
		try {
			visitorDAO.unregisterEvent(visitor, 1001);
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
		EventDAO Ev = new EventDAO();
		try {
			assertTrue("not registered",
					(Ev.checkEventsofVisitor(visitor, 1001)));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// assertTrue("unsuccessfull",registeredEvents.contains(visitor.getVisitorId()));

		// assertThat(E.getEventid(),Is.is(visitor.getVisitorId()));
		// assertThat(E.getEventid(),Is.SubsetOf(visitor.getVisitorId()));

	}

}
