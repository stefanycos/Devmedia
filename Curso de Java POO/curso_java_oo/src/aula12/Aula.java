package aula12;

public class Aula {

	public static void main(String[] args) {

		Programador p = new Programador();
		p.setNome("Joao Nascimento");
		p.setSalario(3.500);
		
		System.out.printf("Programador: %s - R$ %.3f ", p.getNome(), p.calculaSalario());
		
		System.out.println();
		Analista g = new Analista();
		g.setNome("Maria Nascimento");
		g.setSalario(500);
		
		System.out.printf("Analista: %s - R$ %.3f ", g.getNome(), g.calculaSalario());
		
		
		System.out.println();
		ImplantadorJunior i = new ImplantadorJunior();
		i.setNome("Maria Nascimento");
		i.setSalario(500);
		
		System.out.printf("Implantador: %s - R$ %.3f ", i.getNome(), i.calculaSalario());
		
	}

}
