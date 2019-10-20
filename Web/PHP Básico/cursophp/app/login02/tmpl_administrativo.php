<html>
	<head>
		<title><?=$titulo?></title>
	</head>
	<body>
		<h2><font face="Verdana">Welcome!</font></h2>
		<font face="Verdana" size="4">Logged User: <?=$_SESSION['usuario']?></font>
		
		
		<p><b><a href="index.php?r=login02&ac=logout" />Logoff</b></p>
	</body>
</html>