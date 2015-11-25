package managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import control.ItemControl;
import control.PedidoControl;
import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import model.Produto;

@ManagedBean
@SessionScoped
public class CarrinhoMB implements Serializable {
	private static final long serialVersionUID = -9190430576650211038L;
	private Pedido pedido;
	private List<ItemPedido> itemPedido;
	private List<String> formaPagamento;
	
	public List<String> getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(List<String> formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public CarrinhoMB() {
		formaPagamento = new ArrayList<String>();
		itemPedido = new ArrayList<ItemPedido>();
		pedido = new Pedido();
	}
	
	public void adiciona(Produto p) {
		ItemPedido ip = new ItemPedido();
		ip.setProduto(p);
		ip.setValorUnitario(p.getValor());
		itemPedido.add(ip);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage("Seu carrinho tem :  " + itemPedido.size() + " produto(s)" ));
	}
	
	public String finalizarCompra(Cliente cliente) {
		pedido = new Pedido();
		double total;
		total = totalAPagar();
		pedido.setCliente(cliente);
		pedido.setData(new Date());
		pedido.setItemPedido(itemPedido);
		pedido.setValorTotal(total);
		
		return"pagamento";
	}
	
	public void excluir(ItemPedido ip) {
		itemPedido.remove(ip);
	}
	
	public double totalAPagar() {
		return itemPedido.stream().mapToDouble(i -> i.getValorUnitario()).sum();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}
	
	public List<String> parcelas() {
		formaPagamento = new ArrayList<String>();
		formaPagamento.add("1x " + pedido.getValorTotal());
		formaPagamento.add("2x " + pedido.getValorTotal() / 2);
		formaPagamento.add("3x " + pedido.getValorTotal() / 3);
		formaPagamento.add("4x " + pedido.getValorTotal() / 4);
		formaPagamento.add("5x " + pedido.getValorTotal() / 5);
		formaPagamento.add("6x " + pedido.getValorTotal() / 6);
		return formaPagamento;
	}
	
	public String fecharPagamento() {
		PedidoControl pedidoControl = new PedidoControl();
		ItemControl itemControl = new ItemControl();
		pedidoControl.gravarPedido(pedido);
		itemPedido.forEach( i -> itemControl.incluiItem(i, pedido.getIdPedido()) );
		
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage("Pagamento realizado com sucesso!!" ));
		return"index";
	}

}
