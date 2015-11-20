package managedBean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Produto;
import persistence.ProdutoDao;
import persistence.ProdutoDaoImpl;

@ManagedBean(name = "produtoMB")
@SessionScoped
public class ProdutoMB implements Serializable {
	private static final long serialVersionUID = 4196223195266927420L;
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

}
