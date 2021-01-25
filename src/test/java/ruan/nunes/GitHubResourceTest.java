package ruan.nunes;

import io.quarkus.test.junit.QuarkusTest;
import ruan.nunes.domain.File;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@QuarkusTest
public class GitHubResourceTest {

    @Test
    public void testHelloEndpoint() {
        final String body = "{\"files\":[{\"name\":\"test\",\"type\":\"xml\",\"bytes\":12,\"lines\":12}]}";


        
           


        final String url = "https://github.com/RuanNunes/test";
        given()
          .when().get("/githubinfo/{url}", Map.of("url", url))
          .then()
             .statusCode(200)
             
             .body(is(body));
    }

}