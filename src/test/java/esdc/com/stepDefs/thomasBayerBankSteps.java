package esdc.com.stepDefs;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.xml.XmlPath;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import esdc.com.common.httpStatusHelper;
import esdc.com.common.restUtil;
import esdc.com.project.test.queryAddress;

import java.io.File;


import static org.testng.AssertJUnit.assertEquals;


public class thomasBayerBankSteps {

    private Response res = null; //Response object
    private queryAddress actualQueryAddressResponse = null; //actual queryAddressModel
    private queryAddress expectedQueryAddressResponse = null;//expected queryAddressModel
    private String configFolderName = "queryAddress";
    @Given("^Make the request to thomasBayer Bank Service$")
    public void Make_the_request_to_thomasBayer_Bank_Service() {

        String request = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:blz=\"http://thomas-bayer.com/blz/\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <blz:getBank>\n" +
                "         <blz:blz>35070030</blz:blz>\n" +
                "      </blz:getBank>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";

         restUtil.setBaseURI("http://www.thomas-bayer.com"); //Setup Base URI
        restUtil.setBasePath("/axis2/services/BLZService/"); // Setup Base Path
        restUtil.setSoapActionHeader("getBank"); //Setup Soap Action
        restUtil.setContentType(ContentType.XML);

        // Actual Response From Server
        res = restUtil.getResponseAsPost(request); //Get response
       // restUtil.printResponseXML(res);
        actualQueryAddressResponse = new queryAddress(restUtil.getXMLPath(res)); //Get XMLPath



       // Expected Response From XML
        File file = new File(getClass().getClassLoader().getResource("samples/thomasBank/bank-response1.xml").getFile());
        expectedQueryAddressResponse = new queryAddress(new XmlPath(file));

    }

    @When("^check in the response if all okay$")
    public void check_in_the_response_if_all_okay() {

        httpStatusHelper.checkStatusIs200(res);
    }

    @Then("^Should be able to check details$")
    public void Should_be_able_to_check_details() {
        assertEquals(actualQueryAddressResponse.getBankDetailsPLZ(),expectedQueryAddressResponse.getBankDetailsPLZ());
        assertEquals(actualQueryAddressResponse.getBankDetailsBIC(),expectedQueryAddressResponse.getBankDetailsBIC());
    }
}
