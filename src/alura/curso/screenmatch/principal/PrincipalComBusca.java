package alura.curso.screenmatch.principal;

import alura.curso.screenmatch.excecao.AnoInvalidoException;
import alura.curso.screenmatch.modelos.Titulo;
import alura.curso.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
        String endereco = "https://www.omdbapi.com/?t="+ busca.replace(" ", "+") + "&apikey=f23c5cfe";

        try{
            HttpClient client = HttpClient.newHttpClient(); // Criado um novo cliente para fazer a requisição
            HttpRequest request = HttpRequest.newBuilder() // Criando a nova requisição
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client // Criando uma resposta baseado no meu cliente
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json); //  Imprimindo a resposta com o response.body

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();
            TituloOmdb tituloTeste = gson.fromJson(json, TituloOmdb.class);

            Titulo meuTitulo = new Titulo(tituloTeste);
            System.out.println(meuTitulo);
        } catch (NumberFormatException e){
            System.out.println("Aconteceu um erro: ");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e){
            System.out.println("Algum erro de argumento na busca.");
            System.out.println(e.getMessage());
        } catch (AnoInvalidoException e){
            System.out.println(e.getMessage());
        }
    }
}

