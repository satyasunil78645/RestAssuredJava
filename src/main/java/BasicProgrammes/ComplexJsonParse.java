package BasicProgrammes;

import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

    public static void main(String args[]) {
        // TODO Auto-generated method stub
        JsonPath js = new JsonPath(payload.courseFee());
        //print the number courses
        int totalprice =0 ;
        int totalCourses = js.getInt("courses.size()");
        System.out.println(totalCourses);

        //print purchase amount
        int totalAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmount);
        //print single title
        String title = js.get("courses[2].title");
        System.out.println(title);
        //print all list title,price,copies
        for (int i = 0; i < totalCourses; i++) {
            String titles = js.get("courses[" + i + "].title");
            int price = js.get("courses[" + i + "].price");
            int copies = js.get("courses[" + i + "].copies");
            System.out.println(" title : "+titles +"\n price : "+price+"\n copies: "+copies);
            if(titles.equals("RPA")){
                System.out.println("RPA sold :"+copies);
                break;
            }
            for(int j = 0; j < totalCourses; j++){
                int price1 = js.get("courses[" + i + "].price");
                int copies1 = js.get("courses[" + i + "].copies");
                int calculate = price1 * copies1;
                totalprice += calculate;
            }
            System.out.println("calculated price: "+totalprice);
        }
    }
}
