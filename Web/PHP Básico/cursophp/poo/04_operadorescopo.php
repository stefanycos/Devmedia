<?php
	
	define("IDIOMA","pt-br");
	require("language/".IDIOMA.".lang.php");
	
	//Operador de Escopo:
	//Da acesso a um objeto de uma classe, sem a necessidade de instanciar
	echo Lang::MENSAGEM_DE_BOAS_VINDAS."<br/>".Lang::MENSAGEM_DE_SAIDA_DO_SISTEMA;
?>