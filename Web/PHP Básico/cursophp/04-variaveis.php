<html>
	<head>
		<title>Aula 04 - Curso PHP</title>
	</head>
	<body>
	
		<?php
			//Variaveis
			$idade = 22; //Variavel do tipo: Inteira
			$nome = "Stefany Cristina"; //Variavel do tipo: String
			$habilitado = true; //Variavel do tipo: Booleana
			$valor = 100.00; //Variavel do tipo: flutuante
			$calculo = 1 + 2 + 3 + 4 + 5;
			$resultado = $calculo / 2;
			
			//Constantes
			define("IDADE", "23");
			define("URL", "http//www.youtube.com");
		?>
	
		
		<p>Olá, me chamo <?=$nome?>, tenho <?=$idade?> anos</p>
		
		<p> <?=$idade?> + 1 = <?php echo $idade + 1?></p>
		
		<p><?php echo $nome." 1" ?></p> = contatenação
		
		<p>Minha Idade é: <?php echo IDADE ?></p>
		
		<p>Acesse o Site: <?php echo URL ?></p>
		
		<p>1 + 2 + 3 + 4 + 5: <?=$calculo?></p>
		
		<p>Resultado: <?=$resultado?></p>
	</body>
</html>