package cucumber.usuario.stepDef;

import cucumber.PostAPI;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.rest.SerenityRest;

public class GeneralStepDef {

    @Steps
    PostAPI postAPI;

    @Then("debería devolver el codigo {int}")
    public void deberiaRetornarCodigo(int statusCode) {
        SerenityRest.then().assertThat().statusCode(statusCode);
    }
}
