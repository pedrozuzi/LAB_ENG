package control;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import managedBean.ProdutoMB;
import model.Produto;

 
@ManagedBean
@ViewScoped
public class DataGridView implements Serializable {
     
    private List<Produto> produtos;
     
    private Produto selectedProduto;
     
    @ManagedProperty("#{produtos}")
    private ProdutoMB prodmb;
     
    @PostConstruct
    public void init() throws SQLException {
        produtos = prodmb.pesquisar();
    }
 
    public List<Produto> getProduto() {
        return produtos;
    }
 
    public void setProdutoMB(ProdutoMB prodmb) {
        this.prodmb = prodmb;
    }
 
    public Produto getSelectedProduto() {
        return selectedProduto;
    }
 
    public void setSelectedProduto(Produto selectedProduto) {
        this.selectedProduto = selectedProduto;
    }
}