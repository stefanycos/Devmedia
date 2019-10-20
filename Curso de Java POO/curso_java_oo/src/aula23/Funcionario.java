package aula23;

@FunctionalInterface
public interface Funcionario {
	
	abstract double remuneracao();
	
	default void imprime(){
		System.out.println(remuneracao());
	}
}
