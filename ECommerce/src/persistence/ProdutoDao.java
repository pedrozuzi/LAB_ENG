package persistence;

import java.util.List;

import model.Produto;



public interface ProdutoDao {

	void incluiProduto(Produto prod);
	
	List<Produto> pesquisaProduto(Produto prod);
	
	void alteraProduto(Produto prod);
	
	void excluiProduto(Produto prod);
	
}
