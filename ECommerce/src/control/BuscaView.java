package control;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class BuscaView {

   private String busca;

public String getBusca() {
	return busca;
}

public void setBusca(String busca) {
	this.busca = busca;
}
	
}
