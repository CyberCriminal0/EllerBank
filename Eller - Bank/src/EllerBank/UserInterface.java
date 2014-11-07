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
import javax.swing.JPasswordField;
import com.jgoodies.forms.factories.DefaultComponentFactory;

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
		lblWelcomeToEllerbank.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblWelcomeToEllerbank.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToEllerbank.setBounds(79, 11, 286, 77);
		contentPane.add(lblWelcomeToEllerbank);
		
		JButton btnCreateAccount = new JButton("Create New Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				NewAccount newAccount = new NewAccount();				
			}
		});
		btnCreateAccount.setBounds(10, 99, 153, 50);
		contentPane.add(btnCreateAccount);
		
		JButton btnLoginToExisting = new JButton("Login to Existing Account");
		btnLoginToExisting.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLoginToExisting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OldAccount oldAccount = new OldAccount();

			}
		});
		btnLoginToExisting.setBounds(281, 99, 153, 50);
		contentPane.add(btnLoginToExisting);
		
		
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

