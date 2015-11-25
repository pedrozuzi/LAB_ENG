package control;

import java.sql.SQLException;

import model.Pedido;
import persistence.PedidoDao;
import persistence.PedidoDaoImpl;

public class PedidoControl {
	
	private PedidoDao pDao;
	
	public void gravarPedido(Pedido p) {
		pDao = new PedidoDaoImpl();
		try {
			pDao.incluiPedido(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
