package com.bestbuy.stores;

import com.bestbuy.model.StoresPojo;
import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.TestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class StoresCRUDTest extends TestBase {

    static String name = "Name" + TestUtils.getRandomValue();
    static String type = "Type" + TestUtils.getRandomValue();
    static String address = "123 abc street";
    static String address2 = "Efgh Avenue";
    static String city = "Mopkins";
    static String state = "MN";
    static String zip = "12345";
    static double lat = 44.969658;
    static double lng = 93.449539;
    static String hours = "Mon: CLOSED; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8";
    static Integer storeId;

    @Test
    public void test001() {

        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName(name);
        storesPojo.setType(type);
        storesPojo.setAddress(address);
        storesPojo.setAddress2(address2);
        storesPojo.setCity(city);
        storesPojo.setState(state);
        storesPojo.setZip(zip);
        storesPojo.setLat(lat);
        storesPojo.setLng(lng);
        storesPojo.setHours(hours);

        Response response = given()
                .contentType(ContentType.JSON)
                .body(storesPojo)
                .when()
                .post("/stores");
        response.then().statusCode(201);
        response.prettyPrint();
    }

        @Test
        public void test002() {
            String s1 = "data.findAll{it.name ='";
            String s2 = "'}.get(0)";

            HashMap<String, Object> values =
                    given()
                            .when()
                            .get("/stores")
                            .then()
                            .statusCode(200)
                            .extract().path(s1 + name + s2);
            System.out.println(values);
            storeId = (Integer) values.get("id");
        }

    @Test
    public void test003() {
        String p1 = "data.findAll{it.id='";
        String p2 = "'}.get(0)";

        name = name + "_updated";
        type = type + "_updated";
        address = address2 + "_updated";
        address2 = address2 + "_updated";

        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName(name);
        storesPojo.setType(type);
        storesPojo.setAddress(address);
        storesPojo.setAddress2(address2);
        storesPojo.setCity(city);
        storesPojo.setState(state);
        storesPojo.setZip(zip);
        storesPojo.setLat(lat);
        storesPojo.setLng(lng);
        storesPojo.setHours(hours);

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", storeId)
                .body(storesPojo)
                .when()
                .put("/stores/{id}");
        response.then().log().all().statusCode(200);

        HashMap<String, Object> value =
                given()
                        .when()
                        .get()
                        .then()
                        .statusCode(200)
                        .extract()
                        .path(p1 + storeId + p2);

    }
    @Test
    public void test004() {

        Response response = given()
                .pathParam("storeID", storeId)
                .when()
                .delete("stores/{storeID}");
        response.then().statusCode(200);
        response.prettyPrint();

        Response responseA =
                given()
                        .pathParam("storeID", storeId)
                        .when()
                        .get("/stores/{storeID}");
        responseA.then().statusCode(404);
    }
}
