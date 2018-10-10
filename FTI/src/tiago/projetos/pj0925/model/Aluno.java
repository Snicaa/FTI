package tiago.projetos.pj0925.model;

import java.util.Date;

public class Aluno extends Pessoa {
	private String matricula, endere�o, curso, telefone, eMail; 
	
	
	public Aluno(){
		super();
	}
	
	public Aluno(String nome, String cpf, String matricula, Date dataNascimento, String endere�o, char sexo, String curso,
			String telefone, String eMail){
		super(nome, cpf, dataNascimento, sexo);
		this.matricula = matricula;
		this.endere�o = endere�o;
		this.curso = curso;
		this.telefone = telefone;
		this.eMail = eMail;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getEndere�o() {
		return endere�o;
	}

	public void setEndere�o(String endere�o) {
		this.endere�o = endere�o;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

}
