package Builder;


import Visitor.Order;
import javax.swing.*;

public abstract class UIBuilder {

    protected JPanel searchUI;

    public abstract void addUIControls();

    public abstract void initialize();

    public abstract Order createOrder();

    public JPanel getSearchUI() {
        return searchUI;
    }
}
