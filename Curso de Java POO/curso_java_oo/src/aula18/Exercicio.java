package aula18;

public class Exercicio {
	
	
	
	private class MyInnerClass{
		public void hello(){
			System.out.println("Olá, eu sou uma classe interna regular!");
		}
	}
	
	public static void main(String[] args) {
		
		//Outra maneira de acessar uma classe interna regular
		MyInnerClass mic = new  Exercicio().new MyInnerClass();
		mic.hello();
		
	}

}
