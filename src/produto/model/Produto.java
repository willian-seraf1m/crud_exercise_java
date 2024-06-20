package produto.model;

public abstract class Produto {
	
	private int id, categoria;
	private float preco;
	private String nome;
	
	public Produto(int id, float preco, String nome, int categoria) {
		this.id = id;
		this.preco = preco;
		this.nome = nome;
		this.categoria = categoria;
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
	
	
	public void visualizar() {
		String categoria = "";
		
		switch(this.categoria) {
		case 1:
			categoria = "Livro";
			break;
		case 2:
			categoria = "Revista";
			break;
		}
		
		System.out.println("\n\n***********************************************************");
		System.out.printf("\nDados do Produto: ", this.nome);
		System.out.println("\n\n***********************************************************");
		System.out.printf("\nID do produto: ", this.id);
		System.out.printf("\nCategoria do produto: ", categoria);
		System.out.printf("\nNome do Produto: ", this.nome);
		System.out.printf("\nPreço do produto: ", this.preco);
	}
	
}
