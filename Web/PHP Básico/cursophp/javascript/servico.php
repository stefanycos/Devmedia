<?php

	$passo = (isset($_GET['p'])) ? $_GET['p'] : "";

	switch($passo){
		case "excUsuario":
			excUsuario();
			break;
		case "listarDados":
			listarDados();
			break;
		case "cadUsuario" :
			cadUsuario();
			break;
		default:
			getRetorno();
			break;
	}

	function getRetorno(){
		echo "<h2>este texto veio pelo php</h2>";
	}

	function cadUsuario(){
		require("../app/usuario/mdl_usuario.php");
		require("../dbCon.php");
		
		$usuario = $_POST['txtNome'];
		$idade = (int) $_POST['txtIdade'];
		$resultado = usuario_cadastrar( $conexao, $usuario, $idade);
		
		if($resultado){
			echo "Cadastro efetuado com sucesso!";
		} else {
			echo "O cadastro falhou!";
		}
	}

	function listarDados(){
		require("../app/usuario/mdl_usuario.php");
		require("../dbCon.php");
		
		$resultado = usuario_listar($conexao);
		$data = array();
		
		while($row = mysqli_fetch_array($resultado)){
			$data[] = array("id" => $row['id'], "nome" => utf8_encode ( $row['nome'] ), "idade" => ($row['idade'] == "") ? "--" : $row['idade']);
		}
		
		echo json_encode($data);
	}
	
	function excUsuario(){
		require("../app/usuario/mdl_usuario.php");
		require("../dbCon.php");
		
		if(usuario_excluir($conexao, (int)$_GET['cod'])){
			echo "Excluido com Sucesso!";
		}else{
			echo "Exclusão Falhou";
		}
	}
?>