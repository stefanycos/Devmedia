<?php

//Arquivo de funções: funções de uso geral em nossa aplicação
	
	
	//Função que rederiza o template geral padrao do sistema
	function show($tpl, $conteudo = "", $titulo = "Titulo Pagina", $template = "default"){
		$tpl->assign("titulo", $titulo);
		$tpl->assign("conteudo", $conteudo);
		$tpl->draw($template);
	}
	
	//Função que calcula o quadrado de um nº passado por parametro
	function quadrado($num, $escreve = false){
		//Se o parametro for false retornamos o valor
		//se for true, escremos o valor na tela
		
		$resultado = $num * $num;
		
		if($escreve == false){
			return $resultado; 
		}else{
			echo $resultado;
		}
	}
	
	function concatenar($string1, $string2){
		return $string1.$string2;
	}