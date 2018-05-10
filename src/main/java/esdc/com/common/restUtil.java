package esdc.com.common;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.path.xml.XmlPath;
import com.jayway.restassured.response.Response;
import java.io.File;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

public class restUtil {

    //Global Setup Variables
    public static String path; //Rest request path

    public static void setBaseURI (String baseURI){
        RestAssured.baseURI = baseURI;
    }

    public static void setBasePath(String basePathTerm){
        RestAssured.basePath = basePathTerm;
    }

    public static void resetBaseURI (){
        RestAssured.baseURI = null;
    }

    public static void resetBasePath(){
        RestAssured.basePath = null;
    }

    public static void setContentTypeHeaderAsSoapXML (){
        given().header("Content-Type", "application/soap+xml; charset=UTF-8");
    }

    public static void setHeader (String headerName, String headerValue){
        given().header(headerName,headerValue);
    }

    public static void setContentType (ContentType Type){
        given().contentType(Type);
    }

    public static void setSoapActionHeader (String ActionName){
        given().header("SOAPAction",ActionName);
    }

    public static Response getResponseAsGet() {
        return get();
    }

    public static Response getResponseAsPost(String SoapRequest) {
        return given().body(SoapRequest).post();
    }

    public static Response getResponseAsPost(File SoapRequest) {
        return given().body(SoapRequest).post();
    }

    public static JsonPath getJsonPath (Response res) {
        return new JsonPath(res.asString());
    }

    public static XmlPath getXMLPath (Response res) {
        return new XmlPath(res.asString());
    }

    public static  void printResponseXML(Response res){
        System.out.println(res.then().log().all().extract().response());
    }
}
