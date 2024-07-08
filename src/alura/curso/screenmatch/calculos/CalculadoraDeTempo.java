package alura.curso.screenmatch.calculos;

import alura.curso.screenmatch.modelos.Filme;
import alura.curso.screenmatch.modelos.Serie;
import alura.curso.screenmatch.modelos.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }

//    public void calculaTempoTotal(Filme filme){
//        tempoTotal += filme.getDuracaoEmMinutos();
//    }
//
//    public void calculaTempoTotal(Serie serie){
//        tempoTotal += serie.getDuracaoEmMinutos();
//    }

    public void calculaTempoTotal(Titulo titulo){
        tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
