package produto;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


import produto.util.Cores;

public class Menu {
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);

		int opcao;


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
			System.out.println("            6 - Sair do Sistema                      ");
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


			if (opcao == 6) {
				System.out.println("\n***************** você saiu do sistema ********************");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Cadastrar Produto\n\n");

				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todos os produtos\n\n");

				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Buscar produto por ID\n\n");

				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar Dados de um produto\n\n");

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Excluir um Produto\n\n");

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
