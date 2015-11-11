package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Usuario;

public interface UsuarioDao {

	void incluiUsuario(Usuario usu)throws SQLException;
	
	List<Usuario> pesquisaUsuario(Usuario usu) throws SQLException;
	
	void alteraUsuario(Usuario usu)throws SQLException;
	
	void excluiUsuario (Usuario usu) throws SQLException;
	
}
