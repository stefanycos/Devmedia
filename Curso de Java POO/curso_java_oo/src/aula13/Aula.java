package aula13;

public class Aula {
	private Veiculo veiculo;
	private Carro carro;
	private Moto moto;
	
	void veiculos(){
		veiculo = new Ford();
		veiculo.setCor("Amarelo");
		veiculo.setPeso(480);
		System.out.println(veiculo.toString());
		
		veiculo = new Yamaha(); // up cast
		veiculo.setCor("Rosa");
		veiculo.setPeso(400);
		
		moto = (Moto) veiculo; // down cast
		moto.setNome("Fazer 300");
		System.out.println(moto.toString() + " | " + moto.getNome());
	}
	
	void carrosEMotos(){
		carro = new Ford();
		carro.setCor("Amarelo");
		carro.setPeso(480);
		System.out.println(carro.toString());
		
		moto = new Yamaha();
		moto.setNome("Fazer 250");
		moto.setCor("Rosa");
		moto.setPeso(100);
		System.out.println(moto.toString() + " | " + moto.getNome());
	}
	
	public static void main(String[] args) {
		
		new Aula().veiculos();
		
		Ford f = new Ford();
		f.setCor("Preto");
		f.setPeso(600);
		System.out.println(f.toString());
		
		Yamaha y = new Yamaha();
		y.setCor("Azul");
		y.setPeso(120);
		System.out.println(y.toString());
	}

}
