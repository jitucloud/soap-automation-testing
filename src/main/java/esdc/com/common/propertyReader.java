package esdc.com.common;

import com.jayway.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public  class  propertyReader {

    public static Properties GetAllProperty(String fileName) {

        Properties prop = new Properties();
        InputStream input = null;

        try {
            String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            input = new FileInputStream( rootPath + fileName);
            // load a properties file
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  prop;
    }


}


