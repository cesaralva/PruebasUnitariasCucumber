package com.examen.t2.cucumber.usuario.stepDef;


import com.examen.t2.cucumber.PostAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class ObtenerPostStepDef {
    @Steps
    PostAPI postAPI;

    @Given("el post sin parametros")
    public void postSinParametros() {
        postAPI.prepareGetPostRequestWithoutParams();
    }

    @When("se envia solicitud de post")
    public void enviarSolicitudPost() {
        postAPI.sendGetPostRequest();
    }

    @And("validar el post de la lista de esquemas json")
    public void validarPostJsonEsquema() {
        SerenityRest.lastResponse().then().body(JsonSchemaValidator.matchesJsonSchema(new File(Constantes.POST_SCHEMA)));
    }

    @Given("el post con Usuario Id {int}")
    public void postConParametro(Integer usuarioId) {
        postAPI.prepareGetPostRequestWithUserId(usuarioId);
    }

    @And("validar el Usuario Id del post cual debe ser {int}")
    public void validarUsuarioIdPost(Integer parameter) {
        SerenityRest.lastResponse().then().body("userId", equalTo(parameter));
    }

    @Given("el post con Titulo {string}")
    public void postConTitulo(String titulo) {
        postAPI.prepareGetPostRequestWithTitle(titulo);
    }

    @And("validar el Titulo del post debe contener {string}")
    public void validarPostTitulo(String titulo) {
        SerenityRest.lastResponse().then().body("title", containsString(titulo));
    }


    @Given("el post con Cuerpo {string}")
    public void postConCuerpo(String cuerpo) {
        //Codificar aqui
    }

    @And("validar el Cuerpo del post debe ser {string}")
    public void validarPostCuerpo(String cuerpo) {
        //Codificar aqui
    }
}
