<?php

	// se o usuário não estiver logado, vamos abrir o formulário de login
	// mas, se o usuário estiver logado, vamos mostrar uma mensagem de boas vindas
	// e mostrar também o seu nome de usuário
	
	// iniciar o uso de sessão
	session_start();
	
	$titulo = "Aula 12 - Curso PHP";
	
	if(isset($_GET['ac']) && $_GET['ac'] == "logout" && isset($_SESSION['usuario'])) {
		setcookie("usuarioLogado","",time()-3600);
		unset($_SESSION['usuario']);
		unset($_COOKIE['usuarioLogado']);
	}
	
	if(isset($_POST['usuario']) && $_POST['usuario'] == "admin" && isset($_POST['senha']) && $_POST['senha'] == "1234") {
		
		if(isset($_POST['lembrar']) == "1"){
			
			//Criar um cookie que irá nos dizer que o usuario esta logado
			//Função time() - retorna a hora e data atual e multiplicação significa que o usuario ficará logado por um mês
			setcookie("usuarioLogado",$_POST['usuario'],time()+60*60*24);
		}
		
		$_SESSION['usuario'] = $_POST['usuario'];
		
		//escreve em nosso arquivo a data e o IP($_SERVER['REMOTE_ADDR']) do PC - "\r - e como se apertassemos o enter"
		fwrite($log,date("d/m/Y H:i:s")." ".$_SERVER['REMOTE_ADDR']." ".$_POST['usuario']."\r\n");
	}
	
	if(isset($_SESSION['usuario']) || isset($_COOKIE['usuarioLogado'])) {
		if(isset($_COOKIE['usuarioLogado']))
			$_SESSION['usuario'] = $_COOKIE['usuarioLogado'];
		
		// o usuário está logado
		require_once("tmpl_administrativo.php");
	} else {
		// o usuário não está logado
		require_once("tmpl_formularioLogin.php");
	}
	