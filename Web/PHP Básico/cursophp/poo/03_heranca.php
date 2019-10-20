<?php

	require("classes/db.class.php");
	require("classes/usuario.class.php");
	
	$usuario = new Usuario();
	echo $usuario->getTable()."<br/>";
	echo $usuario->getOla()."<br/>";
	
	$usuario->sql("SELECT * FROM usuario");
	print_r($usuario->exec());
	
?>