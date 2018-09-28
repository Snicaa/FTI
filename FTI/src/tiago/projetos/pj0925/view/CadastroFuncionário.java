package tiago.projetos.pj0925.view;

import tiago.projetos.pj0925.model.*;
import tiago.projetos.pj0925.controller.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class CadastroFuncion�rio {

	private JFrame frame;
	private ArrayList<JTextField> arrayTextFilhos;
	private ArrayList<JTextField> arrayTextDatas;
	private ArrayList<JLabel> arrayLabels;
	
	private Border naoValidou;
	private Border simValidou;
	
	private JLabel lblNome;
	
	private JTextField textNome;
	private JTextField textCpf;
	private JTextField textData;
	private JTextField textTelefone;
	private JTextField textEMail;
	private JTextField textFilhos;
	private JTextField textSalario;
	private JTextField textVT;
	private JTextField textVR;
	private JTextField textVA;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncion�rio window = new CadastroFuncion�rio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadastroFuncion�rio() {
		iniciaJanela();
		arrayTextFilhos = new ArrayList<JTextField>();
		arrayTextDatas = new ArrayList<JTextField>();
		arrayLabels = new ArrayList<JLabel>();
	}

	private void iniciaJanela() {
		ControllerUtil u = new ControllerUtil();
		ControllerFuncion�rio cF = new ControllerFuncion�rio();
		naoValidou = BorderFactory.createLineBorder(Color.RED);
		simValidou = BorderFactory.createLineBorder(Color.GREEN);
		
		JPanel container = new JPanel();
		container.setLayout(null);
		container.setLocation(0,0);
		container.setPreferredSize(new Dimension(750, 350));
		
		JScrollPane scroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setSize(800,350);
		scroll.setLocation(0, 100);
		scroll.getViewport().add(container);
		
		frame = new JFrame("Cadastro");
		frame.setResizable(false);
		frame.setSize(785, 416);
		frame.setLocation(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(scroll);
		
		lblNome = new JLabel("Nome:* ");
		lblNome.setBounds(30, 30, 100, 14);
		container.add(lblNome);
		textNome = new JTextField();
		Border defaultBorder = textNome.getBorder();
		textNome.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(textNome.getText().isEmpty()){
					textNome.setBorder(defaultBorder);
					textNome.setForeground(Color.GRAY);
					textNome.setText("ex: Jos�");
				} else if(!u.validaTexto(textNome.getText())){
					textNome.setBorder(naoValidou);
				} else {
					textNome.setBorder(simValidou);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				textNome.setForeground(Color.black);
				if(textNome.getText().equals("ex: Jos�")){
					textNome.setText(null);
				}
			}
		});			
		textNome.setBounds(120, 30, 250, 20);
		container.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:* ");
		lblSexo.setBounds(30, 100, 46, 14);
		container.add(lblSexo);
		
		JLabel lblMale = new JLabel("Masculino");
		lblMale.setBounds(168, 100, 60, 14);
		container.add(lblMale);
		
		JRadioButton radioButtonMale = new JRadioButton("");
		radioButtonMale.setBounds(148, 97, 20, 23);
		container.add(radioButtonMale);
		
		JLabel lblFemale = new JLabel("Feminino");
		lblFemale.setBounds(285, 100, 60, 14);
		container.add(lblFemale);
		
		JRadioButton radioButtonFemale = new JRadioButton("");
		radioButtonFemale.setBounds(265, 97, 20, 23);
		container.add(radioButtonFemale);
		
		JLabel lblCpf = new JLabel("CPF:* ");
		lblCpf.setBounds(30, 65, 100, 14);
		container.add(lblCpf);
		textCpf = new JTextField();
		textCpf.setForeground(Color.gray);
		textCpf.setText("ex: 12345678901");
		textCpf.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(textCpf.getText().isEmpty()){
					textCpf.setForeground(Color.GRAY);
					textCpf.setBorder(defaultBorder);
					textCpf.setText("ex: 12345678901");
				} else if(!u.validaCpf(textCpf.getText())){
					textCpf.setBorder(naoValidou);
				} else {
					textCpf.setBorder(simValidou);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				textCpf.setForeground(Color.black);
				if(textCpf.getText().equals("ex: 12345678901")){
					textCpf.setText(null);
				}
				textCpf.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						u.apenasNumerosLimite(e, textCpf.getText(), 11);
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						u.apenasNumerosLimite(e, textCpf.getText(), 11);
						if (textCpf.getText().length() == 11){
							if (u.validaCpf(textCpf.getText())){
								textCpf.setBorder(simValidou);
							} else {
								textCpf.setBorder(naoValidou);
							}
						} else {
							textCpf.setBorder(naoValidou);
						}
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						u.apenasNumerosLimite(e, textCpf.getText(), 11);
					}
				});
			}
		});
		textCpf.setBounds(120, 65, 250, 20);
		container.add(textCpf);
		textCpf.setColumns(10);
		
		JLabel lblData = new JLabel("Data de");
		lblData.setBounds(40, 130, 100, 14);
		container.add(lblData);
		JLabel lblData2 = new JLabel("Nascimento:* ");
		lblData2.setBounds(30, 145, 100, 14);
		container.add(lblData2);
		textData = new JTextField();
		textData.setForeground(Color.gray);
		textData.setText("dd/mm/aaaa");
		textData.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(textData.getText().isEmpty()){
					textData.setBorder(defaultBorder);
					textData.setForeground(Color.GRAY);
					textData.setText("dd/mm/aaaa");
				} else if(!u.validaData(textData.getText())){
					textData.setBorder(naoValidou);
				} else {
					textData.setBorder(simValidou);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				textData.setForeground(Color.black);
				if(textData.getText().equals("dd/mm/aaaa")){
					textData.setText(null);
				}
			}
		});
		textData.setBounds(120, 135, 250, 20);
		container.add(textData);
		textData.setColumns(10);
		
		JLabel lblEndere�o = new JLabel("Endere�o:* ");
		lblEndere�o.setBounds(405, 30, 80, 14);
		container.add(lblEndere�o);
				
		JTextArea textEndere�o = new JTextArea();
		textEndere�o.setBounds(485, 30, 250, 125);
		Border border = BorderFactory.createLineBorder(Color.GRAY);
		textEndere�o.setForeground(Color.gray);
		textEndere�o.setText("ex: R. Ayrton Senna da Silva, 500\nEdif�cio Torre di Pietra - 3� andar - sala - 303");
		textEndere�o.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(textEndere�o.getText().isEmpty()){
					textEndere�o.setBorder(defaultBorder);
					textEndere�o.setForeground(Color.GRAY);
					textEndere�o.setText("ex: R. Ayrton Senna da Silva, 500\nEdif�cio Torre di Pietra - 3� andar - sala - 303");
				} else if(!u.validaTexto(textEndere�o.getText())){
					textEndere�o.setBorder(naoValidou);
				} else {
					textEndere�o.setBorder(simValidou);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				textEndere�o.setForeground(Color.black);
				if(textEndere�o.getText().equals("ex: R. Ayrton Senna da Silva, 500\nEdif�cio Torre di Pietra - 3� andar - sala - 303")){
					textEndere�o.setText(null);
				}
			}
		});
	    textEndere�o.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
	    container.add(textEndere�o);	
		
		JLabel lblDisciplina = new JLabel("Disciplina:* ");
		lblDisciplina.setBounds(405, 170, 67, 14);
		container.add(lblDisciplina);
		lblDisciplina.setVisible(false);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Selecionar...");
		comboBox.addItem("Banco de Dados");
		comboBox.addItem("Front-end");
		comboBox.addItem("Java WEB");
		comboBox.addItem("Linguagem de Programa��o Java");
		comboBox.addItem("Outros");
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		comboBox.setBounds(485, 170, 250, 20);
		container.add(comboBox);
		comboBox.setVisible(false);
		
		JLabel lblCargo = new JLabel("Cargo:* ");
		lblCargo.setBounds(30, 170, 67, 14);
		container.add(lblCargo);
		
		JComboBox<String> boxCargo = new JComboBox<String>();
		boxCargo.addItem("Selecionar...");
		boxCargo.addItem("Professor");
		boxCargo.addItem("Analista Mainframe");
		boxCargo.addItem("Analista Baixa Plataforma");
		boxCargo.addItem("Programador Mainframe");
		boxCargo.addItem("Programador Baixa Plataforma");
		boxCargo.addItem("L�der de Projetos");
		boxCargo.addItem("Gerente");
		boxCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(boxCargo.getSelectedItem().equals("Professor")){
					comboBox.setVisible(true);
					lblDisciplina.setVisible(true);
				} else {
				comboBox.setVisible(false);
				lblDisciplina.setVisible(false);
				comboBox.setSelectedItem("Selecionar...");
				}
			}
		});
		boxCargo.setBounds(120, 170, 250, 20);
		container.add(boxCargo);
		
		JLabel lblSalario = new JLabel("Salario:* ");
		lblSalario.setBounds(30, 205, 67, 14);
		container.add(lblSalario);
		
		textSalario = new JTextField();
		textSalario.setForeground(Color.gray);
		textSalario.setText("ex: 400.00");
		textSalario.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(textSalario.getText().isEmpty() || textSalario.getText().equals("ex: 400.00")){
					textSalario.setBorder(defaultBorder);
					textSalario.setForeground(Color.GRAY);
					textSalario.setText("ex: 400.00");
				} else if(!u.validaDouble(textSalario.getText())){
					textSalario.setBorder(naoValidou);
				} else {
					textSalario.setBorder(simValidou);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				textSalario.setForeground(Color.black);
				if(textSalario.getText().equals("ex: 400.00")){
					textSalario.setText(null);
				}
				textSalario.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						u.apenasDouble(e);
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						u.apenasDouble(e);	
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						u.apenasDouble(e);	
					}
				});
			}
		});			
		textSalario.setBounds(120, 205, 250, 20);
		container.add(textSalario);
		textSalario.setColumns(10);
		
		JLabel lblVA = new JLabel("Vale  ");
		lblVA.setBounds(423, 196, 80, 14);
		container.add(lblVA);
		JLabel lblVA2 = new JLabel("Alimenta��o:");
		lblVA2.setBounds(402, 212, 80, 14);
		container.add(lblVA2);
		textVA = new JTextField();
		textVA.setForeground(Color.gray);
		textVA.setText("ex: 400.00");
		textVA.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(textVA.getText().isEmpty() || textVA.getText().equals("ex: 400.00")){
					textVA.setBorder(defaultBorder);
					textVA.setForeground(Color.GRAY);
					textVA.setText("ex: 400.00");
				} else if(!u.validaDouble(textVA.getText())){
					textVA.setBorder(naoValidou);
				} else {
					textVA.setBorder(simValidou);
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				textVA.setForeground(Color.black);
				if(textVA.getText().equals("ex: 400.00")){
					textVA.setText(null);
				}
				textVA.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						u.apenasDouble(e);
						
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						u.apenasDouble(e);
						
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						u.apenasDouble(e);
						
					}
				});
			}
		});
		textVA.setBounds(485, 205, 250, 20);
		container.add(textVA);
		textVA.setColumns(10);
		
		JLabel lblVR = new JLabel("Vale ");
		lblVR.setBounds(51, 231, 58, 14);
		container.add(lblVR);
		JLabel lblVR2 = new JLabel("Refei��o: ");
		lblVR2.setBounds(30, 247, 58, 14);
		container.add(lblVR2);
		
		textVR = new JTextField();
		textVR.setForeground(Color.gray);
		textVR.setText("ex: 400.00");
		textVR.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(textVR.getText().isEmpty() || textVR.getText().equals("ex: 400.00")){
					textVR.setBorder(defaultBorder);
					textVR.setForeground(Color.GRAY);
					textVR.setText("ex: 400.00");
				} else if(!u.validaDouble(textVR.getText())){
					textVR.setBorder(naoValidou);
				} else {
					textVR.setBorder(simValidou);
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				textVR.setForeground(Color.black);
				if(textVR.getText().equals("ex: 400.00")){
					textVR.setText(null);
				}
				textVR.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						u.apenasDouble(e);
						
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						u.apenasDouble(e);
						
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						u.apenasDouble(e);
						
					}
				});
			}
		});		
		textVR.setBounds(120, 240, 250, 20);
		container.add(textVR);
		textVR.setColumns(10);
		
		JLabel lblVT = new JLabel("Vale  ");
		lblVT.setBounds(423, 234, 80, 14);
		container.add(lblVT);
		JLabel lblVT2 = new JLabel("Transporte:");
		lblVT2.setBounds(402, 248, 80, 14);
		container.add(lblVT2);
		textVT = new JTextField();
		textVT.setForeground(Color.gray);
		textVT.setText("ex: 400.00");
		textVT.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(textVT.getText().isEmpty() || textVT.getText().equals("ex: 400.00")){
					textVT.setBorder(defaultBorder);
					textVT.setForeground(Color.GRAY);
					textVT.setText("ex: 400.00");
				} else if(!u.validaDouble(textVT.getText())){
					textVT.setBorder(naoValidou);
				} else {
					textVT.setBorder(simValidou);
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				textVT.setForeground(Color.black);
				if(textVT.getText().equals("ex: 400.00")){
					textVT.setText(null);
				}
				textVT.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						u.apenasDouble(e);
						
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						u.apenasDouble(e);
						
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						u.apenasDouble(e);
						
					}
				});
			}
		});
		textVT.setBounds(485, 240, 250, 20);
		container.add(textVT);
		textVT.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:* ");
		lblTelefone.setBounds(30, 275, 60, 14);
		container.add(lblTelefone);
		textTelefone = new JTextField();
		textTelefone.setForeground(Color.GRAY);
		textTelefone.setText("ex: 43999565338");
		textTelefone.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(textTelefone.getText().isEmpty()){
					textTelefone.setBorder(defaultBorder);
					textTelefone.setForeground(Color.GRAY);
					textTelefone.setText("ex: 43999565338");
				} else if(!u.validaApenasNumeros(textTelefone.getText())){
					textTelefone.setBorder(naoValidou);
				} else {
					textTelefone.setBorder(simValidou);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				textTelefone.setForeground(Color.black);
				if(textTelefone.getText().equals("ex: 43999565338")){
					textTelefone.setText(null);
				}
				textTelefone.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						u.apenasNumeros(e);
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						u.apenasNumeros(e);
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						u.apenasNumeros(e);
					}
				});
			}
		});
		textTelefone.setBounds(120, 275, 250, 20);
		container.add(textTelefone);
		textTelefone.setColumns(10);
		
		JLabel lblEMail = new JLabel("e-mail:* ");
		lblEMail.setBounds(405, 275, 60, 14);
		container.add(lblEMail);
		textEMail = new JTextField();
		textEMail.setForeground(Color.GRAY);
		textEMail.setText("ex: nome@site.com");
		textEMail.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(textEMail.getText().isEmpty()){
					textEMail.setBorder(defaultBorder);
					textEMail.setForeground(Color.GRAY);
					textEMail.setText("ex: nome@site.com");
				} else if(!u.validaTexto(textEMail.getText())){
					textEMail.setBorder(naoValidou);
				} else {
					textEMail.setBorder(simValidou);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				textEMail.setForeground(Color.black);
				if(textEMail.getText().equals("ex: nome@site.com")){
					textEMail.setText(null);
				}
			}
		});
		textEMail.setBounds(485, 275, 250, 20);
		container.add(textEMail);
		textEMail.setColumns(10);
		
		JLabel lblFilhos = new JLabel("N�mero de ");
		lblFilhos.setBounds(30, 302, 100, 14);
		container.add(lblFilhos);
		JLabel lblFilhos2 = new JLabel("filhos*: ");
		lblFilhos2.setBounds(45, 315, 100, 14);
		container.add(lblFilhos2);
		textFilhos = new JTextField();
		textFilhos.setForeground(Color.GRAY);
		textFilhos.setText("ex: 2");
		textFilhos.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(textFilhos.getText().isEmpty() || textFilhos.getText().equals("ex: 2")){
					textFilhos.setBorder(defaultBorder);
					textFilhos.setForeground(Color.GRAY);
					textFilhos.setText("ex: 2");
				} else {
					textFilhos.setBorder(simValidou);
					container.setPreferredSize(new Dimension(750, ((35*Integer.parseInt(textFilhos.getText()))+350)));
					scroll.setPreferredSize(new Dimension(750, ((35*Integer.parseInt(textFilhos.getText()))+350)));
					frame.pack();
					frame.setSize(785, 416);
					for (int i = 1; i <= Integer.parseInt(textFilhos.getText()); i++) {
						String label = "Filho " + i + ": ";
						
						JLabel lbl = new JLabel(label);
						lbl.setBounds(40, (35*i)+310, 100, 14);
						container.add(lbl);
						
						JTextField texto = new JTextField();
						texto.setBounds(120, (35*i)+310, 250, 20);
						texto.setForeground(Color.gray);
						texto.setText("ex: Jos�");
						arrayTextFilhos.add(texto);
						container.add(texto);
						
						JLabel lbl1 = new JLabel("Data de");
						lbl1.setBounds(415, (35*i)+302, 100, 14);
						container.add(lbl1);
						JLabel lbl2 = new JLabel("Nascimento: ");
						lbl2.setBounds(400, (35*i)+315, 100, 14);
						container.add(lbl2);
						
						JTextField texto2 = new JTextField();
						texto2.setBounds(485, (35*i)+310, 250, 20);
						texto2.setForeground(Color.gray);
						texto2.setText("ex: dd/mm/aaaa");
						arrayTextDatas.add(texto2);
						arrayLabels.add(lbl);
						arrayLabels.add(lbl1);
						arrayLabels.add(lbl2);
						container.add(texto2);
					}
					for(JTextField text : arrayTextFilhos) {
						text.addFocusListener(new FocusListener() {
							
							@Override
							public void focusLost(FocusEvent e) {
								if(text.getText().isEmpty()){
									text.setBorder(defaultBorder);
									text.setForeground(Color.GRAY);
									text.setText("ex: Jos�");
								} else if(!u.validaTexto(text.getText())){
									text.setBorder(naoValidou);
								} else {
									text.setBorder(simValidou);
								}
							}
							
							@Override
							public void focusGained(FocusEvent e) {
								text.setForeground(Color.black);
								if(text.getText().equals("ex: Jos�")){
									text.setText(null);
								}
							}
						});
					}
					for(JTextField text : arrayTextDatas) {
						text.addFocusListener(new FocusListener() {
							
							@Override
							public void focusLost(FocusEvent e) {
								if(text.getText().isEmpty() || text.getText().equals("ex: dd/mm/aaaa")){
									text.setBorder(defaultBorder);
									text.setForeground(Color.GRAY);
									text.setText("ex: dd/mm/aaaa");
								} else if(!u.validaData(text.getText())){
									text.setBorder(naoValidou);
								} else {
									text.setBorder(simValidou);
								}
							}
							
							@Override
							public void focusGained(FocusEvent e) {
								text.setForeground(Color.black);
								if(text.getText().equals("ex: dd/mm/aaaa")){
									text.setText(null);
								}
							}
						});
					}
					if (textFilhos.getText().equals("0")) {
						for(JTextField texto : arrayTextFilhos) {
							texto.setText(null);
							container.remove(texto);
						}
						for(JTextField texto : arrayTextDatas) {
							texto.setText(null);
							container.remove(texto);
						}
						for(JLabel label : arrayLabels) {
							container.remove(label);
						}
						arrayTextFilhos.clear();
						arrayTextDatas.clear();
						arrayLabels.clear();
						frame.pack();
						frame.setSize(785, 416);
					}
//					cF.reajustaJanela(Integer.parseInt(textFilhos.getText()), container);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				textFilhos.setForeground(Color.black);
				if(textFilhos.getText().equals("ex: 2")){
					textFilhos.setText(null);
				}
				textFilhos.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						u.apenasNumeros(e);
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						u.apenasNumeros(e);
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						u.apenasNumeros(e);
					}
				});
			}
		});
		textFilhos.setBounds(120, 310, 250, 20);
		container.add(textFilhos);
		textFilhos.setColumns(10);
		
		JLabel lblObrigatorio = new JLabel("*: campo obrigat�rio");
		lblObrigatorio.setBounds(330, 5, 200, 14);
		container.add(lblObrigatorio);
		
		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setBounds(440, 307, 100, 23);
		container.add(botaoCadastrar);
		
		JButton botaoLimpar = new JButton("Limpar");
		botaoLimpar.setBounds(620, 307, 100, 23);
		container.add(botaoLimpar);
		
		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double valorVA, valorVR, valorVT;
				Date data = new Date();
				char sexo = '0';
				String erros = "";
				int numeros = 0;
				
				if(textNome.getText().isEmpty() || textNome.getText().equals("ex: Jos�")) {
					erros = erros + "Campo Nome precisa estar preenchido;\n";
					numeros++;
				}
				if(textCpf.getText().isEmpty() || textCpf.getText().equals("ex: 12345678901")){
					erros = erros + "Campo CPF deve ser preenchido (apenas n�meros);\n";
					numeros++;
				} else if(!u.validaCpf(textCpf.getText())){
					erros = erros + "CPF inv�lido\n";
				}
				if(!u.validaData(textData.getText())){
					erros = erros + "Campo Data de Nascimento deve ser preenchido corretamente (dd/mm/aaaa);\n";
					numeros++;
				} 
				if(textEndere�o.getText().isEmpty() || textEndere�o.getText().equals("ex: R. Ayrton Senna da Silva, 500\nEdif�cio Torre di Pietra - 3� andar - sala - 303")){
					erros = erros + "Campo Endere�o deve ser preenchido;\n";
					numeros++;
				}
				if(!radioButtonMale.isSelected() && !radioButtonFemale.isSelected()){
					erros = erros + "� necess�rio informar seu g�nero;\n";
					numeros++;
				} else {
					if(radioButtonMale.isSelected()) {
						sexo = 'M';
					} else {
						sexo = 'F';
					}
				}
				if (boxCargo.getSelectedItem().equals("Selecione...")) {
					erros = erros + "� necess�rio informar o cargo;\n";
					numeros++;
				} else if (boxCargo.getSelectedItem().equals("Professor")) {
					erros = erros + "� necess�rio informar a disciplina;\n";
					numeros++;
				}
				if(textSalario.getText().equals("ex: 400.00")) {
					erros = erros + "� necess�rio informar o sal�rio;\n";
					numeros++;
				} else if(!u.validaDouble(textSalario.getText())) {
					erros = erros + "Sal�rio inv�lido (exemplo: 400.00);\n";
				}
				if(textVA.getText().equals("ex: 400.00")) {
					valorVA = 0;
				} else if(!u.validaDouble(textVA.getText())) {
					erros = erros + "Valor do vale alimenta��o inv�lido (exemplo: 400.00);\n";
				}
				if(textVR.getText().equals("ex: 400.00")) {
					valorVR = 0;
				} else if(!u.validaDouble(textVR.getText())) {
					erros = erros + "Valor do vale refei��o inv�lido (exemplo: 400.00);\n";
				}
				if(textVT.getText().equals("ex: 400.00")) {
					valorVT = 0;
				} else if(!u.validaDouble(textVT.getText())) {
					erros = erros + "Valor do vale transporte inv�lido (exemplo: 400.00);\n";
				}
				if(textTelefone.getText().isEmpty() || textTelefone.getText().equals("ex: 43999565338")){
					erros = erros + "Campo Telefone deve ser preenchido;\n";
					numeros++;
				} else {
					if (!u.validaApenasNumeros(textTelefone.getText())){
						erros = erros + "Campo Telefone deve ser preenchido corretamente (apenas n�meros);\n";
						numeros++;
					}
				}
				if(textEMail.getText().isEmpty() || textEMail.getText().equals("ex: nome@site.com")){
					erros = erros + "Campo e-Mail deve ser preenchido;\n";
					numeros++;
				} else if (!u.validaEmail(textEMail.getText())){
						erros = erros + "Campo e-mail deve ser preenchido corretamente (nome@site.com);\n";
						numeros++;
				}
				if(textFilhos.getText().equals("ex: 2")) {
					erros = erros + "Campo N�mero de filhos deve ser preenchido;\n";
					numeros++;
				} else if (!textFilhos.getText().equals("0")) {
					for (JTextField text : arrayTextFilhos) {
						if(text.getText().equals("ex: Jos�")) {
							erros = erros + "Campo Filho " + (arrayTextFilhos.indexOf(text)+1) + " deve ser preenchido;\n";
							numeros++;
						}
					}
					for (JTextField text : arrayTextDatas) {
						if(text.getText().equals("dd/mm/aaaa")) {
							erros = erros + "Campo Data de nascimento do Filho " + (arrayTextDatas.indexOf(text)+1) + " deve ser preenchido;\n";
							numeros++;
						} else {
							if (!u.validaData(text.getText())) {
								erros = erros + "Campo data de nascimento do Filho " + (arrayTextDatas.indexOf(text)+1) + " deve ser preenchido;\n";
								numeros++;
							}
						}
					}
				}
				if (numeros == 0){
					data = u.transformaData(textData.getText());
//					Professor p = new Professor(textNome.getText(), textCpf.getText(), data, textEndere�o.getText(), sexo, comboBox.getSelectedItem().toString(), textTelefone.getText(), textEMail.getText());
//					cP.cadastraProfessor(p);
					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, erros, numeros + " erros encontrados:", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		botaoLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNome.setForeground(Color.GRAY);
				textCpf.setForeground(Color.GRAY);
				textData.setForeground(Color.GRAY);
				textEndere�o.setForeground(Color.GRAY);
				textSalario.setForeground(Color.GRAY);
				textVA.setForeground(Color.GRAY);
				textVR.setForeground(Color.gray);
				textVT.setForeground(Color.gray);
				textTelefone.setForeground(Color.GRAY);
				textEMail.setForeground(Color.GRAY);
				textFilhos.setForeground(Color.GRAY);
				textNome.setBorder(defaultBorder);
				textCpf.setBorder(defaultBorder);
				textData.setBorder(defaultBorder);
				textEndere�o.setBorder(border);
				textSalario.setBorder(defaultBorder);
				textVA.setBorder(defaultBorder);
				textVR.setBorder(defaultBorder);
				textVT.setBorder(defaultBorder);
				textTelefone.setBorder(defaultBorder);
				textEMail.setBorder(defaultBorder);
				textNome.setText("ex: Jos�");
				textCpf.setText("ex: 12345678901");
				textData.setText("dd/mm/aaaa");
				textEndere�o.setText("ex: R. Ayrton Senna da Silva, 500\nEdif�cio Torre di Pietra - 3� andar - sala - 303");
				textSalario.setText("ex: 400.00");
				textVA.setText("ex: 400.00");
				textVR.setText("ex: 400.00");
				textVT.setText("ex: 400.00");
				textTelefone.setText("ex: 43999565338");
				textEMail.setText("ex: nome@site.com");
				textFilhos.setText("ex: 2");
				radioButtonFemale.setSelected(false);
				radioButtonMale.setSelected(false);
				boxCargo.setSelectedItem("Selecionar...");
				comboBox.setSelectedItem("Selecionar...");
				for(JTextField text : arrayTextDatas) {
					text.setBorder(defaultBorder);
					text.setForeground(Color.gray);
					text.setText("dd/mm/aaaa");
				}
				for(JTextField text : arrayTextFilhos) {
					text.setBorder(defaultBorder);
					text.setForeground(Color.gray);
					text.setText("ex: Jos�");
				}
			}
		});
		
		radioButtonFemale.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				radioButtonMale.setSelected(false);
			}
		});
		
		radioButtonMale.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				radioButtonFemale.setSelected(false);
			}
		});
    }
}
