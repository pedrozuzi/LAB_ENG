package model;

public class Produto {
	
	private int idProduto;
	private String nome;
	private String descicao;
	private double valor;
	private Categoria2 categoria;
	private String marca;
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescicao() {
		return descicao;
	}
	public void setDescicao(String descicao) {
		this.descicao = descicao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Categoria2 getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria2 categoria) {
		this.categoria = categoria;
	}
	
}
