package br.edu.devmedia.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.devmedia.jdbc.bo.PessoaBO;

@WebServlet(urlPatterns = "/cadastro")

public class CadastroServlet extends HttpServlet {

	private static final long serialVersionUID = 6974699321631323518L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PessoaBO pessoaBO = new PessoaBO();
		
		String nome = request.getParameter("nome");
		Long cpf = Long.parseLong( request.getParameter("cpf"));
		String endereco = request.getParameter("endereco");
		String dtNasc = request.getParameter("dtNasc");
	}
}
