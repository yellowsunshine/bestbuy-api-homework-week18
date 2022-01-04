package com.bestbuy.categories;

import com.bestbuy.model.CategoriesPojo;
import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.TestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesPutRequest extends TestBase {

    @Test
    public void updatingACategory(){
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setId("abcat0020002");
        categoriesPojo.setName(TestUtils.getRandomText());

        Response response = given()
                .contentType(ContentType.JSON)
                .body(categoriesPojo)
                .when()
                .patch("/categories");
        response.then().statusCode(200);
        response.prettyPrint();
    }



}
