package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accenture.adf.businesstier.dao.EventDAO;
import com.accenture.adf.businesstier.dao.VisitorDAO;
import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.businesstier.service.VisitorServiceImpl;

/**
 * Junit test class for VisitorServiceImpl
 *
 */
public class TestVisitorServiceImpl {

	private List<Event> visitorList;	
	private Visitor visitor;
	private VisitorServiceImpl visitorServiceImpl;
	private VisitorDAO visitorDAO;
	/**
	 * Set up the initial methods 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {		
		visitorServiceImpl = new VisitorServiceImpl();
		visitor = new Visitor();
		visitorDAO = new VisitorDAO();

	}

	/**
	 * Deallocates the objects after execution of every method
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		visitorServiceImpl=null;
		   visitor=null;
		   visitorDAO=null;
	}

	/**
	 * Test case for method createVisitor
	 */
	@Test
	public void testCreateVisitor() {
		/**
		 * @TODO: Set the appropriate values for visitor object and
		 * call the method createVisitor by passing an argument of this visitor 
		 * object and then asserting the returned type of this method
		 */		
		 Visitor v=new Visitor();
		   VisitorServiceImpl vis=new VisitorServiceImpl();
		   v.setUserName("npatel");
		   v.setPassword("password");
		   Assert.assertFalse(vis.createVisitor(v));
		   
	}

	/**
	 * Test case for method createVisitor
	 */
	@Test
	public void testSearchVisitor() {
		/**
		 * @TODO: Call searchVisitor method by passing the appropriate arguments 
		 * and then asserting the returned type visitor username with the argument passed
		 */	
		 VisitorServiceImpl vis1=new VisitorServiceImpl();
	     Visitor v2=vis1.searchVisitor("npatel","password");
	    assertEquals(v2.getUserName(),"npatel" );
	    /* EventDAO Ev=new EventDAO();

	      assertTrue("unregistered for event",(Ev.checkEventsofVisitor(v2, 1001)));*/
	     
	}

	private boolean equals(String userName, String string) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Test case for method RegisterVisitor
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testRegisterVisitor() throws ClassNotFoundException, SQLException {
		/**
		 * @TODO: Call RegisterVisitor method by passing visitor object which 
		 * can be retrieved using searchVisitor method and then asserting the returned
		 * type of RegisterVisitor method 
		 */		
		  VisitorServiceImpl vis2=new VisitorServiceImpl();
	      Visitor v3=vis2.searchVisitor("npatel","password");
	      
	      vis2.RegisterVisitor(v3,1001);
	     
	     // Assert.assertFalse(v3.getRegisteredEvents().contains(1001));
			EventDAO Ev=new EventDAO();

	      assertTrue("unregistered for event",(Ev.checkEventsofVisitor(v3, 1001)));
		
		
		
		
		
		
	}

	/**
	 * Test case for method showRegisteredEvents
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testShowRegisteredEvents() throws ClassNotFoundException, SQLException {
		/**
		 * @TODO: Call showRegisteredEvents method by passing visitor object which 
		 * can be retrieved using searchVisitor method and then asserting the returned
		 * type of showRegisteredEvents method 
		 * 
		 */
		
		
		visitor= visitorServiceImpl.searchVisitor("bsmith", "password");
		try {
			visitorDAO.registerVisitorToEvent(visitor, 1001);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		visitorList=visitorServiceImpl.showRegisteredEvents(visitor);
		EventDAO Ev=new EventDAO();
		assertTrue("unregistered for event",(Ev.checkEventsofVisitor(visitor, 1001)));
		
		
		
		
		
		
	}

	/**
	 * Test case for method updateVisitorDetails
	 */
	@Test
	public void testUpdateVisitorDetails() {
		/**
		 * @TODO: Call updateVisitorDetails method by passing the visitor object which
		 * can be retrieved using searchVisitor method and then asserting the returned
		 * type of updateVisitorDetails
		 */	int a=0;	
		try {
			visitor= visitorDAO.searchUser( "bsmith", "password");
			a=visitorServiceImpl.updateVisitorDetails(visitor);
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
	
	Assert.assertEquals("fails",(a!=0));
	
		
		
		
	}

	/**
	 * Test case for method unregisterEvent
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testUnregisterEvent() throws ClassNotFoundException, SQLException {
		/**
		 * @TODO: Call unregisterEvent method by passing the visitor object which can be
		 * retrieved using searchVisitor method and then asserting the returned type 
		 * of unregisterEvent
		 */		
		try {
			visitor= visitorServiceImpl.searchVisitor("bsmith", "password");
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
	
		
	
		visitorList=visitorServiceImpl.showRegisteredEvents(visitor);
		EventDAO Ev=new EventDAO();
		assertTrue("unregistered",(Ev.checkEventsofVisitor(visitor, 1001)));
		
		//Assert.assertTrue("fails",(visitor instanceof Visitor));
	}

}
