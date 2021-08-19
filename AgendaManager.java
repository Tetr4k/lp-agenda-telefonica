import java.util.Scanner;

public class AgendaManager {
	static void limpaTela(){
		for(int x=0; x<25; x++) System.out.println();
	}

	static void imprimeMenu(){
		System.out.print("=====MENU=====\n"+
						 "1 - Buscar;\n"+
						 "2 - Inserir;\n"+
						 "3 - Atualizar;\n"+
						 "4 - Remover;\n"+
						 "5 - Salvar;\n"+
						 "6 - Recuperar;\n"+
						 "7 - Sair\n"+
						 "==============\n");
	}

    public static void main(String[] args)
    {
		Scanner leitorInt = new Scanner(System.in);
		Scanner leitorString = new Scanner(System.in);
		Contato contato;
		String nome, endereco, relacao, nomeArquivo;
		int numero;
		Agenda agenda = new Agenda();
		int opcao;
		do{
			System.out.println(agenda);
			imprimeMenu();
			opcao = leitorInt.nextInt();
			switch(opcao)
			{
				case 1:
					System.out.println("Qual o nome do contato?");
					nome = leitorString.nextLine();
					contato = agenda.buscar(nome);
					if(contato != null)
						System.out.println(contato);
					else
						System.out.println("Contato não encontrado");
					break;
				case 2:
					System.out.println("Qual o nome do contato?");
					nome = leitorString.nextLine();
					System.out.println("Qual o numero do contato?");
					numero = leitorInt.nextInt();
					System.out.println("Qual o endereco do contato?");
					endereco = leitorString.nextLine();
					System.out.println("Qual a relação do contato?");
					relacao = leitorString.nextLine();
					if(agenda.inserir(nome, numero, endereco, relacao))
						System.out.println("Inserido com Sucesso");
					else
						System.out.println("Alterado com Sucesso");
					break;
				case 3:
					System.out.println("Qual o nome do contato?");
					nome = leitorString.nextLine();
					System.out.println("Qual o numero do contato?");
					numero = leitorInt.nextInt();
					System.out.println("Qual o endereco do contato?");
					endereco = leitorString.nextLine();
					System.out.println("Qual a relação do contato?");
					relacao = leitorString.nextLine();
					if(agenda.alterar(nome, numero, endereco, relacao))
						System.out.println("Alterado com Sucesso");
					else
						System.out.println("Contato inexistente");
					break;
				case 4:
					System.out.println("Qual o nome do contato?");
					nome = leitorString.nextLine();
					if(agenda.remover(nome))
						System.out.println("Contato removido com sucesso");
					else
						System.out.println("Contato não esta na agenda");
					break;
				case 5:
					System.out.println("Qual o nome do arquivo?");
					nomeArquivo = leitorString.nextLine();
					if(agenda.salvar(nomeArquivo))
						System.out.println("Salvo com sucesso");
					else
						System.out.println("Erro ao salvar");
					break;
				case 6:
					System.out.println("Qual o nome do arquivo?");
					nomeArquivo = leitorString.nextLine();
					if(agenda.recuperar(nomeArquivo))
						System.out.println("Recuperado com sucesso");
					else
						System.out.println("Erro ao salvar");
					break;
			}
		}while(opcao != 7);
		leitorInt.close();
		leitorString.close();
    }
}
