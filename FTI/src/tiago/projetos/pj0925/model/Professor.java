package tiago.projetos.pj0925.model;

import java.util.Date;

public class Professor extends Pessoa {
	private String endere�o, disciplina, telefone, eMail; 
	
	public Professor(){
		super("Tiago", "0", new Date(), 'M');
		this.endere�o = "Rua";
	}
	
	public Professor(String nome, String cpf, Date dataNascimento, char sexo, String endere�o, String disciplina,
			String telefone, String eMail){
		super(nome, cpf, dataNascimento, sexo);
		this.endere�o = endere�o;
		this.disciplina = disciplina;
		this.telefone = telefone;
		this.eMail = eMail;
	}

	public String getEndere�o() {
		return endere�o;
	}

	public void setEndere�o(String endere�o) {
		this.endere�o = endere�o;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
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
