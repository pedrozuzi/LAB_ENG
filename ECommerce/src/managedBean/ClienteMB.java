package managedBean;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import control.ClienteDaoException;
import model.Cliente;
import persistence.ClienteDao;
import persistence.ClienteDaoImpl;

@ManagedBean
@SessionScoped
public class ClienteMB implements Serializable{
	private static final long serialVersionUID = -4203711507524977641L;
	private Cliente clienteAtual;
	private ClienteDao cDao;
	
	public Cliente getClienteAtual() {
		return clienteAtual;
	}

	public void setClienteAtual(Cliente clienteAtual) {
		this.clienteAtual = clienteAtual;
	}

	public ClienteMB() {
		clienteAtual = new Cliente();
		cDao = new ClienteDaoImpl();
	}
	
	public String adicionar(){
		String msg="Erro ao cadastrar!";
		try {
			cDao.incluiCliente(clienteAtual);
			msg = "Cadastro concluído com sucesso!";
		} catch (ClienteDaoException e) {
			e.printStackTrace();
		}
		clienteAtual = new Cliente();
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage( "", new FacesMessage( msg ) );
		return "";
	}
	

}
