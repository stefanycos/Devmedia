<?php

	abstract class Abstrata{
		
		abstract function digaOla();
		
		function escreve($mensagem){
			echo $mensagem."<br/>";
		}
	}
	
	class Especifica extends Abstrata{
		
		function digaOla(){
			echo "Hello!"."<br/>";
		}
	}
	
	class MuitoEspecifica extends Abstrata{
		
		function digaOla(){
			echo "Hello Again!"."<br/>";
		}
	}
	
?>