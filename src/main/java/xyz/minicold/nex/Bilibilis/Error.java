package xyz.minicold.nex.Bilibilis;

import javax.swing.JDialog;
import java.awt.TextArea;

public class Error extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void errors(Exception e) {
		try {
			Error dialog = new Error(e);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.wait(1000);
			dialog.setVisible(false);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Error(Exception e) {
		setTitle("DeBug!  Oooops! your program create a error!");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		TextArea textArea = new TextArea();
		textArea.setText(e.toString());
		textArea.setBounds(0, 10, 440, 241);
		getContentPane().add(textArea);
	}
}
