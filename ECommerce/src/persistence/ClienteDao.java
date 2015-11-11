package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Cliente;

/**
 * 
 * @author hury
 *
 */

public interface ClienteDao {


	void incluiCliente(Cliente cli) throws SQLException;
	
	List<Cliente> pesquisaCliente(Cliente cli) throws SQLException;
	
	void alteraCliente(Cliente cli) throws SQLException;
	
	void excluiCliente(Cliente cli) throws SQLException;
	
	
	
}
