package br.edu.devmedia.jdbc.gui;


import java.util.List;

import br.edu.devmedia.jdbc.dto.UfDTO;
import br.edu.devmedia.jdbc.exception.NegocioException;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.devmedia.jdbc.bo.PessoaBO;
import br.edu.devmedia.jdbc.bo.UfBO;
import br.edu.devmedia.jdbc.dto.EnderecoDTO;
import br.edu.devmedia.jdbc.dto.PessoaDTO;
import br.edu.devmedia.jdbc.util.MensagensUtil;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import javax.swing.border.TitledBorder;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5153988559303364191L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtEndereco;
	private JTextField txtNasc;
	
	
	private JTable tableListagem;
	private JTextField txtNomeConsulta;
	private JTextField txtCpfConsulta;
	
	private JTable tableConsulta;
	
	private JRadioButton rdbOrderNome;
	private JRadioButton rdbOrderCPF;

	JRadioButton rdbMasculinoConsulta = new JRadioButton("Masculino");
	private JTable tableListConsulta_1;
	private List<Integer> idPessoas = new ArrayList<Integer>();
	JRadioButton rdbMasculino = new JRadioButton("Masculino");
	JRadioButton rdbFeminino = new JRadioButton("Feminino");
	
	public JTable getTableConsulta() {

		String nome = txtNomeConsulta.getText();
		Long cpf = txtCpfConsulta.getText().equals("") ? null :Long.parseLong( txtCpfConsulta.getText());
		char sexo = rdbMasculinoConsulta.isSelected() ? 'M' : 'F';
		String orderBY =  rdbOrderNome.isSelected() ? "nome" : "cpf";

		if(tableListConsulta_1 == null) {
			tableListConsulta_1 = new JTable();
		} else {
			PessoaBO pessoaBO2 = new PessoaBO();
			try {
				String[][] lista = pessoaBO2.listaConsulta(nome, cpf, sexo, orderBY);
				TableModel tableListConsultaModel = 
						new DefaultTableModel(
								lista,
								new String[] { "Id", "Nome", "CPF", "Endereço", "Sexo", "Dt. Nasc." });
				tableListConsulta_1.setModel(tableListConsultaModel);
			} catch (Exception e) {
				e.printStackTrace();
				MensagensUtil.addMsg(MainFrame.this, e.getMessage());
			}
		}
		return tableConsulta;
	}
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the frame.
	 */
	
	public MainFrame() {
		setTitle("Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JTabbedPane mainTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(mainTabbedPane)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(15)
					.addComponent(mainTabbedPane, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(67, Short.MAX_VALUE))
		);
		
		JPanel panelListagem = new JPanel();
		mainTabbedPane.addTab("Listagem", null, panelListagem, null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnDeletarTodos = new JButton("Deletar Todos");
		btnDeletarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PessoaBO pessoaBO = new PessoaBO();
				try {
					int resp = JOptionPane.showConfirmDialog(MainFrame.this, "Deseja Realmemte Excluir Todos?");
					if (resp == 0){
						pessoaBO.removeTudo();
						MensagensUtil.addMsg(MainFrame.this, "Pessoas Removidas com Sucesso!");
						getTableConsulta();
					}
				
				} 
				catch (NegocioException e1) {
					e1.printStackTrace();
					MensagensUtil.addMsg(MainFrame.this, "Pessoas Removidas com Sucesso!");
				}
			}
		});
		btnDeletarTodos.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_panelListagem = new GroupLayout(panelListagem);
		gl_panelListagem.setHorizontalGroup(
			gl_panelListagem.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelListagem.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelListagem.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
						.addComponent(btnDeletarTodos, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_panelListagem.setVerticalGroup(
			gl_panelListagem.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelListagem.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDeletarTodos)
					.addGap(12))
		);
		
		tableListagem = new JTable();
		final PessoaBO pessoaBO = new PessoaBO();
		try {
			String[][] lista = pessoaBO.listagem(idPessoas);
			tableListagem.setModel(new DefaultTableModel(
					lista,
					new String[]{
							"Id","Nome","CPF", "Endereco","Sexo","Dt. Nasc", " ", " "
					}
					));
			
			Action actionDelecao = new AbstractAction() {
				public void actionPerformed(ActionEvent actionEvent) {

					int resp = JOptionPane.showConfirmDialog(MainFrame.this, "Deseja realmente Deletar?");

					if(resp == 0){
						JTable table = (JTable) actionEvent.getSource();

						//Metodo que retorna um inteiro, referente a linha da table que foi clicada
						int linha = Integer.parseInt(actionEvent.getActionCommand());

						((DefaultTableModel) table.getModel()).removeRow(linha);
						try {
							pessoaBO.removePessoa(idPessoas.get(linha));
							idPessoas.remove(linha);
							MensagensUtil.addMsg(MainFrame.this, "Pessoa Removida com Sucesso!");
						} 
						catch (NegocioException e) {
							e.printStackTrace();
							MensagensUtil.addMsg(MainFrame.this, e.getMessage());
						}
					}	
				}
			};
			
			Action actionEdicao = new AbstractAction() {
				public void actionPerformed(ActionEvent actionEvent) {
					int linha = Integer.parseInt(actionEvent.getActionCommand());
					try {
						PessoaDTO pessoaDTO = pessoaBO.buscaPorId(idPessoas.get(linha));
					} 
					catch (NegocioException e) {
						e.printStackTrace();
						MensagensUtil.addMsg(MainFrame.this,  e.getMessage());
					}
				}


			};

			ButtonColumn buttonColumnDelecao = new ButtonColumn(tableListagem, actionDelecao, 7);
			ButtonColumn buttonColumnEdicao = new ButtonColumn(tableListagem, actionEdicao, 6);
			//Atalhos ALT + alguma tecla
			buttonColumnDelecao.setMnemonic(KeyEvent.VK_D);
			buttonColumnEdicao.setMnemonic(KeyEvent.VK_A);


		} catch (Exception e) {
			e.printStackTrace();
		}

		scrollPane.setViewportView(tableListagem);
		panelListagem.setLayout(gl_panelListagem);
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setToolTipText("");
		mainTabbedPane.addTab("Cadastro", null, panelCadastro, null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PessoaDTO pessoaDTO = new PessoaDTO();
				PessoaBO pessoaBO = new PessoaBO();
				
				try {
					
					
					//Validação dos Campos
					String nome = txtNome.getText();
					String cpf = txtCPF.getText();
					String endereco = txtEndereco.getText();
					String nasc = txtNasc.getText();
					
					pessoaBO.validaNome(nome);
					pessoaBO.validaCPF(cpf);
					pessoaBO.validaEndereco(endereco);
					pessoaBO.validaNasc(nasc);
					/*******************************/
					pessoaDTO.setNome(nome);
					pessoaDTO.setEndereco(endereco);
					pessoaDTO.setCpf(Long.parseLong(cpf));
					pessoaDTO.setDtNascimento(nasc);
					
					char sexo = rdbMasculino.isSelected() ? 'M' : 'F';
					pessoaDTO.setSexo(sexo);
					
					
					pessoaBO.cadastrar(pessoaDTO);
					MensagensUtil.addMsg(MainFrame.this, "Cadastro Efetuado Com Sucesso!");
					MainFrame.this.dispose();
					main(null);
				} 
				catch (Exception e1) {
					e1.printStackTrace();
					MensagensUtil.addMsg(MainFrame.this, e1.getMessage());
				} 
}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNome.setText("");
				txtCPF.setText("");
				txtEndereco.setText("");
				txtNasc.setText("");
				rdbMasculino.setSelected(true);
				rdbFeminino.setSelected(false);
			}
		});
		
		
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JPanel panelCadastroPrincipal = new JPanel();
		panelCadastroPrincipal.setBorder(new TitledBorder(null, "Cadastro Principal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		
		
		GroupLayout gl_panelCadastro = new GroupLayout(panelCadastro);
		gl_panelCadastro.setHorizontalGroup(
			gl_panelCadastro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCadastro.createSequentialGroup()
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panelCadastro.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnLimpar)
							.addGap(18)
							.addComponent(btnCadastrar))
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelCadastroPrincipal, GroupLayout.PREFERRED_SIZE, 575, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_panelCadastro.setVerticalGroup(
			gl_panelCadastro.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelCadastro.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelCadastroPrincipal, GroupLayout.PREFERRED_SIZE, 251, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnLimpar))
					.addGap(109))
		);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		
		JLabel lblNasc = new JLabel("Dt. Nasc:");
		lblNasc.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtNasc = new JTextField();
		txtNasc.setColumns(10);
		
		
		rdbMasculino.setSelected(true);
		rdbMasculino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		rdbMasculino.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
		rdbFeminino.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_panelCadastroPrincipal = new GroupLayout(panelCadastroPrincipal);
		gl_panelCadastroPrincipal.setHorizontalGroup(
			gl_panelCadastroPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCadastroPrincipal.createSequentialGroup()
					.addGroup(gl_panelCadastroPrincipal.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCadastroPrincipal.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNome))
						.addGroup(gl_panelCadastroPrincipal.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEndereo))
						.addGroup(gl_panelCadastroPrincipal.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblCPF))
						.addGroup(gl_panelCadastroPrincipal.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelCadastroPrincipal.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbMasculino)
								.addComponent(lblNasc))))
					.addGroup(gl_panelCadastroPrincipal.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCadastroPrincipal.createSequentialGroup()
							.addGap(17)
							.addGroup(gl_panelCadastroPrincipal.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNasc, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelCadastroPrincipal.createParallelGroup(Alignment.LEADING, false)
									.addComponent(txtEndereco)
									.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))))
						.addGroup(gl_panelCadastroPrincipal.createSequentialGroup()
							.addGap(36)
							.addComponent(rdbFeminino)))
					.addGap(186))
		);
		gl_panelCadastroPrincipal.setVerticalGroup(
			gl_panelCadastroPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCadastroPrincipal.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_panelCadastroPrincipal.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_panelCadastroPrincipal.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCPF)
						.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelCadastroPrincipal.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbMasculino)
						.addComponent(rdbFeminino))
					.addGap(18)
					.addGroup(gl_panelCadastroPrincipal.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNasc)
						.addComponent(txtNasc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(gl_panelCadastroPrincipal.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEndereo)
						.addComponent(txtEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panelCadastroPrincipal.setLayout(gl_panelCadastroPrincipal);
		panelCadastro.setLayout(gl_panelCadastro);
		
		JPanel panelConsulta = new JPanel();
		mainTabbedPane.addTab("Consulta", null, panelConsulta, null);
		
		JLabel lblNomeConsulta = new JLabel("Nome:");
		lblNomeConsulta.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtNomeConsulta = new JTextField();
		txtNomeConsulta.setColumns(10);
		
		txtCpfConsulta = new JTextField();
		txtCpfConsulta.setColumns(10);
		
		JLabel label = new JLabel("CPF:");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
		rdbMasculinoConsulta.setSelected(true);
		rdbMasculinoConsulta.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JRadioButton rbdFemininoConsulta = new JRadioButton("Feminino");
		rbdFemininoConsulta.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getTableConsulta();
			}
		});
		
		
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JPanel panelTabelaList = new JPanel();
		panelTabelaList.setBorder(new TitledBorder(null, "Listagem", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblOrderBy = new JLabel("Order By:");
		lblOrderBy.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		rdbOrderNome = new JRadioButton("Nome");
		rdbOrderNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		rdbOrderCPF = new JRadioButton("CPF");
		rdbOrderCPF.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_panelConsulta = new GroupLayout(panelConsulta);
		gl_panelConsulta.setHorizontalGroup(
			gl_panelConsulta.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelConsulta.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelConsulta.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelTabelaList, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panelConsulta.createSequentialGroup()
							.addComponent(rdbMasculinoConsulta, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(16)
							.addComponent(rbdFemininoConsulta, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnConsultar))
						.addGroup(Alignment.LEADING, gl_panelConsulta.createSequentialGroup()
							.addComponent(lblNomeConsulta, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtNomeConsulta, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtCpfConsulta, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_panelConsulta.createSequentialGroup()
							.addGroup(gl_panelConsulta.createSequentialGroup()
								.addGap(65)
								.addComponent(rdbOrderNome))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbOrderCPF))
						.addComponent(lblOrderBy, Alignment.LEADING))
					.addContainerGap())
		);
		gl_panelConsulta.setVerticalGroup(
			gl_panelConsulta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelConsulta.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_panelConsulta.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeConsulta)
						.addComponent(txtNomeConsulta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(txtCpfConsulta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_panelConsulta.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnConsultar, Alignment.LEADING)
						.addGroup(Alignment.LEADING, gl_panelConsulta.createParallelGroup(Alignment.LEADING)
							.addComponent(rdbMasculinoConsulta)
							.addComponent(rbdFemininoConsulta)))
					.addGap(18)
					.addGroup(gl_panelConsulta.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOrderBy)
						.addComponent(rdbOrderNome)
						.addComponent(rdbOrderCPF))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelTabelaList, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		
		
		JScrollPane scrollPaneConsulta = new JScrollPane();
		GroupLayout gl_panelTabelaList = new GroupLayout(panelTabelaList);
		gl_panelTabelaList.setHorizontalGroup(
			gl_panelTabelaList.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTabelaList.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneConsulta, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE))
		);
		gl_panelTabelaList.setVerticalGroup(
			gl_panelTabelaList.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTabelaList.createSequentialGroup()
					.addGap(2)
					.addComponent(scrollPaneConsulta, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
		);
		
		
		
		
		scrollPaneConsulta.setViewportView(tableConsulta);
		
		tableListConsulta_1 = new JTable();
		scrollPaneConsulta.setColumnHeaderView(tableListConsulta_1);
		panelTabelaList.setLayout(gl_panelTabelaList);
		panelConsulta.setLayout(gl_panelConsulta);
		contentPane.setLayout(gl_contentPane);
		
		
	}
	
	private static String[] converteEstados(List<UfDTO> lista){
		String[] resultado = new String[lista.size()];
		
		for(int i = 0; i < lista.size(); i++){
			UfDTO ufDTO = lista.get(i);
			resultado[i] = ufDTO.getDescricao();
		}
		return resultado;
	}
	
	
}
