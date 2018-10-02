package tiago.projetos.pj0925.controller;

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
	
	public void geraListaAluno(DefaultTableModel model) {
		String nome2 = "Tiago de Morais Fran�a";
		for (int i = 0; i < 40; i++) {
			nome2 = nome2 + i;
			arrayAluno.add(new Aluno(nome2, "07378278904", "123456789", new Date(), "Rua", 'M', "Java WEB", "43999565338", "tiagomfr@gmail.com"));
		}
		
		for (Aluno aluno : arrayAluno) {
			String matr�cula = aluno.getMatricula().toString();
			String cpf = aluno.getCpf();
			String nome = aluno.getNome();
			String curso = aluno.getCurso();
			String email = aluno.geteMail();
			Object[] linha = {matr�cula, cpf, nome, curso, email};
			model.addRow(linha);
		}
	}
	
	public String setTextTabela(int i){
		return "Matr�cula: " + arrayAluno.get(i).getMatricula() + "\nNome: " + arrayAluno.get(i).getNome() + ";";
	}
}
