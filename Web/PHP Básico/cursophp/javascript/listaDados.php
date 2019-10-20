<html>
	<head>
		<title>Introducao</title>
		<script src="js/jquery-1.11.0.min.js"></script>
		<script>
			$(function(){
				
				setTimeout(function(){
					carrega();
				},2000);
						
			});
			
			function carrega(){
				$.ajax({
					type: "GET",
					url: "servico.php?p=listarDados",
					dataType: 'json',
					success: function(data){
						var usuarios = "";
						
						$.each(data, function(key, val){
							usuarios += "Nome: "+val.nome+"<br/> Idade: "+val.idade+" <br/><a class='listarUsuarios-btnExcluir' href='servico.php?p=excUsuario&cod="+val.id+"'>Excluir usuario</a><br/>===============<br/>";
						});
						
						$("#exibe_cont").html(usuarios);
						
						$(".listarUsuarios-btnExcluir").click(function(e){
							e.preventDefault();
							
							if(!confirm("Deseja realmente excluir o registro?")){
								return false;
							}
							
							$.ajax({
								type: "GET",
								url: $(this).attr("href"),
								success: function(data){
									alert(data);
									carrega();
								}
							});
						});
						
					}
				});
			}
			
		</script>
	</head>
	<body>
		<h1>Usuários Cadastrados</h1>
		
		
		<div id="exibe_cont">
			Carregando...
		</div>
		
		
		
	</body>
</html>