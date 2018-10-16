package tiago.projetos.pj0925.controller;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import tiago.projetos.pj0925.model.Aluno;
import tiago.projetos.pj0925.model.Funcionario;
import tiago.projetos.pj0925.model.Pessoa;
import tiago.projetos.pj0925.model.Professor;
import tiago.projetos.pj0925.view.CadastroAluno;
import tiago.projetos.pj0925.view.CadastroFuncionario;

public class ControllerMenu {
	private static ArrayList<Professor> arrayProfessor;
	private static ArrayList<Funcionario> arrayFuncion�rio;
	private static ArrayList<Aluno> arrayAluno;
	public static SimpleDateFormat sdf; 
	public static NumberFormat nF;
	
	public ControllerMenu() {
		arrayProfessor = new ArrayList<Professor>();
		arrayFuncion�rio = new ArrayList<Funcionario>();
		arrayAluno = new ArrayList<Aluno>();
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		nF = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
	}

	public static ArrayList<Professor> getArrayProfessor() {
		return ControllerMenu.arrayProfessor;
	}

	public static void setArrayProfessor(ArrayList<Professor> arrayProfessor) {
		ControllerMenu.arrayProfessor = arrayProfessor;
	}

	public static ArrayList<Funcionario> getArrayFuncion�rio() {
		return ControllerMenu.arrayFuncion�rio;
	}

	public static void setArrayFuncion�rio(ArrayList<Funcionario> arrayFuncion�rio) {
		ControllerMenu.arrayFuncion�rio = arrayFuncion�rio;
	}

	public static ArrayList<Aluno> getArrayAluno() {
		return ControllerMenu.arrayAluno;
	}

	public static void setArrayAluno(ArrayList<Aluno> arrayAluno) {
		ControllerMenu.arrayAluno = arrayAluno;
	}
	
	public String setTextPaneAluno(int i, CadastroAluno cA){
		String sexo = "";
		try {
			if (cA.getCA().getArrayDisplay().get(i).getSexo() == 'M'){
				sexo = "Masculino";
			} else {
				sexo = "Feminino";
			}
			sexo = "Matr�cula: " + cA.getCA().getArrayDisplay().get(i).getMatricula() + ";\nNome: " +cA.getCA().getArrayDisplay().get(i).getNome() + ";\nCPF: " + cA.getCA().getArrayDisplay().get(i).getCpf() + ";\nData de Nascimento: " + 
					ControllerMenu.sdf.format(cA.getCA().getArrayDisplay().get(i).getDataNascimento()) + ";\nEndere�o: " + cA.getCA().getArrayDisplay().get(i).getEndere�o() + ";\nSexo: " + sexo + ";\nCurso: " + cA.getCA().getArrayDisplay().get(i).getCurso() + 
					";\nTelefone: " + cA.getCA().getArrayDisplay().get(i).getTelefone() + ";\ne-mail: " + cA.getCA().getArrayDisplay().get(i).geteMail() + ";";
		} catch (Exception xcp) {
		}
		return sexo;
	}

	public String setTextPaneFuncionario(int i, CadastroFuncionario cF) {
		String sexo = "";
		try {
		if (cF.getCF().getArrayDisplay().get(i).getSexo() == 'M'){
			sexo = "Masculino";
		} else {	
			sexo = "Feminino";
		}
		sexo = "C�digo do cadastro: " + cF.getCF().getArrayDisplay().get(i).getCodCadastro() + ";\nNome: " + cF.getCF().getArrayDisplay().get(i).getNome() + ";\nCPF: " + 
				cF.getCF().getArrayDisplay().get(i).getCpf() + ";\nData de Nascimento: " + ControllerMenu.sdf.format(cF.getCF().getArrayDisplay().get(i).getDataNascimento()) + ";\nEndere�o: " + cF.getCF().getArrayDisplay().get(i).getEndere�o() +
		";\nSexo: " + sexo + ";\nCargo: " + cF.getCF().getArrayDisplay().get(i).getCargo() + ";\nSal�rio: " + nF.format(cF.getCF().getArrayDisplay().get(i).getSalario()) + ";\nValor do Vale Alimenta��o: " + 
		nF.format(cF.getCF().getArrayDisplay().get(i).getValeAlimenta��o()) + ";\nValor do Vale Refei��o: " + nF.format(cF.getCF().getArrayDisplay().get(i).getValeRefei��o()) + ";\nValor do Vale Transporte: " + 
		nF.format(cF.getCF().getArrayDisplay().get(i).getValeTransporte()) + ";\nTelefone: " + cF.getCF().getArrayDisplay().get(i).getTelefone() + ";\ne-mail: " + cF.getCF().getArrayDisplay().get(i).geteMail() + 
		";\nN�mero de filhos: " + cF.getCF().getArrayDisplay().get(i).getFilhos() + ";";
		if (cF.getCF().getArrayDisplay().get(i).getFilhos() != 0) {
			sexo += "\nFilhos:\n";
			for (Pessoa p : cF.getCF().getArrayDisplay().get(i).getCadastroFilhos()) {
				sexo += p.getNome() + " - " + ControllerMenu.sdf.format(p.getDataNascimento()) + "\n";
			}
		}
		} catch (Exception xcp) {
		}
		return sexo;
	}

	public String setTextPaneProfessor(int i, CadastroFuncionario cF) {
		String sexo = "";
		try {
		if (cF.getCP().getArrayDisplay().get(i).getSexo() == 'M'){
			sexo = "Masculino";
		} else {
			sexo = "Feminino";
		}
		sexo = "C�digo do cadastro: " + cF.getCP().getArrayDisplay().get(i).getCodCadastro() + ";\nNome: " + cF.getCP().getArrayDisplay().get(i).getNome() + ";\nCPF: " + 
				cF.getCP().getArrayDisplay().get(i).getCpf() + ";\nData de Nascimento: " + ControllerMenu.sdf.format(cF.getCP().getArrayDisplay().get(i).getDataNascimento()) + ";\nEndere�o: " + cF.getCP().getArrayDisplay().get(i).getEndere�o() +
		";\nSexo: " + sexo + ";\nCargo: " + cF.getCP().getArrayDisplay().get(i).getCargo() + ";\nSal�rio: " + nF.format(cF.getCP().getArrayDisplay().get(i).getSalario()) + ";\nValor do Vale Alimenta��o: " + 
		nF.format(cF.getCP().getArrayDisplay().get(i).getValeAlimenta��o()) + ";\nValor do Vale Refei��o: " + nF.format(cF.getCP().getArrayDisplay().get(i).getValeRefei��o()) + ";\nValor do Vale Transporte: " + 
		nF.format(cF.getCP().getArrayDisplay().get(i).getValeTransporte()) + ";\nTelefone: " + cF.getCP().getArrayDisplay().get(i).getTelefone() + ";\ne-mail: " + cF.getCP().getArrayDisplay().get(i).geteMail() + 
		";\nN�mero de filhos: " + cF.getCP().getArrayDisplay().get(i).getFilhos() + ";";
		if (cF.getCP().getArrayDisplay().get(i).getFilhos() != 0) {
			sexo += "\nFilhos:\n";
			for (Pessoa p : cF.getCP().getArrayDisplay().get(i).getCadastroFilhos()) {
				sexo += p.getNome() + " - " + ControllerMenu.sdf.format(p.getDataNascimento()) + "\n";
			}
		}
		} catch (Exception xcp) {
		}
		return sexo;
	}
}
