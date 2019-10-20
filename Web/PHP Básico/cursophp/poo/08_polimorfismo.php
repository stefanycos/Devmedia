<?php
	class Classe01{
		function conectar(){
			echo "Chamou o Método Conectar da Classe 01 <br/>";
		}
	}
	
	
	class Classe02 extends Classe01{
		function conectar(){
			echo "Chamou o Método Conectar da Classe 02<br/>";
		}
	}
	
	class Classe03 extends Classe02{
		function conectar(){
			echo "Chamou o Método Conectar da Classe 03<br/>";
		}
	}
	
	$var1 = new Classe01();
	$var2 = new Classe02();
	$var3 = new Classe03();
	
	$var1->conectar();
	$var2->conectar();
	$var3->conectar();
?>