<?php
	
	function tStr($string){
		return addslashes(htmlentities(utf8_decode(trim($string))));
	}
	
	//Trim - tira os espacços em branco
	//utf8_decode - ajusta os caracteres acentuados
	//htmlentities - converte simbolos html em entidades html
	//addslashes - converte alguns simbolos
	
	//Fazendo estes ajustes mesmo q coloquemos algum codigo, não é executado

?>