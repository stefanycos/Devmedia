package aula11;

public class Professor extends Pessoa {
	
	@Override
	public void setMatricula(String matricula) {
		if(matricula.length() == 3){
			super.setMatricula(matricula);
		}else{
			System.out.println("Matricula Invalida");
		}
		
	}

}
