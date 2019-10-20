package br.edu.devmedia.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.edu.devmedia.jdbc.bo.LoginBO;
import br.edu.devmedia.jdbc.dto.LoginDTO;
import br.edu.devmedia.jdbc.exception.NegocioException;

/* Esta notação configura a nossa classe como um webservlet de fato
 * O nome que damos("login"), servirá para chamarmos esse servlet de dentro do HTML, pelo
 * 	atributo action do form
 * */
@WebServlet(urlPatterns = "/login")

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 6136873408070233714L;
	
	/*  HttpServletRequest request: responsavel por trazer as informações da tela até o servidor
	 *  HttpServletResponse response: coloca as informações de repostas
	 * */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginBO loginBO = new LoginBO();
		
		//Metodo para recuperar os parametros de Login e Senha 
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setNome(login);
		loginDTO.setSenha(senha);
		
		String proxPage = "home.jsp";
		try {
			boolean resposta = loginBO.logar(loginDTO);
			if (!resposta) {
				request.setAttribute("msg", "Usuário/Senha inválidos!");
				proxPage = "login.jsp";
			}
		} catch (NegocioException e) {
			proxPage = "login.jsp";
			request.setAttribute("msg", e.getMessage());
			e.printStackTrace();
		}
		
		
		//Objeto de dispacho, atrvees dele sabemos qual será a prox pagina, colocando o nome da pagina(como ser fosse um link)
		RequestDispatcher dispatcher = request.getRequestDispatcher(proxPage);
		dispatcher.forward(request, response);
	}
	
}
