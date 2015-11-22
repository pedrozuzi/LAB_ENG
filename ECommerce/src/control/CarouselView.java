package control;


import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import managedBean.ProdutoMB;
import model.Produto;

@ManagedBean
@SessionScoped
public class CarouselView implements Serializable {

	private static final long serialVersionUID = 5579022747109827039L;

	
	private List<Produto> produtos;

	private Produto selectedProduto;
	
	@ManagedProperty("#{produtoMB}")
	private ProdutoMB prodmb;

	@PostConstruct
	public void init() {
		
		produtos = prodmb.pesquisar();
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getSelectedProduto() {
		return selectedProduto;
	}

	public void setSelectedProduto(Produto selectedProduto) {
		this.selectedProduto = selectedProduto;
	}

	public ProdutoMB getProdmb() {
		return prodmb;
	}

	public void setProdmb(ProdutoMB prodmb) {
		this.prodmb = prodmb;
	}

	
    public String pagPrincipal(){
    	produtos = prodmb.pesquisar();
    	return "index";
    }
    
 
    
    
}