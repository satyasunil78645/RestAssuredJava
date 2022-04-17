package BasicProgrammes;

        import PojoClassFiles.AddPlace;
        import PojoClassFiles.Locations;
        import io.restassured.RestAssured;
        import io.restassured.builder.RequestSpecBuilder;
        import io.restassured.builder.ResponseSpecBuilder;
        import io.restassured.http.ContentType;
        import io.restassured.response.Response;
        import io.restassured.specification.RequestSpecification;
        import io.restassured.specification.ResponseSpecification;

        import java.util.ArrayList;
        import java.util.List;

        import static io.restassured.RestAssured.given;

public class SpecBuilder {
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
        /**
         * Spec creation for reusable code request spec, response spec builders
         */
        RequestSpecification req_spec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
        RequestSpecification req = given().spec(req_spec).body(ap);

        ResponseSpecification res_spec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        Response res = req.when().log().all().post("maps/api/place/add/json").then().spec(res_spec).extract().response();

        System.out.println(res);

    }
}
