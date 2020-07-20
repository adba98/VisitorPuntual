package visitor;

import composite.OrderComponent;

public class NonCaliforniaOrder extends OrderComponent implements Order {

	private double orderAmount;
	private String name = "Non California";

	public NonCaliforniaOrder() {
	}

	public NonCaliforniaOrder(double inp_orderAmount) {
		orderAmount = inp_orderAmount;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void accept(OrderVisitor v) {
		v.visit(this);
	}

	@Override
	public String toString() {
		return "\n " + name + " Order \n Amount: " + orderAmount + "\n Total:" + getTotal();
	}
}
