package aula04;

public class Aula {
	
	int x = 1;
	String y = "Hello";
	String z = "World!";
	
	char c;
	
	void soma(int a, int b){
		int soma = a + b;
		System.out.println("A soma �: " + soma);
	}
	
	
	public static void main(String[] args) {
		Aula a = new Aula();
		
		int x2 = a.x +2;
		
		System.out.println("Valor de x: " + a.x);
		System.out.println("Valor de x2: " + x2);
		
		System.out.println(a.y + " " + a.z);
		
		a.soma(10, 20);
	}

}
