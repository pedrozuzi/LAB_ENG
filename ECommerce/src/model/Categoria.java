package model;

/**
 * 
 * @author hury
 *
 */

public class Categoria {

	Categoria cat;
	private String nome;
	
	public Categoria(Categoria cat) {
		super();
		this.cat = cat;
		//cat = new Categoria(cat);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
		
}
