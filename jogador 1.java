package clube;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogador {
    private String nome;
    private int numeroCamisa;
    private String posicao;
    private int idade;
    private double valor;

    public Jogador(String nome, int numeroCamisa, String posicao, int idade, double valor) {
        this.nome = nome;
        this.numeroCamisa = numeroCamisa;
        this.posicao = posicao;
        this.idade = idade;
        this.valor = valor;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroCamisa() {
		return numeroCamisa;
	}

	public void setNumeroCamisa(int numeroCamisa) {
		this.numeroCamisa = numeroCamisa;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
    // Getters e Setters
    
}