package org.ananya.training.countriesapi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchByFullNameEndpointTest {

    @Test
    public void fullNameSearch() {
        String baseURI = "https://restcountries.com/v3.1";
        String endPoint = "/name/{fullCountryName}";
        int expectedStatusCode = 200;
        String expectedResponseContentTypeHeader = "application/json";
        String expectedCountryName = "India";

        //Create a Request Specification object
        RequestSpecification request = RestAssured.given();

        //Build the request
        request.baseUri(baseURI);
        request.pathParam("fullCountryName", "India");
        request.queryParam("fullText", true);

        //Make the request
        Response response = request.when().get(endPoint);

        //Test Validations

        //Validate Response code
        int actualStatusCode = response.statusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode);

        //Validate response header
        String actualResponseContentTypeHeader = response.header("Content-Type");
        Assert.assertEquals(actualResponseContentTypeHeader,expectedResponseContentTypeHeader);

        //Validate value in response body
        JsonPath jsonResponse = response.jsonPath();
        String actualCountryName = jsonResponse.get("[0].name.common");
        Assert.assertEquals(actualCountryName,expectedCountryName);
    }

    @Test
    public void fullNameSearch2() {
        String baseURI = "https://restcountries.com/v3.1";
        String endPoint = "/name/{fullCountryName}";
        int expectedStatusCode = 200;
        String expectedResponseContentTypeHeader = "application/json";

        //Create a Request Specification object
        RestAssured.given()
                .baseUri(baseURI)
                .pathParam("fullCountryName", "India")
                .queryParam("fullText", true)
                .when()
                .get(endPoint)
                .then()
                .statusCode(expectedStatusCode)
                .header("Content-Type",expectedResponseContentTypeHeader);
    }
}
