package com.trial.object.json;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.trial.json.object.Country_POJO;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.StringWriter;

public class JAVA_to_JSON {
    public static void main(String args[])
    {
        try {
            Country_POJO countryPojo = new Country_POJO();
            countryPojo.setStatusCode("OK");
            countryPojo.setCityName("Al Khawr");
            countryPojo.setIpAddress("37.210.57.113");
            countryPojo.setRegionName("Al Khawr wa adh Dhakhirah");
            countryPojo.setCountryName("Qatar");
            countryPojo.setCountryCode("QA");
            countryPojo.setStatusMessage("");
            countryPojo.setLatitude("");

            ObjectMapper objectMapper = new ObjectMapper();
            StringWriter stringWriter = new StringWriter();

            objectMapper.writeValue(stringWriter, countryPojo);
            System.out.println(" Country POJO is: \n"+stringWriter);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
