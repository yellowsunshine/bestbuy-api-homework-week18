package com.bestbuy.stores;

import com.bestbuy.model.StoresPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StoresPostTest extends TestBase {

    @Test
    public void postNewStore(){

        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName("Abc");
        storesPojo.setType("xyz");
        storesPojo.setAddress("123 abc street");
        storesPojo.setAddress2("Efgh Avenue");
        storesPojo.setCity("Mopkins");
        storesPojo.setState("MN");
        storesPojo.setZip("12345");
        storesPojo.setLat(44.969658);
        storesPojo.setLng(93.449539);
        storesPojo.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(storesPojo)
                .when()
                .post("/stores");
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
