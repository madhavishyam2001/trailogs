package com.trial.logs.trailogs;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
//import java.util.logging.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
//import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

@RestController
public class HomeResource {
    @RequestMapping(path="/weather/{zipcode}")
    public String weatherApi(@PathVariable("zipcode") String zipcode)
    {
        String responseStr = null;
        //System.out.println("before responsestr = "+responseStr +" zipcode= "+zipcode);
        //String zipcode =@PathVariable("zipcode");

        responseStr= weatherCall(responseStr,zipcode);
        String inputJsonText = responseStr;
       // System.out.println(" after responsestr = "+responseStr);
        Logger logger1 = LoggerFactory.getLogger(HomeResource.class);
        logger1.error("in weatherApi");

        //System.out.println("inputjsontext= \n"+inputJsonText);
       // JSONObject inputJson = new JSONObject(inputJsonText);
        //ParseDynamicJson.getKey(inputJson,"temp");
        return responseStr;
    }
    @RequestMapping("/add/{val1},{val2}")
    public int doAdd(@PathVariable("val1") String val1, @PathVariable("val2") String val2)
    {
        System.out.println("val1="+val1+" -    val2="+val2);
        int val1int = Integer.parseInt(val1);
        int val2int = Integer.parseInt(val2);
        int result = val1int + val2int;

        System.out.println("result= "+result);
        return  result;
    }

    @RequestMapping("/sub/{val1},{val2}")
    public int doSubtraction(@PathVariable("val1") String val1, @PathVariable("val2") String val2)
    {
        System.out.println("val1="+val1+" -    val2="+val2);
        int val1int = Integer.parseInt(val1);
        int val2int = Integer.parseInt(val2);
        int result = val1int - val2int;

        System.out.println("result= "+result);
        return  result;
    }
    @RequestMapping("/alloperations/{val1},{val2}")
    public String doOperations(@PathVariable("val1") String val1, @PathVariable("val2") String val2)
    {
        System.out.println("val1="+val1+" -    val2="+val2);
        int val1int = Integer.parseInt(val1);
        int val2int = Integer.parseInt(val2);
        int mulres=doMultiple(val1,val2);
        String result = "mul";
        System.out.println("result= "+result);
        return  result;
    }
    @RequestMapping("/mul/{val1},{val2}")
    public int doMultiple(@PathVariable("val1") String val1, @PathVariable("val2") String val2)
    {
        System.out.println("val1="+val1+" -    val2="+val2);
        int val1int = Integer.parseInt(val1);
        int val2int = Integer.parseInt(val2);
        int result = val1int * val2int;
        System.out.println("result= "+result);
        return  result;
    }

    @RequestMapping("/")
    public String HomeCall()
    {
        return  "Hi, from Simple RestController";
    }

    @RequestMapping("/notfound")
    public String errorCall()
    {
        return " Not found, Something went wrong! check your path";
    }

    private String weatherCall(String resultstr,String zipcode)
    {
        BufferedReader instr = null;
        String resstr =null;
        try
        {
            String apikey = "APPID=bd48003253b8786ce5aee57d5530fa40";
            //'http://api.openweathermap.org/data/2.5/weather?q='+myCity+'&APPID=bd48003253b8786ce5aee57d5530fa40';
            String url1 = "https://api.openweathermap.org/data/2.5/weather?zip="+zipcode+",us&"+ apikey ;
            System.out.println("url= " + url1);
            URL urlfet = new URL(url1);
             instr = new BufferedReader(
                    new InputStreamReader(urlfet.openStream()));

            resstr = instr.readLine();
        //    System.out.println("In Result String = "+resstr);
            instr.close();
        }
        catch(IOException ioe)
        {
            System.out.println(ioe.toString());

        }

        return resstr;
    }
    private void jsonParser(String jsoninstring, String keytext)
    {
        System.out.println("jsoninstring= " + jsoninstring+ "  -- key= "+keytext);
        //JSONObject json1=
    }

}
