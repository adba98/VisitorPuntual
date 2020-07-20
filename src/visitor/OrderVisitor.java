package visitor;

import java.util.*;

class OrderVisitor implements VisitorInterface {

	// private Vector orderObjList;
	private double orderTotal;

	public OrderVisitor() {
		// orderObjList = new Vector();
	}

	public void visit(CaliforniaOrder inp_order) {
		orderTotal = inp_order.getOrderAmount() + (inp_order.getOrderAmount() *inp_order.getAdditionalTax());
		inp_order.setTotal(getOrderTotal());
	}

	public void visit(NonCaliforniaOrder inp_order) {
		orderTotal = inp_order.getOrderAmount();
		inp_order.setTotal(getOrderTotal());

	}

	public void visit(OverseasOrder inp_order) {
		orderTotal = inp_order.getOrderAmount() + (inp_order.getOrderAmount() *inp_order.getAdditionalSH());
		inp_order.setTotal(getOrderTotal());
	}

	public void visit(ColombianOrder inp_order) {
		orderTotal = inp_order.getOrderAmount() + (inp_order.getOrderAmount() * inp_order.getAdditionalIVA());
		inp_order.setTotal(getOrderTotal());
	}

	public double getOrderTotal() {
		return orderTotal;
	}

}
