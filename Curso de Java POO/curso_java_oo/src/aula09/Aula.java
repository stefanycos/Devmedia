package aula09;

public class Aula {
	
	//CONSTANTES
	public static final String OURO = "ouro";
	public static final String PAUS = "paus";
	public static final String ESPADAS = "espadas";
	public static final String COPAS = "copas";
	
	public enum Option {
		YES, NO
	}
	
	public static void main(String[] args) {
		TrueOrFalse t =  TrueOrFalse.FALSE;
		System.out.println(t);
		System.out.println(t.getIndex());
		System.out.println(t.getDesc());
		
		for(TrueOrFalse t2: TrueOrFalse.values()){
			System.out.println(t2);
		}
		
		//Utilizando Enum para Constantes
		Carta carta = Carta.PAUS;
		
		switch (carta) {
		case OURO:
			System.out.println("Sua Carta é OURO");
			break;
		case PAUS:
			System.out.println("Sua Carta é PAUS");
			break;
		case ESPADAS:
			System.out.println("Sua Carta é ESPADAS");
			break;
		case COPAS:
			System.out.println("Sua Carta é COPAS");
			break;
		default:
			System.out.println("Nenhum Naipe Presente1");
			break;
		}
		
		//-----------------------------------
		String naipe = Aula.COPAS;
		
		switch (naipe) {
		case Aula.OURO:
			System.out.println("Sua Carta é OURO");
			break;
		case Aula.PAUS:
			System.out.println("Sua Carta é PAUS");
			break;
		case Aula.ESPADAS:
			System.out.println("Sua Carta é ESPADAS");
			break;
		case Aula.COPAS:
			System.out.println("Sua Carta é COPAS");
			break;
		default:
			System.out.println("Nenhum Naipe Presente1");
			break;
		}
		
		
	}
	
}
