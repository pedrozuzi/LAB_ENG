package managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioMB implements Serializable {
	private static final long serialVersionUID = -7952903320250248386L;
	private Usuario usuario;
	
	public UsuarioMB() {
		usuario = new Usuario();
	}
	
	public String adiciona() {
		
		return "";
	}
	
	public void altera() {

	}

	public List<Usuario> pesquisa(Usuario usu) {

		return null;
	}

	public void exclui(Usuario usu) {

	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
