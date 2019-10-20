<%@page import="br.edu.devmedia.jdbc.dto.UfDTO"%>
<%@page import="br.edu.devmedia.jdbc.dto.PessoaDTO" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<form action="pessoa?acao=atualizar" method="post">
		<fieldset>
			<legend>Pessoa</legend>
		
			<%
				String msg = (String) request.getAttribute("msg");
				PessoaDTO pessoaDTO = (PessoaDTO) request.getAttribute("pessoaDTO");
			%>
			<%= msg != null ? msg : "" %>
		
			<table>
				<tr>
					<td>Nome:</td>
					<td>
						<input type="text" name="nome" value="<%= pessoaDTO.getNome() %>"/>
					</td>
				</tr>
				<tr>
					<td>Cpf:</td>
					<td>
						<input type="text" name="cpf" value="<%= pessoaDTO.getCpf() %>"/>
					</td>
				</tr>
				<tr>
					<td>Endereço:</td>
					<td>
						<input type="text" name="endereco" value="<%= pessoaDTO.getEndereco()%>"/>
					</td>
				</tr>
				<tr>
					<td>Dt. Nasc:</td>
					<td>
						<input type="text" name="dtNasc" value="<%= pessoaDTO.getDtNascimento()%>"/>
					</td>
				</tr>
			</table>
		</fieldset>

		<fieldset>
			<legend>Sexo</legend>
		
			<table>
				<tr>
					<td>Sexo:</td>
					<td>
						<% if (pessoaDTO.getSexo() == 'M') { %>
							<input type="radio" name="sexo" value="M" /> Masculino
							<input type="radio" name="sexo" value="M" checked="checked" /> Masculino
							
						<% } else { %>
							<input type="radio" name="sexo" value="F" checked="checked" /> Feminino
							<input type="radio" name="sexo" value="F" /> Feminino
						<% } %>
					</td>
				</tr>
			</table>
		</fieldset>
		<input type="submit" value="Atualizar"/>
		<input type="reset" value="Limpar"/>
	</form>
</body>
</html>