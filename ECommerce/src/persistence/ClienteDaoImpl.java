package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;
import control.ClienteDaoException;
import model.Cliente;

public class ClienteDaoImpl implements ClienteDao {

	private Connection c;
		
	public ClienteDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public void incluiCliente(Cliente cli) throws ClienteDaoException {
		
	}

	@Override
	public List<Cliente> pesquisaCliente(Cliente cli) throws SQLException {
		List<Cliente> lista = new ArrayList<Cliente>();
		String query = "select * from cliente where id = ?";
		try {
			PreparedStatement ps = c.prepareStatement( query );
			ps.setInt(1, cli.getIdCliente());
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {
                Cliente c = new Cliente();
				
                c.setIdCliente(rs.getInt("id"));
                
                
				lista.add( c );
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public void alteraCliente(Cliente cli) throws SQLException {
		String query = "UPDATE cliente SET nome = ? WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setString(1, cli.getNome());


		ps.execute();
		ps.close();
		
	}

	@Override
	public void excluiCliente(Cliente cli) throws SQLException {
		String query = "DELETE cliente " + " where id = ?";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setInt(1, cli.getIdCliente());


		ps.execute();
		ps.close();
	}

}
