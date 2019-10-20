package aula08;

public class Aula {

	public static void main(String[] args) {
		
		Livro l1 = new Livro();
		l1.setTitulo("Java I");
		l1.setAutor("Beltrano");
		l1.setPaginas(50);
		l1.setLancamento(false);
		System.out.println(l1.toString());
		
		Livro l2 = new Livro("Java II");
		System.out.println(l2.toString());
		
		Livro l3 = new Livro(50);
		System.out.println(l3.toString());
		
		Livro l4 = new Livro("Java III", "Beltrano", 58, true);
		System.out.println(l4.toString());
	}
}
