package com.examen.t2.cucumber;


import com.examen.t2.cucumber.utils.Constantes;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

public class UsuarioAPI {

    public static String GET_USER = Constantes.BASE_URL + "/public/v2/users";

    @Step("Get user")
    public void obtenerUsuarios(String nombre, String email, String genero, String estado) {
        SerenityRest.given()
                .queryParam("name",nombre)
                .queryParam("email", email)
                .queryParam("gender", genero)
                .queryParam("status",estado);
    }
}