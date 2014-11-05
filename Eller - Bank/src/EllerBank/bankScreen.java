package EllerBank;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bankScreen extends JFrame {

	private JPanel contentPane;
	private JTextField Deposit;
	private JTextField AmountSend;
	private JTextField AccountSend;
	double balance;


	
	public bankScreen(final int Account, final double bal) {
		balance = bal;
		setTitle("Bank");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBalance.setBounds(33, 53, 167, 57);
		contentPane.add(lblBalance);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setBounds(108, 10, 196, 32);
		contentPane.add(textArea);
		
		final JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		textArea_1.setEditable(false);
		textArea_1.setBounds(190, 53, 207, 57);
		contentPane.add(textArea_1);
		
		Deposit = new JTextField();
		Deposit.setBounds(53, 144, 86, 20);
		contentPane.add(Deposit);
		Deposit.setColumns(10);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String deposit = Deposit.getText();
				double dep = Double.parseDouble(deposit);
				double newBal = balance + dep;
				balance = newBal;
				appendBal(textArea_1, newBal);
				editAccount edit = new editAccount();
				edit.setUser(Account, newBal);
				
			}
		});
		btnDeposit.setBounds(50, 175, 89, 23);
		contentPane.add(btnDeposit);
		
		
		
		
		AmountSend = new JTextField();
		AmountSend.setBounds(190, 144, 86, 20);
		contentPane.add(AmountSend);
		AmountSend.setColumns(10);
		
		AccountSend = new JTextField();
		AccountSend.setBounds(288, 144, 86, 20);
		contentPane.add(AccountSend);
		AccountSend.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(212, 119, 46, 14);
		contentPane.add(lblAmount);
		
		JLabel lblAccount = new JLabel("Account");
		lblAccount.setBounds(304, 121, 70, 14);
		contentPane.add(lblAccount);
		
		JLabel lblAmount_1 = new JLabel("Amount");
		lblAmount_1.setBounds(73, 121, 46, 14);
		contentPane.add(lblAmount_1);
		
		textArea.append("Account: " + Account);
		textArea_1.append("$"+bal);
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String SendAmount = AmountSend.getText();
				String SendAddress = AccountSend.getText();
				double dep = Double.parseDouble(SendAmount);
				int accnt = Integer.parseInt(SendAddress);
				balance = balance-dep;
				double newBal = balance;
				appendBal(textArea_1, newBal);
				editAccount edit = new editAccount();
				BankDatabase bankData = new BankDatabase();
				bankData.getAccount(SendAddress, " ");
				double userBal = (bankData.getBal()+dep);
				edit.setUser(accnt, userBal);
			}
		});
		btnNewButton.setBounds(246, 175, 89, 23);
		contentPane.add(btnNewButton);
		
	}
	public void appendBal(JTextArea text, double bal){
		text.setText("$"+bal);
	}
}
