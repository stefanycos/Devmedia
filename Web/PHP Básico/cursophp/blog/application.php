<?php
class App {
	// dados de acesso ao banco de dados
	public $db_host = "localhost";
	public $db_user = "root";
	public $db_pass = "";
	public $db_name = "blog_php";
	
	//public $db_host = "localhost";
	//public $db_user = "cursophp_blog";
	//public $db_pass = "147@963!";
	//public $db_name = "cursophp_blog";
	
	// dados do site
	public $site_titulo = "Curso de PHP";

	// dados do sistema
	public $sistema_pasta_upload = "upload/";
	
	// extensões de imagem permitidas
	public $ext_img = array('jpg','gif','png');
	
	// conexão com banco de dados
	public $conexao;
	
	function __construct(){
		try {
			$param = array(
				PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES UTF8'
			);
			$this->conexao = new PDO('mysql:host='.$this->db_host.';port=3306;dbname='.$this->db_name,$this->db_user,$this->db_pass,$param);
		} catch(PDOException $e){
			echo $e->getMessage();
		}
	}
	
	function loadModel($model) {
		include("app/model/".strtolower($model).".class.php");
		return new $model();
	}
	
	function loadView($view, $tpl){
		include("app/view/".strtolower($view).".tpl.php");
	}
	
	function uploadImagem($arquivo){
		$img_tmp = $this->sistema_pasta_upload."tmp/".$arquivo['name'];
		
		$ext = strtolower(end(explode(".",$arquivo['name'])));
		
		if(array_search($ext,$this->ext_img) === 0) {
			if(move_uploaded_file($arquivo['tmp_name'], $img_tmp)){
				// criar um nome unico para o arquivo
				$foto = md5(uniqid(time())).".".$ext;
				
				include("libs/wideimage/WideImage.php");
				WideImage::load($img_tmp)->resize(614, 299)->saveToFile($this->sistema_pasta_upload.$foto);
				WideImage::load($img_tmp)->crop('center', 'center', 257, 247)->saveToFile($this->sistema_pasta_upload."thumb/".$foto);
			
				unlink($this->sistema_pasta_upload."tmp/".$arquivo['name']);
			
				return $foto;
			}
		} 
		
		return false;
	}
}