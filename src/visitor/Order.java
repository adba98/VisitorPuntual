package visitor;

public interface Order {

	public void accept(OrderVisitor v);
}
