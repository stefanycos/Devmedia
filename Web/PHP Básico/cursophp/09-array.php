<html>
	<head>
		<title>Aula 09 - Curso PHP</title>
	</head>
	<body>
		
		<?php
			$nossoArray = array("Valor 1","Valor 2", "Valor 3");
			print_r($nossoArray);
			
			$nossoArray[] = "Valor 4";
			
			print_r($nossoArray);
			
			unset($nossoArray[1]);
			
			echo "<br/>";
			print_r($nossoArray);
			
			
			$novoArray = array("devmedia" => "www.devmedia.com.br", "google" => "www.google.com");
			echo "<br/>".$novoArray['devmedia'];
			echo "<br/>".$novoArray['google'];
			
			$arrayMultinivel = array();
			$arrayMultinivel[0][1] = "valor 0 - 1";
			$arrayMultinivel[0][2] = "valor 0 - 2";
			
			echo "<br/>";
			print_r($arrayMultinivel);
		?>
	</body>
</html>