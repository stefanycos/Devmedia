<?php if(!class_exists('raintpl')){exit;}?>﻿<table border="1" cellpadding="5" cellspacing="5" width="550">
	<tr>
		<td>ID</td>
		<td>Nome</td>
		<td>Idade</td>
	</tr>
	<?php $counter1=-1; if( isset($dados) && is_array($dados) && sizeof($dados) ) foreach( $dados as $key1 => $value1 ){ $counter1++; ?>
		<tr>
			<td><?php echo $value1["id"];?></td>
			<td><?php echo $value1["nome"];?></td>
			<td><?php echo $value1["idade"];?></td>
			</tr>
	<?php } ?>
</table>
