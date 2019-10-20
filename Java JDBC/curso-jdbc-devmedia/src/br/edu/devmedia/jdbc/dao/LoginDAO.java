package br.edu.devmedia.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.Connection;


import br.edu.devmedia.jdbc.ConexaoUtil;
import br.edu.devmedia.jdbc.dto.LoginDTO;
import br.edu.devmedia.jdbc.exception.PersistenciaExcpetion;

public class LoginDAO implements GenericoDAO<LoginDTO> {

	public boolean logar(LoginDTO loginDTO) throws PersistenciaExcpetion{
		boolean resultado = false;
		try 
		{
			Connection connection = ConexaoUtil.getInstance().getConnection(); 
			
			String sql = "SELECT * FROM TB_LOGIN WHERE NOME = ? AND SENHA = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, loginDTO.getNome());
			statement.setString(2, loginDTO.getSenha());
			
			ResultSet resultSet = statement.executeQuery();
			resultado = resultSet.next();
			connection.close();
;			
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(), e);
		}
		
		return resultado;
	}
	
	@Override
	public void inserir(LoginDTO obj) throws PersistenciaExcpetion {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(LoginDTO obj) throws PersistenciaExcpetion {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Integer id) throws PersistenciaExcpetion {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LoginDTO> listarTodos() throws PersistenciaExcpetion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoginDTO buscarPorId(Integer id) throws PersistenciaExcpetion {
		// TODO Auto-generated method stub
		return null;
	}

}
