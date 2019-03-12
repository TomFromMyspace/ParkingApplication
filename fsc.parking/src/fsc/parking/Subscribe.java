package fsc.parking;

import javax.swing.JOptionPane;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;


public class Subscribe {
	private Shell shell;
	private String username;
	private Text textUsername;
	private Text textCCNumber;
	private Text textName;
	private Text textSecurityCode;

	public void setUsername(String name) {
		username = name;
	}
	
	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		Image image = new Image(display, "assets\\fsc-icon.png");
		shell.setImage(image);
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		Display display = Display.getDefault();
		// Makes shell unable to be changed in height / width. Remove arguments to enable resizing.
		shell = new Shell(display, SWT.CLOSE | SWT.TITLE | SWT.MIN );
		shell.setTouchEnabled(true);
		shell.setSize(600, 529);
		shell.setText("FSC Parking");
		shell.setFocus();
		
		Color color = new Color(display, 0, 100, 86);
		
		Label lblSubscribe = new Label(shell, SWT.NONE);
		lblSubscribe.setText("Subscribe");
		lblSubscribe.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSubscribe.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lblSubscribe.setBackground(SWTResourceManager.getColor(0, 100, 86));
		lblSubscribe.setAlignment(SWT.CENTER);
		lblSubscribe.setBounds(0, 0, 594, 37);
		
		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.close();
			}
		});
		
		btnCancel.setText("Cancel");
		btnCancel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnCancel.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btnCancel.setBackground(SWTResourceManager.getColor(0, 100, 86));
		btnCancel.setBounds(365, 428, 219, 60);
		
		textUsername = new Text(shell, SWT.BORDER);
		textUsername.setText(username);
		textUsername.setEditable(false);
		textUsername.setBounds(20, 85, 167, 26);
		
		Label lblUsername = new Label(shell, SWT.NONE);
		lblUsername.setBounds(10, 59, 70, 20);
		lblUsername.setText("Username:");
		
		Button btnRegister = new Button(shell, SWT.NONE);
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Subscription Activated.", "Success!", JOptionPane.INFORMATION_MESSAGE);
				shell.close();
			}
		});
		btnRegister.setText("Confirm Purchase");
		btnRegister.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnRegister.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btnRegister.setBackground(SWTResourceManager.getColor(0, 100, 86));
		btnRegister.setBounds(365, 362, 219, 60);
		
		Label lblCreditCardIssuer = new Label(shell, SWT.NONE);
		lblCreditCardIssuer.setBounds(10, 117, 146, 20);
		lblCreditCardIssuer.setText("Credit Card Issuer:");
		
		textCCNumber = new Text(shell, SWT.BORDER);
		textCCNumber.setBounds(20, 247, 197, 26);
		
		Button btnVisa = new Button(shell, SWT.RADIO);
		btnVisa.setBounds(20, 143, 111, 20);
		btnVisa.setText("Visa");
		
		Button btnMastercard = new Button(shell, SWT.RADIO);
		btnMastercard.setBounds(20, 169, 111, 20);
		btnMastercard.setText("Mastercard");
		
		Button btnAmericanExpress = new Button(shell, SWT.RADIO);
		btnAmericanExpress.setBounds(20, 195, 146, 20);
		btnAmericanExpress.setText("American Express");
		
		Label lblCardNumber = new Label(shell, SWT.NONE);
		lblCardNumber.setBounds(10, 221, 111, 20);
		lblCardNumber.setText("Card Number:");
		
		Label lblNameOnCard = new Label(shell, SWT.NONE);
		lblNameOnCard.setBounds(10, 279, 121, 20);
		lblNameOnCard.setText("Name on Card:");
		
		textName = new Text(shell, SWT.BORDER);
		textName.setBounds(20, 305, 197, 26);
		
		Label lblSecurityCode = new Label(shell, SWT.NONE);
		lblSecurityCode.setBounds(10, 337, 121, 20);
		lblSecurityCode.setText("Security Code:");
		
		textSecurityCode = new Text(shell, SWT.BORDER);
		textSecurityCode.setBounds(20, 362, 78, 26);
	}
}
