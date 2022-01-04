package com.bestbuy.stores;

import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class StoresAssertionHomework extends StoresExtractionHomework{

    //1. Verify the if the total is equal to 1571
    @Test
    public void test001(){
        response.body("total",equalTo(1571));
    }

    //2. Verify the if the stores of limit is equal to 10
    @Test
    public void test002(){
        response.body("limit",equalTo(10));
    }

    //3. Check the single ‘Name’ in the Array list (Inver Grove Heights)
    @Test
    public void test003(){
        response.body("data.name",hasItem("Inver Grove Heights"));
    }

    //4. Check the multiple ‘Names’ in the ArrayList (Rochester, Burnsville, PostmanGroup)
    @Test
    public void test004(){
        response.body("data.name",hasItems("Rochester","Burnsville","PostmanGroup"));
    }

    //5. Verify service id = 2 of second service inside store with storeId=7
    @Test
    public void test005(){
        response.body("data[2].services[1].id",equalTo(2));
    }

    //6. Check hash map values ‘createdAt’ inside store services map where store name = Rochester
    @Test
    public void test006(){
        response.body("data.findAll{it.name='Rochester'}.services",hasItem(hasItem(hasKey("createdAt"))));
    }

    //7. Verify the state = MN of forth store
    @Test
    public void test007(){
        response.body("data[3]",hasEntry("state","MN"));
    }

    //8. Verify the store name = West Des Moines of 9th store
    @Test
    public void test008(){
        response.body("data[8]",hasEntry("name","West Des Moines"));
    }

    //9. Verify the storeId = 13 for the 6th store
    @Test
    public void test009(){
        response.body("data[5].id",equalTo(13));
    }

    //10. Verify the serviceId = 4 for the 7th store of forth service
    @Test
    public void test010(){
        response.body("data[6].services[3].id",equalTo(4));
    }
}
