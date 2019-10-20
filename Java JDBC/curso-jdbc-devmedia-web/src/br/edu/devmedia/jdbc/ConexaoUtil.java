package br.edu.devmedia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class ConexaoUtil {
	
	//Utilizando arquivo de configuração criado
	private static ResourceBundle config;
	
	private static ConexaoUtil conexaoUtil;
	
	private ConexaoUtil(){
		config = ResourceBundle.getBundle("config");
	}
	
	public static ConexaoUtil getInstance(){
		//Faz com q só possa ser instanciado um vez
		if(conexaoUtil == null){
			conexaoUtil = new ConexaoUtil();
		}
		return conexaoUtil;
	}
	
	//Metodo q coneta banco de dados e retorna um objeto do tipo connect
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName(config.getString("br.edu.devmedia.bd.driver.mysql"));
		return DriverManager.getConnection(config.getString("br.edu.devmedia.bd.url.conexao"), config.getString("br.edu.devmedia.bd.usuario"), 
				config.getString("br.edu.devmedia.bd.senha"));
	}
	
	public static void main(String[] args) {
		try{
			System.out.println(getInstance().getConnection());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
