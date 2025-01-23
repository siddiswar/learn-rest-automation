package org.ananya.training.countriesapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllCountriesEndpointTest {


    @Test
    public void allCountriesTest(){
        String baseURI = "https://restcountries.com/v3.1";
        String endPoint = "/all";

        //Create a Request Specification object
        RequestSpecification request = RestAssured.given();

        //Build the request
        request.baseUri(baseURI);

        //Make the request
        Response response = request.get(endPoint);


        int expectedStatusCode = 200;
        int actualStatusCode = response.statusCode();

        //Test Validation
        Assert.assertEquals(actualStatusCode,expectedStatusCode);
    }
}
