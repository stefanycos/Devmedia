package aula19;

public class Aula {
	
	public static void main(String[] args) {
		
		System.out.println("Multiplicação = " + new Aula().getCalculo(2, 3));
	}
	
	int getCalculo(int x, int y){
		
		System.out.println("Valor de x = " + x);
		System.out.println("Valor de y = " + y);
		
		class Calculo{
			private int a;
			private int b;
			
			Calculo(){
				
			}
			
			Calculo(int a, int b){
				this.a = a;
				this.b = b;
			}
			
			int soma(){
				return x + y;
			}
			
			int multiplicar(){
				return a * b;
			}
		}
		
		System.out.println("Soma = " + new Calculo().soma());
		return new Calculo(10, 2).multiplicar();
	}

}
