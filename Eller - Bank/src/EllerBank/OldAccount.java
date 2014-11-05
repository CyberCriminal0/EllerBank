package EllerBank;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OldAccount extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;


	public OldAccount() {
		setTitle("Bank");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);

		
		JLabel lblLoginInfo = new JLabel("Login Info");
		lblLoginInfo.setBounds(155, 11, 135, 107);
		lblLoginInfo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lblLoginInfo);
		
		textField = new JTextField();
		textField.setBounds(46, 155, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(300, 155, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setBounds(46, 124, 109, 20);
		contentPane.add(lblAccountNumber);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(300, 124, 86, 31);
		contentPane.add(lblFirstName);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BankDatabase bank = new BankDatabase();
				bank.getAccount(textField.getText(), textField_1.getText());
				String temp = bank.getOutput();
				int acnt = Integer.parseInt(temp);
				bankScreen user = new bankScreen(acnt, bank.getBal());
				user.setVisible(true);
				dispose();
			}
		});
		btnSubmit.setBounds(173, 183, 89, 23);
		contentPane.add(btnSubmit);
	}
}
