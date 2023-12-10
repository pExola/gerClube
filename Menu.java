package clube;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Clube clube = new Clube();
        Scanner leia = new Scanner(System.in);
        clube.adicionarJogadoresIniciais();
        
        int opcao, opcao2;
        String Treinador;
        // Criar instâncias de jogadores
        
        
        // pegar o nome do usuário
        System.out.print("Digite seu nome: ");
        Treinador = leia.nextLine();
        
        
     do {
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("                                                     ");
		System.out.println("          Olá, "+Treinador+" bem vindo(a)!           ");     
		System.out.println("                                                     ");
		System.out.println("                  MODO CARREIRA                      ");
		System.out.println("                                                     ");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        try {Thread.sleep(1550);} catch (InterruptedException e) {} //gera 1 segundo e pouco de delay
		System.out.println("                                                     ");
		System.out.println("            1 - Comprar Jogador                      ");
		System.out.println("            2 - Listar jogadores                     ");
		System.out.println("            3 - Atualizar jogador                    ");
		System.out.println("            4 - Vender jogador                       ");
		System.out.println("            5 - Procurar por Número                  ");
		System.out.println("            6 - Acessar Base                         ");
		System.out.println("            7 - Escalar Time                         ");
		System.out.println("            8 - Listar 11 Titulares                  ");
		System.out.println("            9 - Sair                                 ");
		System.out.println("                                                     ");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("Digite a opção desejada:                             ");
		System.out.println("                                                     ");
		
		try {
			opcao = leia.nextInt();
		}catch(InputMismatchException e){
			System.out.println("\nDigite valores inteiros!");
			leia.nextLine();
			opcao=0;
		}
		
		if (opcao == 9) {
			System.out.println("Deslogando... Obrigado por utilizar nossos serviços!");
			leia.close();
			System.exit(0);
		}
		
		switch(opcao) {
		
		case 1:
			System.out.println("Cadastro de Jogador Profissional");
			System.out.println("                                ");

            System.out.print("Nome: ");
            String nome = leia.next();
            leia.nextLine();

            System.out.print("Número da Camisa: ");
            int numeroCamisa = leia.nextInt();
            leia.nextLine();  // Consumir a quebra de linha

            // Verificar se o número da camisa já existe
            if (clube.verificarNumeroCamisaExistente(numeroCamisa)) {
                System.out.println("Número da camisa já existe. Escolha outro número.");
            } else {

            System.out.print("Posição: ");
            String posicao = leia.nextLine();

            System.out.print("Idade: ");
            int idade = leia.nextInt();
            leia.nextLine();  // Consumir a quebra de linha

            System.out.print("Valor: ");
            double valor = leia.nextDouble();
            leia.nextLine();  // Consumir a quebra de linha

            System.out.print("Tempo de Contrato: ");
            int tempoContrato = leia.nextInt();
            leia.nextLine();  // Consumer a quebra de linha

            JogadorProfissional novoJogador = new JogadorProfissional(nome, numeroCamisa, posicao, idade, valor, tempoContrato);
            clube.comprarJogador(novoJogador);

            System.out.println("Jogador cadastrado com sucesso!");
        }
            break;
            
        case 2:
            clube.listarTime();
            break;
            
        case 3:
        	System.out.print("Digite o número da camisa do jogador que deseja atualizar: ");
            int numeroCamisaAtualizar = leia.nextInt();
            leia.nextLine();  // Consumir a quebra de linha após o número

            System.out.print("Novo nome: ");
            String novoNome = leia.next();
            leia.nextLine();

            System.out.print("Nova posição: ");
            String novaPosicao = leia.next();
            leia.nextLine();

            System.out.print("Nova idade: ");
            int novaIdade = leia.nextInt();

            System.out.print("Novo valor: ");
            double novoValor = leia.nextDouble();
            
            System.out.print("Novo número Camisa: ");
            int novoNumeroCamisa = leia.nextInt();
            
            if (clube.verificarNumeroCamisaExistente(novoNumeroCamisa)) {
                System.out.println("Número da camisa já existe. Escolha outro número.");
            } else {
            	System.out.print("Novo tempo de contrato: ");
                int novoTempoContrato = leia.nextInt();
                
            	clube.atualizarJogador(numeroCamisaAtualizar, novoNome, novaPosicao, novaIdade, novoValor, novoNumeroCamisa, novoTempoContrato);
            }
            

            break;
            
        case 4:
        	 	System.out.print("Digite o número da camisa do jogador que deseja vender: ");
        	    int numeroCamisaVender = leia.nextInt();
        	    leia.nextLine();  // Consumir a quebra de linha após o número

        	    clube.venderJogador(numeroCamisaVender);       	  
        	  break;
        	  
        case 5:
        	System.out.print("Digite o número da camisa do jogador: ");
        	int numeroCamisaProcurado = leia.nextInt();
        	leia.nextLine();
        	
        	Jogador jogadorEncontrado = clube.procurarPorNumero(numeroCamisaProcurado);
        	
        	if(jogadorEncontrado != null) {
        		System.out.println("Número: " + jogadorEncontrado.getNumeroCamisa());
        		System.out.println("Nome: " + jogadorEncontrado.getNome());
        		System.out.println("Posição: " + jogadorEncontrado.getPosicao());
        		System.out.println("Idade: " + jogadorEncontrado.getIdade());
        		System.out.println("Valor: " + clube.formatarValor(jogadorEncontrado.getValor())+"R$");
        		if (jogadorEncontrado instanceof JogadorProfissional) 
        		{
        	            System.out.println("Tempo de Contrato: " + ((JogadorProfissional) jogadorEncontrado).getTempoContrato()+" anos");
        	    }
        	} else {
        		System.out.println("Jogador não encontrado.");
        	}
        	break;
        	
        case 6:
        	do {
        	System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    		System.out.println("                                                     ");
    		System.out.println("            1 - Listar jogadores da base             ");
    		System.out.println("            2 - Promover jogador da base             ");
    		System.out.println("            3 - Vender jogador da base               ");
    		System.out.println("            4 - Voltar                               ");
    		System.out.println("                                                     ");
    		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    		
    		try {
    			opcao2 = leia.nextInt();
    		}catch(InputMismatchException e){
    			System.out.println("\nDigite valores inteiros!");
    			leia.nextLine();
    			opcao2=0;
    		}
    		switch(opcao2) {
        	case 1:
        		clube.listarJogadoresDaBase();
        		break;
        	case 2:
        		System.out.print("Número da camisa do jogador que deseja promover: ");
                int numeroCamisaPromover = leia.nextInt();
                clube.promoverJogadorDaBase(numeroCamisaPromover);
                
            	break;
        	case 3:
        		System.out.print("Digite o número da camisa do jogador que deseja vender: ");
        	    int numeroCamisaVenderb = leia.nextInt();
        	    leia.nextLine();  // Consumir a quebra de linha após o número

        	    clube.venderJogadorb(numeroCamisaVenderb);       
            	break;
        	case 4:
            	
            	break;
        	default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        	
        		
    		}
        	} while (opcao2 != 4);
        	break;
        case 7:
        	clube.escalarTime();
        	break;
        case 8:
        	clube.listarTitulares();
        	break;
    //fim do switch case  	
    } 
		//telinha de retornar
        System.out.println("\n 1. Retornar ao menu principal");
        System.out.println("Finalizar programa - (qualquer número)");
        int retorno = leia.nextInt();
        leia.nextLine();  // Consumir a quebra de linha após o número

        if (retorno != 1) {
            System.out.println("\nSaindo do programa. Obrigado!");
            System.exit(0);
            break;
        }

} while (opcao != 0);

        leia.close();
}
}