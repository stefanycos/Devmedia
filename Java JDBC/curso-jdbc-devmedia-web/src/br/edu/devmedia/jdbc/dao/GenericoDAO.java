package br.edu.devmedia.jdbc.dao;

import java.util.List;

import br.edu.devmedia.jdbc.exception.PersistenciaExcpetion;

public interface GenericoDAO <T> {
	
	//Estamos dizendo que o metodo inserir recebe um objeto T
	//Q ñ sabemos o q é, pois é uma Interface Generica
	void inserir(T obj) throws PersistenciaExcpetion;
	
	void atualizar (T obj) throws PersistenciaExcpetion;
	
	void deletar (Integer id) throws PersistenciaExcpetion;
	
	List<T> listarTodos() throws PersistenciaExcpetion;
	
	T buscarPorId(Integer id) throws PersistenciaExcpetion;
	

}
