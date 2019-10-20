package aula20;

public class Aula {
	
	public static void main(String[] args) {
		Calculo c = new Calculo();
		
		System.out.println("Soma = " + c.somar(2, 3));
		System.out.println("Mult = " + c.multiplicar(2, 3));
		
		Aula a = new Aula();
		System.out.println("MySoma = " + a.mySoma(10, 5));
		
		a.imprime(new Executa(){

			@Override
			public void executar() {

				System.out.println("Soma = " + c.somar(1, 3));
				System.out.println("Mult = " + c.multiplicar(1, 3));
			}
			
		});
	}
	
	
	void imprime(Executa executa){
		executa.executar();
	}
	
	int mySoma(int z, int y){
		
		Adicao adicao = new Adicao(){

			@Override
			public int somar(int a, int b) {
				return a + b;
			}
			
		};
		
		return adicao.somar(z, y);
	}

}
