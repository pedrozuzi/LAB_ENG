package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connection.ConnectionImpl;
import connection.GenericConnection;
import model.Usuario;

/**
 * 
 * @author hury
 *
 */

public class UsuarioDaoImpl implements UsuarioDao {

	private Connection c;

	public UsuarioDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	/**
	 * create table usuario(
	 * 
	 *    id int not null,
	 *    email VARCHAR(320),
	 *    senha varbinary(32),
	 *    foreign key (id ) references cliente(id) )
	 */

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
		List<Usuario> list = new ArrayList<Usuario>();
		
		
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public void alteraUsuario(Usuario usu) throws SQLException {
		
		String query = "insert into usuario values(?,?)";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setString(1, usu.getEmail());
		ps.setString(2, usu.getSenha());
		
		ps.execute();
		ps.close();

	}

	@Override
	public void excluiUsuario(Usuario usu) throws SQLException {
		
		String query = "UPDATE usuario set email=?, senha=? where id=?";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setString(1, usu.getEmail());
		ps.setString(2, usu.getSenha());
		ps.setInt(3, usu.getIdUsuario());
		
		ps.execute();
		ps.close();
	}

}
