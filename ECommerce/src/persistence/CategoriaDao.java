package persistence;

import java.util.List;

import model.Categoria;

public interface CategoriaDao {

	void incluiCategoria(Categoria cat);
	
	List<Categoria> pesquisaCategoria(Categoria cat);
	
	void alteraCategoria(Categoria cat);
	
	void excluiCategoria(Categoria cat);
	
	
}
