package com.iexceed.appzillon.utils;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class XMLToJsonConverter {

    public static String XMLToJson(String xmlInput) {

        String jsonPrettyPrintString = null;
        JSONObject xmlJSONObj;
        try {
            xmlJSONObj = XML.toJSONObject(xmlInput);
            jsonPrettyPrintString = xmlJSONObj.toString();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

       // System.out.println(jsonPrettyPrintString);

        return jsonPrettyPrintString;

    }
}
