package tiago.projetos.pj0925.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import tiago.projetos.pj0925.model.Aluno;
import tiago.projetos.pj0925.view.Menu;
import tiago.projetos.pj0925.controller.ControllerMenu;
import tiago.projetos.pj0925.dao.AlunoDAO;

public class ControllerAluno {
	
	private DefaultTableModel modelTabelaAluno;
	private AlunoDAO aDAO;
	private ArrayList<Aluno> arrayDisplay;
	
	public ControllerAluno() {
		aDAO = new AlunoDAO();
		modelTabelaAluno = new DefaultTableModel(new Object[][] {}, new String[] {"Matr�cula", "CPF", "Nome", "Curso"});
		arrayDisplay = new ArrayList<Aluno>();
		iniciaTabela();
	}
	
	public ArrayList<Aluno> getArrayDisplay(){
		return arrayDisplay;
	}
	
	public void iniciaTabela(){
		arrayDisplay = aDAO.consultarListaAluno();
		for (Aluno a : arrayDisplay){
			String matr�cula = a.getMatricula();
			String cpf = a.getCpf();
			String nome = a.getNome();
			String curso = a.getCurso();
			Object[] linha = {matr�cula, cpf, nome, curso};
			modelTabelaAluno.addRow(linha);
		}
	}
	
	public void cadastraAluno(Aluno aluno){
		modelTabelaAluno.setRowCount(0);
		aDAO.cadastrarAluno(aluno);
		
		iniciaTabela();
	}
	
	public void removeAluno(int i){
		aDAO.inativarAluno(i);
		modelTabelaAluno.removeRow(i);
	}
	
	public DefaultTableModel modelAluno(){
		return this.modelTabelaAluno;
	}
	
