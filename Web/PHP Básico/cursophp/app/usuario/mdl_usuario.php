<?php

function usuario_listar($conexao){
	$sql = "SELECT id, nome, idade FROM usuario ORDER BY id";
	$resultado = mysqli_query($conexao, $sql);
	
	return $resultado;
}

function usuario_porId($conexao, $id){
	$sql = sprintf("SELECT id, nome, idade FROM usuario WHERE id = %s", $id);
	$resultado = mysqli_query($conexao, $sql);
	
	return $resultado;
}

function usuario_excluir($conexao, $id_usuario){
	$sql = sprintf("DELETE FROM usuario WHERE id = %s", $id_usuario);
	$resultado = mysqli_query($conexao, $sql);
	
	return $resultado;
}

function usuario_cadastrar($conexao, $usuario_nome, $usuario_idade, $usuario_foto = '', $usuario_senha = ''){
	if($usuario_nome == ""){
		return false;
	}
	if($usuario_idade == ""){
		$usuario_idade = 'NULL';
	}
	
	if($usuario_senha != ''){
		//Outros tipos de criptografia - md5, base64_encode
		$usuario_senha = sha1($usuario_senha);
	}
	
	$sql = sprintf("INSERT INTO usuario (nome, idade, foto, senha) VALUES ('%s', %s, '%s', '%s')", $usuario_nome, $usuario_idade, $usuario_foto, $usuario_senha);
	$resultado = mysqli_query($conexao, $sql) or die(mysqli_error($conexao));
	
	return $resultado;
}

function usuario_alterar($conexao, $usuario_nome, $usuario_idade, $usuario_id){
	if($usuario_nome == ""){
		return false;
	}
	if($usuario_idade == ""){
		$usuario_idade = 'NULL';
	}
	
	$sql = sprintf("UPDATE usuario SET nome = '%s', idade = %s WHERE id = %s", $usuario_nome, $usuario_idade, $usuario_id);
	$resultado = mysqli_query($conexao, $sql) or die(mysqli_error($conexao));
	
	return $resultado;
}