package com.bestbuy.categories;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesDeleteRequest {

    @Test
    public void deleteACategory(){
        Response response = given()
                .pathParam("id", "abcat0100000")
                .when()
                .delete("/categories/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
