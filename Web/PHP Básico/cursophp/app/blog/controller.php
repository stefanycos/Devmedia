<?php
	$titulo = "Aula 11 - Curso PHP";
	$nome = "Stefany Cristina";
	$idade = 22;
	$dtNasc = "13/09/1993";
	
	$mensagem = "";
	
	if($idade < 18){
		$mesagem = "Menor de Idade";
	}else{
		$mensagem = "Maior de Idade";
	}
	
	//Calculando o quadrado de um numero
	$retorno = quadrado(4);
	$funcao =  "O quadrado de 4 é: ".$retorno;
	
	$concatenei = concatenar("Stefany", "Cristina");