package managedBean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import persistence.ProdutoDao;
import persistence.ProdutoDaoImpl;
import model.ItemPedido;

@ManagedBean
@SessionScoped
public class ItemPedidoMB {
	
	private List<ItemPedido> itensCarrinho;
	private ProdutoDao pDao;
	
	public ItemPedidoMB() {
		setItensCarrinho(new ArrayList<ItemPedido>());
		pDao = new ProdutoDaoImpl();
	}
	
	public List<ItemPedido> getItensCarrinho() {
		return itensCarrinho;
	}

	public void setItensCarrinho(List<ItemPedido> itensCarrinho) {
		this.itensCarrinho = itensCarrinho;
	}
	
	public String adiciona() {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage("Seu carrinho tem :  " + itensCarrinho.size() + " produtos" ));
		return "";
	}
	
	public String finalizarCompra() {
		double total;
		total = itensCarrinho.stream().mapToDouble(i -> i.getValorUnitario()).sum();
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage("Compra Finalizada. Total : " + total));
		itensCarrinho = new  ArrayList<ItemPedido>();
		return"";
	}
	
}
