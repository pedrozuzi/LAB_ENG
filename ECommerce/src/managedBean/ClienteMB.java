package managedBean;

import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import model.Cliente;
import model.Usuario;
import persistence.ClienteDao;
import persistence.ClienteDaoImpl;
import persistence.UsuarioDao;
import persistence.UsuarioDaoImpl;
import exception.ClienteDaoException;

@ManagedBean
@ApplicationScoped
public class ClienteMB implements Serializable{
	private static final long serialVersionUID = -4203711507524977641L;
	private Cliente clienteAtual;
	private ClienteDao cDao;
	private UsuarioDao uDao;
	
	public ClienteMB() {
		clienteAtual = new Cliente();
		cDao = new ClienteDaoImpl();
		uDao = new UsuarioDaoImpl();
	}
	
	public String adicionar(Usuario u) throws SQLException{
		String msg="Erro ao cadastrar!";
		try {
			uDao.incluiUsuario(u);
			clienteAtual.setUsuario(u);
			cDao.incluiCliente(clienteAtual);
			msg = "Cadastro concluído com sucesso!";
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage( "", new FacesMessage( msg ) );
			return "index";
		} catch (ClienteDaoException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public Cliente getClienteAtual() {
		return clienteAtual;
	}

	public void setClienteAtual(Cliente clienteAtual) {
		this.clienteAtual = clienteAtual;
	}
	
	public void buscaCliente(Usuario u) {
		System.out.println("BUSCA CLIENTE");
		try {
			clienteAtual = cDao.getCliente(u.getEmail());
			System.out.println(clienteAtual.getNome());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
