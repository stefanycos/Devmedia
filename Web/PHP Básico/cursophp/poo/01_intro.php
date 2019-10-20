<?php

// orientação a objetos 
// classes e os objetos

class usuario {
	public $nome = "Usuário sem nome";
	public $idade = "";
	
	function setNome($param){
		$this->nome = $param;
	}
	
	function getNome(){
		return $this->nome;
	}
	
	function setIdade($param){
		$this->idade = $param;
	}
	
	function getIdade(){
		return $this->idade;
	}
}

// utilizar a classe criada
// classe = é o projeto de um objeto
// objeto = é quando usamos a classe para criar um novo objeto em memória
// instanciar = criar um objeto apartir de uma classe

$usuario = new usuario(); // instanciamos um novo objeto
echo "O nome do usuário atual, é: ".$usuario->getNome()."<br/>";

// setar nome para o usuário
$usuario->setNome("Jaison Schmidt");

echo "O nome do usuário atual, é: ".$usuario->getNome()."<br/>";

?>