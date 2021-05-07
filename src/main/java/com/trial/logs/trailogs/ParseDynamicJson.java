package com.trial.logs.trailogs;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class ParseDynamicJson {

    public static void getKey(JSONObject json, String key)
    {
        boolean exists = json.has(key);
        Iterator<?> keys;
        String nextKeys;

       // System.out.println(" In getKey method --> key= "+key+" : exists= "+exists+" : jsonobject="+json.toString());
        if (!exists) {
            keys = json.keys();
            while(keys.hasNext()) {
                nextKeys = (String) keys.next();
                try{
                    if(json.get(nextKeys) instanceof JSONObject){
                        if(exists == false) {
                            getKey(json.getJSONObject(nextKeys),key);
                        }
                    } else if(json.get(nextKeys) instanceof JSONArray){
                        JSONArray jsonarray = json.getJSONArray(nextKeys);
                        for (int i=0; i < jsonarray.length(); i++) {
                            String jsonarraystring = jsonarray.get(i).toString();
                            JSONObject innerJson= new JSONObject(jsonarraystring);

                            if (exists == false)
                            {
                                getKey(innerJson,key);
                            }
                        }
                    }
                }
                catch(Exception exp)
                {
                    System.out.println(exp);
                }
            }
        }else{
            parseJson(json,key);
        }
    }
    public static void parseJson(JSONObject json, String key)
    {
        System.out.println("exists="+json.has(key));
        System.out.println("key=" +key+ " : value= " + json.get(key));
    }
    public static void main(String args[])
    {
        /*
        String inputJsonText = "{\n" +
                " \"claim_loss_type_cd\": \"TEL\",\n" +
                " \"claim_type\": \"001\",\n" +
                " \"claim_reason\": \"002\",\n" +
                " \"policy_number\": \"123kk45fff678\",\n" +
                " \"info\": {\n" +
                "   \"ApplicationContext\": { \n" +
                "       \"country\": \"US\"\n" +
                "       } \n" +
                "   } \n" +
                " }" ;
        */
        try {
            //System.out.println(" reader File content \n");
            String filePath = "C:/Users/madha/trailogs/trailogs/target/classes/testjson1.json";
            String content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
           // System.out.println("This File content \n"+content);
            JSONObject inputJson = new JSONObject(content);
            String inputJsonText = inputJson.toString();
           // System.out.println("Before - inputjsontext= \n" + inputJsonText);
            getKey(inputJson, "country");
           // System.out.println("After - inputjsontext= \n" + inputJsonText);
        }
        catch(IOException ex){
            ex.printStackTrace();
        }

    }

}
