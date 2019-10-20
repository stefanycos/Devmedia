<?php

	// verificar se o IP que está tentando acessar a página não está em nossa blocklist
	$ipsbloqueados = array("10.0.0.1");
	foreach($ipsbloqueados as $ip){
		if($ip == $_SERVER['REMOTE_ADDR']){
			// redireciona o usuário para a página de acesso negado
			header("Location: /cursophp/app/negado.php");
			exit();
		}
	}
	session_start();
	
	// previne o cache nas página
	header("Expires: Mon, 21 Out 1999 00:00:00 GMT");
	header("Cacho-control: no-cache");
	header("Pragma: no-cache");
	
	// área de includes obrigatórios
	include("libs/funcoes.php");
	include("application.php");
	
	// variável m = módulo que será acessado
	$modulo = (isset($_GET['m'])) ? tStr($_GET['m']) : 'inicial';
	
	// Controlar o front-end
	// página inicial, abrir um post ou página de contato
	
	switch($modulo){
		case "admin" :
			$app = new App();
			// verifica se está logado
			
			if(isset($_SESSION["usuario"])){
			
				$comp = (isset($_GET['c'])) ? tStr($_GET['c']) : null;
				$action = (isset($_GET['a'])) ? tStr($_GET['a']) : null;
				
				switch ($comp) {
					case "usuarios" :
						// caso o componente solicitado seja o componente de controle de usuários
						include("app/controller/usuario.class.php");
						
						$usuario = new Usuario();
						if($action!=null){
							$usuario->$action($app);
						} else {
							$usuario->listarUsuarios($app);
						}
						
						break;
					case "categorias" :
						include("app/controller/categoria.class.php");
						
						$categoria = new Categoria();
						if($action!=null){
							$categoria->$action($app);
						} else {
							$categoria->listarCategorias($app);
						}
						
						break;
					case "imagens" :
						include("app/controller/imagem.class.php");
						
						$imagem = new Imagem();
						if($action!=null){
							$imagem->$action($app);
						} else {
							$imagem->listarImagens($app,(int)$_GET["id"]);
						}
						
						break;
					case "posts" :
						include("app/controller/post.class.php");
						
						$post = new Post();
						if($action!=null){
							$post->$action($app);
						} else {
							renderizaAdminInicial($app);
						}
						
						break;
					default :
						renderizaAdminInicial($app);
						break;
				}
				
				
			} else {
				renderizaLogin($app);
			}

			break;
		case "doLogin":
			$app = new App();
			$admin = $app->loadModel("Admin");
			$usuario = tStr($_POST["usuario"]);
			$senha = md5(tStr($_POST["senha"]));
			
			$obj = $admin->getUsuarioLoginSenha($app->conexao, $usuario, $senha);
			
			if($obj){
				// efetuou login
				session_start();
				$_SESSION["usuarioid"] = $obj->usuarioid;
				$_SESSION["usuario"] = $obj->usuariouser;
				$_SESSION["usuarionome"] = $obj->usuarionome;
				renderizaAdminInicial($app);
			} else {
				// login falhou
				echo "<script>alert('Login ou senha incorreto(s)');</script>";
				renderizaLogin($app);
			}
			
			break;
		
		case "logout" :
			$app = new App();
			
			session_start();
			session_destroy();
			
			echo "<script>alert('Usuário desconectado com sucesso!');</script>";
			renderizaLogin($app);
			break;
			
		case "fale-conosco" : 
			$app = new App();
			$site = $app->loadModel("Site");
			$mensagem = "";
			$classe="";
			
			// inicia envio formulário
			if(isset($_POST["frm_enviar"])){
			
				$nome = tStr($_POST["nome"]);
				$email = tStr($_POST["email"]);
				$msg = $_POST["mensagem"];
			
				$headers='';
				$headers.="MIME-Version: 1.0 \r\n";
				$headers.="Content-type: text/html; charset=\"UTF-8\" \r\n";
				$headers.= "From: ".$nome." <".$email.">";

				$mensagem  = "Nome: ".$nome."<br/>";
				$mensagem .= "Email: ".$email."<br/>";
				$mensagem .= "Mensagem: ".$msg;
				
				include("../libs/smtp/SMTPconfig.php");
				include("../libs/smtp/SMTPclass.php");

				// Servidor, Porta, Usuario, Senha, FROM (DE), TO (PARA), titulo, mensagem, headers
				$SMTPMail = new SMTPClient(
											$SmtpServer,
											$SmtpPort,
											$SmtpUser,
											$SmtpPass,
											$SmtpUser,
											$SmtpUser,
											"E-mail enviado atraves do site",
											$mensagem,
											$headers
										);
				// se enviar o email, mostra sucesso, senão, mostra falha					
				if($SMTPMail->SendMail()){
					$mensagem = "O Email foi enviado com sucesso!";
					$classe = "alert-success";
				} else {
					$mensagem = "O email falhou!";
					$classe = "alert-danger";
				}
			}
			// fim envio formulário
			
			$param = array("titulo"=>$app->site_titulo, 
				   "pagina" => "contato",
				   "contato" => array(
				   "mensagem" => $mensagem,
				   "classe"=> $classe
				   ));
						 
			$app->loadView("Site",$param);
			
			break;
		case "post" :
			$app = new App();
			$site = $app->loadModel("Site");
			
			$url = tStr($_GET['url']);
			
			$post = $site->getPost($app->conexao, $codpost=null, $url);
			
			$obj = $site->listaImagensPost($app->conexao, $post->postid, "0");
			$imagens = $obj->fetchAll(PDO::FETCH_ASSOC);
			
			$obj = $site->listaCategorias($app->conexao);
			$categorias = $obj->fetchAll(PDO::FETCH_ASSOC);

			renderizaVerPost($app, $categorias, $post, $imagens);
			break;
		case "categoria" :
			$app = new App();
			$site = $app->loadModel("Site");	
			
			// vamos carregar os posts da página inicial
			$obj = $site->listaPosts($app->conexao, "0", (int)$_GET['id']);
			$posts = $obj->fetchAll(PDO::FETCH_ASSOC);
			
			// vamos carregar as categorias
			$obj = $site->listaCategorias($app->conexao);
			$categorias = $obj->fetchAll(PDO::FETCH_ASSOC);
			
			renderizaPaginaInicial($app, $categorias, $posts);
			
			break;
		
		default :
			$app = new App();
			$site = $app->loadModel("Site");
			
			// vamos carregar os posts da página inicial
			$obj = $site->listaPosts($app->conexao, 0);
			$posts = $obj->fetchAll(PDO::FETCH_ASSOC);
			
			// vamos carregar as categorias
			$obj = $site->listaCategorias($app->conexao);
			$categorias = $obj->fetchAll(PDO::FETCH_ASSOC);
			
			renderizaPaginaInicial($app, $categorias, $posts);
			
			break;
	}
	
	function renderizaVerPost($app, $categorias, $post, $imagens){
		$param = array("titulo"=>$app->site_titulo, 
				   "pagina" => "verpost",
				   "verpost" => array(
				   "post" => $post,
				   "categorias" => $categorias,
				   "imagens" => $imagens
				   ));
						 
		$app->loadView("Site",$param);
	}
	
	function renderizaAdminInicial($app,$mensagem=""){
		$site = $app->loadModel("Site");
			
		// vamos carregar os posts
		$obj = $site->listaPosts($app->conexao);
		$posts = $obj->fetchAll(PDO::FETCH_ASSOC);
	
		$param = array("titulo"=>$app->site_titulo, 
					   "pagina" => "inicialadmin",
					   "dados" => array(
						"posts" => $posts,
						"msg" => $mensagem
					   )
					   );
						 
		$app->loadView("Admin",$param);
	}
	
	function renderizaLogin($app){
		$param = array("titulo"=>$app->site_titulo);
		$app->loadView("Login",$param);
	}
	
	function renderizaPaginaInicial($app, $categorias, $posts){
		$param = array("titulo"=>$app->site_titulo, 
					   "pagina" => "inicial",
					   "inicial" => array(
					   "posts" => $posts,
					   "categorias" => $categorias
					   ));
						 
		$app->loadView("Site",$param);
	}