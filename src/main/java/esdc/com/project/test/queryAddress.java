package esdc.com.project.test;

import com.jayway.restassured.path.xml.XmlPath;
import com.jayway.restassured.path.xml.element.Node;

public class queryAddress {

    XmlPath responseXML = null;

    public queryAddress(XmlPath queryAddressReponse){
        responseXML = queryAddressReponse;
    }
    public String checkPlay(int playedNumber) {
        return Integer.toString(playedNumber);
    }

    public String getBankDetailsPLZ(){
            return  responseXML.get("Envelope.Body.getBankResponse.details.plz").toString();
    }

    public String getBankDetailsBIC(){
        return  responseXML.get("Envelope.Body.getBankResponse.details.bic").toString();
    }
    public Boolean checkIfBICNodeIsPresent(){
       // Node dd = responseXML.getNode("Envelope.Body.getBankResponse.details.bic");
       // System.out.println(dd);
        return  responseXML.get("Envelope.Body.getBankResponse.details.bic").toString().equals("DEUTDEDE350");
    }

}

