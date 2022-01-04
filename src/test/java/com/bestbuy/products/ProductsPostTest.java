package com.bestbuy.products;

import com.bestbuy.model.ProductsPojo;
import com.bestbuy.model.StoresPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductsPostTest extends TestBase {

    @Test
    public void postNewProduct(){

        ProductsPojo productsPojo = new ProductsPojo();
        productsPojo.setName("Abc");
        productsPojo.setType("HardGood");
        productsPojo.setPrice(10);
        productsPojo.setUpc("0456461301343");
        productsPojo.setShipping(5);
        productsPojo.setDescription("Compatible with select electronic devices; C size; DURALOCK Power Preserve technology;");
        productsPojo.setManufacturer("Postman");
        productsPojo.setModel("ABCDEFG");
        productsPojo.setUrl("http://www.bestbuy.com/site/duracell-c-batteries-4-pack/185230.p?id=1051384046486&skuId=185230&cmp=RMXCC");
        productsPojo.setImage("ABCDEFG");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(productsPojo)
                .when()
                .post("/products");
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
