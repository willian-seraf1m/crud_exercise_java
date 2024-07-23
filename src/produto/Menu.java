package produto;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import produto.controller.ProdutoController;
import produto.model.ProdutoLivro;
import produto.model.ProdutoRevista;
import produto.util.Cores;

public class Menu {
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);

		ProdutoController produtos = new ProdutoController();

		int opcao, id, categoria, estoque, quantidade;
		String nome, autor, editora;
		float preco;

		ProdutoLivro livro1 = new ProdutoLivro(produtos.createId(), 23f, "Sherlock holems", 1, 10, "Arthur");
		produtos.cadastrar(livro1);

		while(true) {

			System.out.println(Cores.TEXT_WHITE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
					+       "\n\n*****************************************************");
			System.out.println("                                                     ");
			System.out.println("               Gerenciamento de Estoque              ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println(Cores.TEXT_CYAN_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
					+"            1 - Cadastrar Produto                    ");
			System.out.println("            2 - Listar todos os produtos             ");
			System.out.println("            3 - Buscar produto por ID                ");
			System.out.println("            4 - Atualizar Dados de um produto        ");
			System.out.println("            5 - Excluir um Produto                   ");
			System.out.println("            6 - Vender Produto                       ");
			System.out.println("            7 - Sair do Sistema                      ");
			System.out.println("                                                     ");
			System.out.println(Cores.TEXT_WHITE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
					+"*****************************************************");
			System.out.println("              Entre com a opção desejada:            ");
			System.out.println("                                                     " 
					+ Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("\nDigite números inteiros");
				leia.nextLine();
				opcao = 0;
			}


			if (opcao == 7) {
				System.out.println("\n***************** você saiu do sistema ********************");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Cadastrar produto\n\n");

				do {
					System.out.println("Digite a categoria (1-Livro ou 2-Revista): ");
					categoria = leia.nextInt();
				} while(categoria < 1 || categoria > 2);

				System.out.println("Digite o nome: ");
				leia.skip("\\R?");
				nome = leia.nextLine();

				System.out.println("Digite o preço (R$): ");
				preco = leia.nextFloat();

				System.out.println("Digite a quantidade do estoque: ");
				estoque = leia.nextInt();

				switch(categoria) {
				case 1 -> {
					System.out.println("Digite o autor do livro: ");
					leia.skip("\\R?");
					autor = leia.nextLine();
					produtos.cadastrar(new ProdutoLivro(produtos.createId(), preco, nome, categoria, estoque, autor));
				} case 2 -> {
					System.out.println("Digite a editora da revista: ");
					leia.skip("\\R?");
					editora = leia.nextLine();
					produtos.cadastrar(new ProdutoRevista(produtos.createId(), preco, nome, categoria, estoque, editora));
				}
				}

				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todos os produtos\n\n");
				produtos.listarProdutos();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Buscar produto por ID\n\n");

				System.out.println("Digite o Id do produto: ");
				id = leia.nextInt();

				produtos.procurarPorId(id);

				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar Dados de um produto\n\n");

				System.out.println("Digite o id da produto: ");
				id = leia.nextInt();

				var buscaConta = produtos.buscarNaCollection(id);

				if(buscaConta != null) {


					categoria = buscaConta.getCategoria();

					System.out.println("Digite o nome atualizado do produto: ");
					leia.skip("\\R?");
					nome = leia.nextLine();

					System.out.println("Digite o preço atualizado do produto: ");
					preco = leia.nextFloat();

					System.out.println("Digite a quantidade do estoque: ");
					estoque = leia.nextInt();

					switch(categoria) {
					case 1 -> {
						System.out.println("Digite o autor do livro): ");
						leia.skip("\\R?");
						autor = leia.nextLine();

						produtos.atualizar(new ProdutoLivro(id, preco, nome, categoria, estoque, autor));

					}
					case 2 -> {
						System.out.println("Digite da editora: ");
						leia.skip("\\R?");
						editora = leia.nextLine();

						produtos.atualizar(new ProdutoRevista(id, preco, nome, categoria, estoque, editora));

					}
					default -> {
						System.out.println("Categoria inválida!");
					}
					}
				} else {
					System.out.println("Produto não encontrado!");
				}

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Excluir um Produto\n\n");

				System.out.println("digite o id do produto que você deseja excluir: ");
				id = leia.nextInt();

				produtos.deletar(id);

				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Vender Produto\n\n");

				System.out.println("digite o id do produto que será vendido: ");
				id = leia.nextInt();

				System.out.println("Qual quantidade você ira vender?");
				quantidade = leia.nextInt();

				produtos.vender(quantidade, id);

				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				break;
			}
		}	
	}

	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione enter para continuar...");
			System.in.read();
		} catch(IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}
