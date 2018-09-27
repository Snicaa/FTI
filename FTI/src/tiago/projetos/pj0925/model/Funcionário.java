package tiago.projetos.pj0925.model;

import java.util.ArrayList;
import java.util.Date;

public class Funcion�rio extends Pessoa {
	private String endere�o, cargo, telefone, eMail;
	double salario, valeAlimenta��o, valeTransporte, valeRefei��o;
	private int filhos;
	private ArrayList<Pessoa> cadastroFilhos;
	
	public Funcion�rio(String nome, String cpf, Date dataNascimento, String endere�o, char sexo, String cargo, double salario,
			double valeAlimenta��o, double valeTransporte, double valeRefei��o, int filhos, ArrayList<Pessoa> cadastroFilhos,
			String telefone, String eMail){
		super(nome, cpf, dataNascimento, sexo);
		this.endere�o = endere�o;
		this.cargo = cargo;
		this.salario = salario;
		this.valeAlimenta��o = valeAlimenta��o;
		this.valeTransporte = valeTransporte;
		this.valeRefei��o = valeRefei��o;
		this.filhos = filhos;
		this.cadastroFilhos = cadastroFilhos;
		this.telefone = telefone;
		this.eMail = eMail;
	}

	public String getEndere�o() {
		return endere�o;
	}

	public void setEndere�o(String endere�o) {
		this.endere�o = endere�o;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getValeAlimenta��o() {
		return valeAlimenta��o;
	}

	public void setValeAlimenta��o(double valeAlimenta��o) {
		this.valeAlimenta��o = valeAlimenta��o;
	}

	public double getValeTransporte() {
		return valeTransporte;
	}

	public void setValeTransporte(double valeTransporte) {
		this.valeTransporte = valeTransporte;
	}

	public double getValeRefei��o() {
		return valeRefei��o;
	}

	public void setValeRefei��o(double valeRefei��o) {
		this.valeRefei��o = valeRefei��o;
	}

	public int getFilhos() {
		return filhos;
	}

	public void setFilhos(int filhos) {
		this.filhos = filhos;
	}

	public ArrayList<Pessoa> getCadastroFilhos() {
		return cadastroFilhos;
	}

	public void setCadastroFilhos(ArrayList<Pessoa> cadastroFilhos) {
		this.cadastroFilhos = cadastroFilhos;
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
