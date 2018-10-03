package tiago.projetos.pj0925.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import tiago.projetos.pj0925.model.Aluno;
import tiago.projetos.pj0925.model.Funcion�rio;
import tiago.projetos.pj0925.model.Professor;

public class ControllerMenu {
	private static ArrayList<Professor> arrayProfessor;
	private static ArrayList<Funcion�rio> arrayFuncion�rio;
	private static ArrayList<Aluno> arrayAluno;
	public static SimpleDateFormat sdf; 
	
	public ControllerMenu() {
		arrayProfessor = new ArrayList<Professor>();
		arrayFuncion�rio = new ArrayList<Funcion�rio>();
		arrayAluno = new ArrayList<Aluno>();
		sdf = new SimpleDateFormat("dd/mm/yyyy");
	}

	public static ArrayList<Professor> getArrayProfessor() {
		return ControllerMenu.arrayProfessor;
	}

	public static void setArrayProfessor(ArrayList<Professor> arrayProfessor) {
		ControllerMenu.arrayProfessor = arrayProfessor;
	}

	public static ArrayList<Funcion�rio> getArrayFuncion�rio() {
		return ControllerMenu.arrayFuncion�rio;
	}

	public static void setArrayFuncion�rio(ArrayList<Funcion�rio> arrayFuncion�rio) {
		ControllerMenu.arrayFuncion�rio = arrayFuncion�rio;
	}

	public static ArrayList<Aluno> getArrayAluno() {
		return ControllerMenu.arrayAluno;
	}

	public static void setArrayAluno(ArrayList<Aluno> arrayAluno) {
		ControllerMenu.arrayAluno = arrayAluno;
	}
	
	public String setTextPaneAluno(int i){
		String sexo = "";
		if (arrayAluno.get(i).getSexo() == 'M'){
			sexo = "Masculino";
		} else {
			sexo = "Feminino";
		}
		return "Matr�cula: " + arrayAluno.get(i).getMatricula() + ";\nNome: " + arrayAluno.get(i).getNome() + ";\nCPF: " + arrayAluno.get(i).getCpf() + ";\nData de Nascimento: " + 
				ControllerMenu.sdf.format(arrayAluno.get(i).getDataNascimento()) + ";\nEndere�o: " + arrayAluno.get(i).getEndere�o() + ";\nSexo: " + sexo + ";\nCurso: " + arrayAluno.get(i).getCurso() + 
				";\nTelefone: " + arrayAluno.get(i).getTelefone() + ";\ne-mail: " + arrayAluno.get(i).geteMail() + ";";
	}

	public String setTextPaneFuncionario(int i) {
		String sexo = "";
		if (arrayFuncion�rio.get(i).getSexo() == 'M'){
			sexo = "Masculino";
		} else {
			sexo = "Feminino";
		}
		return "C�digo do cadastro: " + arrayFuncion�rio.get(i).getCodCadastro() + ";\nNome: " + arrayFuncion�rio.get(i).getNome() + ";\nCPF: " + 
		arrayFuncion�rio.get(i).getCpf() + ";\nData de Nascimento: " + ControllerMenu.sdf.format(arrayFuncion�rio.get(i).getDataNascimento()) + ";\nEndere�o: " + arrayFuncion�rio.get(i).getEndere�o() +
		";\nSexo: " + sexo + ";\nCargo: " + arrayFuncion�rio.get(i).getCargo() + ";\nSal�rio: R$" + arrayFuncion�rio.get(i).getSalario() + ";\nValor do Vale Alimenta��o: R$" + 
		arrayFuncion�rio.get(i).getValeAlimenta��o() + ";\nValor do Vale Refei��o: R$" + arrayFuncion�rio.get(i).getValeRefei��o() + ";\nValor do Vale Transporte: R$" + 
		arrayFuncion�rio.get(i).getValeTransporte() + ";\nTelefone: " + arrayFuncion�rio.get(i).getTelefone() + ";\ne-mail: " + arrayFuncion�rio.get(i).geteMail() + 
		";\nN�mero de filhos: " + arrayFuncion�rio.get(i).getFilhos() + ";";
	}

	public String setTextPaneProfessor(int i) {
		String sexo = "";
		if (arrayProfessor.get(i).getSexo() == 'M'){
			sexo = "Masculino";
		} else {
			sexo = "Feminino";
		}
		return "C�digo do cadastro: " + arrayProfessor.get(i).getCodCadastro() + ";\nNome: " + arrayProfessor.get(i).getNome() + ";\nCPF: " + 
		arrayProfessor.get(i).getCpf() + ";\nData de Nascimento: " + ControllerMenu.sdf.format(arrayProfessor.get(i).getDataNascimento()) + ";\nEndere�o: " + arrayProfessor.get(i).getEndere�o() +
		";\nSexo: " + sexo + ";\nCargo: " + arrayProfessor.get(i).getCargo() + ";\nDisciplina: " + arrayProfessor.get(i).getDisciplina() + ";\nSal�rio: R$" + arrayProfessor.get(i).getSalario() + ";\nValor do Vale Alimenta��o: R$" + 
		arrayProfessor.get(i).getValeAlimenta��o() + ";\nValor do Vale Refei��o: R$" + arrayProfessor.get(i).getValeRefei��o() + ";\nValor do Vale Transporte: R$" + 
		arrayProfessor.get(i).getValeTransporte() + ";\nTelefone: " + arrayProfessor.get(i).getTelefone() + ";\ne-mail: " + arrayProfessor.get(i).geteMail() + 
		";\nN�mero de filhos: " + arrayProfessor.get(i).getFilhos() + ";";
	}
}
