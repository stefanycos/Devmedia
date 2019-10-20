package aula10;

import java.time.LocalDate;

public class Aula {

	public static void main(String[] args) {
		
		Aluno a1 = new Aluno();
		a1.setDataNasc(LocalDate.of(1993, 12, 12));
		a1.setNome("Maria");
		a1.setSexo('F');
		a1.setSobrenome("Souza");
		a1.setTurno(Turno.MANHA);
		
		System.out.println(a1.toString());
		
		
		Professor p1 = new Professor();
		p1.setDataNasc(LocalDate.of(1986, 8, 25));
		p1.setHoras(Horas.TRINTA_HORAS);
		p1.setNome("Eduardo");
		p1.setSexo('M');
		p1.setSobrenome("Shecman");
		
		System.out.println(p1.toString());
	}

}
