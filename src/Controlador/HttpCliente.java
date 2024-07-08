package Controlador;

import Modelo.Intermediaria;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;


public class HttpCliente {
    String tipoMoneda;

    public Intermediaria consulta(int monedaEleccion) throws IOException, InterruptedException{
        String monedaConsulta = generadorMoneda(monedaEleccion);

        Gson gson = new GsonBuilder().create();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/acefbbd8f21ac4a659a151fe/latest/"+ monedaConsulta ))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Intermediaria monedaCambio = gson.fromJson(response.body(),Intermediaria.class);
            return (monedaCambio);
        }catch (Exception e){
            throw new RuntimeException("Moneda no encontrada");
        }



    }
    public String generadorMoneda(int numMoneda){

        switch (numMoneda) {
            case 1:
                tipoMoneda = "ARS";
                break;
            case 2:
                tipoMoneda = "BOB";
                break;
            case 3:
                tipoMoneda = "BRL";
                break;
            case 4:
                tipoMoneda = "CLP";
                break;
            case 5:
                tipoMoneda = "COP";
                break;
            case 6:
                tipoMoneda = "USD";
                break;

        }

            return (tipoMoneda);
    }
}
