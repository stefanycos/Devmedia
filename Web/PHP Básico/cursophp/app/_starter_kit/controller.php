<?php
	$titulo = "Manutenção de Usuários";
	$con = @mysqli_connect($db_host, $db_user, $db_pass, $db_name);
	
	if( mysqli_connect_errno($con) ){
		echo "A conexão falhou, erro reportado: ".mysqli_connect_error();
		exit();
	}
	
	//require("mdl_usuario.php");
	$passo = (isset($_GET['p'])) ? $_GET['p']: null;
	
	$tpl = new raintpl();
	
	switch($passo){
		default:
		inicial($con, $tpl);
		break;
	}
	
	function inicial($con, $tpl){
		$tpl = new raintpl();
		
		$tpl->assign("dados", $dados);
		show($tpl, "conteudo", true);
		
	}
	