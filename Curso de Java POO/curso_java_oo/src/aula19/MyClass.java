package aula19;

public class MyClass {
	
	private int a;
	private static int valor = 1000;
	
	
	public MyClass(int a){
		this.a = a;
	}
	
	public MyStaticClass getMyStaticClass(){
		return new MyStaticClass(a);
	}
	
	//Classe Interna Estatica
	private static class MyStaticClass{
		
		private int valor;
		
		public MyStaticClass(int valor){
			this.valor = valor;
		}
		
		public void imprime(){
			System.out.println(valor);
		}
	}
	
	//FIM Classe Interna Estatica
	
	public static void main(String[] args) {
		
		int a = MyClass.valor;
		
		//Este NEW se refere a MyStaticClass
		MyStaticClass m =  new MyClass.MyStaticClass(500);
		m.imprime();
		
		MyClass mc = new MyClass(999);
		mc.getMyStaticClass().imprime();
	}

}
