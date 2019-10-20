package aula10;

import java.time.LocalDate;

public class Pessoa {
	
	private String nome;
	private String sobrenome;
	private LocalDate dataNasc;
	private char sexo;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public LocalDate getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	@Override
	public String toString() {
		return "Nome: " + nome + "| Sobrenome: " + sobrenome + "| Data Nasc: " + dataNasc + "| Sexo: " + sexo + " - ";
	}
	
	

}
