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

public class SelectVehicle {
	private Shell shell;
	private String username;
	
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
		
		Label lblSelectVehicle = new Label(shell, SWT.NONE);
		lblSelectVehicle.setText("Select Vehicle");
		lblSelectVehicle.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSelectVehicle.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lblSelectVehicle.setBackground(SWTResourceManager.getColor(0, 100, 86));
		lblSelectVehicle.setAlignment(SWT.CENTER);
		lblSelectVehicle.setBounds(0, 0, 594, 37);
		
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
	}
}
