package PostReqRestApi;
import BaseTest.BaseTestPost;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

/*Aclaracion, se utilizo la API de ReqRes ya que la api de la NASA solo permite utilizar
el metodo GET  y Spotify requiere de credenciales productivas*/
public class ReqResApiTest extends BaseTestPost{

    @Test(description = "Enviamos via el metodo POST nombre y profesion de una persona ")
    public void testCreateUser() {
        // Crear el cuerpo de la solicitud usando org.json.JSONObject
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Matias");
        requestBody.put("job", "QA");

        // Imprimir los valores enviados para verlo en consola
        System.out.println("Valores enviados:");
        System.out.println("Name: " + requestBody.getString("name"));
        System.out.println("Job: " + requestBody.getString("job"));

        // Realizar la solicitud POST
        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString()) // Convertir JSONObject a String
                .when()
                .post("/api/users");//endpoint

        // Imprimir el código de estado de la respuesta
        System.out.println("Response Code: " + response.statusCode());

        // Imprimir el cuerpo de la respuesta
        System.out.println("Response Body:");
        System.out.println(response.body().asPrettyString());

        // Validaciones que la respuesta sea 201 creacion de un nuevo recurso junto a su valores y atributos
        Assert.assertEquals(response.statusCode(), 201, "El código de estado no es 201");
        Assert.assertEquals(response.jsonPath().getString("name"), "Matias", "El nombre no coincide");
        Assert.assertEquals(response.jsonPath().getString("job"), "QA", "El trabajo no coincide");
        Assert.assertNotNull(response.jsonPath().getString("id"), "El campo 'id' no fue generado");
        Assert.assertNotNull(response.jsonPath().getString("createdAt"), "El campo 'createdAt' no está presente");
    }
}
