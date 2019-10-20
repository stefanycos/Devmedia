package aula16;

public class MyClass {
	
	void imprime(){
		System.out.println(Aula.nome + " " +new Aula().sobrenome);
	
		Aula.show();
		
		new Aula().imprime();
	}
	
	static void show(){
		System.out.println(Aula.nome + " " + new Aula().sobrenome);
	}

}
