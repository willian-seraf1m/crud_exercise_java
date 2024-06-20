package produto.model;

public class ProdutoRevista extends Produto {

	private String editora;
	
	public ProdutoRevista(int id, float preco, String nome, int categoria, String editora) {
		super(id, preco, nome, categoria);
		this.editora = editora;
	}

	public String getEditora() {
		return editora;
	}
	
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	@Override
	public void visualizar() {
	    super.visualizar();
	    System.out.printf("\nEditora que publicou: %s", this.getEditora());
	    System.out.println("\n***********************************************************\n");
	}

}
