<?php

	$titulo = "Login Form";
	
	session_start();
	
	if(isset($_GET['ac']) && $_GET['ac'] == "logout" && isset($_SESSION['usuario'])){
		unset($_SESSION['usuario']);
	}
	
	if(isset($_POST['usuario']) && $_POST['usuario'] == "admin" && isset($_POST['senha']) && $_POST['senha'] == "1234") {
		$_SESSION['usuario'] = $_POST['usuario'];
	}
	
	if(isset($_SESSION['usuario'])) {
		// o usuário está logado
		require_once("tmpl_administrativo.php");
	} else {
		// o usuário não está logado
		require_once("tmpl_formularioLogin.php");
	}
	