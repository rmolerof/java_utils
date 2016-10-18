package org.fedex.sandbox.mockito;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class OrderBOImplTest {

	@Mock
	OrderDAO dao;
	
	// Initialize all mock objects
	@Before
	public void initMocks(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testPlaceOrderReturnsTrue() {
		OrderBOImpl bo = new OrderBOImpl();
		bo.setDao(dao);
		
		Mockito.when(dao.processOrder()).thenReturn(true); // Mock the object
		
		assertTrue(bo.placeOrder());
		
		Mockito.verify(dao, Mockito.times(1)).processOrder(); // Verifies that processOrder gets called once
		
		
	}
	
	@Test
	public void getRootCauseException(){
		
		try{
			//throw new RuntimeException("Runtime");
			int i = 2/0;
		} catch (Exception e){
//			System.out.println("Exception: " + e.getStackTrace()[0]);
			/*String[] classNameStr = e.getClass().getName().split("\\.");
			String exStr = "Exception name: " + classNameStr[classNameStr.length-1];*/
			System.out.println(getExceptionName(e));
//			e.printStackTrace();
		}
		
	}
	
	private String getExceptionName(Exception ex){
		String[] classNameStr = ex.getClass().getName().split("\\.");
		String exMsg = "FAILURE-" + classNameStr[classNameStr.length-1];
		return StringUtils.substring(exMsg, 0, 50);
	}

	@Test
	public void test30EExceptions(){
		
	//	String[] arr = ex.toString().split(":");
		
		String propertyKey = "Get Pricing failed org.springframework.ws.client.WebServiceIOException";
		String[] tmpArr = propertyKey.split("Get Pricing failed ");
		System.out.println("FINAL STRING:" + tmpArr[1]);
	}
}
