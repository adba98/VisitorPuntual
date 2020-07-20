package Visitor;

public interface Order {

	public void accept(OrderVisitor v);
}
