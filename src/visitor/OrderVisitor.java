package visitor;

import java.util.*;

class OrderVisitor implements VisitorInterface {

	// private Vector orderObjList;
	private double orderTotal;

	public OrderVisitor() {
		// orderObjList = new Vector();
	}

	public void visit(CaliforniaOrder inp_order) {
		orderTotal = inp_order.getOrderAmount() + (inp_order.getOrderAmount() *inp_order.getAdditionalTax() /100);
		inp_order.setTotal(getOrderTotal());
	}

	public void visit(NonCaliforniaOrder inp_order) {
		orderTotal = inp_order.getOrderAmount();
		inp_order.setTotal(getOrderTotal());

	}

	public void visit(OverseasOrder inp_order) {
		orderTotal = inp_order.getOrderAmount() + (inp_order.getOrderAmount() *inp_order.getAdditionalSH()/100);
		inp_order.setTotal(getOrderTotal());
	}

	public void visit(ColombianOrder inp_order) {
		orderTotal = inp_order.getOrderAmount() + (inp_order.getOrderAmount() * inp_order.getAdditionalIVA()/100);
		inp_order.setTotal(getOrderTotal());
	}

	public double getOrderTotal() {
		return orderTotal;
	}

}
