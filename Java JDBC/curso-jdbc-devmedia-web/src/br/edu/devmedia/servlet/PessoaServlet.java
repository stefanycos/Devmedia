package br.edu.devmedia.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.devmedia.jdbc.bo.PessoaBO;
import br.edu.devmedia.jdbc.dto.EnderecoDTO;
import br.edu.devmedia.jdbc.dto.PessoaDTO;
import br.edu.devmedia.jdbc.dto.UfDTO;

/**
 * Servlet implementation class PessoaServlet
 */
@WebServlet("/pessoa")
public class PessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String proxPage = "home.jsp";
		try {
			PessoaBO pessoaBO = new PessoaBO();
			if (acao.equals("cadastrar")) {
				
			
				String cpf = request.getParameter("cpf");
				String nome = request.getParameter("nome");
				String dtNasc = request.getParameter("dtNasc");
				String sexo = request.getParameter("sexo");
				String endereco = request.getParameter("endereco");
				
				PessoaDTO pessoaDTO = new PessoaDTO();
				pessoaDTO.setCpf(Long.parseLong(cpf));
				pessoaDTO.setDtNascimento(dtNasc);
				pessoaDTO.setNome(nome);
				pessoaDTO.setSexo(sexo.charAt(0));
				pessoaDTO.setEndereco(endereco);
				
				pessoaBO.cadastrar(pessoaDTO);
				request.setAttribute("msg", "Cadastro efetuado com sucesso!");
				proxPage = "pessoa?acao=listar";
				
			} else if (acao.equals("listar")) {
				
				List<PessoaDTO> lista = pessoaBO.listagem();
				request.setAttribute("listaPessoas", lista);
				proxPage = "lista.jsp";
				
			} else if (acao.equals("editar")) {
				
				String id = request.getParameter("id");
				PessoaDTO pessoaDTO = pessoaBO.buscaPorId(Integer.parseInt(id));
				request.setAttribute("pessoaDTO", pessoaDTO);
				proxPage = "edicao.jsp";
				
			} else if (acao.equals("atualizar")) {
				
				String idPessoa = request.getParameter("id");
				
				
				String cpf = request.getParameter("cpf");
				String nome = request.getParameter("nome");
				String dtNasc = request.getParameter("dtNasc");
				String sexo = request.getParameter("sexo");
				String endereco = request.getParameter("endereco");
			
				PessoaDTO pessoaDTO = new PessoaDTO();
				pessoaDTO.setIdPessoa(Integer.parseInt(idPessoa));
				pessoaDTO.setCpf(Long.parseLong(cpf));
				pessoaDTO.setDtNascimento(dtNasc);
				pessoaDTO.setNome(nome);
				pessoaDTO.setSexo(sexo.charAt(0));
				pessoaDTO.setEndereco(endereco);
				
				pessoaBO.atualizar(pessoaDTO);
				proxPage = "pessoa?acao=listar";
				
			} else if (acao.equals("remover")){
				String idPessoa = request.getParameter("idPessoa");
				pessoaBO.removePessoa(Integer.parseInt(idPessoa));
				request.setAttribute("msg", "Pessoa removida com sucesso!");
				proxPage = "pessoa?acao=listar";
			}
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
		}
		request.getRequestDispatcher(proxPage).forward(request, response);
	}

}
