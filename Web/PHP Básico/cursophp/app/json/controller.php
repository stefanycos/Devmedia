<?php
	$titulo = "Manutenção de Usuários";
	$con = @mysqli_connect($db_host, $db_user, $db_pass, $db_name);
	
	if( mysqli_connect_errno($con) ){
		echo "A conexão falhou, erro reportado: ".mysqli_connect_error();
		exit();
	}
	
	//require("mdl_usuario.php");
	$passo = (isset($_GET['p'])) ? $_GET['p']: null;
	
	$tpl = new raintpl();
	
	switch($passo){
		case "jsonEncode":
			jsonEncode($con, $tpl);
			break;
		case "decodeIntermediario":
			jsonDecodeIntermediario($con, $tpl);
			break;
		default:
			jsonDecodeBasico($con, $tpl);
			break;
	}
	
	function jsonDecodeBasico($con, $tpl){
		$json = '{"nomeDoCampo" : "Curso PHP - JSON" }';
		$obj = json_decode($json);
		
		switch(json_last_error()){
			//JSON_ERROR_DEPTH JSON_ERROR_NONE
			case JSON_ERROR_SYNTAX :
				echo "Problema com a String JSON";
				break;
			case JSON_ERROR_NONE :
				echo "Valor: ".$obj->nomeDoCampo;
				break;
			default :
				echo "Erro JSON Desconhecido";
				break;
		}
		
	}
	
	function jsonEncode($con, $tpl){
		$usuarios = array( "usuarios" => array(
				array("nome" => "Oliver Queen", "Idade" => 29, "dataNascimento" => "01/01/2014"),
				array("nome" => "Oliver Queen", "Idade" => 29, "dataNascimento" => "01/01/2014"),
				array("nome" => "Oliver Queen", "Idade" => 29, "dataNascimento" => "01/01/2014"),
				array("nome" => "Oliver Queen", "Idade" => 29, "dataNascimento" => "01/01/2014")
		));
		$json = json_encode($usuarios);
		
		echo $json;
		
	}
	
	function jsonDecodeIntermediario($con, $tpl){
		$json = '{
			
			"usuarios" : 
			[
				{"nome": "Moira Queen", "Idade" : 29, "dataNascimento" : "02/02/1993"},
				{"nome": "Oliver Queen", "Idade" : 30, "dataNascimento" : "02/02/1993"},
				{"nome": "Tea Queen", "Idade" : 20, "dataNascimento" : "02/02/1993"},
				{"nome": "Malcon Merlyn", "Idade" : 53, "dataNascimento" : "02/02/1993"}
			]
		}
		
		';
		
		$obj = json_decode($json);
		
		foreach($obj->usuarios as $usuario){
			echo "<p>Nome: ".$usuario->nome." - Idade: ".$usuario->Idade." - Dt Nasc.:".$usuario->dataNascimento."</p>";
		}
	}