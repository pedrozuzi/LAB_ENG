package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Produto;



public interface ProdutoDao {

	void incluiProduto(Produto prod) throws SQLException;
	
	List<Produto> pesquisaProduto(Produto prod) throws SQLException;
	
	void alteraProduto(Produto prod) throws SQLException;
	
	void excluiProduto(Produto prod) throws SQLException;
	
}
