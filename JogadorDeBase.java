package clube;

class JogadorDeBase extends Jogador {
    private int potencial;

    public JogadorDeBase(String nome, int numeroCamisa, String posicao, int idade, double valor, int potencial) {
        super(nome, numeroCamisa, posicao, idade, valor);
        this.potencial = potencial;
    }

    public int getPotencial() {
        return potencial;
    }

    public void setPotencial(int potencial) {
        this.potencial = potencial;
    }
}