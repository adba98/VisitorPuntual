package Visitor;

import Builder.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.sun.java.swing.plaf.windows.*;

/**
 * @author OSCAR
 */
public class OrderManager extends JFrame {

    public static final String BLANK = "";
    public static final String CA_ORDER = "California Order";
    public static final String NON_CA_ORDER = "Non-California Order";
    public static final String OVERSEAS_ORDER = "Overseas Order";
    public static final String CO_ORDER = "Colombian Order";

    public static final String GET_TOTAL = "Get Total";
    public static final String CREATE_ORDER = "Create Order";
    public static final String EXIT = "Exit";

    private JComboBox cmbOrderType;
    private JPanel pSearchCriteria;

    private JLabel lblOrderType;
    private JLabel lblTotal, lblTotalValue;

    private OrderVisitor objVisitor;

    public OrderManager() {
        super("Visitor Pattern - Example");

        objVisitor = new OrderVisitor();

        cmbOrderType = new JComboBox();
        cmbOrderType.addItem(OrderManager.BLANK);
        cmbOrderType.addItem(OrderManager.CA_ORDER);
        cmbOrderType.addItem(OrderManager.NON_CA_ORDER);
        cmbOrderType.addItem(OrderManager.OVERSEAS_ORDER);
        cmbOrderType.addItem(OrderManager.CO_ORDER);

        pSearchCriteria = new JPanel();

        lblOrderType = new JLabel("Order Type:");

        lblTotal = new JLabel("Result:");
        lblTotalValue = new JLabel("Click Create or GetTotal Button");

        //Create the open button
        JButton getTotalButton = new JButton(OrderManager.GET_TOTAL);
        getTotalButton.setMnemonic(KeyEvent.VK_G);

        JButton createOrderButton = new JButton(OrderManager.CREATE_ORDER);
        getTotalButton.setMnemonic(KeyEvent.VK_C);//getTotal?

        JButton exitButton = new JButton(OrderManager.EXIT);
        exitButton.setMnemonic(KeyEvent.VK_X);

        ButtonHandler objButtonHandler = new ButtonHandler(this);

        getTotalButton.addActionListener(objButtonHandler);
        createOrderButton.addActionListener(objButtonHandler);
        cmbOrderType.addActionListener(objButtonHandler);
        exitButton.addActionListener(objButtonHandler);

        //For layout purposes, put the buttons in a separate panel
        JPanel panel = new JPanel();

        GridBagLayout gridbag2 = new GridBagLayout();
        panel.setLayout(gridbag2);

        GridBagConstraints gbc2 = new GridBagConstraints();

        panel.add(getTotalButton);
        panel.add(createOrderButton);
        panel.add(exitButton);
        gbc2.anchor = GridBagConstraints.EAST;
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gridbag2.setConstraints(createOrderButton, gbc2);
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        gridbag2.setConstraints(getTotalButton, gbc2);
        gbc2.gridx = 2;
        gbc2.gridy = 0;
        gridbag2.setConstraints(exitButton, gbc2);

        //****************************************************
        JPanel buttonPanel = new JPanel();
        GridBagLayout gridbag = new GridBagLayout();
        buttonPanel.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();
        buttonPanel.add(lblOrderType);
        buttonPanel.add(cmbOrderType);
        buttonPanel.add(pSearchCriteria);
        buttonPanel.add(lblTotal);
        buttonPanel.add(lblTotalValue);

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblOrderType, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(cmbOrderType, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gridbag.setConstraints(pSearchCriteria, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gridbag.setConstraints(lblTotal, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gridbag.setConstraints(lblTotalValue, gbc);

        gbc.insets.left = 2;
        gbc.insets.right = 2;
        gbc.insets.top = 40;

        //****************************************************
        //Add the buttons and the log to the frame
        Container contentPane = getContentPane();

        contentPane.add(buttonPanel, BorderLayout.NORTH);
        contentPane.add(panel, BorderLayout.CENTER);
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
            SwingUtilities.updateComponentTreeUI(OrderManager.this);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new OrderManager();

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        }
        );

        //frame.pack();
        frame.setSize(500, 400);
        frame.setVisible(true);
    }

    public void setTotalValue(String msg) {
        lblTotalValue.setText(msg);
    }

    public OrderVisitor getOrderVisitor() {
        return objVisitor;
    }

    public String getOrderType() {
        return (String) cmbOrderType.getSelectedItem();
    }

    public JComboBox getOrderTypeCtrl() {
        return cmbOrderType;
    }

    public void displayNewUI(JPanel panel) {
        pSearchCriteria.removeAll();
        pSearchCriteria.add(panel);
        pSearchCriteria.validate();
        validate();
    }

}// End of class OrderManager

class ButtonHandler implements ActionListener {

    OrderManager objOrderManager;
    UIBuilder builder;
    JPanel UIObj;

    public void actionPerformed(ActionEvent e) {
        String totalResult = null;

        if (e.getActionCommand().equals(OrderManager.EXIT)) {
            System.out.println("EXIT");
            System.exit(1);
        }
        if (e.getSource() == objOrderManager.getOrderTypeCtrl()) {
            System.out.println("ComboBox");
            String selection = objOrderManager.getOrderType();
            if (selection.equals("") == false) {
                BuilderFactory factory = new BuilderFactory();
                //create an appropriate builder instance
                builder = factory.getUIBuilder(selection);
                //configure the director with the builder
                UIDirector director = new UIDirector(builder);
                //director invokes different builder
                // methods
                director.build();
                //get the final build object
                UIObj = builder.getSearchUI();
                objOrderManager.displayNewUI(UIObj);
            }
        }

        if (e.getActionCommand().equals(OrderManager.CREATE_ORDER)) {
            //get input values

            Order order = builder.createOrder();

            //Get the Visitor (instantiate)
            OrderVisitor visitor = objOrderManager.getOrderVisitor();

            // accept the visitor instance
            order.accept(visitor);

            objOrderManager.setTotalValue(
                    " Order Created Successfully");
        }

        if (e.getActionCommand().equals(OrderManager.GET_TOTAL)) {
            //Get the Visitor
            OrderVisitor visitor = objOrderManager.getOrderVisitor();
            totalResult = new Double(visitor.getOrderTotal()).toString();
            totalResult = " Orders Total = " + totalResult;
            objOrderManager.setTotalValue(totalResult);
        }
    }

    public ButtonHandler() {
    }

    public ButtonHandler(OrderManager inObjOrderManager) {
        objOrderManager = inObjOrderManager;
    }
}

class BuilderFactory {

    public UIBuilder getUIBuilder(String str) {
        UIBuilder builder = null;
        if (str.equals(OrderManager.CA_ORDER)) {
            builder = new CABuilder();
        } else if (str.equals(OrderManager.NON_CA_ORDER)) {
            builder = new NONCABuilder();
        } else if (str.equals(OrderManager.OVERSEAS_ORDER)) {
            builder = new OverseasBuilder();
        } else if (str.equals(OrderManager.CO_ORDER)) {
            builder = new COBuilder();
        }
        return builder;

    }
}
