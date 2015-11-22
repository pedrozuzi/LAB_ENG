package persistence;

import java.util.ArrayList;
import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Produto;

public class ProdutoDaoImpl implements ProdutoDao, Serializable {

	private static final long serialVersionUID = -8597603272404903316L;
	
	private Connection c;

	public ProdutoDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	/*
	 * id int not null, nome varchar (100), valor decimal(7,2), descricao
	 * varchar(max), categoria int, marca varchar(40), imagem varchar(40)
	 */

	@Override
	public void incluiProduto(Produto prod) throws SQLException {
		String query = "INSERT INTO PRODUTO VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setString(1, prod.getNome());
		ps.setDouble(2, prod.getValor());
		ps.setString(3, prod.getDescricao());
		ps.setInt(4, prod.getCategoria());
		ps.setString(5, prod.getMarca());
		ps.setString(6, prod.getImagem());

		ps.execute();
		ps.close();

	}

	@Override
	public void alteraProduto(Produto prod) throws SQLException {

		String query = "UPDATE produto SET nome = ?, valor = ?, descricao=?,"
				+ " categoria = ?, marca=?, imagem=? WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setString(1, prod.getNome());
		ps.setDouble(2, prod.getValor());
		ps.setString(3, prod.getDescricao());
		ps.setInt(4, prod.getCategoria());
		ps.setString(5, prod.getMarca());
		ps.setString(6, prod.getImagem());
		ps.setInt(7, prod.getIdProduto());

		ps.execute();
		ps.close();

	}

	@Override
	public void excluiProduto(Produto prod) throws SQLException {

		String query = "DELETE produto where id = ?";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setInt(1, prod.getIdProduto());

		ps.execute();
		ps.close();

	}

	@Override
	public List<Produto> pesquisaProduto(Produto prod) throws SQLException {
		List<Produto> lista = new ArrayList<Produto>();
		String query = "select * from produto"; // where id = ?
		PreparedStatement ps = c.prepareStatement(query);
		//ps.setInt(1, prod.getIdProduto());
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Produto p = new Produto();

			p.setIdProduto(rs.getInt("id"));
			p.setNome(rs.getString("nome"));
			p.setValor(rs.getDouble("valor"));
			p.setDescricao(rs.getString("descricao"));
			p.setCategoria(rs.getInt("categoria"));
			p.setMarca(rs.getString("marca"));
			p.setImagem(rs.getString("imagem"));

			lista.add(p);
		}
		ps.close();

		return lista;
	}
	
	public List<Produto> pesquisaProdutoNome(String nome) throws SQLException {
		List<Produto> lista = new ArrayList<Produto>();
		String query = "select * from produto where nome like ?"; // where id = ?
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, "%"+nome+"%");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Produto p = new Produto();

			p.setIdProduto(rs.getInt("id"));
			p.setNome(rs.getString("nome"));
			p.setValor(rs.getDouble("valor"));
			p.setDescricao(rs.getString("descricao"));
			p.setCategoria(rs.getInt("categoria"));
			p.setMarca(rs.getString("marca"));
			p.setImagem(rs.getString("imagem"));

			lista.add(p);
		}
		ps.close();

		return lista;
	}

	@Override
	public List<Produto> pesquisaProdutoCategoria(int cat) throws SQLException {
		List<Produto> lista = new ArrayList<Produto>();
		String query = "select * from v_prodcat where idcat = ?";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setInt(1, cat);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Produto p = new Produto();

			p.setIdProduto(rs.getInt("id"));
			p.setNome(rs.getString("nome"));
			p.setValor(rs.getDouble("valor"));
			p.setDescricao(rs.getString("descricao"));
			p.setCategoria(rs.getInt("idcat"));
			p.setMarca(rs.getString("marca"));
			p.setImagem(rs.getString("imagem"));

			lista.add(p);
		}
		ps.close();

		return lista;
	}

}
