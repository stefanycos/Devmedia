<?php 
	require("../dbCon.php");
	
	try {
		$pdo = new PDO('mysql:host='.$db_host.';port=3306;dbname='.$db_name,$db_user,$db_pass);
		
		$usuario = "Usuario Criado via PDO";
		$idade = 30;
		$senha = sha1 ('1234');
		
		//Inserção Via PDO
		$ins = $pdo->prepare("INSERT INTO usuario(nome, idade, senha) VALUES(:nome,:idade,:senha)");
		
		//Passando as variaveis para inserir
		$ins->bindParam(":nome", $usuario);
		$ins->bindParam(":idade", $idade);
		$ins->bindParam(":senha",$senha);
		
		$ins->execute();
		
		//Fecha/Limpa a Conexão
		$ins = null;
		
		//Listar Dados Via PDO, usando a função prepare
		$obj = $pdo->prepare("SELECT id, nome, idade FROM usuario");
		
		if($obj->execute()){
			//Se as linhas retornadas form maior que 0 exibe
			if($obj->rowCount() > 0){
				// Faz a iteração com o retorno da consulta
				while($row = $obj->fetch(PDO::FETCH_OBJ)){
					echo $row->id." - ".$row->nome." - ".$row->idade."<br/>";
				}
			}
		}
		$obj = null;
	
	} catch(PDOException $e){
		echo $e->getMessage();
	}