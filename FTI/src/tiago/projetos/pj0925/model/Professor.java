package tiago.projetos.pj0925.model;

import java.util.ArrayList;
import java.util.Date;

public class Professor extends Funcionario {
	private String disciplina;
	
	public Professor(){}
	
	public Professor(String codCadastro, String nome, String cpf, Date dataNascimento, String endere�o, char sexo, String cargo, String disciplina,
			double salario, double valeAlimenta��o, double valeTransporte, double valeRefei��o, int filhos, 
			ArrayList<Pessoa> cadastroFilhos, String telefone, String eMail){
		super(codCadastro, nome, cpf, dataNascimento, endere�o, sexo, cargo, salario, valeAlimenta��o, valeTransporte, valeRefei��o, filhos,
				cadastroFilhos, telefone, eMail);
		this.disciplina = disciplina;
	}

	public String getDisciplina() {
		return disciplina;
	}
	
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
}
