package com.esdc.automation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.RestAssuredConfig;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.path.xml.XmlPath;
import com.jayway.restassured.path.xml.config.XmlPathConfig;
import com.jayway.restassured.response.Response;

import java.io.File;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.post;
import static com.jayway.restassured.config.RestAssuredConfig.newConfig;
import static com.jayway.restassured.config.XmlConfig.xmlConfig;


public class RestUtil {

    //Global Setup Variables
    public static String path; //Rest request path

    public static void setBaseURI (String baseURI){
        RestAssured.baseURI = baseURI;
     //   RestAssured.config().newConfig().xmlConfig(xmlConfig().with().namespaceAware(true).declareNamespace("blz", "http://thomas-bayer.com/blz/"));
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

    public static Response getResponse() {
        return get();
    }

    public static Response getResponseAsPost(String SoapRequest) {
        return given().body(SoapRequest).log().all().post();
    }

    public static Response getResponseAsPost(File SoapRequest) {
        System.out.println("test" + SoapRequest);
        return given().body(SoapRequest).log().all().post();
    }

    public static JsonPath getJsonPath (Response res) {
        String response = res.asString();
        return new JsonPath(response);
    }

    public static XmlPath getXMLPath (Response res) {
        String response = res.asString();
        return new XmlPath(response);
    }

    public static  void printResponseXML(Response res){
        System.out.println(res.then().log().all().extract().response());
    }

}
