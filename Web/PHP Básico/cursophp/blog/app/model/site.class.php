<?php
class Site {

	public $sqlPost = "SELECT 
							bp.postid, 
							bp.posttitulo,
							bp.posttexto,
							bp.postbloqueado,
							bp.postdata,
							bp.postcriadoem,
							bp.posturlamigavel,
							bc.categoriaid as postcategoriaid,
							bc.categoriatitulo as postcategoria,
							bu.usuarioid,
							bu.usuarionome as postusuarionome,
							(
							 SELECT 
								bi.imagemarquivo
							 FROM 
								blog_imagem bi
							 WHERE
								bi.blog_post_postid = bp.postid AND
								bi.imagemdestaque = 1
							 ORDER BY
								bi.imagemid DESC
							 LIMIT 1
							 ) as postimagemdestaque
						FROM 
							blog_categoria bc,
							blog_usuario bu,
							blog_post bp
						WHERE
							bp.blog_categoria_categoriaid = bc.categoriaid AND
							bp.blog_usuario_usuarioid = bu.usuarioid ";
						
	public function listaCategorias($pdo){
		$obj = $pdo->prepare("SELECT categoriaid, categoriatitulo FROM blog_categoria");
		return ($obj->execute()) ? $obj : false;
	}
	
	public function listaPosts($pdo, $bloqueado = "NI", $categoriaid = null){
		$where = " ";
		
		if($bloqueado !== "NI")
			$where .= " AND bp.postbloqueado = :bloqueado ";
		
		if($categoriaid != null)
			$where .= " AND bp.blog_categoria_categoriaid = :categoriaid";

		$obj = $pdo->prepare($this->sqlPost." ".$where." ORDER BY bp.postid DESC");
		
		if($bloqueado !== "NI")
			$obj->bindParam(":bloqueado",$bloqueado);
			
		if($categoriaid != null)
			$obj->bindParam(":categoriaid",$categoriaid);
		
		$obj->execute();
		return $obj;
	}
	
	public function getPost($pdo, $postid, $url=null){
		if($url==null){
			$where = " AND bp.postid = :postid ";		
			$obj = $pdo->prepare($this->sqlPost." ".$where);
			$obj->bindParam(":postid",$postid);
		} else {
			$where = " AND bp.posturlamigavel = :url ";		
			$obj = $pdo->prepare($this->sqlPost." ".$where);
			$obj->bindParam(":url",$url);
		}
		
		return ($obj->execute()) ? $obj->fetch(PDO::FETCH_OBJ) : false;
	}
	
	public function listaImagensPost($pdo, $postid, $destaque = "NI"){
		
		$sql = "SELECT * FROM blog_imagem WHERE blog_post_postid = :postid  ";
		$where = "";
		
		if($destaque != "NI")
			$where = " AND imagemdestaque = ".$destaque." ";
			
		$obj = $pdo->prepare($sql." ".$where);
		$obj->bindParam(":postid",$postid);
		$obj->execute();
		return $obj;
	}
}