package Visitor;

import Composite.OrderComponent;

/**
 *
 * @author OSCAR
 */
public class ColombianOrder extends OrderComponent implements Order {

	private double orderAmount;
	private double additionalIVA;
	private String name = "Colombia";

	public ColombianOrder(double inp_orderAmount, double inp_additionalIVA) {
		orderAmount = inp_orderAmount;
		additionalIVA = inp_additionalIVA;
	}

	@Override
	public void accept(OrderVisitor v) {
		v.visit(this);
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public double getAdditionalIVA() {
		return additionalIVA;

	}

	@Override
	public String toString() {
		return "\n " + name + " Order \n Amount: " + orderAmount + "\n IVA: " + additionalIVA + "\n Total:"
				+ getTotal();
	}
}
