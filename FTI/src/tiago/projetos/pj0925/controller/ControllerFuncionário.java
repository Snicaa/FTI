package tiago.projetos.pj0925.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import tiago.projetos.pj0925.model.Aluno;
import tiago.projetos.pj0925.model.Funcion�rio;
import tiago.projetos.pj0925.model.Pessoa;
import tiago.projetos.pj0925.model.Professor;
import tiago.projetos.pj0925.view.Menu;

public class ControllerFuncion�rio {
	
	private Border defaultBorder;
	private Border border;
	private DefaultTableModel modelTabelaFuncion�rio;
	
	public ControllerFuncion�rio(){
		border = BorderFactory.createLineBorder(Color.GRAY);
		defaultBorder = new JTextField().getBorder();
		modelTabelaFuncion�rio = new DefaultTableModel(new Object[][] {}, new String[] {"Cadastro", "CPF", "Nome", "Cargo"});
		//geraListaFuncion�rio(modelTabelaFuncion�rio);
	}
	
	public void geraListaFuncion�rio(DefaultTableModel model){
		String nome2 = "Tiago de Morais Fran�a";
		for (int i = 0; i < 17; i++) {
			ControllerMenu.getArrayFuncion�rio().add(new Funcion�rio("123456789", nome2 + i, "07378278904", new Date(), "Rua M",
					'M', "Analista Mainframe", 4000.00, 800.00, 900.00, 80.00, 0, new ArrayList<Pessoa>(), "43999565338", "tiagomfr@gmail.com"));
		}
		
		for (Funcion�rio func : ControllerMenu.getArrayFuncion�rio()) {
			String codCadastro = func.getCodCadastro();
			String cpf = func.getCpf();
			String nome = func.getNome();
			String cargo = func.getCargo();
			Object[] linha = {codCadastro, cpf, nome, cargo};
			model.addRow(linha);
		}
	}
	
	public void cadastraProfessor(Professor p) {
		
	}
	public void cadastraFuncion�rio(Funcion�rio f) {
		String cadastro = f.getCodCadastro();
		String cpf = f.getCpf();
		String nome = f.getNome();
		String cargo = f.getCargo();
		Object[] linha = {cadastro, cpf, nome, cargo};
		modelTabelaFuncion�rio.addRow(linha);
		ControllerMenu.getArrayFuncion�rio().add(f);
	}
	
