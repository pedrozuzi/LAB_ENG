package control;

import java.sql.SQLException;

import model.ItemPedido;
import persistence.ItemPedidoDao;
import persistence.ItemPedidoDaoImpl;

public class ItemControl {
	
	private ItemPedidoDao ipDao;
	
	public void incluiItem(ItemPedido item, int idPedido) {
		ipDao = new ItemPedidoDaoImpl();
		try {
			ipDao.incluiItemPedido(item, idPedido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
