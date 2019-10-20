<?php

	//TRAIT - Usado para faciliatar a utilização de uma classe dentro de outra
	trait Log{
		
		function log($mensagem){
			
			
			//o usuario tal exclui o registro tal - horario
			echo $mensagem." - ".date("d/m/Y H:i:s")."<br/>";
		}
	}
?>