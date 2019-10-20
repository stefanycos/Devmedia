package aula15;

public class B {
	
	public B(){
		go();
	}

	
	public B(String b){
		this();
	}
	private void go() {
		new B("b");
	}

}
