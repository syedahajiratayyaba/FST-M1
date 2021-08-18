package project_RESTAssuredGITHub;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
public class GITHubRESTAssuredProj {
 
    // Declare request specification
    RequestSpecification requestSpec;
    // Declare response specification
    ResponseSpecification responseSpec;
    String SSHKey;
    String baseURI = "https://api.github.com";
    int userid;

    @BeforeClass
    public void setUp() {
        // Create request specification
        requestSpec = new RequestSpecBuilder().setContentType(ContentType.JSON)
        				.addHeader("Authorization", "token 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")
        				// Set base URL
        				.setBaseUri(baseURI)
        				// Build request specification
        				.build();
  }


    @Test(priority=1)

    public void POST() {
        String reqBody = "{\"title\": \"TestAPIKey\", \"key\": \"ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQDJqu8Vbf7YHVl7kuBwrZoriSVwqRmkF+FmsvnRmMqeeqReOAHVRu9a86lRgSSFZf7zWIOxqjmvN5fFMHiukoOUpxvXxFtK9CK8XLAughWSTwKt5/a2hY2+XE6H+E9rXzFzdXQcc7hgXx7rjVBeldxlhMM0zrRC4vlynZSYvDzsOlwMBo43HO97C/Stg1w723F5mW4aZCq4bzxFMsbx6R/Dq44mHAlbAoVYuQsYbXoadLYYK96dJU47RXO9QMm1NIKVPeNXnAtKZmVcuatsq2mhyAvnFHikv6/wcq3jnyqkOjPDauuKB6pZOj6Dy6RGvwsgDlllujksdaqewyQakdcBuUtFEkkXaRjcL9FSe6i577EtNOtBGyx4MXFfm0jvWUnizavZfaDJ7Bf0GKTLhvuGnjKuW5spRwyTlpf0XbvvZS5O4mhcu8luYQt4BdiJIKzT5ISjWyvQA6dDln6cuhLKs4sSSJuKe3KcicxqrzyQ3+sftNYjlYcJa72bmDp1PeU=\",\"read_only\": \"true\"}";
        Response response = given().spec(requestSpec) // Use requestSpec
                .body(reqBody) // Send request body
                .when().post("/user/keys").then().extract().response(); // Send POST request
        
        String body = response.getBody().asPrettyString();
        System.out.println(body);
        
        userid = response.path("id");
        System.out.println(userid);
        
        //Assertions
        response.then().statusCode(201);

       }

    @Test(priority=2)
    public void GET() {
        Response response = given().spec(requestSpec) // Use requestSpec
        				.when().get("/user/keys").then().extract().response(); // Send GET request

        // Print response
        System.out.println(response.asPrettyString());
        Reporter.log("GET response is: " + response);
      //Assertions
        response.then().statusCode(200);
        
    }

    
    @Test(priority=3)
    public void DELETE() {
        Response response = given().spec(requestSpec) // Use requestSpec
        					.when().delete("/user/keys/{keyId}"); // Send DELETE request

       Reporter.log("DELETE response is: " + response);
        
        //Assertions
        response.then().statusCode(204);
    }

}