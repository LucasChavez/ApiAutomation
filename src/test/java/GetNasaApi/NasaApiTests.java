package GetNasaApi;

import BaseTest.BaseTestGet;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NasaApiTests extends BaseTestGet {

    @Test(description = "Realizaremos un Get a la API de la NASA buscando obtener un 200 e imprimiendo los resultados en consola")
    public void testGetImageOfTheDay() {
        // Solicitar la imagen del día
        Response response = RestAssured
                .given()
                .queryParam("api_key", "FcBI3SWizdPns4pd120eQ0agPLcGcSEKUJBF4H0E")
                .when()
                .get("/planetary/apod");

        // Mostrar la respuesta en la consola
        System.out.println("Respuesta de la API:");
        System.out.println(response.body().asPrettyString());

        // Validar el código de estado
        Assert.assertEquals(response.statusCode(), 200, "Código de estado no es 200");

        // Validar campos clave
        Assert.assertNotNull(response.jsonPath().get("date"), "El campo 'date' no está presente");
        Assert.assertNotNull(response.jsonPath().get("url"), "El campo 'url' no está presente");
        Assert.assertNotNull(response.jsonPath().get("title"), "El campo 'title' no está presente");

        // Mostrar mensaje de éxito
        System.out.println("Test ejecutado correctamente.");
    }

}
