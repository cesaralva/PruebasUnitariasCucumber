package cucumber;

import cucumber.utils.Constantes;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

public class PostAPI {

    public static String GET_POST = Constantes.BASE_URL + "/public/v2/posts";

    @Step("Get user")
    public void obtenerPosts(Integer idUsuario, String titulo, String cuerpo) {
        SerenityRest.given()
                .queryParam("user_id", idUsuario)
                .queryParam("title", titulo)
                .queryParam("body", cuerpo);
    }
}
