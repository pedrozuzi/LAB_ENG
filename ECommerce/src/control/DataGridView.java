package control;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import managedBean.ProdutoMB;
import model.Produto;

@ManagedBean(name = "dataGridView")
@SessionScoped
// @ViewScoped
public class DataGridView implements Serializable {
	private static final long serialVersionUID = 7659498095569980364L;

	private List<Produto> produtos;

	private Produto selectedProduto;
	
	private String busca;

	private int categoria;
	
	@ManagedProperty("#{produtoMB}")
	private ProdutoMB prodmb;

	@PostConstruct
	public void init() {
		//primeira pagina
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

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

	
	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	
	public void pesquisarNome(){
		produtos = prodmb.pesquisarNome(busca);
	}
	
    public String pagPrincipal(){
    	produtos = prodmb.pesquisar();
    	return "index";
    }
    
    public String pesquisaCateg(String cat){
    	categoria = Integer.parseInt(cat);
    	produtos = prodmb.pesquisaCategoria(categoria);
    	return "index";
    }


}