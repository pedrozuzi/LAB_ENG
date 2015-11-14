package persistence;

import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Produto;

public class ProdutoDaoImpl implements ProdutoDao {
	
	private Connection c;
	
	public ProdutoDaoImpl(){
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public void incluiProduto(Produto prod) throws SQLException {
		String query = "INSERT INTO PRODUTO VALUES (?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setString(1, prod.getNome());
		ps.setDouble(2, prod.getValor());
	//	ps.setString(3, prod.getCategoria());

		ps.execute();
		ps.close();
		
	}

	/*
	@Override
	public List<Produto> pesquisaProduto(Produto prod) {
		
		List<Produto> lista = new ArrayList<Produto>();
		String query = "select * from produto where id = ?";
		try {
			PreparedStatement ps = c.prepareStatement( query );
			ps.setInt(1, prod.getIdProduto());
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {
                Produto P = new Produto();
				
                P.setIdProduto(rs.getInt("id"));
                P.setNome()
                P.setDescricao()
                P.setValor()
                //Primeiramete Carregar objeto categoria
                P.setCategoria()
                
                
				lista.add( c );
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
*/
	@Override
	public void alteraProduto(Produto prod) throws SQLException {
		
		String query = "UPDATE produto SET nome = ?, valor = ?, categoria = ? WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setString(1, prod.getNome());
		ps.setDouble(2, prod.getValor());
		//ps.setString(3, prod.getCategoria().getNome());

		ps.execute();
		ps.close();
		
	}

	@Override
	public void excluiProduto(Produto prod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Produto> pesquisaProduto(Produto prod) {
		// TODO Auto-generated method stub
		return null;
	}

}
