<?php
	// criamos a conexão
	include("../dbCon.php");
	include("../libs/funcoes.php");

	// pegamos o usuário e senha
	$usuario = tStr($_GET['usuario']);
	$senha = tStr($_GET['senha']);

	// criamos um sql que busca o usuario e a senha no banco
	$sql = "SELECT * FROM usuario WHERE nome='".$usuario."' AND senha='".$senha."'";

	// executamos a consulta
	$ret = mysqli_query($conexao, $sql);

	// se encontrou resultados, deixamos acessar o sistema
	if(mysqli_num_rows($ret) > 0){
		echo "Usuario Logado, Sistema Liberado!";
	}else{
		echo "Falha no login, Bloqueado!";
	}