package br.edu.devmedia.jdbc.bo;

import br.edu.devmedia.jdbc.dto.PessoaDTO;
import br.edu.devmedia.jdbc.exception.NegocioException;
import br.edu.devmedia.jdbc.exception.ValidacaoException;

import java.util.List;

import br.edu.devmedia.jdbc.dao.PessoaDAO;

public class PessoaBO {
	
	public void cadastrar(PessoaDTO pessoaDTO) throws NegocioException{
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.inserir(pessoaDTO);
		} 
		catch (Exception exception) {
			throw new NegocioException(exception.getMessage());
		}
	}
	
	public List<PessoaDTO> listagem() throws NegocioException {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			return pessoaDAO.listarTodos();
		} 
		catch(Exception exception) {
			throw new NegocioException(exception.getMessage());
		} 
	}
	public String[][] listagem(List<Integer> idPessoas) throws NegocioException{
		int numCols = 8;
		String [][] listaRetorno = null;
		
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			List<PessoaDTO> lista = pessoaDAO.listarTodos();
			listaRetorno = new String [lista.size()][numCols];
			
			for(int i = 0; i < lista.size(); i++){
				PessoaDTO pessoa = lista.get(i);
					listaRetorno[i][0] = pessoa.getIdPessoa().toString(); 
					idPessoas.add(pessoa.getIdPessoa());
					listaRetorno[i][1] = pessoa.getNome(); 
					listaRetorno[i][2] = pessoa.getCpf().toString();
					listaRetorno[i][3] = pessoa.getEndereco();
					listaRetorno[i][4] = pessoa.getSexo() == 'M' ? "Masculino" : "Feminino" ;
					listaRetorno[i][5] = pessoa.getDtNascimento();
					listaRetorno[i][6] = "Editar";
					listaRetorno[i][7] = "Deletar";
			}
			
			return listaRetorno;
		} 
		catch (Exception exception) {
			throw new NegocioException(exception.getMessage());
		}
	}
	
	public String[][] listaConsulta(String nome, Long cpf, char sexo, String orderBy ) throws NegocioException{
		int numCols = 6;
		String [][] listaRetorno = null;
		
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			List<PessoaDTO> lista = pessoaDAO.filtrarPessoa(nome, cpf, String.valueOf(sexo), orderBy);
			listaRetorno = new String [lista.size()][numCols];
			
			for(int i = 0; i < lista.size(); i++){
				PessoaDTO pessoa = lista.get(i);
					listaRetorno[i][0] = pessoa.getIdPessoa().toString(); 
					listaRetorno[i][1] = pessoa.getNome(); 
					listaRetorno[i][2] = pessoa.getCpf().toString();
					listaRetorno[i][3] = pessoa.getEndereco();
					listaRetorno[i][4] = pessoa.getSexo() == 'M' ? "Masculino" : "Feminino" ;
					listaRetorno[i][5] = pessoa.getDtNascimento();
			}
			
			return listaRetorno;
		} 
		catch (Exception exception) {
			throw new NegocioException(exception.getMessage());
		}
	}
	
	public void removePessoa(int idPessoa) throws NegocioException{
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.deletar(idPessoa);
		} 
		catch (Exception e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
	public PessoaDTO buscaPorId(Integer idPessoa) throws NegocioException{
		PessoaDTO pessoaDTO = null;
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDTO = pessoaDAO.buscarPorId(idPessoa);
		} 
		catch (Exception e) {
			throw new NegocioException(e.getMessage());
		}
		return pessoaDTO;
	}
	
	public boolean validaNome(String nome) throws ValidacaoException{
		boolean ehValido = true;
		if(nome == null || nome.equals("")){
			ehValido = false;
			throw new ValidacaoException("Campo Nome Obrigatorio");
		}else if(nome.length() > 30){
			throw new  ValidacaoException("Limite de Letras 30");
		}
		return ehValido;
	}
	
	public void removeTudo() throws NegocioException{
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
				pessoaDAO.deletarTudo();
		} 
		catch (Exception e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
	public boolean validaCPF (String cpf) throws ValidacaoException{
		boolean ehValido = true;
		if(cpf == null || cpf.equals("")){
			ehValido = false;
			throw new ValidacaoException("Campo CPF Obrigatorio");
		}else if(cpf.length() != 11){
			ehValido = false;
			throw new  ValidacaoException("Campo CPF deve ter 11 Digitos");
		}else{
			/*Verifica se é um numero*/
			char[] digitos = cpf.toCharArray();
			for(char digito : digitos){
				if(! Character.isDigit(digito)){
					throw new ValidacaoException("Campo CPF só aceita Números");
				}
			}
		}
		return ehValido;
	}
	
	public boolean validaEndereco (String endereco) throws ValidacaoException{
		boolean ehValido = true;
		if(endereco == null || endereco.equals("")){
			ehValido = false;
			throw new ValidacaoException("Campo Endereço Obrigatorio");
		}
		//Fazer os Outros Testes Bairro, Numero , etc
		return ehValido;
	}
	
	public boolean validaNasc (String nasc) throws ValidacaoException{
		boolean ehValido = true;
		if(nasc == null || nasc.equals("")){
			ehValido = false;
			throw new ValidacaoException("Campo Nascimento Obrigatorio");
		}else if(nasc.length() != 10){
			ehValido = false;
			throw new  ValidacaoException("Data de Nascimento Incorreta");
		}
		return ehValido;
	}
	
	
	public void atualizar(PessoaDTO pessoaDTO) throws NegocioException {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.atualizar(pessoaDTO);
		} catch (Exception e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
	public void removePessoa(Integer idPessoa) throws NegocioException {
		try {
			
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.deletar(idPessoa);
			
		} catch(Exception exception) {
			throw new NegocioException(exception.getMessage());
		}
	}
	
}