	public void botaoCadastrar(String textCadastro, String textNome, String textCpf, boolean botaoMale, boolean botaoFemale, String textData, String textEndere�o,
			String boxCargo, String boxDisciplina, String textSalario, String textVA, String textVR, String textVT, String textTelefone, String textEMail,
			String textFilhos, ArrayList<JTextField> arrayTextFilhos, ArrayList<JTextField> arrayTextDatas){
		ControllerUtil u = new ControllerUtil();
		ArrayList<Pessoa> arrayFilhos = new ArrayList<Pessoa>();
		double valorVA = 1;
		double valorVR = 1;
		double valorVT = 1;
		char sexo = '0';
		String erros = "";
		int numeros = 0;
		
		if(textCadastro.equals("") || textCadastro.equals("ex: 123456789")){
			erros = erros + "Campo C�digo do cadastro deve ser preenchido;\n";
			numeros++;
		}			
		if(textNome.equals("") || textNome.equals("ex: Jos�")) {
			erros = erros + "Campo Nome precisa estar preenchido;\n";
			numeros++;
		}
		if(textCpf.equals("") || textCpf.equals("ex: 12345678901")){
			erros = erros + "Campo CPF deve ser preenchido (apenas n�meros);\n";
			numeros++;
		} else if(!u.validaCpf(textCpf)){
			erros = erros + "CPF inv�lido\n";
		}
		if(!botaoMale && !botaoFemale){
			erros = erros + "� necess�rio informar seu g�nero;\n";
			numeros++;
		} else {
			if(botaoMale) {
				sexo = 'M';
			} else {
				sexo = 'F';
			}
		}
		if(!u.validaData(textData)){
			erros = erros + "Campo Data de Nascimento deve ser preenchido corretamente (dd/mm/aaaa);\n";
			numeros++;
		} 
		if(textEndere�o.equals("") || textEndere�o.equals("ex: R. Ayrton Senna da Silva, 500\nEdif�cio Torre di Pietra - 3� andar - sala - 303")){
			erros = erros + "Campo Endere�o deve ser preenchido;\n";
			numeros++;
		}
		if (boxCargo.equals("Selecione...")) {
			erros = erros + "� necess�rio informar o cargo;\n";
			numeros++;
		} else if (boxCargo.equals("Professor")) {
			if (boxDisciplina.equals("Selecionar...")){
				erros = erros + "� necess�rio informar a disciplina;\n";
				numeros++;
			}
		}
		if(textSalario.equals("ex: 400,00")) {
			erros = erros + "� necess�rio informar o sal�rio;\n";
			numeros++;
		} else if(!u.validaDouble(textSalario)) {
			erros = erros + "Sal�rio inv�lido (exemplo: 400,00);\n";
		}
		if(textVA.equals("ex: 400,00")) {
			valorVA = 0;
		} else if(!u.validaDouble(textVA)) {
			erros = erros + "Valor do vale alimenta��o inv�lido (exemplo: 400,00);\n";
		}
		if(textVR.equals("ex: 400,00")) {
			valorVR = 0;
		} else if(!u.validaDouble(textVR)) {
			erros = erros + "Valor do vale refei��o inv�lido (exemplo: 400,00);\n";
		}
		if(textVT.equals("ex: 400,00")) {
			valorVT = 0;
		} else if(!u.validaDouble(textVT)) {
			erros = erros + "Valor do vale transporte inv�lido (exemplo: 400,00);\n";
		}
		if(textTelefone.equals("") || textTelefone.equals("ex: 43999565338")){
			erros = erros + "Campo Telefone deve ser preenchido;\n";
			numeros++;
		} else {
			if (!u.validaApenasNumeros(textTelefone)){
				erros = erros + "Campo Telefone deve ser preenchido corretamente (apenas n�meros);\n";
				numeros++;
			}
		}
		if(textEMail.equals("") || textEMail.equals("ex: nome@site.com")){
			erros = erros + "Campo e-Mail deve ser preenchido;\n";
			numeros++;
		} else if (!u.validaEmail(textEMail)){
				erros = erros + "Campo e-mail deve ser preenchido corretamente (nome@site.com);\n";
				numeros++;
		}
		if(textFilhos.equals("ex: 2")) {
			erros = erros + "Campo N�mero de filhos deve ser preenchido;\n";
			numeros++;
		} else if (!textFilhos.equals("0")) {
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
						erros = erros + "Campo data de nascimento do Filho " + (arrayTextDatas.indexOf(text)+1) + " deve ser preenchido corretamente (dd/mm/aaaa);\n";
						numeros++;
					}
				}
			}
		}
		if (numeros == 0){
			if(valorVA != 0) {
				valorVA = Double.parseDouble(textVA);
			}
			if(valorVR != 0) {
				valorVR = Double.parseDouble(textVR);
			}
			if(valorVT != 0) {
				valorVT = Double.parseDouble(textVT);
			}
			if(!textFilhos.equals("0")) {
				for(JTextField text : arrayTextFilhos) {
					Pessoa filho = new Pessoa(text.getText(), u.transformaData(arrayTextDatas.get(arrayTextFilhos.indexOf(text)).getText()));
					arrayFilhos.add(filho);
				}
			}
				Funcion�rio f = new Funcion�rio(textCadastro, textNome, textCpf, u.transformaData(textData), textEndere�o, sexo, boxCargo,
						Double.parseDouble(textSalario), valorVA, valorVT, valorVR, Integer.parseInt(textFilhos), arrayFilhos, textTelefone, textEMail);
				cadastraFuncion�rio(f);
			JOptionPane.showMessageDialog(null, "Cadastro de funcion�rio efetuado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			Menu.editando = false;
		} else {
			JOptionPane.showMessageDialog(null, erros, numeros + " erros encontrados:", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void botaoEditar(String textCadastro, String textNome, String textCpf, boolean botaoMale, boolean botaoFemale, String textData, String textEndere�o,
			String boxCargo, String boxDisciplina, String textSalario, String textVA, String textVR, String textVT, String textTelefone, String textEMail,
			String textFilhos, ArrayList<JTextField> arrayTextFilhos, ArrayList<JTextField> arrayTextDatas){
		ControllerUtil u = new ControllerUtil();
		ArrayList<Pessoa> arrayFilhos = new ArrayList<Pessoa>();
		double valorVA = 1;
		double valorVR = 1;
		double valorVT = 1;
		char sexo = '0';
		String erros = "";
		int numeros = 0;
		
		if(textCadastro.equals("") || textCadastro.equals("ex: 123456789")){
			erros = erros + "Campo C�digo do cadastro deve ser preenchido;\n";
			numeros++;
		}			
		if(textNome.equals("") || textNome.equals("ex: Jos�")) {
			erros = erros + "Campo Nome precisa estar preenchido;\n";
			numeros++;
		}
		if(textCpf.equals("") || textCpf.equals("ex: 12345678901")){
			erros = erros + "Campo CPF deve ser preenchido (apenas n�meros);\n";
			numeros++;
		} else if(!u.validaCpf(textCpf)){
			erros = erros + "CPF inv�lido\n";
		}
		if(!botaoMale && !botaoFemale){
			erros = erros + "� necess�rio informar seu g�nero;\n";
			numeros++;
		} else {
			if(botaoMale) {
				sexo = 'M';
			} else {
				sexo = 'F';
			}
		}
		if(!u.validaData(textData)){
			erros = erros + "Campo Data de Nascimento deve ser preenchido corretamente (dd/mm/aaaa);\n";
			numeros++;
		} 
		if(textEndere�o.equals("") || textEndere�o.equals("ex: R. Ayrton Senna da Silva, 500\nEdif�cio Torre di Pietra - 3� andar - sala - 303")){
			erros = erros + "Campo Endere�o deve ser preenchido;\n";
			numeros++;
		}
		if (boxCargo.equals("Selecione...")) {
			erros = erros + "� necess�rio informar o cargo;\n";
			numeros++;
		} else if (boxCargo.equals("Professor")) {
			if (boxDisciplina.equals("Selecionar...")){
				erros = erros + "� necess�rio informar a disciplina;\n";
				numeros++;
			}
		}
		if(textSalario.equals("ex: 400,00")) {
			erros = erros + "� necess�rio informar o sal�rio;\n";
			numeros++;
		} else if(!u.validaDouble(textSalario)) {
			erros = erros + "Sal�rio inv�lido (exemplo: 400,00);\n";
		}
		if(textVA.equals("ex: 400,00")) {
			valorVA = 0;
		} else if(!u.validaDouble(textVA)) {
			erros = erros + "Valor do vale alimenta��o inv�lido (exemplo: 400,00);\n";
		}
		if(textVR.equals("ex: 400,00")) {
			valorVR = 0;
		} else if(!u.validaDouble(textVR)) {
			erros = erros + "Valor do vale refei��o inv�lido (exemplo: 400,00);\n";
		}
		if(textVT.equals("ex: 400,00")) {
			valorVT = 0;
		} else if(!u.validaDouble(textVT)) {
			erros = erros + "Valor do vale transporte inv�lido (exemplo: 400,00);\n";
		}
		if(textTelefone.equals("") || textTelefone.equals("ex: 43999565338")){
			erros = erros + "Campo Telefone deve ser preenchido;\n";
			numeros++;
		} else {
			if (!u.validaApenasNumeros(textTelefone)){
				erros = erros + "Campo Telefone deve ser preenchido corretamente (apenas n�meros);\n";
				numeros++;
			}
		}
		if(textEMail.equals("") || textEMail.equals("ex: nome@site.com")){
			erros = erros + "Campo e-Mail deve ser preenchido;\n";
			numeros++;
		} else if (!u.validaEmail(textEMail)){
				erros = erros + "Campo e-mail deve ser preenchido corretamente (nome@site.com);\n";
				numeros++;
		}
		if(textFilhos.equals("ex: 2")) {
			erros = erros + "Campo N�mero de filhos deve ser preenchido;\n";
			numeros++;
		} else if (!textFilhos.equals("0")) {
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
						erros = erros + "Campo data de nascimento do Filho " + (arrayTextDatas.indexOf(text)+1) + " deve ser preenchido corretamente (dd/mm/aaaa);\n";
						numeros++;
					}
				}
			}
		}
		if (numeros == 0){
			if(valorVA != 0) {
				valorVA = Double.parseDouble(textVA);
			}
			if(valorVR != 0) {
				valorVR = Double.parseDouble(textVR);
			}
			if(valorVT != 0) {
				valorVT = Double.parseDouble(textVT);
			}
			if(!textFilhos.equals("0")) {
				for(JTextField text : arrayTextFilhos) {
					Pessoa filho = new Pessoa(text.getText(), u.transformaData(arrayTextDatas.get(arrayTextFilhos.indexOf(text)).getText()));
					arrayFilhos.add(filho);
				}
			}
			editaFuncion�rio(textCadastro, textNome, textCpf, textData, textEndere�o, sexo, boxCargo, textTelefone, textEMail, Integer.parseInt(textFilhos), 
						Double.parseDouble(textSalario), valorVA, valorVR, valorVT, arrayFilhos);
			JOptionPane.showMessageDialog(null, "Cadastro de funcion�rio efetuado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			Menu.editando = false;
		} else {
			JOptionPane.showMessageDialog(null, erros, numeros + " erros encontrados:", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void botaoLimpar(JFrame frame, JPanel container, JTextField textCadastro, JTextField textNome, JTextField textCpf, JTextField textData, JTextArea textEndere�o, JTextField textSalario,
			JTextField textVA, JTextField textVR, JTextField textVT, JTextField textTelefone, JTextField textEMail, JTextField textFilhos, ArrayList<JTextField> arrayTextFilhos,
			ArrayList<JTextField> arrayTextDatas, ArrayList<JLabel> arrayLabels, JComboBox<String> boxCargo, JComboBox<String> boxDisciplina, JRadioButton botaoMale, JRadioButton botaoFemale){
		textCadastro.setForeground(Color.gray);
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
		textCadastro.setBorder(defaultBorder);
		textNome.setBorder(defaultBorder);
		textCpf.setBorder(defaultBorder);
		textData.setBorder(defaultBorder);
		textEndere�o.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
		textSalario.setBorder(defaultBorder);
		textVA.setBorder(defaultBorder);
		textVR.setBorder(defaultBorder);
		textVT.setBorder(defaultBorder);
		textTelefone.setBorder(defaultBorder);
		textEMail.setBorder(defaultBorder);
		textFilhos.setBorder(defaultBorder);
		textCadastro.setText("ex: 123456789");
		textNome.setText("ex: Jos�");
		textCpf.setText("ex: 12345678901");
		textData.setText("dd/mm/aaaa");
		textEndere�o.setText("ex: R. Ayrton Senna da Silva, 500\nEdif�cio Torre di Pietra - 3� andar - sala - 303");
		textSalario.setText("ex: 400,00");
		textVA.setText("ex: 400,00");
		textVR.setText("ex: 400,00");
		textVT.setText("ex: 400,00");
		textTelefone.setText("ex: 43999565338");
		textEMail.setText("ex: nome@site.com");
		textFilhos.setText("ex: 2");
		botaoFemale.setSelected(false);
		botaoMale.setSelected(false);
		boxCargo.setSelectedItem("Selecionar...");
		boxDisciplina.setSelectedItem("Selecionar...");
		for(JTextField text : arrayTextDatas) {
			container.remove(text);
		}
		for(JTextField text : arrayTextFilhos) {
			container.remove(text);
		}
		for(JLabel label : arrayLabels) {
			container.remove(label);
		}
		container.setPreferredSize(new Dimension(750, 385));
		frame.pack();
		frame.setSize(785, 451);	
	}
	
	public void geraFilhos(int i, JPanel container, ArrayList<JTextField> arrayTextFilhos, ArrayList<JTextField> arrayTextDatas, ArrayList<JLabel> arrayLabels){
		String label = "Filho " + i + ": ";
		
		JLabel lbl = new JLabel(label);
		lbl.setBounds(45, (35*i)+345, 100, 14);
		container.add(lbl);
		
		JTextField texto = new JTextField();
		texto.setBounds(120, (35*i)+345, 250, 20);
		texto.setForeground(Color.gray);
		texto.setText("ex: Jos�");
		arrayTextFilhos.add(texto);
		container.add(texto);
		
		JLabel lbl1 = new JLabel("Data de");
		lbl1.setBounds(415, (35*i)+337, 100, 14);
		container.add(lbl1);
		JLabel lbl2 = new JLabel("Nascimento: ");
		lbl2.setBounds(400, (35*i)+350, 100, 14);
		container.add(lbl2);
		
		JTextField texto2 = new JTextField();
		texto2.setBounds(485, (35*i)+345, 250, 20);
		texto2.setForeground(Color.gray);
		texto2.setText("dd/mm/aaaa");
		arrayTextDatas.add(texto2);
		arrayLabels.add(lbl);
		arrayLabels.add(lbl1);
		arrayLabels.add(lbl2);
		container.add(texto2);
	}
	
	public void deletaFilhos(JFrame frame, JPanel container, ArrayList<JTextField> arrayTextFilhos, ArrayList<JTextField> arrayTextDatas, ArrayList<JLabel> arrayLabels){
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
		frame.setSize(785, 451);
	}
	
	public DefaultTableModel modelFuncion�rio(){
		return this.modelTabelaFuncion�rio;
	}
	
	public void removeFuncionario(int i){
		ControllerMenu.getArrayFuncion�rio().remove(i);
		modelTabelaFuncion�rio.removeRow(i);
	}
	public void geraFilhosEditar(ArrayList<Pessoa> arrayFilhos, int i, JPanel container, ArrayList<JTextField> arrayTextFilhos, ArrayList<JTextField> arrayTextDatas, ArrayList<JLabel> arrayLabels){
		String label = "Filho " + i + ": ";
		
		JLabel lbl = new JLabel(label);
		lbl.setBounds(45, (35*i)+345, 100, 14);
		container.add(lbl);
		
		JTextField texto = new JTextField();
		texto.setBounds(120, (35*i)+345, 250, 20);
		texto.setForeground(Color.gray);
		texto.setText(arrayFilhos.get(i).getNome());
		arrayTextFilhos.add(texto);
		container.add(texto);
		
		JLabel lbl1 = new JLabel("Data de");
		lbl1.setBounds(415, (35*i)+337, 100, 14);
		container.add(lbl1);
		JLabel lbl2 = new JLabel("Nascimento: ");
		lbl2.setBounds(400, (35*i)+350, 100, 14);
		container.add(lbl2);
		
		JTextField texto2 = new JTextField();
		texto2.setBounds(485, (35*i)+345, 250, 20);
		texto2.setForeground(Color.gray);
		texto2.setText(ControllerMenu.sdf.format(arrayFilhos.get(i).getDataNascimento()));
		arrayTextDatas.add(texto2);
		arrayLabels.add(lbl);
		arrayLabels.add(lbl1);
		arrayLabels.add(lbl2);
		container.add(texto2);
	}
	
	public void editaFuncion�rio(String cadastro, String nome, String cpf, String data, String endere�o, char sexo, String boxCargo, String telefone, String email, int filhos,
			double salario, double vA, double vR, double vT, ArrayList<Pessoa> arrayFilhos){
		ControllerUtil u = new ControllerUtil();
		Date date = new Date();
		date = u.transformaData(data);
		
		ControllerMenu.getArrayFuncion�rio().get(Menu.pessoaEditada).setCodCadastro(cadastro);
		ControllerMenu.getArrayFuncion�rio().get(Menu.pessoaEditada).setNome(nome);
		ControllerMenu.getArrayFuncion�rio().get(Menu.pessoaEditada).setCpf(cpf);
		ControllerMenu.getArrayFuncion�rio().get(Menu.pessoaEditada).setDataNascimento(date);
		ControllerMenu.getArrayFuncion�rio().get(Menu.pessoaEditada).setEndere�o(endere�o);
		ControllerMenu.getArrayFuncion�rio().get(Menu.pessoaEditada).setSexo(sexo);
		ControllerMenu.getArrayFuncion�rio().get(Menu.pessoaEditada).setCargo(boxCargo);
		ControllerMenu.getArrayFuncion�rio().get(Menu.pessoaEditada).setTelefone(telefone);
		ControllerMenu.getArrayFuncion�rio().get(Menu.pessoaEditada).seteMail(email);
		ControllerMenu.getArrayFuncion�rio().get(Menu.pessoaEditada).setFilhos(filhos);
		ControllerMenu.getArrayFuncion�rio().get(Menu.pessoaEditada).setSalario(salario);
		ControllerMenu.getArrayFuncion�rio().get(Menu.pessoaEditada).setValeAlimenta��o(vA);
		ControllerMenu.getArrayFuncion�rio().get(Menu.pessoaEditada).setValeRefei��o(vR);
		ControllerMenu.getArrayFuncion�rio().get(Menu.pessoaEditada).setValeTransporte(vT);
		ControllerMenu.getArrayFuncion�rio().get(Menu.pessoaEditada).setCadastroFilhos(arrayFilhos);
		
		refazTabela();
		Menu.pessoaEditada = -1;
	}
	
	public void refazTabela(){
		modelTabelaFuncion�rio.setRowCount(0);
		for (Funcion�rio f : ControllerMenu.getArrayFuncion�rio()) {
			String cadastro = f.getCodCadastro();
			String cpf = f.getCpf();
			String nome = f.getNome();
			String cargo = f.getCargo();
			Object[] linha = {cadastro, cpf, nome, cargo};
			modelTabelaFuncion�rio.addRow(linha);
		}
	}
}
