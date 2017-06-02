import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;



public class Login {



	private JFrame frame;
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private JLabel lblPassword;
	private JLabel lblNombre;
	private JButton btnIniciarSesin;

	/**
	 * Launch the application.
	 */
	public Login() {

		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("CheckBox.select"));
		txtUsuario = new JTextField();
		lblNombre = new JLabel("Usuario");
		lblPassword = new JLabel("Password");
		passwordField = new JPasswordField();
		btnIniciarSesin = new JButton("Iniciar Sesi\u00F3n");
	
		initialize();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		propiedades();
		eventos();

	}

	private void propiedades() {

		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnIniciarSesin.setBounds(87, 135, 154, 23);
		frame.getContentPane().add(btnIniciarSesin);

		txtUsuario.setBounds(155, 65, 86, 20);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		lblNombre.setFont(new Font("Narkisim", Font.BOLD, 13));
		lblNombre.setBounds(86, 68, 59, 14);
		frame.getContentPane().add(lblNombre);

		passwordField.setBounds(155, 96, 86, 20);
		frame.getContentPane().add(passwordField);

		lblPassword.setFont(new Font("Narkisim", Font.BOLD, 13));
		lblPassword.setBounds(86, 100, 59, 14);
		frame.getContentPane().add(lblPassword);
	}

	public void eventos() {

		
		btnIniciarSesin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				FrameBusqueda window=new FrameBusqueda();
				window.getFrame2().setVisible(true);
				frame.dispose();
			}
		});


	}

}