package alura.curso.screenmatch.modelos;

import alura.curso.screenmatch.excecao.AnoInvalidoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb tituloTeste) {
        this.nome = tituloTeste.title();

        if (tituloTeste.year().length() > 4){ // Criando nossa propria exceção
            throw new AnoInvalidoException("Ano com mais valores do que deveria.");
        }
        this.anoDeLancamento = Integer.valueOf(tituloTeste.year());
        this.duracaoEmMinutos = Integer.valueOf(tituloTeste.runtime().substring(0, 3));
    }

    // Criando método
    public void exibeFichaTecnica() {
        System.out.println("Nome do filme: " +nome);
        System.out.println("Ano de lançamento: " +anoDeLancamento);
        System.out.println("Duração em minutos: " +duracaoEmMinutos);
        System.out.println("Incluído no plano: " +incluidoNoPlano);
    }

    public void avalia(double nota) {
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double obterMedia(){
        return somaDasAvaliacoes/totalDeAvaliacoes;
    }

    // Getters e Setters
    public int getTotalDeAvaliacoes(){
        return totalDeAvaliacoes;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome; // This quer dizer que estou acessando o atributo da minha classe
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    @Override
    public int compareTo(Titulo outroTitulo) { // Aqui estamos fazer um override no método compareTo da interface Comparable, onde vou receber um titulo e comparar com a variavel outroTitulo
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "nome=" + nome + '\'' +
                ", anoDeLancamento=" + anoDeLancamento + "," +
                " duração"+ duracaoEmMinutos;
    }
}
