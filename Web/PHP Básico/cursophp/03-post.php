<html>
	<head>
		<title>Aula 03 - Curso PHP</title>
	</head>
	<body>
		<?php
			if(isset($_POST['palavra'])){ ?>
				<h3>Você Buscou Por: <?=$_POST['palavra']?></h3>
		<?php } ?>
		
		<form method="post">
			<p>Digite uma palavra</p>
			<input name="palavra" type="text" />
		</form>
	</body>
</html>