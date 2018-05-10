package esdc.com.project.test;

import com.jayway.restassured.path.xml.XmlPath;

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

}

