package managedBean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Produto;
import persistence.ProdutoDao;
import persistence.ProdutoDaoImpl;

@ManagedBean(name = "produtoMB")
@ApplicationScoped
public class ProdutoMB {
	//private static final long serialVersionUID = 4196223195266927420L;
	private List<Produto> listaPesquisa = new ArrayList<Produto>();

	private Produto produtoAtual;
	private ProdutoDao produtoDao;
	

	public ProdutoMB() {
		produtoAtual = new Produto();
		produtoDao = new ProdutoDaoImpl();
	}

	void primeiraPagina() {

	}

	public List<Produto> carregaProdrutoCategoria(int categoria) throws SQLException {
		List<Produto> lista = new ArrayList<Produto>();
		lista = produtoDao.pesquisaProdutoCategoria(categoria);

		return lista;
	}

	public List<Produto> pesquisar() {
		// String msg = "Erro ao pesquisar Produto";
		try {
			listaPesquisa = produtoDao.pesquisaProduto(produtoAtual);
			// msg = "Foram encontrados " + listaPesquisa.size() + " Produtos";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// FacesContext fc = FacesContext.getCurrentInstance();
		// fc.addMessage( "", new FacesMessage( msg ) );
		return listaPesquisa;
	}

	void caregaProdutoUnico(int id) {

	}

	void pesquisaProduto() {

	}

	void icluiProduto() {

	}

	public List<Produto> getListaPesquisa() {
		return listaPesquisa;
	}

	public void setListaPesquisa(List<Produto> listaPesquisa) {
		this.listaPesquisa = listaPesquisa;
	}

	public Produto getProdutoAtual() {
		return produtoAtual;
	}

	public void setProdutoAtual(Produto produtoAtual) {
		this.produtoAtual = produtoAtual;
	}

	public ProdutoDao getProdutoDao() {
		return produtoDao;
	}

	public void setProdutoDao(ProdutoDao produtoDao) {
		this.produtoDao = produtoDao;
	}
	
	
	
	

}
