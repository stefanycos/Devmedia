package aula11;

public class Aluno extends Pessoa {
	
	@Override
	public void setMatricula(String matricula) {
		if(matricula.length() == 10){
			super.setMatricula(matricula);
		}else{
			System.out.println("Matricula Invalida! Aluno: " + getNome());
		}
	}

	@Override
	public void imprime() {
		// TODO Auto-generated method stub
		super.imprime();
	}
	
	

}
