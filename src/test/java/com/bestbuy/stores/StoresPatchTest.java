package com.bestbuy.stores;

import com.bestbuy.model.StoresPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresPatchTest extends TestBase {

    @Test
    public void updatedAStoreBasedOnIdAsAParameter(){
        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName("Updated Using Patch");

        Response response = given()
                .pathParam("id", 15)
                .contentType(ContentType.JSON)
                .body(storesPojo)
                .when()
                .patch("/stores/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
