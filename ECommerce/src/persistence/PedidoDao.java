package persistence;

import java.util.List;

import model.Pedido;

public interface PedidoDao {

	void incluiPedido(Pedido ped);
	
	List<Pedido> pesquisaPedido(Pedido ped);
	
	void alteraPedido(Pedido ped);
	
	void excluiPedido(Pedido ped);
	
}
