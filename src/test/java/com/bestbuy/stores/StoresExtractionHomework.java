package com.bestbuy.stores;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import static io.restassured.RestAssured.given;

public class StoresExtractionHomework {

    public static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;

        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }

    @Test
    public void test001(){
        //Extract the limit
        int limit = response.extract().path("limit");
        System.out.println("Q1. Extract the limit");
        System.out.println("A1. The limit is " + limit);
        System.out.println("**************************************************************");
    }

    @Test
    public void test002(){
       //Extract the total
        int total = response.extract().path("total");
        System.out.println("Q2. Extract the total");
        System.out.println("A2. The total is " + total);
        System.out.println("**************************************************************");

    }

    @Test
    public void test003(){
        //Extract the name of 5th store
        List<String> name = response.extract().path("data.findAll{it.id == 4}.name");
        System.out.println("Q3. Extract the name of 5th store");
        System.out.println("A3. The name of 5th store is " + name.get(0));
        System.out.println("**************************************************************");
    }

    @Test
    public void test004(){
        //Extract the names of all the store
      List<String> stores = response.extract().path("data.name");
        System.out.println("Q4. Extract the names of all the store");
        System.out.println("A4. The names of all the stores are: " );
      for (String store : stores) {
          System.out.println(store);
      }
        System.out.println("**************************************************************");
    }

    @Test
    public void test005(){
        //Extract the storeId of all the store
        List<Integer> storeIds = response.extract().path("data.id");
        System.out.println("Q5. Extract the storeId of all the stores");
        System.out.println("A5. The storeId of all the stores are: " );
        for (int storeId : storeIds) {
            System.out.println(storeId);
        }
        System.out.println("**************************************************************");
    }

    @Test
    public void test006(){
        //Print the size of the data list
       List<HashMap<String, ?>> data = response.extract().path("data");
        System.out.println("Q6. Print the size of the data list");
        System.out.println("A6. The size of the data list is " + data.size());
        System.out.println("**************************************************************");
    }

    @Test
    public void test007(){
        //Get all the value of the store where store name = St Cloud
        List<HashMap<String, ?>> storeNames = response.extract().path("data.findAll{it.name == 'St Cloud'}");
        System.out.println("Q7. Get all the value of the store where store name = St Cloud");
        System.out.println("A7. The value of the store where store name = St Cloud is: ");
        for(HashMap<String, ?> store:storeNames){
            System.out.println(store);
         }
        System.out.println("**************************************************************");
    }

    @Test
    public void test008(){
        //Get the address of the store where store name = Rochester
        List<String> address = response.extract().path("data.findAll{it.name == 'Rochester'}.address");
        System.out.println("Q8. Print the address of the store where store name = Rochester");
        System.out.println("A8. The address of the store where store name = 'Rochester' is: " + address.get(0));
        System.out.println("**************************************************************");
    }

    @Test
    public void test009(){
        //Get all the services of 8th store
        List<HashMap<String, ?>> services = response.extract().path("data[7].services");
        //List<HashMap<String, ?>> services = response.extract().path("data.findAll{it.id == 8}.services");
        System.out.println("Q9. Get all the services of 8th store");
        System.out.println("A9. The services of 8th store are: " + services);
        System.out.println("**************************************************************");
    }

    @Test
    public void test010(){
        //Get storeservices of the store where service name = Windows Store
        List<HashMap<String, ?>> storeServices = response.extract().path("data.findAll{it.services.findAll{it.name=='Geek Squad Services'}}.services.storeservices");
        System.out.println("Q10. Get storeservices of the store where service name = Geek Squad Services");
        System.out.println("A10. The storeservices of the store where service name = Geek Squad Services are: " + storeServices);
        System.out.println("**************************************************************");
    }

    @Test
    public void test011(){
        //Get all the storeId of all the store
        List<Integer> storeIds = response.extract().path("data.services.storeservices.storeId");
        System.out.println("Q11. Get all the storeId of all the stores");
        System.out.println("A11. The storeId of all the stores are: " + storeIds);
        System.out.println("**************************************************************");
    }

    @Test
    public void test012(){
        //Get id of all the store
        List<Integer> storeIds = response.extract().path("data.id");
        System.out.println("Q11. Get all the storeId of all the stores");
        System.out.println("A11. The storeId of all the stores are: " + storeIds);
        System.out.println("**************************************************************");
    }

    @Test
    public void test013(){
        //Find the store names Where state = ND
        List<String> storeNames = response.extract().path("data.findAll{it.state == 'ND'}.name");
        System.out.println("Q12. Find the store names Where state = ND");
        System.out.println("A12. The store names Where state = ND is: " + storeNames.get(0));
        System.out.println("**************************************************************");
    }


    @Test
    public void test014() {
        //14. Find the Total number of services for the store where store name = Rochester
        List<List<String>> services = response.extract().path("data.findAll{it.name=='Rochester'}.services.name");
        System.out.println("Q14. Find the Total number of services for the store where store name = Rochester");
        System.out.println("A14. The total number of services for the store where store name = Rochester are : " + services.get(0).size());
        System.out.println("**************************************************************");
    }

    @Test
    public void test015() {
        //15. Find the createdAt for all services whose name = “Windows Store”
        List<List<String>> createdAt = response.extract().path("data.findAll{it.services.findAll{it.name=='Windows Store'}}.services.createdAt");
        System.out.println("Q15. Find the createdAt for all services whose name = Windows Store");
        System.out.println("A15. The createdAt for all services whose name = Windows Store : " + createdAt);
        System.out.println("**************************************************************");
    }

    //16. Find the name of all services Where store name = “Inver Grove Heights”
    @Test
    public void test016() {
        //16. Find the name of all services Where store name = “Inver Grove Heights”
        List<String> servicesName = response.extract().path("data.findAll{it.name=='Inver Grove Heights'}.services.name");
        System.out.println("Q16. Find the createdAt for all services whose name = Windows Store");
        System.out.println("A16. The name of all services Where store name = “Inver Grove Heights” are : " + servicesName);
        System.out.println("**************************************************************");
    }

    @Test
    public void test017() {
        //17. Find the zip of all the store
        List<String> zip = response.extract().path("data.zip");
        System.out.println("Q17. Find the zip of all the store");
        System.out.println("A17. The zip of all the stores are : " + zip);
        System.out.println("**************************************************************");
    }

    @Test
    public void test018() {
        //18. Find the zip of store name = Fargo
        List<String> zip = response.extract().path("data.findAll{it.name=='Fargo'}.zip");
        System.out.println("Q18. Find the zip of store name = Fargo");
        System.out.println("A18. The zip of store name = Fargo : " + zip.get(0));
        System.out.println("**************************************************************");
    }

    @Test
    public void test019() {
        //19. Find the storeservices details of the service name = Samsung Experience
        List<String> storeServices = response.extract().path("data.findAll{it.services.findAll{it.name=='Samsung Experience'}}.services.storeservices");
        System.out.println("Q19. Find the storeservices details of the service name = Samsung Experience");
        System.out.println("A19. The storeservices details of the service name = Samsung Experience : " + storeServices);
        System.out.println("**************************************************************");
    }

    @Test
    public void test020() {
        //20. Find the lat of all the stores
        List<HashMap<String,?>> lat = response.extract().path("data.lat");
        System.out.println("Q20. Find the lat of all the stores");
        System.out.println("A20. The latitude of all the stores " + lat);
        System.out.println("**************************************************************");
    }


}
