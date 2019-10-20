<?php
	//Vamos verificar se a variavel btnLogar que virá por metodo POST possui o valor Logar
	$logado = "";
	$mensagem = "";
	if(isset($_POST['btnLog'])){
		
		if($_POST['usuario'] == "123" && $_POST['senha'] == '456'){
			$logado = $_POST['usuario'];
		}else{
			$mensagem = "Usuario e/ou senha Incorreto ou Inesistente";
		}
	}
?>

<html>
	<head>
		<title>Aula 05 - Curso PHP</title>
	</head>
	<body>
		<?php
			if($logado != ""){
				echo "Welcome ".$logado;
			}else if ($mensagem != ""){
				echo $mensagem;
			}
		?>
		<form method="post">
			<p>Informe o Usuario: <input type="text" name="usuario"/></p>
			<p>Informe a Senha: <input type="password" name="senha"/></p>
			<p><input type="submit" value="Logar" name="btnLog"/></p>
		<form>
	</body>
</html>