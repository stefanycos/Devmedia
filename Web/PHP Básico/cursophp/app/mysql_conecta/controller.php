<?php
	
	$conexao = mysql_connect($db_host, $db_user, $db_pass, $db_name);
	
	if(mysqli_connect_errno($conexao)){
		$resultado = "Conexao Falhou: ".mysqli_connect_error();
	}else{
		$resultado = "Conexao Bem Sucedida";
	}
		
	
	mysql_close($conexao);	
	