<?php

	require("classes/abstrata.class.php");
	
	$esp = new Especifica();
	
	$esp->escreve("Devmedia");
	$esp->digaOla();
	
	$mesp = new MuitoEspecifica();
	$mesp->digaOla();
?>