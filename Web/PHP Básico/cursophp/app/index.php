<?php
	
	$titulo = "Aula 18 - Curso PHP";
	//Tem que ser a primeira coisa a fazer antes de acessar qq pagina
	//Verificar se o IP que esta tentanto cessar a pagina não esta na nossa block list
	$ipsBloqueados = array();
	
	foreach($ipsBloqueados as $ip){
		
		
		if($ip = $_SERVER['REMOTE_ADDR']){
			
			//se o ip estiver na lista redirecionamos o usuario p pagina acesso negado
			header("Location: /cursophp/app/negado.php");
			
			//Colocamos o exit, pois o que esta abaixo ñ será executado
			exit;
		}
		
	}
	
	//RainTPL - Criando uma instancia da raintpl
	include ("lib/template/raintpl/rain.tpl.class.php");
	raintpl::$tpl_dir = $_GET['r']."/tpl/";
	raintpl::$cache_dir = $_GET['r']."/tmp/";
	
	
	//Previne cache na pagina
	header("Expires: Mon, 21 Out 1999 00:00:00 GMT");
	header("Cache-control: no-cache");
	header("Pragma; no-cache");
	
	
	//declaração dos dados do banco de dados
	//O que precisamos: host, username, dbnome
	$db_host = "localhost";
	$db_user = "root";
	$db_pass = "";
	$db_name = "exemplo01";
	
	
	//Vamos receber uma variavel chamada "r" que significa rota
	$r = $_GET['r'];
	
	require_once("14-funcoes.php");
	require_once($r."/index.php");