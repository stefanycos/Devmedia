<?php
	//func_get_arg() - retornar um argumento, 
	//func_get_args() - retorna todos os argumentos, 
	//func_num_args() - retorna o numero de argumentos
	
	class sobrecarga{
		// 1 argumento, multiplica
		// 2 argumentos, soma
		// 3 argumento, multiplica
		function operacao(){
			print_r(func_get_args());
			echo "<br/>-------------------------------------<br/>";
			
			switch(func_num_args()){
				case 1 :
					$this->multiplica(func_get_arg(0));
					break;
				case 2 :
					$this->soma(func_get_arg(0), func_get_arg(1));
					break;
				case 3 :
					$this->multi(func_get_arg(0), func_get_arg(1), func_get_arg(2));
					break;
				default:
					echo "Quantidade de Argumentos Invalida!";
					break;
			}
		}
		
		private function multiplica($var){
			echo $var*$var."<br/>";
		}
		
		private function soma ($var1, $var2){
			echo $var1+$var2."<br/>";
		}
		
		private function multi($var1, $var2, $var3){
			echo $var1* $var2 * $var3."<br/>";
		}
	
	}
	
	$cl = new Sobrecarga();
	$cl->operacao(10,9,3,4,5,6,7,8,9);
	
?>