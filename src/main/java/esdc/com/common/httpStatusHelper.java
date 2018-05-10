package esdc.com.common;

import com.jayway.restassured.response.Response;
import static junit.framework.Assert.assertEquals;

public class httpStatusHelper {
    public static void checkStatusIs200 (Response res) {
        assertEquals("Status Check Failed!", 200, res.getStatusCode());
    }
}
