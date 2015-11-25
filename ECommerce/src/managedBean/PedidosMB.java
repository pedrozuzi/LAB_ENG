package managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import persistence.PedidoDao;
import persistence.PedidoDaoImpl;
import model.Cliente;
import model.Pedido;

@ManagedBean
@ViewScoped
public class PedidosMB {
	
	private List<Pedido> pedido;
	
	public PedidosMB() {
		pedido = new ArrayList<Pedido>();
	}
	
	public List<Pedido> buscaPedidos(Cliente c) {
		PedidoDao pDao = new PedidoDaoImpl();
//		pedido = pDao.pesquisaPedido(ped);
		return pedido;
		
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

}
