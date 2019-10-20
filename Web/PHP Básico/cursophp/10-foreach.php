<html>
	<head>
		<title>Aula 10 - Curso PHP</title>
	</head>
	<body>
		<?php
			$estrutura = array(
					array("Maria", "24", "13/12/2000", "Av. Itaquera"),
					array("Maria", "24", "13/12/2000", "Av. Itaquera"),
					array("Maria", "24", "13/12/2000", "Av. Itaquera"),
					array("Maria", "24", "13/12/2000", "Av. Itaquera")
				);
			
			
			echo "<table border='1'>";
			echo "<tr><h3><td>Nome</td><td>Idade</td><td>Dt Nasc</td><td>Endereço</td></h3></tr>";
			
			foreach	($estrutura as $val1){
				//print_r($val1);
				
				echo "<tr>";
				foreach($val1 as $val2){
					echo "<td>".$val2."</td>";
				}
				echo "<tr/>";
			}	
			echo "</table>";
		?>
	</body>
</html>