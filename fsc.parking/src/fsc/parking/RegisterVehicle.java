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



public class RegisterVehicle {

	private Shell shell;
	private String username;
	private Text textUsername;
	private Text textVehicleMake;
	private Text textVehicleModel;
	private Text textVehicleColor;
	private Text textLicensePlateNumber;
	
	public String getUsername() {
		return username;
	}
	
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
		
		Label lblVehicleRegistry = new Label(shell, SWT.NONE);
		lblVehicleRegistry.setText("Vehicle Registry");
		lblVehicleRegistry.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblVehicleRegistry.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lblVehicleRegistry.setBackground(SWTResourceManager.getColor(0, 100, 86));
		lblVehicleRegistry.setAlignment(SWT.CENTER);
		lblVehicleRegistry.setBounds(0, 0, 594, 37);
		
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
		btnCancel.setBounds(375, 428, 209, 60);
		
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
				JOptionPane.showMessageDialog(null, "Vehicle Registered.", "Success!", JOptionPane.INFORMATION_MESSAGE);
				shell.close();
			}
		});
		btnRegister.setText("Register");
		btnRegister.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnRegister.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btnRegister.setBackground(SWTResourceManager.getColor(0, 100, 86));
		btnRegister.setBounds(375, 362, 209, 60);
		
		Label labelVehicleMake = new Label(shell, SWT.NONE);
		labelVehicleMake.setText("Vehicle Make:");
		labelVehicleMake.setBounds(10, 117, 110, 20);
		
		textVehicleMake = new Text(shell, SWT.BORDER);
		textVehicleMake.setBounds(20, 143, 167, 26);
		
		Label labelVehicleModel = new Label(shell, SWT.NONE);
		labelVehicleModel.setText("Vehicle Model:");
		labelVehicleModel.setBounds(10, 175, 110, 20);
		
		textVehicleModel = new Text(shell, SWT.BORDER);
		textVehicleModel.setBounds(20, 201, 167, 26);
		
		Label labelVehicleColor = new Label(shell, SWT.NONE);
		labelVehicleColor.setText("Vehicle Color:");
		labelVehicleColor.setBounds(10, 233, 110, 20);
		
		textVehicleColor = new Text(shell, SWT.BORDER);
		textVehicleColor.setBounds(20, 259, 167, 26);
		
		Label labelLicensePlateNumber = new Label(shell, SWT.NONE);
		labelLicensePlateNumber.setText("License Plate Number:");
		labelLicensePlateNumber.setBounds(10, 291, 151, 20);
		
		textLicensePlateNumber = new Text(shell, SWT.BORDER);
		textLicensePlateNumber.setBounds(20, 317, 167, 26);
		
		Label lblVehicleType = new Label(shell, SWT.NONE);
		lblVehicleType.setBounds(10, 349, 97, 20);
		lblVehicleType.setText("Vehicle Type:");
		
		Button btnCar = new Button(shell, SWT.RADIO);
		btnCar.setBounds(20, 375, 111, 20);
		btnCar.setText("Car");
		
		Button btnMotorcycle = new Button(shell, SWT.RADIO);
		btnMotorcycle.setBounds(20, 401, 111, 20);
		btnMotorcycle.setText("Motorcycle");
		
		Button btnElectricVehicle = new Button(shell, SWT.CHECK);
		btnElectricVehicle.setBounds(10, 440, 298, 26);
		btnElectricVehicle.setText("This vehicle is electric.");
		
	}
}
