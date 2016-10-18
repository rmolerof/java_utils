package org.fedex.sandbox.mockito;

public class OrderBOImpl {
	
	private OrderDAO dao;
	
	public boolean placeOrder(){
		return dao.processOrder();
	}
	
	public OrderDAO getDAO(){
		return dao;
	}
	
	public void setDao(OrderDAO dao){
		this.dao=dao;
	}
}
