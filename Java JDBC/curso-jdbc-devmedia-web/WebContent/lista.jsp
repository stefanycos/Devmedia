<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="br.edu.devmedia.jdbc.dto.PessoaDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listagem</title>
</head>
<body>
	<%
		String msg = (String) request.getAttribute("msg");
	%>
	<%= msg != null ? msg : "" %>
	
	<table border="1" cellpadding="5" cellspacing="0" width="500px">
		<tr style="color: white" bgcolor="black" align="center">
			<td>Nome</td>
			<td>CPF</td>
			<td>Endereço</td>
			<td>Dt. Nasc</td>
			<td colspan="2">Ações</td>
		</tr>
		
		<%
			List<PessoaDTO> listaPessoas = (List<PessoaDTO>) request.getAttribute("listaPessoas");
			
			for (PessoaDTO pessoaDTO : listaPessoas) {
		%>
			<tr>
				<td><%= pessoaDTO.getNome() %></td>
				<td><%= pessoaDTO.getCpf() %></td>
				<td><%= pessoaDTO.getEndereco() %></td>
				<td><%= pessoaDTO.getDtNascimento() %></td>
				<td >
					<a href="pessoa?acao=editar&id=<%= pessoaDTO.getIdPessoa() %>">Editar</a>
				</td>
				<td>
					<a href="pessoa?acao=remover&idPessoa=<%= pessoaDTO.getIdPessoa() %>">Remover</a>
				</td>
			</tr>
		<%
			}
		%>
	</table>
</body>
</html>