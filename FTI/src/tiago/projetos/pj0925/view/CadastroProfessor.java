package tiago.projetos.pj0925.view;

import tiago.projetos.pj0925.model.*;
import tiago.projetos.pj0925.controller.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.Border;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class CadastroProfessor {

	private JFrame frame;
	private JTextField textField;
	private JTextField textCpf;
	private JTextField textData;
	private JTextField textTelefone;
	private JTextField textEMail;
	
	private static boolean nomeValidado;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProfessor window = new CadastroProfessor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadastroProfessor() {
		iniciaJanela();
	}

	private void iniciaJanela() {
		frame = new JFrame();
		frame.setBounds(100, 100, 485, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(150, 28, 250, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Nome:* ");
		lblName.setBounds(65, 31, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblCpf = new JLabel("CPF:* ");
		lblCpf.setBounds(70, 65, 46, 14);
		frame.getContentPane().add(lblCpf);
		textCpf = new JTextField();
		textCpf.setBounds(150, 65, 250, 20);
		frame.getContentPane().add(textCpf);
		textCpf.setColumns(10);
		
		JLabel lblData = new JLabel("Data de");
		lblData.setBounds(59, 105, 46, 14);
		frame.getContentPane().add(lblData);
		JLabel lblData2 = new JLabel("Nascimento:* ");
		lblData2.setBounds(45, 120, 100, 14);
		frame.getContentPane().add(lblData2);
		textData = new JTextField();
		textData.setText("dd/mm/aaaa");
		textData.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(textData.getText().isEmpty()){
					textData.setForeground(Color.GRAY);
					textData.setText("dd/mm/aaaa");
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
		textData.setBounds(150, 109, 250, 20);
		frame.getContentPane().add(textData);
		textData.setColumns(10);
		
		JLabel lblAddress = new JLabel("Endere�o:* ");
		lblAddress.setBounds(53, 162, 80, 14);
		frame.getContentPane().add(lblAddress);
				
		JTextArea textArea1 = new JTextArea();
		textArea1.setBounds(150, 157, 250, 40);
		Border border = BorderFactory.createLineBorder(Color.GRAY);
	    textArea1.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
		frame.getContentPane().add(textArea1);	
		
		JLabel lblSex = new JLabel("Sexo:* ");
		lblSex.setBounds(65, 228, 46, 14);
		frame.getContentPane().add(lblSex);
		
		JLabel lblMale = new JLabel("Masculino");
		lblMale.setBounds(150, 228, 60, 14);
		frame.getContentPane().add(lblMale);
		
		JLabel lblFemale = new JLabel("Feminino");
		lblFemale.setBounds(320, 228, 60, 14);
		frame.getContentPane().add(lblFemale);
		
		JRadioButton radioButtonMale = new JRadioButton("");
		radioButtonMale.setBounds(215, 224, 20, 23);
		frame.getContentPane().add(radioButtonMale);

		JRadioButton radioButtonFemale = new JRadioButton("");
		radioButtonFemale.setBounds(380, 224, 20, 23);
		frame.getContentPane().add(radioButtonFemale);
		
		JLabel lblOccupation = new JLabel("Disciplina:* ");
		lblOccupation.setBounds(53, 270, 67, 14);
		frame.getContentPane().add(lblOccupation);
		
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
		comboBox.setBounds(150, 270, 250, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblTelefone = new JLabel("Telefone:* ");
		lblTelefone.setBounds(55, 302, 60, 14);
		frame.getContentPane().add(lblTelefone);
		textTelefone = new JTextField();
		textTelefone.setBounds(150, 302, 250, 20);
		frame.getContentPane().add(textTelefone);
		textTelefone.setColumns(10);
		
		JLabel lblEMail = new JLabel("e-mail:* ");
		lblEMail.setBounds(65, 334, 60, 14);
		frame.getContentPane().add(lblEMail);
		textEMail = new JTextField();
		textEMail.setBounds(150, 334, 250, 20);
		frame.getContentPane().add(textEMail);
		textEMail.setColumns(10);
		
		JLabel lblObrigatorio = new JLabel("*: campo obrigat�rio");
		lblObrigatorio.setBounds(180, 420, 200, 14);
		frame.getContentPane().add(lblObrigatorio);
		
		JButton btnClear = new JButton("Limpar");
		
		btnClear.setBounds(312, 387, 89, 23);
		frame.getContentPane().add(btnClear);
		
		JButton btnSubmit = new JButton("Cadastrar");
		
		btnSubmit.setBackground(Color.BLACK);
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setBounds(65, 387, 100, 23);
		frame.getContentPane().add(btnSubmit);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller c = new Controller();
				String erros = "";
				int numeros = 0;
				
				if(textField.getText().isEmpty()) {
					erros = erros + "Campo Nome precisa estar preenchido;\n";
					numeros++;
				}
				if(textCpf.getText().isEmpty()){
					erros = erros + "Campo CPF deve ser preenchido (apenas n�meros);\n";
					numeros++;
				} else if(!c.validaCpf(textCpf.getText())){
					erros = erros + "CPF inv�lido\n";
				}
				if(!c.validaData(textData.getText())){
					erros = erros + "Campo Data de Nascimento deve ser preenchido corretamente (dd/mm/aaaa);\n";
					numeros++;
				} 
				if(textArea1.getText().isEmpty()){
					erros = erros + "Campo Endere�o deve ser preenchido;\n";
					numeros++;
				}
				if(!radioButtonMale.isSelected() && !radioButtonFemale.isSelected()){
					erros = erros + "� necess�rio informar seu g�nero;\n";
					numeros++;
				}
				if(comboBox.getSelectedItem().equals("Selecione...")){
					erros = erros + "� necess�rio informar a disciplina;\n";
					numeros++;
				}
				if(textTelefone.getText().isEmpty()){
					erros = erros + "Campo Telefone deve ser preenchido;\n";
					numeros++;
				} else {
					if (!c.validaApenasNumeros(textTelefone.getText())){
						erros = erros + "Campo Telefone deve ser preenchido corretamente (apenas n�meros);\n";
						numeros++;
					}
				}
				if(textEMail.getText().isEmpty()){
					erros = erros + "Campo e-Mail deve ser preenchido;\n";
					numeros++;
				} else {
					boolean verificaEmail = false;
					for (int i = 0; i < textEMail.getText().length(); i++){
						if(textEMail.getText().charAt(i) == '@') {
							verificaEmail = true;
						}
					}
					if (verificaEmail == false){
						erros = erros + "Campo e-mail deve ser preenchido corretamente (nome@site.com);\n";
						numeros++;
					}
				}
				if (numeros == 0){
					Professor p = new Professor();
					c.cadastraProfessor(p);
					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, erros, numeros + " erros encontrados:", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textArea1.setText(null);
				textData.setText(null);
				textEMail.setText(null);
				textTelefone.setText(null);
				textCpf.setText(null);
				radioButtonFemale.setSelected(false);
				radioButtonMale.setSelected(false);
				comboBox.setSelectedItem("Selecionar...");
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
