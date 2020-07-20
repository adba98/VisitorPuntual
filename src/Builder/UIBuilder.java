package Builder;

import java.util.ArrayList;
import javax.swing.*;

public abstract class UIBuilder {

	protected JPanel searchUI;

	public abstract void addUIControls();

	public abstract void initialize();

	public abstract ArrayList getValues();

	public JPanel getSearchUI() {
		return searchUI;
	}
}
