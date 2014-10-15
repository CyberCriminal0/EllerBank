package EllerBank;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class UserInterface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public UserInterface() {
		/**try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		**/
		setResizable(false);
		setTitle("Bank Interface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToEllerbank = new JLabel("Welcome to EllerBank!");
		lblWelcomeToEllerbank.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblWelcomeToEllerbank.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToEllerbank.setBounds(132, 11, 179, 77);
		contentPane.add(lblWelcomeToEllerbank);
		
		JButton btnCreateAccount = new JButton("Create New Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreateAccount.setBounds(10, 99, 153, 50);
		contentPane.add(btnCreateAccount);
		
		JButton btnLoginToExisting = new JButton("Login to Existing Account");
		btnLoginToExisting.setBounds(281, 99, 153, 50);
		contentPane.add(btnLoginToExisting);
	}
	
	private void login (String name, String IP, int port){
		dispose();
		System.out.println(name + IP + port + "");
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

