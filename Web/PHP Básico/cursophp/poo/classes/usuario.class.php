<?php

class Usuario extends Db {
	const table = "usuario";
	
	function getTable(){
		return self::table;
	}
	
	function getOla(){
		return parent::ola;
	}
}