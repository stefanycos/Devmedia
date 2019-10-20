<?php

	class Login{
		use Log;
		
		function logar($usuario){
			$this->log("O usuário ".$usuario." efetuou Login Em: ");
		}
	}
?>