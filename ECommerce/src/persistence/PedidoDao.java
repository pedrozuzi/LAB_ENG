package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Pedido;

public interface PedidoDao {

	void incluiPedido(Pedido ped) throws SQLException;
	
	List<Pedido> pesquisaPedido(Pedido ped);
	
	void alteraPedido(Pedido ped);
	
	void excluiPedido(Pedido ped);
	
}
