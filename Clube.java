package clube;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

class Clube {
    private List<JogadorProfissional> timeProfissional;
    private List<JogadorDeBase> timeDeBase;
    private List<JogadorProfissional> timetitulares;
   
    
    Scanner leia = new Scanner(System.in);
    

    public Clube() {
        this.timeProfissional = new ArrayList<>();
        this.timeDeBase = new ArrayList<>();
        this.timetitulares = new ArrayList<>();
    }

    public void comprarJogador(JogadorProfissional jogador) {
    	//Comprar (cadastrar) jogador no time
        timeProfissional.add(jogador);
    }

    public void listarTime() {
    	// Listar o time profissional
        for (JogadorProfissional jogador : timeProfissional) {
            System.out.println(jogador.getNome() + " Nº " + jogador.getNumeroCamisa() + ", " + jogador.getPosicao() + ", " + jogador.getIdade()+" anos");
        }
    }

    public void atualizarJogador(int numeroCamisa, String novoNome, String novaPosicao, int novaIdade, double novoValor, int novoNumeroCamisa, int novoTempoContrato) {
        // Altera o jogador já existente
        for (Jogador jogador : timeProfissional) {
            if (jogador.getNumeroCamisa() == numeroCamisa && jogador instanceof JogadorProfissional) {
                JogadorProfissional jogadorProfissional = (JogadorProfissional) jogador;
                
                jogadorProfissional.setNome(novoNome);
                jogadorProfissional.setPosicao(novaPosicao);
                jogadorProfissional.setIdade(novaIdade);
                jogadorProfissional.setValor(novoValor);
                jogadorProfissional.setNumeroCamisa(novoNumeroCamisa);
                jogadorProfissional.setTempoContrato(novoTempoContrato);
                
                System.out.println("Jogador atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Jogador não encontrado ou não é um jogador profissional.");
    }

    public void venderJogador(int numeroCamisa) {
       Jogador jogadorVendido = null;
       for (Jogador jogador : timeProfissional) {
           if (jogador.getNumeroCamisa() == numeroCamisa) {
               jogadorVendido = jogador;
               timeProfissional.remove(jogador);
               break;
           }
       }

       if (jogadorVendido != null) {
    	   System.out.println("                            ");
           System.out.println("Jogador vendido com sucesso!");
           System.out.println(formatarValor(jogadorVendido.getValor())+ "R$ foi adicionado ao clube.");
       } else {
           System.out.println("Jogador não encontrado.");
       }
   }

    public JogadorProfissional procurarPorNumero(int numeroCamisa) {
        // Procura jogador pelo número da camiseta atribuido
    	for (JogadorProfissional jogador : timeProfissional) {
            if (jogador.getNumeroCamisa() == numeroCamisa) {
            	return jogador;
            }
    	}
    	return null;
    	}
    
    public void escalarTime() {
        Scanner leia = new Scanner(System.in);

        System.out.println("TIME TITULAR");
        System.out.println("            ");

        for (int i = 1; i <= 11; i++) {
        	 System.out.print("Digite o número da camisa do " + i + "º jogador: ");
            int numeroCamisa = leia.nextInt();

            JogadorProfissional jogador = encontrarJogadorProfissional(numeroCamisa);

            if (jogador != null) {
                timetitulares.add(jogador);
                System.out.println(jogador.getPosicao()+" "+jogador.getNome()+" adicionado ao time titular.");
                System.out.println("            ");
            } else {
                System.out.println("Número da camisa inválido ou jogador já escolhido. Tente novamente.");
                i--; // Repetir a iteração para escolher novamente
            }
        }

    }

    // Método encontrar um jogador profissional pelo número da camisa
    private JogadorProfissional encontrarJogadorProfissional(int numeroCamisa) {
        for (Jogador jogador : timeProfissional) {
            if (jogador instanceof JogadorProfissional && jogador.getNumeroCamisa() == numeroCamisa) {
                return (JogadorProfissional) jogador;
            }
        }
        return null;
    }
    

    public void listarTitulares() {
        System.out.println("Jogadores Titulares:");
        System.out.println(" ");

        // Ordenar a lista de titulares com base na posição
        Collections.sort(timetitulares, Comparator.comparing(JogadorProfissional::getPosicao));

        for (JogadorProfissional jogador : timetitulares) {
            System.out.println(jogador.getPosicao() +" "+ jogador.getNome() +" nº"+ jogador.getNumeroCamisa());
        }
    }
    
    
    public boolean verificarNumeroCamisaExistente(int numeroCamisa) {
        for (Jogador jogador : timeProfissional) {
            if (jogador.getNumeroCamisa() == numeroCamisa) {
                return true; // Número de camisa já existe
            }
        }
        return false; // Número de camisa não existe
    }
    
    
    public void listarJogadoresDaBase() {

        for (Jogador jogador : timeDeBase) {
            System.out.println("Nome: " + jogador.getNome());
            System.out.println("Número da Camisa: " + jogador.getNumeroCamisa());
            System.out.println("Posição: " + jogador.getPosicao());
            System.out.println("Idade: " + jogador.getIdade());           
            if (jogador instanceof JogadorDeBase) {
                JogadorDeBase jogadorBase = (JogadorDeBase) jogador;
                System.out.println("Potencial: " + jogadorBase.getPotencial()+"%");
            }
            System.out.println("Valor: " + formatarValor(jogador.getValor())+"R$");
            System.out.println("------------------------");
        }
    }
    
    public void promoverJogadorDaBase(int numeroCamisa) {
        for (JogadorDeBase jogador : timeDeBase) {
            if (jogador.getNumeroCamisa() == numeroCamisa) {
                // Remover da lista da base
                timeDeBase.remove(jogador);

                // Solicitar o novo tempo de contrato
                System.out.print("Novo tempo de contrato como profissional: ");
                int novoTempoContrato = leia.nextInt();

                // Criar um novo jogador profissional com base no jogador da base
                JogadorProfissional jogadorProfissional = new JogadorProfissional(
                        jogador.getNome(), jogador.getNumeroCamisa(),
                        jogador.getPosicao(), jogador.getIdade(),
                        jogador.getValor(), novoTempoContrato);

                // Adicionar à lista profissional
                timeProfissional.add(jogadorProfissional);

                System.out.println("Jogador promovido com sucesso!");
                return;
            }
        }
        System.out.println("Jogador não encontrado na base.");
    }
    
    public void venderJogadorb(int numeroCamisa) {
        Jogador jogadorVendido = null;
        for (Jogador jogador : timeDeBase) {
            if (jogador.getNumeroCamisa() == numeroCamisa) {
                jogadorVendido = jogador;
                timeDeBase.remove(jogador);
                break;
            }    
        }
        if (jogadorVendido != null) {
        	System.out.println("                            ");
            System.out.println("Jogador vendido com sucesso!");
            System.out.println(formatarValor(jogadorVendido.getValor())+ "R$ foi adicionado ao clube.");
        } else {
            System.out.println("Jogador não encontrado.");
        }
    }
    
    
    public void adicionarJogadorProfissional(String nome, int numeroCamisa, String posicao, int idade, double valor, int tempoContrato) {
        JogadorProfissional novoJogador = new JogadorProfissional(nome, numeroCamisa, posicao, idade, valor, tempoContrato);
        timeProfissional.add(novoJogador);
    }
    

    public void adicionarJogadorDaBase(String nome, int numeroCamisa, String posicao, int idade, double valor, int potencial) {
        JogadorDeBase novoJogador = new JogadorDeBase(nome, numeroCamisa, posicao, idade, valor, potencial);
        timeDeBase.add(novoJogador);
    }
    

    public void adicionarJogadoresIniciais() {
        // Adicionando listinha de jogadores profissionais iniciais
    	adicionarJogadorProfissional("Calleri", 9, "Atacante", 30, 5000000, 3);
    	adicionarJogadorProfissional("Rony Rústico", 10, "Atacante", 28, 4000000, 2);
    	adicionarJogadorProfissional("Luciano", 20, "Atacante", 30, 1000000, 4);
    	adicionarJogadorProfissional("Kauan", 99, "Goleiro", 19, 800000, 5);
    	adicionarJogadorProfissional("Weverton", 21, "Goleiro", 35, 800000, 1);
    	adicionarJogadorProfissional("Veiga", 23, "Meio-campista", 28, 11000000, 2);
    	adicionarJogadorProfissional("Scarpa", 11, "Meio-campista", 29, 9500000, 3);
    	adicionarJogadorProfissional("James Rodriguez", 19, "Meio-campista", 32, 13000000, 1);
    	adicionarJogadorProfissional("Beraldo", 35, "Zagueiro", 26, 850000, 3);
    	adicionarJogadorProfissional("Gómez", 15, "Zagueiro", 30, 3050000, 3);
    	adicionarJogadorProfissional("Rafinha", 13, "Lateral", 38, 420000, 2);
    	adicionarJogadorProfissional("Marcelo", 12, "Lateral", 35, 900000, 2);

    	// Adicionando listinha de jogadores de base iniciais
        adicionarJogadorDaBase("Endrick", 91, "Atacante", 17, 10000000, 98);
        adicionarJogadorDaBase("Makita", 69, "Atacante", 18, 400000, 75);
        adicionarJogadorDaBase("André", 36, "Meio-campista", 16, 500000, 80);
        adicionarJogadorDaBase("Paulo", 45, "Meio-campista", 15, 200000, 60);
        adicionarJogadorDaBase("Mariano", 88, "Goleiro", 17, 3000000, 85);
       
    }
    
    
    public String formatarValor(double valor) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(valor);
    }
}