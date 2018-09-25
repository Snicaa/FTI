package tiago.projetos.pj0925.model;

import java.util.Date;

public class Professor extends Pessoa {
	private String enderešo, disciplina, telefone, eMail; 
	
	public Professor(){
		super("Tiago", "0", new Date(), 'M');
		this.enderešo = "Rua";
	}
	
	public Professor(String nome, String cpf, Date dataNascimento, char sexo, String enderešo, String disciplina,
			String telefone, String eMail){
		super(nome, cpf, dataNascimento, sexo);
		this.enderešo = enderešo;
		this.disciplina = disciplina;
		this.telefone = telefone;
		this.eMail = eMail;
	}

	public String getEnderešo() {
		return enderešo;
	}

	public void setEnderešo(String enderešo) {
		this.enderešo = enderešo;
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
