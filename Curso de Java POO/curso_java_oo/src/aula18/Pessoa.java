package aula18;

import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
	
	private String nome;
	private String sobrenome;
	private LocalDate dtNascimento;
	
	
	public CalculaIdade getIade(){
		return new Idade();
	}
	
	//Classe Interna
	private class Idade implements CalculaIdade{

		@Override
		public int getAnos() {
			Period p = Period.between(dtNascimento, LocalDate.now());
			return p.getYears();
		}

		@Override
		public int getMeses() {
			Period p = Period.between(dtNascimento, LocalDate.now());
			return p.getMonths();
		}

		@Override
		public int getDias() {
			Period p = Period.between(dtNascimento, LocalDate.now());
			return p.getDays();
		}
		
	}
	//Fim Classe Interna
	
	
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
	public LocalDate getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	
	

}
