<?php

class Db {
	// public, protected e private
	public $con = NULL;
	protected $sql = "";
	protected $host = "localhost";
	protected $base = "exemplo01";
	protected $user = "root";
	protected $pass = "";
	
	const ola = "Essa é a classe pai";
	
	function __construct(){
		echo "Objeto inicializado<br/>";
		$this->con = mysqli_connect($this->host, $this->user, $this->pass, $this->base);
		if( mysqli_connect_errno($this->con) ){
			echo "A conexão falhou, erro reportado: ".mysqli_connect_error();
		}
	}
	
	function __destruct(){
		echo "<br/>Objeto finalizado";
		mysqli_close($this->con);
	}
	
	function sql($sql){
		$this->sql = $sql;
	}
	
	function exec(){
		if($this->sql == "") return false;
		return mysqli_query($this->con, $this->sql);
	}
}