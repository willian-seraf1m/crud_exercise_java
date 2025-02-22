package produto.repository;

import produto.model.Produto;

public interface ProdutoRepository {
	public void procurarPorId(int id);
	public void listarProdutos();
	public void cadastrar(Produto produto);
	public void atualizar(Produto produto);
	public void deletar(int numero);
	public void vender(int quantidade, int id);
}
