package aluno;

import java.util.Calendar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Aluno {
	private String nome;
	private String matricula;
	private int idade;
	private Calendar dataNascimento;
	private String data;
	private String CPF;
	private String telefone;
	public static int numMatricula = 0;
	public static ObservableList<Aluno> arrayAluno = FXCollections.observableArrayList();

	Aluno(){
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		this.CPF = cPF;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
