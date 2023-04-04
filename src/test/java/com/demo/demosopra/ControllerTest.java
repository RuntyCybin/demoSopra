package com.demo.demosopra;

import org.hamcrest.Matchers;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static com.demo.demosopra.util.Constantes.OPERATION_ENDPOINT;
import static com.demo.demosopra.util.EnumOperaciones.SUMA;

public class ControllerTest extends RestAssuredBase {

    @Test
    public void consultPricesTest200() throws JSONException {

        JSONObject requestJson = new JSONObject();
        requestJson.put("datoA", 1);
        requestJson.put("datoB", 2);
        requestJson.put("operacion", SUMA);

        request
                .body(requestJson.toString())
                .when()
                .post(OPERATION_ENDPOINT)
                .then()
                .statusCode(200)
                .body("resultado", Matchers.equalTo(3));
    }

    @Test
    public void consultPricesTest404() throws JSONException {

        JSONObject requestJson = new JSONObject();
        requestJson.put("datoA", 1);
        requestJson.put("datoB", 2);
        requestJson.put("operacion", SUMA);

        request
                .body(requestJson.toString())
                .when()
                .post("wrongEndpoint")
                .then()
                .statusCode(404);
    }

    @Test
    public void consultPricesTest400() throws JSONException {

        JSONObject requestJson = new JSONObject();
        requestJson.put("datoA", 1);
        requestJson.put("datoB", 2);
        requestJson.put("operacion", "MULTIPLICACION");

        request
                .body(requestJson.toString())
                .when()
                .post(OPERATION_ENDPOINT)
                .then()
                .statusCode(400);
    }

    @Test
    public void consultPricesTest500() throws JSONException {

        JSONObject requestJson = new JSONObject();
        requestJson.put("fallo", 1);
        requestJson.put("datoB", 2);
        requestJson.put("operacion", SUMA);

        request
                .body(requestJson.toString())
                .when()
                .post(OPERATION_ENDPOINT)
                .then()
                .statusCode(500);
    }
}
