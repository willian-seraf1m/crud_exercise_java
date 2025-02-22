package produto.model;

public class ProdutoLivro extends Produto {

	private String autor;

	public ProdutoLivro(int id, float preco, String nome, int categoria, int estoque, String autor) {
		super(id, preco, nome, categoria, estoque);
		this.autor = autor;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.printf("\nNome do autor: %s\n", this.getAutor());
		System.out.println("\n***********************************************************\n");
	}


}
