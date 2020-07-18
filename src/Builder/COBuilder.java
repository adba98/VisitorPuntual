package Builder;

import Visitor.ColombianOrder;
import Visitor.Order;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author OSCAR
 */
public class COBuilder extends UIBuilder {

    private JTextField txtOrderAmount = new JTextField(10);
    private JTextField txtAdditionalSH = new JTextField(10);

    @Override
    public void addUIControls() {
        searchUI = new JPanel();
        JLabel lblOrderAmount = new JLabel("Order Amount:");
        JLabel lblAdditionalSH = new JLabel("Additional S & H:");

        GridBagLayout gridbag = new GridBagLayout();
        searchUI.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();

        searchUI.add(lblOrderAmount);
        searchUI.add(txtOrderAmount);
        searchUI.add(lblAdditionalSH);
        searchUI.add(txtAdditionalSH);

        gbc.anchor = GridBagConstraints.WEST;

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblOrderAmount, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gridbag.setConstraints(lblAdditionalSH, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(txtOrderAmount, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gridbag.setConstraints(txtAdditionalSH, gbc);

    }

    @Override
    public void initialize() {
        txtOrderAmount.setText("Enter Amount");
        txtAdditionalSH.setText("Enter Add Tax");
    }

    @Override
    public Order createOrder() {
        String strOrderAmount = txtOrderAmount.getText();
        String strSH = txtAdditionalSH.getText();

        Double dblOrderAmount = new Double(strOrderAmount).doubleValue();
        Double dblSH = new Double(strSH).doubleValue();

        return new ColombianOrder(dblOrderAmount, dblSH);
    }
}
