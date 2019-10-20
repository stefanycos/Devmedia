package br.edu.devmedia.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.edu.devmedia.jdbc.ConexaoUtil;
import br.edu.devmedia.jdbc.dto.EnderecoDTO;
import br.edu.devmedia.jdbc.dto.PessoaDTO;
import br.edu.devmedia.jdbc.exception.PersistenciaExcpetion;

public class PessoaDAO implements GenericoDAO<PessoaDTO> {

	@Override
	public void inserir(PessoaDTO pessoaDTO) throws PersistenciaExcpetion {
		try {
			
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "INSERT INTO TB_PESSOA (NOME, CPF, ENDERECO, SEXO, DT_NASC) "
					+ "VALUES(?,?,?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, pessoaDTO.getNome());
			statement.setLong(2, pessoaDTO.getCpf());
			statement.setString(3, pessoaDTO.getEndereco());
			statement.setString(4, String.valueOf(pessoaDTO.getSexo()));
			statement.setString(5, pessoaDTO.getDtNascimento());
			
			statement.execute();
			connection.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(), e);
		}
	}
	
	/*private int insereEndereco(EnderecoDTO enderecoDTO) throws PersistenciaExcpetion{
		int chave = 0;
		try {
			
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "INSERT INTO TB_ENDERECO (LONGRADOURO, BAIRRO, CIDADE, NUMERO, CEP, COD_UF) "
					+ "VALUES(?,?,?,?,?,?)";
			//Retorna a chave primaria q foi criada ao inserir o endereco
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, enderecoDTO.getLongradouro());
			statement.setString(2, enderecoDTO.getBairro());
			statement.setString(3, enderecoDTO.getCidade());
			statement.setLong(4, enderecoDTO.getNumero());
			statement.setInt(5, enderecoDTO.getCep());
			statement.setInt(6, enderecoDTO.getUfDTO().getIdUf());
			
			statement.execute();
			ResultSet result = statement.getGeneratedKeys();
			
			if(result.next()){
				chave = result.getInt(1);
			}
			connection.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(), e);
		}
		
		return chave;
	}*/

	@Override
	public void atualizar(PessoaDTO pessoaDTO) throws PersistenciaExcpetion {
		
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "UPDATE TB_PESSOA "
					+ "SET NOME = ? ,"
					+ "CPF = ? , "
					+ "ENDERECO = ? , "
					+ "SEXO = ? , "
					+ "DT_NASC = ? "
					+ "WHERE ID_PESSOA = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, pessoaDTO.getNome());
			statement.setLong(2, pessoaDTO.getCpf());
			//statement.setString(3, pessoaDTO.getEndereco());
			statement.setString(4, String.valueOf(pessoaDTO.getSexo()));
			statement.setString(5, pessoaDTO.getDtNascimento());
			statement.setInt(6, pessoaDTO.getIdPessoa());
			
			statement.execute();
			connection.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(), e);
		}
		
	}

	@Override
	public void deletar(Integer id) throws PersistenciaExcpetion {
		
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "DELETE FROM TB_PESSOA WHERE ID_PESSOA = ?";
			
			 PreparedStatement statement = connection.prepareStatement(sql);
			 statement.setInt(1, id);
			
			 statement.execute();
			 connection.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(), e);
		}
	}
	
	public void deletarTudo() throws PersistenciaExcpetion{
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "DELETE FROM TB_PESSOA";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.execute();
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(), e);
		}
	}

	@Override
	public List<PessoaDTO> listarTodos() throws PersistenciaExcpetion {
		List<PessoaDTO> listaPessoas = new ArrayList<PessoaDTO>();
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "SELECT * FROM TB_PESSOA";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			//Retorna um objeto com a tabela consultada
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				PessoaDTO pessoaDTO = new PessoaDTO();
				pessoaDTO.setIdPessoa(resultSet.getInt("id_pessoa"));
				pessoaDTO.setNome(resultSet.getString("nome"));
				pessoaDTO.setCpf(resultSet.getLong("cpf"));
				pessoaDTO.setDtNascimento(resultSet.getString("dt_nasc"));
				//pessoaDTO.setEndereco(resultSet.getString("endereco"));
				pessoaDTO.setSexo(resultSet.getString("sexo").charAt(0));
				
				listaPessoas.add(pessoaDTO);
					
			}
			connection.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(), e);
		}
		return listaPessoas;
	}

	@Override
	public PessoaDTO buscarPorId(Integer id) throws PersistenciaExcpetion {
		PessoaDTO pessoaDTO = null;
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM TB_PESSOA WHERE ID_PESSOA = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()){
				pessoaDTO = new PessoaDTO();
				pessoaDTO.setIdPessoa(resultSet.getInt("id_pessoa"));
				pessoaDTO.setNome(resultSet.getString("nome"));
				pessoaDTO.setCpf(resultSet.getLong("cpf"));
				pessoaDTO.setDtNascimento(resultSet.getString("dt_nasc"));
				//pessoaDTO.setEndereco(resultSet.getString("endereco"));
				pessoaDTO.setSexo(resultSet.getString("sexo").charAt(0));
			}
			
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(), e);
		}
		return pessoaDTO;
	}

	public List<PessoaDTO> filtrarPessoa(String nome, Long cpf, String sexo, String orderBy) throws PersistenciaExcpetion{
		List<PessoaDTO> lista = new ArrayList<PessoaDTO>();
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM TB_PESSOA ";
			boolean ultimo = false;
			if (nome != null && !nome.equals("")) {
				sql += " WHERE NOME LIKE ?";
				ultimo = true;
			}
			
			if (cpf != null && !cpf.equals("")) {
				if (ultimo) {
					sql += " AND ";
				} else {
					sql += " WHERE ";
					ultimo = true;
				}
				sql += " CPF LIKE ?";
			}
			
			if (sexo != null && !sexo.equals("")) {
				if (ultimo) {
					sql += " AND ";
				} else {
					sql += " WHERE ";
				}
				sql += " SEXO = ?";
			}
			sql += " ORDER BY " + orderBy;
			
			PreparedStatement statement = connection.prepareStatement(sql);
			int cont = 0;
			if (nome != null && !nome.equals("")) {
				statement.setString(++cont, "%" + nome + "%");
			}
			
			if (cpf != null && !cpf.equals("")) {
				statement.setString(++cont, "%" + cpf + "%");
			}
			
			if (sexo != null && !sexo.equals("")) {
				statement.setString(++cont, sexo);
			}
			
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				PessoaDTO pessoaDTO = new PessoaDTO();
				pessoaDTO.setIdPessoa(resultSet.getInt("id_pessoa"));
				pessoaDTO.setNome(resultSet.getString("nome"));
				pessoaDTO.setCpf(resultSet.getLong("cpf"));
				pessoaDTO.setDtNascimento(resultSet.getString("dt_nasc"));
				//pessoaDTO.setEndereco(resultSet.getString("endereco"));
				pessoaDTO.setSexo(resultSet.getString("sexo").charAt(0));
				
				lista.add(pessoaDTO);
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(), e);
		}
		return lista;
	}
}
