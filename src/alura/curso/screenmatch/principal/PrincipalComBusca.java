package alura.curso.screenmatch.principal;

import alura.curso.screenmatch.modelos.Titulo;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite um filme para busca: ");
        var busca = leitor.nextLine();
        String endereco = "https://www.omdbapi.com/?t="+ busca + "&apikey=f23c5cfe";
        HttpClient client = HttpClient.newHttpClient(); // Criado um novo cliente para fazer a requisição
        HttpRequest request = HttpRequest.newBuilder() // Criando a nova requisição
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client // Criando uma resposta baseado no meu cliente
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json); //  Imprimindo a resposta com o response.body

        Gson gson = new Gson();
        Titulo tituloTeste = gson.fromJson(json, Titulo.class);
        System.out.println(tituloTeste);
    }
}
