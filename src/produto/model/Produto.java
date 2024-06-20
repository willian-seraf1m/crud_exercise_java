package produto.model;

public abstract class Produto {
	
	private int id;
	private int categoria;
	private int estoque;
	private float preco;
	private String nome;
	
	public Produto(int id, float preco, String nome, int categoria, int estoque) {
		this.id = id;
		this.preco = preco;
		this.nome = nome;
		this.categoria = categoria;
		this.estoque = estoque;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	
	public void visualizar() {
	    String categoriaString = this.getCategoria() == 1 ? "Livro" : "Revista";
	    
	    System.out.println("\n***********************************************************");
	    System.out.println("\nDados do Produto:");
	    System.out.printf("\nID do produto: %d", this.getId());
	    System.out.printf("\nCategoria do produto: %s", categoriaString);
	    System.out.printf("\nNome do Produto: %s", this.getNome());
	    System.out.printf("\nEstoque do Produto: %s", this.estoque);
	    System.out.printf("\nPreço do produto: R$ %.2f", this.getPreco());
	}
	
}
