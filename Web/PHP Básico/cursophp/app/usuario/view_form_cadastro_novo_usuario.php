<html>
	<head>
		<title><?=$titulo?></title>
	</head>
	<body>
		<h1>Cadastro de Usuários</h1>
		<form method="POST" action="index.php?r=usuario&p=cadastrar">
			<p>Nome Usuario:</p>
			<p><input type="text" maxlength="120" name="txtNomeUsuario"/></p>
			
			<p>Idade:</p>
			<p><input type="text" maxlength="120" name="txtIdade"/></p>
			
			<p><input type="submit"  name="btnCadastrar" value="Cadastrar"/></p>
			
			<input type="hidden" name="frmCadUsuario" />
		</form>
	</body>
</html>