package managedBean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Produto;
import persistence.ProdutoDao;
import persistence.ProdutoDaoImpl;

@ManagedBean
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
	
	void carregaProdrutoCategoria(int categoria){
		
	}
	
	void caregaProdutoUnico(int id){
		
	}
	
	void pesquisaProduto(){
		
	}
	
	void icluiProduto(){
		
	}
	
	
	
}
