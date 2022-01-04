package com.bestbuy.stores;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresDeleteTest extends TestBase {

    @Test
    public void deleteASingleStoreBasedOnID(){
        Response response = given()
                .pathParam("id", 11)
                .when()
                .delete("/stores/{id}");

        response.then().statusCode(200);
        response.prettyPrint();

    }
}
