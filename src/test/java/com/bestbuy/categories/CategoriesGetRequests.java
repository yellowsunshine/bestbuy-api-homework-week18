package com.bestbuy.categories;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesGetRequests extends TestBase {

    @Test
    public void getAllCategories() {
        Response response = given()
                .when()
                .get("/categories");
        response.then()
                .statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getAllCategoriesWithName() {
        Response response = given()
                .queryParams("name", "Pioneer - 4\" 3-Way Surface-Mount Speakers with IMPP Composite Cones (Pair) - Black")
                .when()
                .get("/categories");
        response.then()
                .statusCode(200);
        response.prettyPrint();
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
