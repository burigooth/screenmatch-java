package alura.curso.screenmatch.modelos; // Falando que essa classe pertence a esse pacote

import alura.curso.screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {
    private String diretor;

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) (obterMedia() / 2);
    }

    @Override
    public String toString() {
        return "Filme:" + this.getNome() + " (" + this.getAnoDeLancamento() + ")";
    }
}