package managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import control.PedidoControl;
import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import model.Produto;

@ManagedBean
@SessionScoped
public class CarrinhoMB implements Serializable{
	private static final long serialVersionUID = -9190430576650211038L;
	private Pedido pedido;
	private List<ItemPedido> itemPedido;
	
	public CarrinhoMB() {
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
		PedidoControl pedidoControl = new PedidoControl();
		double total;
		total = totalAPagar();
		pedido.setCliente(cliente);
		pedido.setData(new Date());
		pedido.setItemPedido(itemPedido);
		pedido.setValorTotal(total);
		
		pedidoControl.gravarPedido(pedido);
		
		pedido = new Pedido();
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

}
