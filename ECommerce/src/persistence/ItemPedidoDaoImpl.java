package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import connection.ConnectionImpl;
import connection.GenericConnection;
import model.ItemPedido;

public class ItemPedidoDaoImpl implements ItemPedidoDao {
	
	private Connection c;
	
	public ItemPedidoDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public void incluiItemPedido(ItemPedido it, int idPedido)
			throws SQLException {
		String query = "insert into itempedido values (?,?,?)";
		
		PreparedStatement ps = c.prepareStatement(query);
		ps.setDouble(1, it.getValorUnitario());
		ps.setInt(2, it.getProduto().getIdProduto());
		ps.setInt(3, idPedido);
		ps.execute();
		ps.close();

	}

	@Override
	public List<ItemPedido> pesquisaItemPedido(ItemPedido it) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alteraItemPedido(ItemPedido it) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluiItemPedido(ItemPedido it) {
		// TODO Auto-generated method stub

	}

}
