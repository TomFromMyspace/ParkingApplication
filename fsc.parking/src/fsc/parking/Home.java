package fsc.parking;

import javax.swing.JOptionPane;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

/**
 * @author 
 * @version 1.0.0
 */
public class Home {

	private Shell shell;
	private String username;
	private Text locationText;
	private int uid;
	private int hours;
	private int minutes;
	
	
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
		shell.setSize(600, 690);
		shell.setText("FSC Parking");
		shell.setFocus();
		
		Color color = new Color(display, 0, 100, 86);
		
		Label lblWelcomeBanner = new Label(shell, SWT.NONE);
		lblWelcomeBanner.setBounds(0, 0, 594, 33);
		lblWelcomeBanner.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lblWelcomeBanner.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblWelcomeBanner.setBackground(color);
		lblWelcomeBanner.setAlignment(SWT.CENTER);
		lblWelcomeBanner.setText("Welcome, " + username + "!");
		
		Button btnHelp = new Button(shell, SWT.NONE);
		btnHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Help help = new Help();
				help.open();
			}
		});
		btnHelp.setBounds(10,519, 209, 60);
		btnHelp.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btnHelp.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnHelp.setBackground(color);
		btnHelp.setText("Help");
		
		Button btnSignOut = new Button(shell, SWT.NONE);
		btnSignOut.setBounds(10, 585, 209, 60);
		btnSignOut.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btnSignOut.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnSignOut.setBackground(color);
		btnSignOut.setText("Sign out");
		
		Button btnRegisterVehicle = new Button(shell, SWT.NONE);
		btnRegisterVehicle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				RegisterVehicle regVeh = new RegisterVehicle();
				regVeh.setUsername(username);
				regVeh.open();
			}
		});
		btnRegisterVehicle.setText("Register Vehicle");
		btnRegisterVehicle.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnRegisterVehicle.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btnRegisterVehicle.setBackground(SWTResourceManager.getColor(0, 100, 86));
		btnRegisterVehicle.setBounds(10, 453, 209, 60);
		
		Button btnSelectVehicle = new Button(shell, SWT.NONE);
		btnSelectVehicle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				SelectVehicle selVeh = new SelectVehicle();
				selVeh.setUsername(username);
				selVeh.open();
			}
		});
		btnSelectVehicle.setText("Select Vehicle");
		btnSelectVehicle.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnSelectVehicle.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btnSelectVehicle.setBackground(SWTResourceManager.getColor(0, 100, 86));
		btnSelectVehicle.setBounds(10, 387, 209, 60);
		
		Button btnSubscribe = new Button(shell, SWT.NONE);
		btnSubscribe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Subscribe subscribe = new Subscribe();
				subscribe.setUsername(username);
				subscribe.open();				
			}
		});
		
		btnSubscribe.setText("Subscribe");
		btnSubscribe.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnSubscribe.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btnSubscribe.setBackground(SWTResourceManager.getColor(0, 100, 86));
		btnSubscribe.setBounds(10, 321, 209, 60);
		// Closes current shell when user signs out, and opens Login GUI.
		btnSignOut.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event e) {
		          switch (e.type) {
		          case SWT.Selection:
		            shell.close();
		            Login login = new Login();
		            login.open();
		            break;
		          }
		        }
		      });
		
	}
	
	/**
	 * This method stores the username that is entered in the previous window,
	 * and sets the username of the Home GUI to the stored username.
	 * @param username that is entered in the Login GUI.
	 */
	public void setUsername(String usernameText)
	{
		username = usernameText;
	}
	
	
}
