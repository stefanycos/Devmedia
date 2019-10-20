<?php
	//Vamos receber uma variavel via GET e exibir a mesma na tela
	//é preciso escrever no browser: ?Nome=Stefany, logo após http://localhost/cursophp/03-get.php
	$texto = $_GET['Nome'];
?>
<html>
	<head>
		<title>Aula 03 - Curso PHP</title>
	</head>
	<body>
		Olá <?=$texto?> seja bem vindo!
	</body>
</html>