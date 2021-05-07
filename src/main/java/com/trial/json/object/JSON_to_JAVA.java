package com.trial.json.object;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSON_to_JAVA {
public static void main(String args[]) {
    try {
        convert_json_to_java();
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
}
public static void convert_json_to_java() throws Exception
{
    String ip = "37.210.57.113";
    String ipn="192.168.1.16";
    String key = "9d64fcfdfacc213c7ddf4ef911dfe97b55e4696be3532bf8302876c09ebad06b";
    String urlstr="http://api.ipinfodb.com/v3/ip-city/?key="+key+"&ip="+ip+"&format=json";
        URL url=new URL(urlstr);
        HttpURLConnection httpurl = (HttpURLConnection)url.openConnection();
        httpurl.setRequestMethod("GET");
        httpurl.setRequestProperty("User-Agent","Mozilla/5.0");
        int responsecode = httpurl.getResponseCode();
        System.out.println("responsecode="+responsecode);
        System.out.println("\n Sending 'GET' request to url= "+urlstr);
    BufferedReader bufred = new BufferedReader(new InputStreamReader(httpurl.getInputStream()));
    String inputline;
    StringBuffer response = new StringBuffer();

    while((inputline=bufred.readLine()) != null)
    {
        response.append(inputline);
    }

    bufred.close();
    System.out.println("response="+response.toString());

    ObjectMapper obj_objectmapper = new ObjectMapper();
    Country_POJO objcountry = new Country_POJO();

    objcountry=obj_objectmapper.readValue(response.toString(),Country_POJO.class);
    System.out.println("statuscode= " +objcountry.getStatusCode());
    System.out.println("regionName= "+objcountry.getRegionName());
}
}
