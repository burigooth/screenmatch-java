import alura.curso.screenmatch.calculos.CalculadoraDeTempo;
import alura.curso.screenmatch.calculos.FiltroRecomendacao;
import alura.curso.screenmatch.modelos.Episodio;
import alura.curso.screenmatch.modelos.Filme; // Importando a classe filme do pacote X
import alura.curso.screenmatch.modelos.Serie;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme(); // Parte da direita estou dizendo que minha variavel meuFilme será guardada na "gaveta" java.curso.screenmatch.modelos.Filme(minha classe), já na da direita estou criando o objeto
        Serie minhaSerie = new Serie();
        meuFilme.setNome("Pânico");
        meuFilme.setAnoDeLancamento(1996);
        meuFilme.setDuracaoEmMinutos(180);
        meuFilme.setIncluidoNoPlano(true);

        meuFilme.exibeFichaTecnica(); // Chamando meu método
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);

        minhaSerie.setNome("Breaking Bad");
        minhaSerie.setTemporadas(5);
        minhaSerie.setEpisodiosPorTemporada(10);
        minhaSerie.setMinutosPorEpisodio(45);
        System.out.println(minhaSerie.getDuracaoEmMinutos());
        System.out.println("Duração completa da série "+minhaSerie.getNome()+" é de "+minhaSerie.getDuracaoEmMinutos()+" minutos");
        System.out.println("Duração completa do filme "+meuFilme.getNome()+" é de "+meuFilme.getDuracaoEmMinutos()+" minutos");
        System.out.println("Total de avaliações: "+meuFilme.getTotalDeAvaliacoes());

        System.out.println(meuFilme.obterMedia());
        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.calculaTempoTotal(meuFilme);
        calculadora.calculaTempoTotal(minhaSerie);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNome("Piloto");
        episodio.setSerie(minhaSerie);
        episodio.setTotalVisualizacoes(500);

        filtro.filtra(episodio);


    }
}