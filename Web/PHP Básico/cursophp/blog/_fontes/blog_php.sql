-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 23-Jun-2014 às 00:12
-- Versão do servidor: 5.6.16
-- PHP Version: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `blog_php`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `blog_categoria`
--

CREATE TABLE IF NOT EXISTS `blog_categoria` (
  `categoriaid` int(11) NOT NULL AUTO_INCREMENT,
  `categoriatitulo` varchar(60) NOT NULL,
  PRIMARY KEY (`categoriaid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `blog_categoria`
--

INSERT INTO `blog_categoria` (`categoriaid`, `categoriatitulo`) VALUES
(1, 'Diversos'),
(2, 'PHP');

-- --------------------------------------------------------

--
-- Estrutura da tabela `blog_imagem`
--

CREATE TABLE IF NOT EXISTS `blog_imagem` (
  `imagemid` int(11) NOT NULL AUTO_INCREMENT,
  `imagemlegenda` varchar(45) DEFAULT NULL,
  `imagemarquivo` varchar(120) NOT NULL,
  `imagemdestaque` int(11) NOT NULL DEFAULT '0' COMMENT '0 = não é destaqu',
  `blog_post_postid` int(11) NOT NULL,
  PRIMARY KEY (`imagemid`),
  KEY `fk_blog_imagem_blog_post_idx` (`blog_post_postid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Extraindo dados da tabela `blog_imagem`
--

INSERT INTO `blog_imagem` (`imagemid`, `imagemlegenda`, `imagemarquivo`, `imagemdestaque`, `blog_post_postid`) VALUES
(1, 'teste', 'teste.jpg', 1, 1),
(3, NULL, 'img01.jpg', 0, 1),
(4, NULL, 'img01.jpg', 0, 1),
(5, NULL, 'img01.jpg', 0, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `blog_post`
--

CREATE TABLE IF NOT EXISTS `blog_post` (
  `postid` int(11) NOT NULL AUTO_INCREMENT,
  `posttitulo` varchar(120) NOT NULL,
  `posttexto` text,
  `postbloqueado` int(11) NOT NULL DEFAULT '0' COMMENT '0 = bloqueado',
  `postdata` datetime NOT NULL,
  `posturlamigavel` varchar(120) NOT NULL,
  `blog_categoria_categoriaid` int(11) NOT NULL,
  `blog_usuario_usuarioid` int(11) NOT NULL,
  `postcriadoem` datetime NOT NULL,
  PRIMARY KEY (`postid`),
  KEY `fk_blog_post_blog_categoria1_idx` (`blog_categoria_categoriaid`),
  KEY `fk_blog_post_blog_usuario1_idx` (`blog_usuario_usuarioid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `blog_post`
--

INSERT INTO `blog_post` (`postid`, `posttitulo`, `posttexto`, `postbloqueado`, `postdata`, `posturlamigavel`, `blog_categoria_categoriaid`, `blog_usuario_usuarioid`, `postcriadoem`) VALUES
(1, 'Olá!', 'teste', 0, '2014-05-20 00:00:00', 'ola', 1, 1, '2014-05-20 00:00:00'),
(2, 'Olá nosso post cadastrado', 'texto completo', 0, '2014-05-21 00:00:00', 'teste_teste', 2, 2, '2014-05-21 00:00:00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `blog_usuario`
--

CREATE TABLE IF NOT EXISTS `blog_usuario` (
  `usuarioid` int(11) NOT NULL AUTO_INCREMENT,
  `usuariouser` varchar(45) NOT NULL,
  `usuariopass` varchar(150) NOT NULL,
  `usuarionome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`usuarioid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `blog_usuario`
--

INSERT INTO `blog_usuario` (`usuarioid`, `usuariouser`, `usuariopass`, `usuarionome`) VALUES
(1, 'jaison', 'e10adc3949ba59abbe56e057f20f883e', 'jaison'),
(2, 'teste', '698dc19d489c4e4db73e28a713eab07b', 'teste');

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `blog_imagem`
--
ALTER TABLE `blog_imagem`
  ADD CONSTRAINT `fk_blog_imagem_blog_post` FOREIGN KEY (`blog_post_postid`) REFERENCES `blog_post` (`postid`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `blog_post`
--
ALTER TABLE `blog_post`
  ADD CONSTRAINT `fk_blog_post_blog_categoria1` FOREIGN KEY (`blog_categoria_categoriaid`) REFERENCES `blog_categoria` (`categoriaid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_blog_post_blog_usuario1` FOREIGN KEY (`blog_usuario_usuarioid`) REFERENCES `blog_usuario` (`usuarioid`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
