package aula13;

public class Veiculo {
	
	private String cor;
	private int peso;
	
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	@Override
	public String toString() {
		return "=== Veiculo === \nCor: " + cor + " | Peso: " + peso;
	}
	
	

}