	public void botaoCadastrar(String textNome, String textCpf, String textMatricula, boolean botaoMale, boolean botaoFemale, String textData, String textEndere�o,
			String boxCurso, String textTelefone, String textEMail){
		ControllerUtil u = new ControllerUtil();
		String matricula = "";
		Date data = new Date();
		char sexo = '0';
		String erros = "";
		int numeros = 0;
		
		if (textNome.equals("") || textNome.equals("ex: Jos�")) {
			erros = erros + "Campo Nome precisa estar preenchido;\n";
			numeros++;
		}
		if(textCpf.equals("") || textCpf.equals("ex: 12345678901")){
			erros = erros + "Campo CPF deve ser preenchido (apenas n�meros);\n";
			numeros++;
		} else if(!u.validaCpf(textCpf)){
			erros = erros + "CPF inv�lido;\n";
		}
		if(textMatricula.equals("") || textMatricula.equals("ex: 123456789")){
			matricula = "";
		} 
		if (textData.equals("") || textData.equals("dd/mm/aaaa")) {
			erros = erros + "Campo Data de Nascimento deve ser preenchido;\n";
			numeros++;
		} else if (!u.validaData(textData)){
			erros = erros + "Data inv�lida, utilize o formato dd/mm/aaaa;\n";
			numeros++;
		} 
		if(textEndere�o.equals("") || textEndere�o.equals("ex: R. Ayrton Senna da Silva, 500\nEdif�cio Torre di Pietra - 3� andar - sala - 303")){
			erros = erros + "Campo Endere�o deve ser preenchido;\n";
			numeros++;
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
		if(boxCurso.equals("Selecione...")){
			erros = erros + "� necess�rio informar a disciplina;\n";
			numeros++;
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
		} else {
			boolean verificaEmail = false;
			for (int i = 0; i < textEMail.length(); i++){
				if(textEMail.charAt(i) == '@') {
					verificaEmail = true;
				}
			}
			if (verificaEmail == false){
				erros = erros + "Campo e-mail deve ser preenchido corretamente (nome@site.com);\n";
				numeros++;
			}
		}
		if (numeros == 0){
			data = u.transformaData(textData);
			Aluno a = new Aluno(textNome, textCpf, matricula, data, textEndere�o, sexo, boxCurso, textTelefone, textEMail);
			cadastraAluno(a);
			JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			Menu.adicionando = false;
		} else {
			Menu.adicionando = true;
			JOptionPane.showMessageDialog(null, erros, numeros + " erros encontrados:", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void botaoEditar(String textNome, String textCpf, String textMatricula, boolean botaoMale, boolean botaoFemale, String textData, String textEndere�o,
			String boxCurso, String textTelefone, String textEMail){
		ControllerUtil u = new ControllerUtil();
		char sexo = '0';
		String erros = "";
		int numeros = 0;
		
		if (textNome.equals("") || textNome.equals("ex: Jos�")) {
			erros = erros + "Campo Nome precisa estar preenchido;\n";
			numeros++;
		}
		if(textCpf.equals("") || textCpf.equals("ex: 12345678901")){
			erros = erros + "Campo CPF deve ser preenchido (apenas n�meros);\n";
			numeros++;
		} else if(!u.validaCpf(textCpf)){
			erros = erros + "CPF inv�lido;\n";
		}
		if (textData.equals("") || textData.equals("dd/mm/aaaa")) {
			erros = erros + "Campo Data de Nascimento deve ser preenchido;\n";
			numeros++;
		} else if (!u.validaData(textData)){
			erros = erros + "Data inv�lida, utilize o formato dd/mm/aaaa;\n";
			numeros++;
		} 
		if(textEndere�o.equals("") || textEndere�o.equals("ex: R. Ayrton Senna da Silva, 500\nEdif�cio Torre di Pietra - 3� andar - sala - 303")){
			erros = erros + "Campo Endere�o deve ser preenchido;\n";
			numeros++;
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
		if(boxCurso.equals("Selecione...")){
			erros = erros + "� necess�rio informar a disciplina;\n";
			numeros++;
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
		} else {
			boolean verificaEmail = false;
			for (int i = 0; i < textEMail.length(); i++){
				if(textEMail.charAt(i) == '@') {
					verificaEmail = true;
				}
			}
			if (verificaEmail == false){
				erros = erros + "Campo e-mail deve ser preenchido corretamente (nome@site.com);\n";
				numeros++;
			}
		}
		if (numeros == 0){
			editaAluno(textNome, textCpf, textData, textEndere�o, sexo, boxCurso, textTelefone, textEMail);
			Menu.editando = false;
			JOptionPane.showMessageDialog(null, "Informa��es do aluno foram atualizadas com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			Menu.pessoaEditada = -1;
		} else {
			Menu.editando = true;
			JOptionPane.showMessageDialog(null, erros, numeros + " erros encontrados:", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void editaAluno(String nome, String cpf, String data, String endere�o, char sexo, String boxCurso, String textTelefone, String textEMail) {
		ControllerUtil u = new ControllerUtil();
		Date date = new Date();
		date = u.transformaData(data);
		
		Aluno a = new Aluno();
		a.setNome(nome);
		a.setCpf(cpf);
		a.setDataNascimento(date);
		a.setEndere�o(endere�o);
		a.setSexo(sexo);
		a.setCurso(boxCurso);
		a.setTelefone(textTelefone);
		a.seteMail(textEMail);
		aDAO.alterarAluno(a);
		arrayDisplay.get(Menu.pessoaEditada).setNome(nome);
		arrayDisplay.get(Menu.pessoaEditada).setCpf(cpf);
		arrayDisplay.get(Menu.pessoaEditada).setDataNascimento(date);
		arrayDisplay.get(Menu.pessoaEditada).setEndere�o(endere�o);
		arrayDisplay.get(Menu.pessoaEditada).setSexo(sexo);
		arrayDisplay.get(Menu.pessoaEditada).setCurso(boxCurso);
		arrayDisplay.get(Menu.pessoaEditada).setTelefone(textTelefone);
		arrayDisplay.get(Menu.pessoaEditada).seteMail(textEMail);
		
		iniciaTabela();
		Menu.setTextAluno();
		Menu.pessoaEditada = -1;
	}
	
	public void refazTabela(){
		modelTabelaAluno.setRowCount(0);
		iniciaTabela();
	}

}
