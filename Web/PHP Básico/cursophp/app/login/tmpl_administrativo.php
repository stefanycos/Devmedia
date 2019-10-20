<html>
	<head>
		<title><?=$titulo?></title>
	</head>
	<body>
		<h1>Usuario Logado: <?=$_SESSION['usuario']?></h1>
		
		<p><a href="index.php?r=login&ac=logout" />Efetuar Logoff</p>
	</body>
</html>