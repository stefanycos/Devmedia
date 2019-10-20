package br.edu.devmedia.jdbc.bo;

import br.edu.devmedia.jdbc.dao.LoginDAO;
import br.edu.devmedia.jdbc.dto.LoginDTO;
import br.edu.devmedia.jdbc.exception.NegocioException;

public class LoginBO {
	
	public boolean logar(LoginDTO loginDTO) throws NegocioException{
		boolean resultado = false;
		try 
		{
			//se o login for igual a nulo ou igual a vazio
			if(loginDTO.getNome() == null || "".equals(loginDTO.getNome()) ){
				throw new NegocioException("Login Obrigatório");
			}
			else if(loginDTO.getSenha() == null || "".equals(loginDTO.getSenha()) ){
				throw new NegocioException("Senha Obrigatório");
			}
			else{
				LoginDAO loginDAO = new LoginDAO();
				if(loginDAO.logar(loginDTO)){
					resultado =  loginDAO.logar(loginDTO);
				}
			}
		} 
		catch (Exception e) {
			throw new NegocioException(e.getMessage());
		}
		return resultado;
	}

}
