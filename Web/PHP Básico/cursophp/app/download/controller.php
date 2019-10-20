<?php

	$array = array("12345" => "edital_aula17.pdf");
	
	$titulo = "Aula 17 - Curso de PHP - Download de Arquivo";
	
	$idArquivo = $_GET['id'];
	
	header("Content-type:application/pdf");
	header("Content-Disposition:attachment;filename='edital_17.pdf'");
	
	readfile("arquivos/".$array[$idArquivo]);
	
	