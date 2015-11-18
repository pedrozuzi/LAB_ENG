package managedBean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Produto;
import persistence.ProdutoDao;
import persistence.ProdutoDaoImpl;

@ManagedBean(name ="produtos")
@SessionScoped
public class ProdutoMB implements Serializable {
	
	private static final long serialVersionUID = 4196223195266927420L;

	private Produto produto;
	private ProdutoDao pDao;
	
	public ProdutoMB() {
		produto = new Produto();
		pDao = new ProdutoDaoImpl();
	}
	
	void primeiraPagina(){
		
	}
	
	public List<Produto> carregaProdrutoCategoria(int categoria) throws SQLException{
		List<Produto> lista = new ArrayList<Produto>();
		 lista=pDao.pesquisaProdutoCategoria(categoria);
		 
		 
		 return lista;
	}
	
	void caregaProdutoUnico(int id){
		
	}
	
	void pesquisaProduto(){
		
	}
	
	void icluiProduto(){
		
	}
	
	
	
}
