package aula12;

public class Programador extends Funcionario {
	
	@Override
	public double calculaSalario() {
		return (getSalario() * 0.30) + getSalario();
	}

}
