package persistence;

import java.sql.SQLException;
import java.util.List;
import model.ItemPedido;

public interface ItemPedidoDao {

	void incluiItemPedido(ItemPedido it, int idPedido) throws SQLException;
	
	List<ItemPedido> pesquisaItemPedido(ItemPedido it);
	
	void alteraItemPedido (ItemPedido it);
	
	void excluiItemPedido (ItemPedido it);
	
}
