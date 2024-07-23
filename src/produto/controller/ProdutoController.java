package produto.controller;

import java.util.ArrayList;

import produto.model.Produto;
import produto.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {

	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	int id = 0;

	@Override
	public void procurarPorId(int id) {
		var produto = buscarNaCollection(id);

		if(produto != null) {
			produto.visualizar();
		} else {
			System.out.println("Produto não encontrado!");
		}
	}

	@Override
	public void listarProdutos() {		
		listaProdutos.forEach(produto -> produto.visualizar());
	}

	@Override
	public void cadastrar(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("O produto foi cadastrado com sucesso!");
	}

	@Override
	public void atualizar(Produto produto) {
		var buscaProduto = buscarNaCollection(produto.getId());

		if(buscaProduto != null) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto), produto);
		} else {
			System.out.println("Produto nao encontrado!");
		}

	}

	@Override
	public void deletar(int id) {
		var produto = buscarNaCollection(id);

		if(produto != null && listaProdutos.remove(produto) == true) { 
			listaProdutos.remove(produto);
			System.out.printf("\nO produto id %d foi deletado com sucesso!", id);
		} else {
			System.out.println("\nProduto não encontrado!");
		}
	}

	@Override
	public void vender(int quantidade, int id) {
		var produto = buscarNaCollection(id);

		if(produto != null && produto.getEstoque() > quantidade) {
			produto.setEstoque(produto.getEstoque() - quantidade);

			float faturamento = produto.getPreco()*quantidade;
			System.out.printf("Produto vendido! Valor total da venda: R$ %.2f", faturamento);
		} else {
			System.err.println("Não foi possível completar a venda!");
		}

	}

	public int createId() {
		return ++id;
	}

	public Produto buscarNaCollection(int id) {	
		for(var produto : listaProdutos) {
			if(produto.getId() == id) {
				return produto;
			}
		}

		return null;
	}
}
