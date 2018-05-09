package com.esdc.automation.StepDefinations;
import com.esdc.automation.RestUtil;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.xml.XmlPath;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.File;

import static com.jayway.restassured.RestAssured.given;

public class thomasBayerBankSteps {

    private Response res = null; //Response object
    private XmlPath xmlPath = null; //XmlPath object

    @Given("^Make the request to thomasBayer Bank Service$")
    public void Make_the_request_to_thomasBayer_Bank_Service() {

        String request1 = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:blz=\"http://thomas-bayer.com/blz/\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <blz:getBank>\n" +
                "         <blz:blz>35070030</blz:blz>\n" +
                "      </blz:getBank>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";


       // File file = new File(getClass().getResource("/samples/bank-request1.xml").getFile());
        File request = new File("I:\\code\\playground\\cucumber\\comesdcautomation\\src\\test\\resources\\samples\\bank-request1.xml");



        RestUtil.setBaseURI("http://www.thomas-bayer.com"); //Setup Base URI
        RestUtil.setBasePath("/axis2/services/BLZService/"); // Setup Base Path
        RestUtil.setSoapActionHeader("getBank"); //Setup Soap Action
        RestUtil.setContentType(ContentType.XML);

        res = RestUtil.getResponseAsPost(request); //Get response
        xmlPath = RestUtil.getXMLPath(res); //Get XMLPath
        String plz = xmlPath.get("Envelope.Body.getBankResponse.details.plz").toString();
        String bic= xmlPath.get("Envelope.Body.getBankResponse.details.bic").toString();


        File expectedResponse = new File("I:\\code\\playground\\cucumber\\comesdcautomation\\src\\test\\resources\\samples\\bank-response1.xml");
        XmlPath xmlPath1 = new XmlPath(expectedResponse); //XmlPath object
        String plz1 = xmlPath1.get("Envelope.Body.getBankResponse.details.plz").toString();
        System.out.println(plz1);
        System.out.println(bic);
        System.out.println(plz);

    }

    @When("^check in the response if all okay$")
    public void check_in_the_response_if_all_okay() {

    }

    @Then("^Should be able to check details$")
    public void Should_be_able_to_check_details() {

    }
}