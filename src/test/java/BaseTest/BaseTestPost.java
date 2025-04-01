package BaseTest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTestPost {

    @BeforeClass
    public void setup() {
        // Configuración base para la API Reqres.in
        RestAssured.baseURI = "https://reqres.in"; // URL base de la API
    }
}
