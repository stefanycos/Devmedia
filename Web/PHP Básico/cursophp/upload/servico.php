<?php

$passo = (isset($_GET['p'])) ? $_GET['p'] : "";
$dir = "../_up/";

$ext_img = array('jpg','gif','png');
$ext_arq = array('doc','docx','pdf','zip','rar');

switch($passo){
	case "cadUsuario":
		cadUsuario($dir, $ext_img, $ext_arq);
		break;
	default:
		uploadBasico($dir, $ext_img, $ext_arq);
		break;
}

function cadUsuario($dir, $ext_img, $ext_arq){
	require("../app/usuario/mdl_usuario.php");
	require("../dbCon.php");
	require("../libs/funcoes.php");
	
	
	
	$usuario = tStr($_POST['txtNomeUsuario']);
	$idade = (int) $_POST['txtIdadeUsuario'];
	$foto = "";
	//tStr - chama a função que valida a String
	$senha = tStr($_POST['txtSenha']);
	
	$arquivo = $_FILES['arquivo'];
	$file = $dir.$arquivo['name'];
	
	$ext = strtolower(end(explode(".",$arquivo['name'])));
	
	if(array_search($ext,$ext_img) === 0) {
		if(move_uploaded_file($arquivo['tmp_name'], $file)){
			$foto = $arquivo['name'];
			
			include("../libs/wideimage/WideImage.php");
			WideImage::load($file)->resize(200, 150)->saveToFile($dir."thumbnail_p/".$foto);
			WideImage::load($file)->crop('center', 'center', 350, 250)->saveToFile($dir."thumbnail_m/".$foto);
		}
			
	} 
	
	
	$resultado = usuario_cadastrar( $conexao, $usuario, $idade, $foto, $senha);
	
	if($resultado){
		echo "Cadastro efetuado com sucesso!<br/>";
		
		echo "Nome: ".$usuario."<br/>";
		echo "Idade: ".$idade."<br/>";
		echo "Foto: <img width='150' src='../_up/".$foto."' />";
		
	} else {
		echo "O cadastro falhou!";
	}
}

function uploadBasico($dir, $ext_img, $ext_arq){
	$arquivo = $_FILES['arquivo'];
	$file = $dir.$arquivo['name'];
	
	$ext = strtolower(end(explode(".",$arquivo['name'])));
	
	if(array_search($ext,$ext_img) === false) {
		if(array_search($ext,$ext_arq) === false) {
			echo "O tipo do arquivo é incorreto!<br/>";
			return false;
		}
	}
	
	if(move_uploaded_file($arquivo['tmp_name'], $file)) {
		echo "O Arquivo foi enviado corretamente!<br/>";
		echo "<a href='../_up/".$arquivo['name']."'>arquivo</a><br/>";
		print_r($_FILES);
	} else {
		echo "O envio do arquivo falhou!";
		print_r($_FILES);
	}
}