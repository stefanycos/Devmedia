package aula06;

import aula05.ClassB;

public class Aula extends ClassB{

	
	public static void main(String[] args) {
		
		
		ClassA a = new ClassA();
		
		a.pacote = "Pacote A";
		a.protegido = "Protegido a";
		a.publico = "Public a";
		
		ClassB b = new ClassB();
		b.publico = "Public B";
		
		Aula aula = new Aula();
		aula.publico = "Publico de b";
		aula.protegido = "Protegido de b por Herança";
	}
}
