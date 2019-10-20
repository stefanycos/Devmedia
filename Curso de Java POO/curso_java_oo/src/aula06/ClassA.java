package aula06;

public class ClassA {
	
	private String privado;
	protected String protegido;
	public String publico;
	//Default
	String pacote;
	
public static void main(String[] args) {
		
		
		ClassA a = new ClassA();
		
		a.pacote = "Pacote A";
		a.protegido = "Protegido a";
		a.publico = "Public a";
		a.privado = "Privado a";
	}

}
