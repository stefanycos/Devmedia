/* fun��o que valida o formul�rio de login */

function validaLogin(){
	// pegar os valores digitados no campo de usu�rio e senha
	
	var usuario = document.getElementById("inputUsuario").value;
	var senha = document.getElementById("inputSenha").value;
	
	// verificar se ambos os campos foram preenchidos
	// se foram preenchidos, deixa enviar o formul�rio
	// sen�o, avisa que tem erro e n�o envia o formul�rio
	
	if(usuario == "" || senha == "") {
		alert("Preencha ambos os campos");
		return false;
	} else {
		alert("Preencheu os campos de forma correta");
		return true;
	}
	
	// Estudar: JQUERY
	
}