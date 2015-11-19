package managedBean;

import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import persistence.UsuarioDao;
import persistence.UsuarioDaoImpl;
import model.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioMB implements Serializable {
	private static final long serialVersionUID = -7952903320250248386L;
	private Usuario usuario;
	private UsuarioDao uDao;
	private boolean logado = true;
	private String msg = "Entre ou cadastra-se";
	
	public UsuarioMB() {
		usuario = new Usuario();
		uDao = new UsuarioDaoImpl();
	}
	
	public String realizarLogin() {
		String msg="Usuário ou senha inválido!";
		try {
			if (!uDao.realizarLogin(usuario)) {
				usuario = new Usuario();
				FacesContext fc = FacesContext.getCurrentInstance();
				fc.addMessage( "", new FacesMessage( msg ) );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
		
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	public String getMsg() {
		if (logado) {
			return "Olá Usuário";
		}
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
