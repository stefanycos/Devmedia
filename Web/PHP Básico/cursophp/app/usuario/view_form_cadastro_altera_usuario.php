<html>
	<head>
		<title><?=$titulo?></title>
	</head>
	<body>
		<h1>Alteração de Usuários</h1>
		<form method="POST" action="index.php?r=usuario&p=alterar">
			<p>Nome Usuario:</p>
			<p><input type="text" maxlength="120" name="txtNomeUsuario" value="<?=$dados['nome']?>" /></p>
			
			<p>Idade:</p>
			<p><input type="text" maxlength="120" name="txtIdade" value="<?=$dados['idade']?>"/></p>
			
			<p><input type="submit"  name="btnCadastrar" value="Alterar"/></p>
			
			<input type="hidden" name="idusuario" value="<?=$dados['id']?>" />
		</form>
	</body>
</html>