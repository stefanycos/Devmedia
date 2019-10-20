<html>
	<head>
		<title>Aula 07 - Curso PHP</title>
	</head>
	<body>
		
		<p>Listar os 100 primeiros números</p>
		
		<?php
			//Inicialização, Condição, Incremento
			
			/*for($x=1; $x<=100; $x++){
				echo $x." ";
			}*/
		?>
		
		<table width="500" border="1">
			<tr>
				<td><h3>Código</h3></td>
				<td><h3>Nome</h3></td>
				<td><h3>Endereço</h3></td>
			</tr>
			
			<?php
				for($x=1; $x<=50; $x++){
			?>
				<tr>
					<td><?=$x?></td>
					<td>Stefany</td>
					<td>Av. Leandro</td>
				</tr>
			<?php
				}
			?>
			
		</table>
	</body>
</html>