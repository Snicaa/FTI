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
	
	public ControllerMenu() {
		arrayProfessor = new ArrayList<Professor>();
		arrayFuncion�rio = new ArrayList<Funcion�rio>();
		arrayAluno = new ArrayList<Aluno>();
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
	
	public String setTextTabela(int i){
		String sexo = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		if (arrayAluno.get(i).getSexo() == 'M'){
			sexo = "Masculino";
		} else {
			sexo = "Feminino";
		}
		return "Matr�cula: " + arrayAluno.get(i).getMatricula() + "\nNome: " + arrayAluno.get(i).getNome() + ";\nCPF: " + arrayAluno.get(i).getCpf() + ";\nData de Nascimento: " + 
				sdf.format(arrayAluno.get(i).getDataNascimento()) + ";\nEndere�o: " + arrayAluno.get(i).getEndere�o() + ";\nSexo: " + sexo + ";\nCurso: " + arrayAluno.get(i).getCurso() + 
				";\nTelefone: " + arrayAluno.get(i).getTelefone() + ";\ne-mail: " + arrayAluno.get(i).geteMail() + ";";
	}
}
