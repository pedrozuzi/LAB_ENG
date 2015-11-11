package persistence;

import java.util.List;

import model.ItemPedido;

public interface ItemPedidoDao {

	void incluiItemPedido(ItemPedido it);
	
	List<ItemPedido> pesquisaItemPedido(ItemPedido it);
	
	void alteraItemPedido (ItemPedido it);
	
	void excluiItemPedido (ItemPedido it);
	
}
