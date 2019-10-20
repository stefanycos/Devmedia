package aula20;

public class Calculo implements Adicao, Multiplicacao {

	@Override
	public int multiplicar(int a, int b) {
		return a * b;
	}

	@Override
	public int somar(int a, int b) {
		return a + b;
	}

	
	
}
