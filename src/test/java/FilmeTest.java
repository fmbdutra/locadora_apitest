import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

public class FilmeTest {

    public FilmeTest() {
        baseURI = "http://172.22.6.1:8080/api";
    }
    public String token_gerado;

    @Test
    public void ListaDeFilmesTodos() {
        given()
            .contentType("application/json")
            .header("token","token_gerado")
        .when()
            .get("/filme")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body(notNullValue());
    }

    @Test
    public void ListaDeFilmesDisponiveis() {
        given()
            .contentType("application/json")
            .header("token","token_gerado")
        .when()
            .get("/filme/disponiveis")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body(notNullValue());
    }

    @Test
    public void PesquisaPorNome() {
        String nomeFilme = "avengers";

        given()
        .when()
            .get("/filme/"+nomeFilme)
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("nome", hasItems("The Avengers", "Avengers: Infinity War", "Avengers: Endgame"));
    }









}
