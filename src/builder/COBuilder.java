package builder;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

import visitor.ColombianOrder;
import visitor.Order;

/**
 *
 * @author OSCAR
 */
public class COBuilder extends UIBuilder {

    private JTextField txtOrderAmount;
    private JTextField txtAdditionalIVA;

    @Override
    public void addUIControls() {
        searchUI = new JPanel();
        JLabel lblOrderAmount = new JLabel("Order Amount:");
        txtOrderAmount = new JTextField(10);
        JLabel lblAdditionalIVA = new JLabel("Additional IVA:");
        txtAdditionalIVA = new JTextField(10);

        GridBagLayout gridbag = new GridBagLayout();

        searchUI.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();

        searchUI.add(lblOrderAmount);

        searchUI.add(txtOrderAmount);

        searchUI.add(lblAdditionalIVA);

        searchUI.add(txtAdditionalIVA);

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

        gridbag.setConstraints(lblAdditionalIVA, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;

        gridbag.setConstraints(txtOrderAmount, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;

        gridbag.setConstraints(txtAdditionalIVA, gbc);

    }

    @Override
    public void initialize() {
        txtOrderAmount.setText("Enter Amount");
        txtAdditionalIVA.setText("Enter Add Tax");
    }

    @Override
    public HashMap<String, String> getValues() {
        HashMap<String, String> values = new HashMap<String, String>();
        String strOrderAmount = txtOrderAmount.getText();
        String strIVA = txtAdditionalIVA.getText();

        values.put("orderAmount", strOrderAmount);
        values.put("additionalIVA", strIVA);

        return values;
    }

    @Override
    public void setValues(HashMap<String, String> values) {
        txtOrderAmount.setText(values.get("orderAmount"));
        txtAdditionalIVA.setText((String) values.get("additionalIVA"));
    }
}
