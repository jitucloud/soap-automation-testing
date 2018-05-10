package esdc.com.stepDefs;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.xml.XmlPath;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import esdc.com.common.httpStatusHelper;
import esdc.com.common.propertyReader;
import esdc.com.common.restUtil;
import esdc.com.project.test.queryAddress;

import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.testng.AssertJUnit.assertEquals;


public class thomasBayerBankSteps {

    private Response res = null; //Response object
    private queryAddress actualQueryAddressResponse = null; //XmlPath object

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

        System.out.println(propertyReader.GetAllProperty("config\\config.properties").getProperty("database"));

        restUtil.setBaseURI("http://www.thomas-bayer.com"); //Setup Base URI
        restUtil.setBasePath("/axis2/services/BLZService/"); // Setup Base Path
        restUtil.setSoapActionHeader("getBank"); //Setup Soap Action
        restUtil.setContentType(ContentType.XML);
        res = restUtil.getResponseAsPost(request); //Get response
        actualQueryAddressResponse = new queryAddress(restUtil.getXMLPath(res)); //Get XMLPath


//        File expectedResponse = new File("I:\\code\\playground\\cucumber\\comesdcautomation\\src\\test\\resources\\samples\\thomasBank\\bank-response1.xml");
//        XmlPath xmlPath1 = new XmlPath(expectedResponse); //XmlPath object
//        String plz1 = xmlPath1.get("Envelope.Body.getBankResponse.details.plz").toString();
//        System.out.println(plz1);
//        System.out.println(bic);
//        System.out.println(plz);

    }

    @When("^check in the response if all okay$")
    public void check_in_the_response_if_all_okay() {
        httpStatusHelper.checkStatusIs200(res);
    }

    @Then("^Should be able to check details$")
    public void Should_be_able_to_check_details() {
        assertEquals(actualQueryAddressResponse.GetBankDetailsPLZ(),"47003");
        assertEquals(actualQueryAddressResponse.GetBankDetailsBIC(),"DEUTDEDE350");
    }
}
