package control;

import model.Pedido;
import persistence.PedidoDao;
import persistence.PedidoDaoImpl;

public class PedidoControl {
	
	private PedidoDao pDao;
	
	public void gravarPedido(Pedido p) {
		pDao = new PedidoDaoImpl();
		pDao.incluiPedido(p);
	}
}
