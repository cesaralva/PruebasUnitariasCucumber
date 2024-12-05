package cucumber.usuario.stepDef;

import cucumber.PostAPI;
import cucumber.utils.Constantes;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.rest.SerenityRest;

import java.io.File;

import static org.hamcrest.Matchers.*;


public class ObtenerPostStepDef {
    @Steps
    PostAPI postAPI;

    @Given("el post sin parametros")
    public void postSinParametros()
    {
        SerenityRest.given();
    }

    @When("se envia solicitud de post")
    public void enviarSolicitudPost() {
        SerenityRest.when().get(PostAPI.GET_POST);
    }

    @And("validar el post de la lista de esquemas json")
    public void validarPostJsonEsquema() {
        File jsonSchema = new File(Constantes.JSON_SCHEMA + "/ResponsePostSchemaValid.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("el post con Usuario Id {int}")
    public void postConParametro(Integer usuarioId) {
        postAPI.obtenerPosts(usuarioId, "", "");
    }

    @And("validar el Usuario Id del post cual debe ser {int}")
    public void validarUsuarioIdPost(Integer parameter) {
        SerenityRest.then()
                .assertThat()
                .body("user_id", everyItem(equalTo(parameter)));
    }

    @Given("el post con Titulo {string}")
    public void postConTitulo(String titulo) {
        postAPI.obtenerPosts( null, titulo, "");
    }

    @And("validar el Titulo del post debe contener {string}")
    public void validarPostTitulo(String titulo) {
        SerenityRest.then()
                .assertThat()
                .body("title", everyItem(containsStringIgnoringCase(titulo)));
    }

    @Given("el post con Cuerpo {string}")
    public void postConCuerpo(String cuerpo) {
        postAPI.obtenerPosts( null, "", cuerpo);
    }

    @And("validar el Cuerpo del post debe ser {string}")
    public void validarPostCuerpo(String cuerpo) {
        SerenityRest.then()
                .assertThat()
                .body("body", everyItem(containsStringIgnoringCase(cuerpo)));
    }

}
