package BaseTest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTestGet {

    @BeforeClass
    public void setup() {
        // Configuración básica de la URL base de la API
        RestAssured.baseURI = "https://api.nasa.gov";
    }
}
