package com.demo.demosopra;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.web.server.LocalServerPort;

import static com.demo.demosopra.util.Constantes.LOCALHOST;

public class RestAssuredBase {
    @LocalServerPort
    protected static int port = 8080;

    protected static RequestSpecification request;

    @BeforeAll
    public static void init() {
        RestAssured.baseURI = LOCALHOST;
        request = RestAssured
                .given()
                .port(port)
                .contentType(ContentType.JSON)
                .relaxedHTTPSValidation();
    }
}
