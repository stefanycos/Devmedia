<html>
	<head>
		<title>Upload de arquivos</title>
	</head>
	<body>
		<form enctype="multipart/form-data" action="servico.php?p=uploadBasico" method="POST">
			Selecione o arquivo:
			<input type="file" name="arquivo"/>
			<input type="submit" value="Enviar arquivo"/>
			<input type="hidden" name="MAX_FILE_SIZE" value="30000" />
		</form>		
	</body>
</html>