<html>
	<head>
		<title>Introducao</title>
		<script src="js/jquery-1.11.0.min.js"></script>
		<script>
			//pagina acessa outra e retorna os dados sem precisar recarregar a pagina)
			$(function(){
				setTimeout(function(){
					$.ajax({
						url: "servico.php"						
					}).done(function(msg) {
						$("#exibe_cont").html(msg);
					});
				}, 3000);
			});
		</script>
	</head>
	<body>
		<h1>Seja bem vindo!</h1>
		<div id="exibe_cont">Carregando...</div>
	</body>
</html>