package tiago.projetos.pj0925.view;

import tiago.projetos.pj0925.controller.*;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class CadastroFuncionario {

	private JFrame frame;
	private JPanel container;
	private JScrollPane scroll;
	private ControllerFuncionario cF;
	private ControllerProfessor cP;
	private ArrayList<JTextField> arrayTextFilhos;
	private ArrayList<JTextField> arrayTextDatas;
	private ArrayList<JLabel> arrayLabels;
	
	private Border simValidou;
	
	private JTextArea textEndereço;
	private JTextField textCadastro, textNome, textCpf, textData, textTelefone, textEMail, textFilhos, textSalario, textVT, textVR, textVA;
	private JComboBox<String> boxCargo, boxDisciplina;
	private JButton botaoCadastrar, botaoLimpar;
	private JRadioButton botaoMale, botaoFemale;
	String filhosAntes;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionario window = new CadastroFuncionario();
					window.frame.setVisible(true);
				} catch (Exception e) {
				}
			}
		});
	}

	public CadastroFuncionario() {
		
		arrayTextFilhos = new ArrayList<JTextField>();
		arrayTextDatas = new ArrayList<JTextField>();
		arrayLabels = new ArrayList<JLabel>();
		boxCargo = new JComboBox<String>();
		boxCargo.setRenderer(new DefaultListCellRenderer() {
	        @Override
	        public void paint(Graphics g) {
	            setForeground(Color.BLACK);
	            super.paint(g);
	        }
	    });
		iniciaJanela();
		filhosAntes = "";
	}
	
	public JFrame getFrame(){
		return frame;
	}

	private void iniciaJanela() {
		ControllerUtil u = new ControllerUtil();
		cF = new ControllerFuncionario();
		cP = new ControllerProfessor();
		simValidou = BorderFactory.createLineBorder(Color.GREEN);
		
		container = new JPanel();
		container.setLayout(null);
		container.setLocation(0,0);
		container.setPreferredSize(new Dimension(750, 385));
		
		scroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setSize(800,385);
		scroll.setLocation(0, 100);
		scroll.getViewport().add(container);
		
		frame = new JFrame("Cadastro");
		frame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				if(!Menu.editando){
					if(!Menu.adicionando){
						frame.setVisible(false);
						resetaBotao();
					}
				}
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				Menu.adicionando = false;
				Menu.editando = false;
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
			}
		});
		frame.setResizable(false);
		frame.setSize(785, 451);
		frame.setLocation(200, 200);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().add(scroll);
		
		//lblCadastro.setBounds(33, 20, 100, 14);
		//lblCadastro2.setBounds(35, 35, 100, 14);
		// text Bounds(120, 30, 250, 20);
		
		JLabel lblNome = new JLabel("Nome:* ");
		lblNome.setBounds(45, 65, 100, 14);
		container.add(lblNome);
		textNome = new JTextField("ex: José");
		Border defaultBorder = textNome.getBorder();
		textNome.setForeground(Color.gray);
		textNome.addFocusListener(u.focusListenNome(textNome, "ex: José"));			
		textNome.setBounds(120, 65, 250, 20);
		container.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:* ");
		lblCpf.setBounds(52, 100, 100, 14);
		container.add(lblCpf);
		textCpf = new JTextField("ex: 12345678901");
		textCpf.setForeground(Color.gray);
		textCpf.addFocusListener(u.focusListenCpf(textCpf));
		textCpf.setBounds(120, 100, 250, 20);
		container.add(textCpf);
		textCpf.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:* ");
		lblSexo.setBounds(47, 135, 46, 14);
		container.add(lblSexo);
		
		JLabel lblMale = new JLabel("Masculino");
		lblMale.setBounds(168, 135, 60, 14);
		container.add(lblMale);
		
		botaoMale = new JRadioButton("");
		botaoMale.setBounds(148, 132, 20, 23);
		container.add(botaoMale);
		
		JLabel lblFemale = new JLabel("Feminino");
		lblFemale.setBounds(285, 135, 60, 14);
		container.add(lblFemale);
		
		botaoFemale = new JRadioButton("");
		botaoFemale.setBounds(265, 132, 20, 23);
		container.add(botaoFemale);
		
		
		JLabel lblData = new JLabel("Data de");
		lblData.setBounds(40, 165, 100, 14);
		container.add(lblData);
		JLabel lblData2 = new JLabel("Nascimento:* ");
		lblData2.setBounds(30, 180, 100, 14);
		container.add(lblData2);
		textData = new JTextField("dd/mm/aaaa");
		textData.setForeground(Color.gray);
		textData.addFocusListener(u.focusListenData(textData, "dd/mm/aaaa"));
		textData.setBounds(120, 170, 250, 20);
		container.add(textData);
		textData.setColumns(10);
		
		JLabel lblEndereço = new JLabel("Endereço:* ");
		lblEndereço.setBounds(405, 65, 80, 14);
		container.add(lblEndereço);
				
		textEndereço = new JTextArea("ex: R. Ayrton Senna da Silva, 500\nEdifício Torre di Pietra - 3° andar - sala - 303");
		textEndereço.setBounds(485, 65, 250, 125);
		Border border = BorderFactory.createLineBorder(Color.GRAY);
		textEndereço.setForeground(Color.gray);
		textEndereço.addFocusListener(u.focusListenEndereço(textEndereço, "ex: R. Ayrton Senna da Silva, 500\nEdifício Torre di Pietra - 3° andar - sala - 303"));
	    textEndereço.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
	    container.add(textEndereço);	
		
		JLabel lblDisciplina = new JLabel("Disciplina:* ");
		lblDisciplina.setBounds(405, 205, 67, 14);
		container.add(lblDisciplina);
		lblDisciplina.setVisible(false);
		
		boxDisciplina = new JComboBox<String>();
		boxDisciplina.addItem("Selecionar...");
		boxDisciplina.addItem("Banco de Dados");
		boxDisciplina.addItem("Front-end");
		boxDisciplina.addItem("Java WEB");
		boxDisciplina.addItem("Linguagem de Programação Java");
		boxDisciplina.addItem("Outros");
		boxDisciplina.setBounds(485, 205, 250, 20);
		container.add(boxDisciplina);
		boxDisciplina.setVisible(false);
		
		JLabel lblCargo = new JLabel("Cargo:* ");
		lblCargo.setBounds(45, 205, 67, 14);
		container.add(lblCargo);
		
		boxCargo.addItem("Selecionar...");
		boxCargo.addItem("Professor");
		boxCargo.addItem("Analista Mainframe");
		boxCargo.addItem("Analista Baixa Plataforma");
		boxCargo.addItem("Programador Mainframe");
		boxCargo.addItem("Programador Baixa Plataforma");
		boxCargo.addItem("Líder de Projetos");
		boxCargo.addItem("Gerente");
		boxCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(boxCargo.getSelectedItem().equals("Professor")){
					boxDisciplina.setVisible(true);
					lblDisciplina.setVisible(true);
				} else {
				boxDisciplina.setVisible(false);
				lblDisciplina.setVisible(false);
				boxDisciplina.setSelectedItem("Selecionar...");
				}
			}
		});
		boxCargo.setBounds(120, 205, 250, 20);
		container.add(boxCargo);
		
		JLabel lblSalario = new JLabel("Salario:* ");
		lblSalario.setBounds(41, 240, 67, 14);
		container.add(lblSalario);
		
		textSalario = new JTextField("ex: 400,00");
		textSalario.setForeground(Color.gray);
		textSalario.addFocusListener(u.focusListenDouble(textSalario, "ex: 400,00"));			
		textSalario.setBounds(120, 240, 250, 20);
		container.add(textSalario);
		textSalario.setColumns(10);
		
		JLabel lblVA = new JLabel("Vale  ");
		lblVA.setBounds(423, 231, 80, 14);
		container.add(lblVA);
		JLabel lblVA2 = new JLabel("Alimentação:");
		lblVA2.setBounds(402, 247, 80, 14);
		container.add(lblVA2);
		textVA = new JTextField("ex: 400,00");
		textVA.setForeground(Color.gray);
		textVA.addFocusListener(u.focusListenDouble(textVA, "ex: 400,00"));
		textVA.setBounds(485, 240, 250, 20);
		container.add(textVA);
		textVA.setColumns(10);
		
		JLabel lblVR = new JLabel("Vale ");
		lblVR.setBounds(51, 266, 58, 14);
		container.add(lblVR);
		JLabel lblVR2 = new JLabel("Refeição: ");
		lblVR2.setBounds(39, 282, 58, 14);
		container.add(lblVR2);
		textVR = new JTextField("ex: 400,00");
		textVR.setForeground(Color.gray);
		textVR.addFocusListener(u.focusListenDouble(textVR, "ex: 400,00"));	
		textVR.setBounds(120, 275, 250, 20);
		container.add(textVR);
		textVR.setColumns(10);
		
		JLabel lblVT = new JLabel("Vale  ");
		lblVT.setBounds(423, 266, 80, 14);
		container.add(lblVT);
		JLabel lblVT2 = new JLabel("Transporte:");
		lblVT2.setBounds(402, 282, 80, 14);
		container.add(lblVT2);
		textVT = new JTextField("ex: 400,00");
		textVT.setForeground(Color.gray);
		textVT.addFocusListener(u.focusListenDouble(textVT, "ex: 400,00"));
		textVT.setBounds(485, 275, 250, 20);
		container.add(textVT);
		textVT.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:* ");
		lblTelefone.setBounds(38, 310, 60, 14);
		container.add(lblTelefone);
		textTelefone = new JTextField("ex: 43999565338");
		textTelefone.setForeground(Color.GRAY);
		textTelefone.addFocusListener(u.focusListenInt(textTelefone, "ex: 43999565338"));
		textTelefone.setBounds(120, 310, 250, 20);
		container.add(textTelefone);
		textTelefone.setColumns(10);
		
		JLabel lblEMail = new JLabel("e-mail:* ");
		lblEMail.setBounds(414, 310, 60, 14);
		container.add(lblEMail);
		textEMail = new JTextField("ex: nome@site.com");
		textEMail.setForeground(Color.GRAY);
		textEMail.addFocusListener(u.focusListenEmail(textEMail, "ex: nome@site.com"));
		textEMail.setBounds(485, 310, 250, 20);
		container.add(textEMail);
		textEMail.setColumns(10);
		
		JLabel lblFilhos = new JLabel("Número de ");
		lblFilhos.setBounds(30, 337, 100, 14);
		container.add(lblFilhos);
		JLabel lblFilhos2 = new JLabel("filhos:* ");
		lblFilhos2.setBounds(45, 350, 100, 14);
		container.add(lblFilhos2);
		textFilhos = new JTextField("ex: 2");
		textFilhos.setForeground(Color.GRAY);
		textFilhos.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(textFilhos.getText().isEmpty() || textFilhos.getText().equals("ex: 2")){
					textFilhos.setBorder(defaultBorder);
					textFilhos.setForeground(Color.GRAY);
					textFilhos.setText("ex: 2");
				} else {
					if (!filhosAntes.equals(textFilhos.getText())) {
						if (!filhosAntes.equals("")){
							if (Integer.parseInt(textFilhos.getText()) < Integer.parseInt(filhosAntes)){
								for (int i = (Integer.parseInt(filhosAntes)-1); i > (Integer.parseInt(textFilhos.getText())-1); i--){
									container.remove(arrayTextFilhos.get(i));
									container.remove(arrayTextDatas.get(i));
									for (int j = 2; j >=0; j--){
										container.remove(arrayLabels.get((i*3)+j));
										arrayLabels.remove((i*3)+j);
									}
									arrayTextFilhos.remove(i);
									arrayTextDatas.remove(i);
								}
							}
						}
						textFilhos.setBorder(simValidou);
						container.setPreferredSize(new Dimension(750, ((35*Integer.parseInt(textFilhos.getText()))+385)));
						scroll.setPreferredSize(new Dimension(750, ((35*Integer.parseInt(textFilhos.getText()))+385)));
						frame.pack();
						frame.setSize(785, 451);
						if (arrayTextFilhos.size() < Integer.parseInt(textFilhos.getText())){
							for (int i = arrayTextFilhos.size()+1; i <= Integer.parseInt(textFilhos.getText()); i++) {
								cF.geraFilhos(i, container, arrayTextFilhos, arrayTextDatas, arrayLabels);
							}
							for(JTextField text : arrayTextFilhos) {
								text.addFocusListener(u.focusListenNome(text, "ex: José"));
							}
							for(JTextField text : arrayTextDatas) {
								text.addFocusListener(u.focusListenData(text, "dd/mm/aaaa"));
							}
							if (textFilhos.getText().equals("0")) {
								cF.deletaFilhos(frame, container, arrayTextFilhos, arrayTextDatas, arrayLabels);
							}
						}
					}
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				textFilhos.setForeground(Color.black);
				if(textFilhos.getText().equals("ex: 2")){
					textFilhos.setText(null);
				} else {
					filhosAntes = textFilhos.getText();
				}
				textFilhos.addKeyListener(u.keyListenInt());
			}
		});
		textFilhos.setBounds(120, 345, 250, 20);
		container.add(textFilhos);
		textFilhos.setColumns(10);
		
		JLabel lblObrigatorio = new JLabel("*: campo obrigatório");
		lblObrigatorio.setBounds(550, 30, 200, 14);
		container.add(lblObrigatorio);
		
		botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setBounds(440, 342, 100, 23);
		container.add(botaoCadastrar);
		
		botaoLimpar = new JButton("Limpar");
		botaoLimpar.setBounds(620, 342, 100, 23);
		container.add(botaoLimpar);
		
		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!Menu.editando){
					if (boxCargo.getSelectedItem().toString().equals("Professor")){
						cP.botaoCadastrar(textNome.getText(), textCpf.getText(), botaoMale.isSelected(), botaoFemale.isSelected(), textData.getText(),
								textEndereço.getText(), boxCargo.getSelectedItem().toString(), boxDisciplina.getSelectedItem().toString(), textSalario.getText().replace(',','.'), textVA.getText().replace(',','.'),
								textVR.getText().replace(',','.'), textVT.getText().replace(',','.'), textTelefone.getText(), textEMail.getText(), textFilhos.getText(), arrayTextFilhos, arrayTextDatas);
						if (!Menu.adicionando) {
							cF.iniciaTabela();
						}
					} else {
						cF.botaoCadastrar(textNome.getText(), textCpf.getText(), botaoMale.isSelected(), botaoFemale.isSelected(), textData.getText(),
							textEndereço.getText(), boxCargo.getSelectedItem().toString(), boxDisciplina.getSelectedItem().toString(), textSalario.getText().replace(',','.'), textVA.getText().replace(',','.'),
							textVR.getText().replace(',','.'), textVT.getText().replace(',','.'), textTelefone.getText(), textEMail.getText(), textFilhos.getText(), arrayTextFilhos, arrayTextDatas);
					}
				} else {
					botaoCadastrar.setText("Salvar");
					if (boxCargo.getSelectedItem().equals("Professor")){
						cP.botaoEditar(textCadastro.getText(), textNome.getText(), textCpf.getText(), botaoMale.isSelected(), botaoFemale.isSelected(), textData.getText(),
								textEndereço.getText(), boxCargo.getSelectedItem().toString(), boxDisciplina.getSelectedItem().toString(), textSalario.getText().replace(',','.'), textVA.getText().replace(',','.'),
								textVR.getText().replace(',','.'), textVT.getText().replace(',','.'), textTelefone.getText(), textEMail.getText(), textFilhos.getText(), arrayTextFilhos, arrayTextDatas);
						if (!Menu.editando) {
							cP.iniciaTabela();
							cF.iniciaTabela();
						}
					} else {
						cF.botaoEditar(textNome.getText(), textCpf.getText(), botaoMale.isSelected(), botaoFemale.isSelected(), textData.getText(),
							textEndereço.getText(), boxCargo.getSelectedItem().toString(), boxDisciplina.getSelectedItem().toString(), textSalario.getText().replace(',','.'), textVA.getText().replace(',','.'),
							textVR.getText().replace(',','.'), textVT.getText().replace(',','.'), textTelefone.getText(), textEMail.getText(), textFilhos.getText(), arrayTextFilhos, arrayTextDatas);
					}
				}
			}
		});
		
		botaoLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cF.botaoLimpar(frame, container, textNome, textCpf, textData, textEndereço, textSalario, 
						textVA, textVR, textVT, textTelefone, textEMail, textFilhos, arrayTextFilhos, arrayTextDatas, arrayLabels, 
						boxCargo, boxDisciplina, botaoMale, botaoFemale);	
			}
		});
		
		botaoFemale.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				botaoMale.setSelected(false);
			}
		});
		
		botaoMale.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				botaoFemale.setSelected(false);
			}
		});
    }
	
	public JButton getBotaoLimpar() {
		return this.botaoLimpar;
	}
	
	public ControllerFuncionario getCF(){
		return this.cF;
	}
	
	public ControllerProfessor getCP(){
		return this.cP;
	}
	
	public void preencheCampoFuncionário(String cadastro, String nome, String cpf, String data, String endereço, String salario, String vA, String vR, String vT, String telefone, String email, int filhos, char sexo, String cargo) {
		ControllerUtil u = new ControllerUtil();
		if (Menu.editando) {
			botaoCadastrar.setText("Salvar");
		}
		//textCadastro.setEditable(false);
		//textCadastro.setForeground(Color.black);
		textNome.setForeground(Color.black);
		textCpf.setForeground(Color.black);
		textData.setForeground(Color.black);
		textEndereço.setForeground(Color.black);
		textSalario.setForeground(Color.black);
		textVA.setForeground(Color.black);
		textVR.setForeground(Color.black);
		textVT.setForeground(Color.black);
		textTelefone.setForeground(Color.black);
		textEMail.setForeground(Color.black);
		textFilhos.setForeground(Color.black);
		//textCadastro.setBorder(simValidou);
		textNome.setBorder(simValidou);
		textCpf.setBorder(simValidou);
		textData.setBorder(simValidou);
		textEndereço.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.green), BorderFactory.createEmptyBorder(2, 2, 2, 2)));
		textSalario.setBorder(simValidou);
		textVA.setBorder(simValidou);
		textVR.setBorder(simValidou);
		textVT.setBorder(simValidou);
		textTelefone.setBorder(simValidou);
		textEMail.setBorder(simValidou);
		textFilhos.setBorder(simValidou);
		//textCadastro.setText(cadastro);
		textNome.setText(nome);
		textCpf.setText(cpf);
		textData.setText(data);
		textEndereço.setText(endereço);
		textSalario.setText(salario);
		textVA.setText(vA);
		textVR.setText(vR);
		textVT.setText(vT);
		textTelefone.setText(telefone);
		textEMail.setText(email);
		textFilhos.setText("" + filhos);
		if (sexo == 'M') {
			botaoFemale.setSelected(false);
			botaoMale.setSelected(true);
		} else {
			botaoFemale.setSelected(true);
			botaoMale.setSelected(false);
		}
		boxCargo.setSelectedItem(cargo);
		boxDisciplina.setSelectedItem("Selecionar...");
		
		for (int i = arrayTextFilhos.size()+1; i <= filhos; i++) {
			cF.geraFilhosEditar(cF.getArrayDisplay().get(Menu.pessoaEditada).getCadastroFilhos(), i, container, arrayTextFilhos, arrayTextDatas, arrayLabels);
		}
		for(JTextField text : arrayTextFilhos) {
			text.addFocusListener(u.focusListenNome(text, "ex: José"));
		}
		for(JTextField text : arrayTextDatas) {
			text.addFocusListener(u.focusListenData(text, "dd/mm/aaaa"));
		}
		
		for(JTextField text : arrayTextDatas) {
			container.add(text);
		}
		for(JTextField text : arrayTextFilhos) {
			container.add(text);
		}
		for(JLabel label : arrayLabels) {
			container.add(label);
		}
		container.setPreferredSize(new Dimension(750, (filhos*35)+385));
		scroll.setPreferredSize(new Dimension(750, (filhos*35)+385));
		frame.pack();
		frame.setSize(785, 451);
	}

	public void preencheCampoProfessor(String cadastro, String nome, String cpf, String data, String endereço,
			String salario, String vA, String vR, String vT, String telefone, String email, int filhos, char sexo,
			String cargo, String disciplina) {
		ControllerUtil u = new ControllerUtil();
		if (Menu.editando) {
			botaoCadastrar.setText("Salvar");
		}
		textCadastro.setEditable(false);
		textCadastro.setForeground(Color.black);
		textNome.setForeground(Color.black);
		textCpf.setForeground(Color.black);
		textData.setForeground(Color.black);
		textEndereço.setForeground(Color.black);
		textSalario.setForeground(Color.black);
		textVA.setForeground(Color.black);
		textVR.setForeground(Color.black);
		textVT.setForeground(Color.black);
		textTelefone.setForeground(Color.black);
		textEMail.setForeground(Color.black);
		textFilhos.setForeground(Color.black);
		textCadastro.setBorder(simValidou);
		textNome.setBorder(simValidou);
		textCpf.setBorder(simValidou);
		textData.setBorder(simValidou);
		textEndereço.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.green), BorderFactory.createEmptyBorder(2, 2, 2, 2)));
		textSalario.setBorder(simValidou);
		textVA.setBorder(simValidou);
		textVR.setBorder(simValidou);
		textVT.setBorder(simValidou);
		textTelefone.setBorder(simValidou);
		textEMail.setBorder(simValidou);
		textFilhos.setBorder(simValidou);
		textCadastro.setText(cadastro);
		textNome.setText(nome);
		textCpf.setText(cpf);
		textData.setText(data);
		textEndereço.setText(endereço);
		textSalario.setText(salario);
		textVA.setText(vA);
		textVR.setText(vR);
		textVT.setText(vT);
		textTelefone.setText(telefone);
		textEMail.setText(email);
		textFilhos.setText("" + filhos);
		if (sexo == 'M') {
			botaoFemale.setSelected(false);
			botaoMale.setSelected(true);
		} else {
			botaoFemale.setSelected(true);
			botaoMale.setSelected(false);
		}
		boxCargo.setSelectedItem(cargo);
		boxDisciplina.setSelectedItem(disciplina);
		
		for (int i = arrayTextFilhos.size()+1; i <= filhos; i++) {
			cF.geraFilhosEditar(cP.getArrayDisplay().get(Menu.pessoaEditada).getCadastroFilhos(), i, container, arrayTextFilhos, arrayTextDatas, arrayLabels);
		}
		for(JTextField text : arrayTextFilhos) {
			text.addFocusListener(u.focusListenNome(text, "ex: José"));
		}
		for(JTextField text : arrayTextDatas) {
			text.addFocusListener(u.focusListenData(text, "dd/mm/aaaa"));
		}
		
		for(JTextField text : arrayTextDatas) {
			container.add(text);
		}
		for(JTextField text : arrayTextFilhos) {
			container.add(text);
		}
		for(JLabel label : arrayLabels) {
			container.add(label);
		}
		container.setPreferredSize(new Dimension(750, (filhos*35)+385));
		scroll.setPreferredSize(new Dimension(750, (filhos*35)+385));
		frame.pack();
		frame.setSize(785, 451);
	}
	
	public void resetaBotao(){
		//textCadastro.setEditable(true);
		boxCargo.setEnabled(true);
		botaoCadastrar.setText("Cadastrar");
	}
	
	public void setBoxCargo(){
		boxCargo.setSelectedItem("Professor");
		boxCargo.setEnabled(false);
		boxCargo.setForeground(Color.BLACK);
	}
	
}
