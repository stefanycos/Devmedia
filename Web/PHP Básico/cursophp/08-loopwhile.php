<html>
	<head>
		<title>Aula 08 - Curso PHP</title>
	</head>
	<body>
		
		<p>Listar os 100 primeiros números</p>
		
		<?php
			$contador = 1;
			
			while($contador < 101){
				echo $contador."<br/>";
				
				$contador++;
				
				if($contador == 20){
					$contador++;
					continue;
				}
				
				echo "....";
				
				if($contador == 50) {
					echo "A variavel contadora esta em ".$contador;
					break;
				}
				
			}
			
			echo "<hr/>";
			
			$contador = 0;
			do{
				echo "Do - While: ".$contador; 
				$contador++;
			}while($contador < 0);
		?>
		
	</body>
</html>