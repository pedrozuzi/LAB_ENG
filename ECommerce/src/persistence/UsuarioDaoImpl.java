package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import connection.ConnectionImpl;
import connection.GenericConnection;
import model.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {
	
	private Connection c;
	
	public UsuarioDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public void incluiUsuario(Usuario usu) throws SQLException {
		String query = "insert into usuario values(?,?)";
		PreparedStatement ps = c.prepareStatement(query);
		
		ps.setString(1, usu.getEmail());
		ps.setString(2, usu.getSenha());
		ps.execute();
		ps.close();
	}

	@Override
	public List<Usuario> pesquisaUsuario(Usuario usu) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alteraUsuario(Usuario usu) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluiUsuario(Usuario usu) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
