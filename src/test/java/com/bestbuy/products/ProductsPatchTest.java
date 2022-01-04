package com.bestbuy.products;

import com.bestbuy.model.ProductsPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductsPatchTest extends TestBase {

    @Test
    public void postNewProduct(){

        ProductsPojo productsPojo = new ProductsPojo();
        productsPojo.setType("Good");


        Response response = given()
                .contentType(ContentType.JSON)
                .body(productsPojo)
                .when()
                .patch("/products/127687");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
