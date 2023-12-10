package clube;

class JogadorProfissional extends Jogador {
	private int tempoContrato;
	
	public JogadorProfissional(String nome, int numeroCamisa, String posicao, int idade, double valor, int tempoContrato) {
        super(nome, numeroCamisa, posicao, idade, valor);
        this.tempoContrato = tempoContrato;
        }

        public int getTempoContrato() {
            return tempoContrato;
        }

        public void setTempoContrato(int tempoContrato) {
            this.tempoContrato = tempoContrato;
        }
    }