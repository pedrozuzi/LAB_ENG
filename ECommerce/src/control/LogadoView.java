package control;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
public class LogadoView {

	public void save(ActionEvent e) {
		addMessage("Success", "Alterar");
	}

	public void update(ActionEvent e) {
		addMessage("Success", "Pedidos");
	}
	
    public void carrinhoAdd(ActionEvent e) {
        addMessage("Adicionado ao Carrinho!");
    }
	
	public void logOff() {
		
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
