<?php
	require("classes/db.class.php");
	
	// instanciar o objeto DB
	$db = new Db();
	$db->sql("SELECT * FROM usuario");
	print_r( $db->exec() );
?>