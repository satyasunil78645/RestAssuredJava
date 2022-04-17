package BasicProgrammes;

import PojoClassFiles.AddPlace;
import PojoClassFiles.Locations;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

class Serialization {
    public static void main(String[] args) {
        AddPlace ap = new AddPlace();
        ap.setAccuracy(50);
        ap.setAddress("29, side layout, cohen 09");
        ap.setLanguage("French-IN");
        ap.setPhone_number("+91 81437611201");
        ap.setWebsite("https://rahulshettyacademy.com");
        ap.setName("Satya Sunil badiganti");
        List<String> li = new ArrayList<String>();
        li.add("shoe park");
        li.add("shop");
        ap.setType(li);
        Locations lo = new Locations();
        lo.setLat(-38.383494);
        lo.setLng(30.2425);
        ap.setLocation(lo);
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        Response response = given().log().all().queryParam("key", "qaclick123")
                .body(ap)
                .when().post("maps/api/place/add/json")
                .then().assertThat().statusCode(200).extract().response();
        String responseString = response.asString();
        System.out.println(responseString);
    }

}
