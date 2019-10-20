package aula18;

import java.time.LocalDate;

public class Aula {
	
	public static void main(String[] args) {
		
		Pessoa p = new Pessoa();
		p.setNome("Ana");
		p.setSobrenome("Pinheiro");
		p.setDtNascimento(LocalDate.of(1980, 5, 15));
		
		System.out.printf("%s %s possui %d anos, %d meses, %d dias.  ", p.getNome(), p.getSobrenome(), 
				p.getIade().getAnos(), p.getIade().getMeses(), p.getIade().getDias());
		
	}

}
