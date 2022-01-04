package com.bestbuy.categories;

import com.bestbuy.model.CategoriesPojo;
import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.TestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesPatchRequest extends TestBase {

    @Test
    public void updatingACategory(){
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setId("TestUtils.getRandomValue()");
        categoriesPojo.setName(TestUtils.getRandomText());

        Response response = given()
                .contentType(ContentType.JSON)
                .body(categoriesPojo)
                .when()
                .post("/categories");
        response.then().statusCode(201);
        response.prettyPrint();
    }



}
