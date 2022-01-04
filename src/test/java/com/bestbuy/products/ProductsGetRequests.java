package com.bestbuy.products;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductsGetRequests extends TestBase {

    @Test
    public void getAllProducts() {
        Response response = given()
                .when()
                .get("/products");
        response.then()
                .statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void getAllProductsSortedByPriceHighToLow() {
        Response response = given()
                .queryParams("$sort[price]", -1)
                .when()
                .get("/products");
        response.then()
                .statusCode(200);
        //response.prettyPrint();

    }

    @Test
    public void getAllProductsShowNameAndPrice() {
        Response response = given()
                .queryParams("$select[]", "name")
                .queryParams("$select[]", "price")
                .when()
                .get("/products");
        response.then()
                .statusCode(200);
        //response.prettyPrint();

    }

    @Test
    public void getAllProductsWithTypeHardGood() {
        Response response = given()
                .queryParams("type", "HardGood")
                .when()
                .get("/products");
        response.then()
                .statusCode(200);
        //response.prettyPrint();
    }

    @Test
    public void getAllProductsWithManufacturerNameDuracell() {
        Response response = given()
                .queryParams("manufacturer", "Duracell")
                .when()
                .get("/products");
        response.then()
                .statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getProductsWithIdAsAPathParam() {
        Response response = given()
                .pathParam("id", 346575)
                .when()
                .get("/products/{id}");
        response.then().statusCode(200);
        //response.prettyPrint();
    }
}
