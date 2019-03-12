package fsc.parking;

/**
 * @author 
 * @version 1.0.0
 */
public class Main {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Login login = new Login();
			// Opens login window for user to enter credentials.
			login.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
