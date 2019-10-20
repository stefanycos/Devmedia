<?php
	$passo = (isset($_GET['p'])) ? $_GET['p'] : "";
	session_start();
	
	switch($passo){
	case "spoofing":
		spoofing();
		break;
	}
	
	function spoofing(){
		include_once '../libs/securimage/securimage.php';
		$securimage = new Securimage();
		
		if ($securimage->check($_POST['captcha_code']) == false) {
			//Captcha Incorreto
			echo "Código Digitado Invalido";
			exit;
		}
		
		echo "Código Validado, Seu formulario será enviado";
	}
?>