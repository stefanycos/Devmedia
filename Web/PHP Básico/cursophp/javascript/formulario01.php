<html>
	<head>
		<title>Introducao</title>
		<script src="js/jquery-1.11.0.min.js"></script>
		<script>
			$(function(){
				$("#frmCadUsuario").submit(function(e){
					e.preventDefault();
					$.ajax({
						type: "POST",
						url: $(this).attr("action"),
						data: $(this).serialize(),
						dataType: 'html',
						success: function(mensagem){
							alert(mensagem);
							$("#txtNome, #txtIdade").val("");
						}
					});
				});				
			});
		</script>
	</head>
	<body>
		<h1>Cadastre-se em nosso site</h1>
		<div id="exibe_cont"></div>
		
		<form action="servico.php?p=cadUsuario" method="POST" id="frmCadUsuario">
			Nome:  <input type="text" maxlength="120" name="txtNome" id="txtNome" />
			Idade: <input type="text" maxlength="3" name="txtIdade" id="txtIdade" />
			<input type="submit" value="Enviar" />
		</form>
		
	</body>
</html>