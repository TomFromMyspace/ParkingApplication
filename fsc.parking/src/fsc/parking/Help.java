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

public class Help {
	private Shell shell;
	
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
		shell.setSize(606, 364);
		shell.setText("FSC Parking");
		shell.setFocus();
		
		Color color = new Color(display, 0, 100, 86);
		
		Label lblHelpBanner = new Label(shell, SWT.NONE);
		lblHelpBanner.setBounds(0, 0, 594, 42);
		lblHelpBanner.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lblHelpBanner.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblHelpBanner.setBackground(color);
		lblHelpBanner.setAlignment(SWT.CENTER);
		lblHelpBanner.setText("Help");
		
		Label lblHelp = new Label(shell, SWT.NONE);
		lblHelp.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblHelp.setBounds(10, 54, 584, 229);
		lblHelp.setText("Subscribe - Purchase your subscription for authorization to start\n"
				+ "reserving your parking spots.\n\n"
				+ "Select Vehicle - Select your registered vehicle to begin the\n"
				+ "reservation process.\n\n"
				+ "Register Vehicle - Register your vehicle to authorize parking\n"
				+ "with that vehicle.\n\n");
		
		Button btnClose = new Button(shell, SWT.NONE);
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.close();
			}
		});
		btnClose.setBounds(249, 289, 90, 30);
		btnClose.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnClose.setBackground(color);
		btnClose.setText("Close");
		
	}
}