package ruan.nunes;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Scanner;
import static org.hamcrest.Matchers.containsString;
@QuarkusTest
public class GitHubResourceTest {

    @Test
    public void testGitHubEndpoint() {
        String body = "";
        try{
            body = getTextPlainFileAsString("data/test.txt");
            System.out.println(body);
        }catch (Exception e){
            System.out.println("error for import file");
        }
        

        final String url = "https://github.com/RuanNunes/test";
        given().when().get("/githubinfo/{url}", Map.of("url", url))
                .then().assertThat()
                .body(containsString(url)).body(containsString("teste"));
    }
    
    protected String getTextPlainFileAsString(final String path) {
        final InputStream resourceAsStream = this.getClass().getResourceAsStream(String.format("/%s", path));
        String text;
        try (Scanner scanner = new Scanner(resourceAsStream, StandardCharsets.UTF_8.name())) {
            text = scanner.useDelimiter("\\A").next();
        }
        return text;
    }
}