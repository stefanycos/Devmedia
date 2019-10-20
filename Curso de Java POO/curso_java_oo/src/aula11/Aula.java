package aula11;

public class Aula {

	public static void main(String[] args) {

		Aluno a = new Aluno();
		a.setNome("Maria Severina");
		a.setMatricula("153399-XXV");
		System.out.println("Nome: " + a.getNome() + " | Matricula: "+ a.getMatricula());
		
		System.out.println("\n");
		
		Aluno b = new Aluno();
		b.setNome("Marcos Alencar");
		b.setMatricula("1533");
		System.out.println("Nome: " + a.getNome() + " | Matricula: "+ a.getMatricula());
		
		System.out.println("\n");
		
		Professor c = new Professor();
		c.setNome("Professor Fulano");
		c.setMatricula("153");
		System.out.println("Nome: " + a.getNome() + " | Matricula: "+ a.getMatricula());
		
		System.out.println("\n");
		
		
	}

}
