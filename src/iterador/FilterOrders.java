package iterador;

import java.util.*;

import composite.OrderComposite;
import visitor.Order;

public class FilterOrders implements Iterator {

	// toda la informacion de nuestra estructura
	private OrderComposite orderColecction;
	private String filteredType;
	private Enumeration ec;

	// ?? FIXME Puede componet, order,
	private Order nextOrder;

	public FilterOrders(OrderComposite c, String typeOrder) {
		orderColecction = c;
		filteredType = typeOrder;
		ec = c.getAllOrders();
	}

	@Override
	public boolean hasNext() {
		boolean matchFound = false;
		while (ec.hasMoreElements()) {

			/**
			 *
			 * // FIXME recorro los archivos compuestos y luego los las ordenes?
			 * OrderComponent tempObj = (OrderComponent) ec.nextElement();
			 *
			 * if(tempObj.getClass() == OrderComposite.class) { // vuelvo a iterar el
			 * compuesto }else {
			 *
			 * if (tempObj.getCertificationType().equals(filteredType)) { matchFound = true;
			 * nextCandidate = tempObj; break; } }*
			 */
			Order tempObj = (Order) ec.nextElement();

			matchFound = true;
			nextOrder = tempObj;
			break;
		}
		if (matchFound == true) {
		} else {
			nextOrder = null;
		}
		return matchFound;
	}

	@Override
	public Object next() {
		if (nextOrder == null) {
			throw new NoSuchElementException();
		} else {
			return nextOrder;
		}
	}

}
