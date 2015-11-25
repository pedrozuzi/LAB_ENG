package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import connection.ConnectionImpl;
import connection.GenericConnection;
import model.Pedido;

public class PedidoDaoImpl implements PedidoDao {
	
	private Connection c;
	
	public PedidoDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public void incluiPedido(Pedido ped) throws SQLException{
		String query = "insert into pedido values (?,?)";
		PreparedStatement ps = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setDate(1, new java.sql.Date(ped.getData().getTime()));
		ps.setDouble(2, ped.getValorTotal());
		ps.execute();
		
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		ped.setIdPedido(rs.getInt(1));
		
		ps.close();
	}

	@Override
	public List<Pedido> pesquisaPedido(Pedido ped) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alteraPedido(Pedido ped) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluiPedido(Pedido ped) {
		// TODO Auto-generated method stub

	}

}
