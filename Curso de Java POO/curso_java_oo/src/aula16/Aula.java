package aula16;

public class Aula {
	
	static String nome = "Ana";
	String sobrenome = "Monteiro";
	
	void imprime(){
		System.out.println(nome +" "+ sobrenome);
	}
	
	
	public static void main(String[] args) {
		
		/*new Aula().imprime();
		System.out.println(nome + " " + new Aula().sobrenome);
		
		show();
		
		MyClass my = new MyClass();
		my.imprime();
		my.show();
		*/
		
		Aula a1 = new Aula();
		a1.sobrenome = "da Silva";
		a1.nome = "Maria";
		
		Aula a2 = new Aula();
		a2.sobrenome = "da Souza";
		
		Aula a3 = new Aula();
		a3.sobrenome = "de Oliveira";
		
		System.out.println("a1: " + nome + " " + a1.sobrenome);
		System.out.println("a2: " + nome + " " + a2.sobrenome);
		System.out.println("a3: " + nome + " " + a3.sobrenome);
		System.out.println("a4: " + nome + " " + new Aula().sobrenome);
	}
	
	static void show(){
		System.out.println(nome + " " + new Aula().sobrenome);
	}
}
