package alura.curso.screenmatch.principal;

import alura.curso.screenmatch.modelos.Filme;
import alura.curso.screenmatch.modelos.Serie;
import alura.curso.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalComLista {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("Pânico", 1996);
        meuFilme.avalia(9);
        Filme filmeDoBruno = new Filme("De volta ao jogo", 2010);
        filmeDoBruno.avalia(4);
        Serie minhaSerie = new Serie("Breaking bad", 2008);
        ArrayList<Titulo> lista = new ArrayList<>(); // Trabalhando com arrays
        lista.add(meuFilme);
        lista.add(filmeDoBruno);
        lista.add(minhaSerie);

        for (Titulo item: lista){  // Para cada item que ta dentro da lita eu vou fazer alguma ação
            System.out.println(item.getNome());
            if (item instanceof Filme filme){ // Aqui estou perguntando se o item for uma instancia de filme, eu vou imprimir as estrelas
                System.out.println("Quantidade de estrelas: "+filme.getClassificacao());
            }
        }
        //lista.forEach(item -> System.out.println(item.getNome())); forEach acima de outra maneira, mais simplificada

        List<String> buscaPorArtista = new LinkedList<>();
        buscaPorArtista.add("Bryan Cranston");
        buscaPorArtista.add("Aron Paul");
        System.out.println(buscaPorArtista);
        Collections.sort(buscaPorArtista); // Usando a sort do collections para ordenar em ordem alfabetica
        System.out.println("Depois da ordenação:");
        System.out.println(buscaPorArtista);
        System.out.println("Lista de titulos ordenados");
        Collections.sort(lista);
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento)); // Comparando utilizando o sort da interface Comparator onde usa o meu ano de lançamento do meu titulo
        System.out.println("Ordenando por ano");
        System.out.println(lista);
    }
}
