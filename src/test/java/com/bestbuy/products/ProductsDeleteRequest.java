package com.bestbuy.products;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductsDeleteRequest extends TestBase {

    @Test
    public void deleteASingleProductBasedOnID(){
        Response response = given()
                .pathParam("id", 346646)
                .when()
                .delete("/products/{id}");

        response.then().statusCode(200);
        response.prettyPrint();

    }
}
