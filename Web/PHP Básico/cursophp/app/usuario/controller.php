<?php
	$titulo = "Manutenção de Usuários";
	$conexao = @mysqli_connect($db_host, $db_user, $db_pass, $db_name);
	
	if( mysqli_connect_errno($conexao) ){
		echo "A conexão falhou, erro reportado: ".mysqli_connect_error();
		exit();
	}
	
	require("mdl_usuario.php");
	
	// qual será a view a ser carregada
	// p = listar, p = cadastrar e p = excluir
	
	if(isset($_GET['p'])) {
		$passo = $_GET['p'];
	} else {
		$passo = null;
	}
	
	
	switch($passo){
		case "importar" :
			importarUsuarios($conexao, "usuario\_usuario.xml");
			break;
		case "exportar" :
			
			exportarUsuarios($conexao, "usuario\_bkp_usuarios.xml");
			break;
		case "cadastrar" :
			cadastrarUsuario($conexao);
			break;
		case "excluir" :
			$retornoExc = excluirUsuario( $conexao );
			$dados = listarDados($conexao);
			require("view_lista.php");
			break;
		case "alterar":
			alterarUsuario($conexao);
			break;
		case "listarUsandoTemplate" :
			listarDadosUsandoTemplate(listarDados($conexao));
			break;	
		default:
			$dados = listarDados($conexao);
			require("view_lista.php");
			break;
	}
	
	function listarDadosUsandoTemplate($dados){
		$tpl = new raintpl();
		
		$tpl->assign("dados", $dados);
		show($tpl, $tpl->draw("listaUsuarios", true), "Lista de Usuários");
		
	}
	
	function listarDados($conexao) {
		$resultado = usuario_listar($conexao);
		$data = array();
		
		while($row = mysqli_fetch_array($resultado)){
			$data[] = array("id" => $row['id'], "nome" => utf8_encode ( $row['nome'] ), "idade" => ($row['idade'] == "") ? "--" : $row['idade']);
		}
		
		return $data;
	}
	
	function excluirUsuario( $conexao ){
		$id_usuario = (isset($_GET["codigo"])) ? $_GET["codigo"] : -1;
		$resultado = usuario_excluir($conexao, $id_usuario);
		
		if($resultado) {
			return "Exclusão efetuada com sucesso!";
		} else {
			return "";
		}
	}
	
	function alterarUsuario($conexao){
		$titulo = "Alterar Usuario";
		
		if(isset($_POST['idusuario'])){
			$usuario = $_POST['txtNomeUsuario'];
			$idade = $_POST['txtIdade'];
			$id = $_POST['idusuario'];
			
			if(usuario_alterar($conexao, $usuario, $idade, $id)){
				$retornoExc = "Dados Alterados com Sucesso";
				$dados = listarDados($conexao);
				require("view_lista.php");
				return false;
			}else{
				echo "Verifique os Dados!";
			}
		}
		
		if(isset($_POST['idusuario'])){
			$id_usuario = $_POST['idusuario'];
		}else{
			$id_usuario = $_GET['codigo'];
		}
		
		$retorno = usuario_porId($conexao, $id_usuario);
		
		if (! $retorno){
			echo "Falha ao Buscar Usuario por Id";
			return false;
		}
		
		$dadosUsuario = mysqli_fetch_row($retorno);
		$dados = array("id" => $dadosUsuario[0], "nome" => $dadosUsuario[1], "idade" => $dadosUsuario[2]);
		
		require("view_form_cadastro_altera_usuario.php");
		
	}
	
	function cadastrarUsuario($conexao){
		$titulo = "Cadastro de Novo Usuario";
		//Verificar se o formulario foi postado
		if(isset($_POST['frmCadUsuario'])){
			//postou o usuario de cadastro
			$usuario = $_POST['txtNomeUsuario'];
			$idade = $_POST['txtIdade'];
			
			if(usuario_cadastrar($conexao, $usuario, $idade)){
				$retornoExc = "Usuario Cadastrado com Sucesso";
				$dados = listarDados($conexao);
				require("view_lista.php");
			}else{
				echo "Verifique os Dados";
				require("view_form_cadastro_novo_usuario.php");
			}
		}else{
			//mostarr o formulario de cadastro
			require("view_form_cadastro_novo_usuario.php");
		}
	}
	
	function importarUsuarios($conexao, $arquivoXml){
		$xml = simplexml_load_file($arquivoXml);
		
		//Garvar registro por registro no banco de dados
		foreach($xml as $usuario){
			if(! usuario_cadastrar($conexao, $usuario->nome, $usuario->idade)){
				echo $usuario->nome." - ".$usuario->idade." - Erro<br/>";
			}
		}
		
		$titulo = "Registros Importados com Sucesso!";
		
		$dados = listarDados($conexao);
		require("view_lista.php");
	}
	
	function exportarUsuarios($conexao, $arquivoXml){
		$dadosUsuarios = listarDados($conexao);
		//print_r($dadosUsuarios);
		
		$xml = "<?xml version='1.0' encoding='iso-8859-1'?>";
		$xml .= "<usuarios>";
		
		foreach($dadosUsuarios as $u){
			$xml .= "<usuario>";
				$xml .="<id>".$u['id']."</id>";
				$xml .="<nome>".$u['nome']."</nome>";
				$xml .="<idade>".$u['idade']."</idade>";
			$xml .= "</usuario>";
		}
		
		$xml .= "</usuarios>";
		
		file_put_contents($arquivoXml, $xml);
		echo "Usuarios Exportados com Sucesso!";
	}
	
	@mysqli_close($conexao);
	
	