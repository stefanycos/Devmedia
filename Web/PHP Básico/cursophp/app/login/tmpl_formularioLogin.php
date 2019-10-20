<html>
	<head>
		<title><?=$titulo?></title>
	</head>
	<body>
		<form method="post">
			<p>Efetue Login para Acessar o Sistema</p>
			<p>Usuário</p>
			<input type="text" name="usuario" />
			
			
			<p>Senha</p>
			<input type="password" name="senha" />
			
			<p><input type="checkbox" value="1" name="lembrar" />Manter Logado</p>
			
			<input type="submit" value="Logar"/>
		<form/>
	</body>
</html>