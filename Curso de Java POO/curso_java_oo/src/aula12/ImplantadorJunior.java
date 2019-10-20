package aula12;

public class ImplantadorJunior extends Implantador {

	@Override
	public double calculaSalario() {
		return (getSalario() * 0.10) + getSalario();
	}

}
