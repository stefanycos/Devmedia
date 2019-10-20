<div class="container">
<div class="row">
<div class="col-sm-8 blog-main">

	<?php foreach($tpl["inicial"]["posts"] as $post) { ?>
	<?php 
		$date = new DateTime($post["postdata"]);
	?>
  <div class="blog-post">
	<a href="index.php?m=post&url=<?=$post["posturlamigavel"]?>">
		<h2 class="blog-post-title"><?=$post["posttitulo"]?></h2>
	</a>
	<p class="blog-post-meta"><?=$date->format('d/m/Y H:i:s')?> por <?=$post["postusuarionome"]?>. Categoria: <strong><?=$post["postcategoria"]?></strong></p>
	
	<?php if($post["postimagemdestaque"] != "") { ?>
		<img src="upload/<?=$post["postimagemdestaque"]?>" width="100%" />
	<?php } ?>
	
	<p><pre><?=$post["posttexto"]?></pre></p>
  </div><!-- /.blog-post -->
	
	<?php } ?>
	
  
</div><!-- /.blog-main -->

<div class="col-sm-3 col-sm-offset-1 blog-sidebar">
  <div class="sidebar-module sidebar-module-inset">
	<h4>Sobre</h4>
	<p>Fale um pouco sobre você</p>
  </div>
  <div class="sidebar-module">
	<h4>Categorias</h4>
	<ol class="list-unstyled">
	  <?php foreach($tpl["inicial"]["categorias"] as $categoria) { ?>
		<li><a href="index.php?m=categoria&id=<?=$categoria["categoriaid"]?>"><?=$categoria["categoriatitulo"]?></a></li>
	  <?php } ?>
	</ol>
  </div>
  
</div><!-- /.blog-sidebar -->
</div><!-- /.row -->
</div><!-- /.container -->