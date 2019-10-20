package br.edu.devmedia.jdbc.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import br.edu.devmedia.jdbc.bo.LoginBO;
import br.edu.devmedia.jdbc.dto.LoginDTO;
import br.edu.devmedia.jdbc.exception.NegocioException;
import br.edu.devmedia.jdbc.util.MensagensUtil;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3227773657377371171L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JButton btnSair;
	private JPasswordField passSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JButton btnLogin = new JButton("Logar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginDTO loginDTO = new LoginDTO();
				loginDTO.setNome(txtLogin.getText());
				loginDTO.setSenha(new String (passSenha.getPassword()));
				
				LoginBO loginBO = new LoginBO();
				try 
				{
					if(loginBO.logar(loginDTO)){
						LoginFrame.this.dispose();
						MainFrame mainFrame = new MainFrame();
						mainFrame.setLocationRelativeTo(null);
						mainFrame.setVisible(true);
					}
					else{
						MensagensUtil.addMsg(LoginFrame.this, "Dados Invalidos");
					}
				} 
				catch (NegocioException e1) {
					e1.printStackTrace();
					MensagensUtil.addMsg(LoginFrame.this, e1.getMessage());
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Login", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panelLogin, GroupLayout.PREFERRED_SIZE, 404, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnLogin)
							.addGap(18)
							.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelLogin, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSair)
						.addComponent(btnLogin))
					.addContainerGap())
		);
		
		JLabel lblLabel = new JLabel("Login:");
		lblLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		
		passSenha = new JPasswordField();
		GroupLayout gl_panelLogin = new GroupLayout(panelLogin);
		gl_panelLogin.setHorizontalGroup(
			gl_panelLogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLogin.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panelLogin.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblSenha, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelLogin.createParallelGroup(Alignment.LEADING, false)
						.addComponent(passSenha)
						.addComponent(txtLogin, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
					.addGap(127))
		);
		gl_panelLogin.setVerticalGroup(
			gl_panelLogin.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelLogin.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panelLogin.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_panelLogin.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSenha)
						.addComponent(passSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(62))
		);
		panelLogin.setLayout(gl_panelLogin);
		contentPane.setLayout(gl_contentPane);
	}
}
