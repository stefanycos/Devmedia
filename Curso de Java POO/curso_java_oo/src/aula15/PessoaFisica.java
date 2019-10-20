package aula15;

public class PessoaFisica extends Pessoa {

	public PessoaFisica(){
		super();
		System.out.println("PessoaFisica()");
	}
	
	public PessoaFisica(String nome){
		super(nome);
		System.out.println("PessoaFisica(String Pessoa Fisica)");
	}
}
