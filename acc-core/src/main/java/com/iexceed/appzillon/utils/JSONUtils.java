package com.iexceed.appzillon.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils {

    public static String extractJsonString(String inputJson, String nodeName) {

        String outputString = null;

        try {
            JSONObject jo = new JSONObject(inputJson).getJSONObject(nodeName);
            outputString = jo.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return outputString;
    }

    public static String getJsonValueFromKey(String inputJson, String key) {

        String outputString = null;

        try {
            outputString = new JSONObject(inputJson).getString(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return outputString;

    }

    public static Map<String, String> getJsonHashMap(String inputJson) {
        Map<String, String> outmap = new HashMap<String, String>();
        try {
            JSONObject jsonobj = new JSONObject(inputJson);
            Iterator jsonnames = jsonobj.keys();
            while (jsonnames.hasNext()) {
                String name = (String) jsonnames.next();
                String value =  jsonobj.get(name).toString();
                if (value == null) {
                    value = "";
                }
                outmap.put(name, value);
            }
        } catch (JSONException jsonex) {
            jsonex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return outmap;
    }

    public static String getJsonStringFromMap(Map<String, String> inputMap) {
        JSONObject l_jsonobject = null;

        l_jsonobject = new JSONObject(inputMap);

        return l_jsonobject.toString();
    }

    public static String getColStringFromBody(Map<String, String> headerMap,
            String pupdate, String pname) {

        //String scolstring = "";
        String scolstring1 = "";
        try {
            JSONObject bodyobject = new JSONObject(pupdate);
            Iterator ite = bodyobject.keys();
            JSONObject soapobj = null;
            String sname = "";
            while (ite.hasNext()) {
                sname = ite.next().toString();
                if ((sname.equals(pname))) {
                    scolstring1 = bodyobject.get(sname).toString();

                    //soapobj = (JSONObject) bodyobject.get(sname);
                    //scolstring = soapobj.toString();
                    //scolstring=sname;
                }
            }

        } catch (JSONException jsone) {
            jsone.printStackTrace();
        }
        return scolstring1;

    }

    public static String getOutputString(JSONArray recarray,
            HashMap<String, String> headerMap, String pname) {

        JSONObject bodyobj = new JSONObject();
        JSONObject outputobj = new JSONObject();

        try {
            bodyobj.put(pname, recarray);
            outputobj.put("appzillonHeader", headerMap);
            outputobj.put("appzillonBody", bodyobj);

        } catch (JSONException jsone) {

            jsone.printStackTrace();

        }

        return outputobj.toString();

    }

    /*
     * concatArray method returns JsonArray by concatenating 
     * list of JsonArrays in arrs array
     * Added by Samy on 11-07-2013
     * Reviewed by Siddarth
     */
    public static JSONArray concatArray(JSONArray... arrs) {
        JSONArray result = new JSONArray();

        try {

            for (JSONArray arr : arrs) {
                for (int i = 0; i < arr.length(); i++) {
                    result.put(arr.get(i));
                }
            }
        } catch (JSONException jsonex) {
            // TODO: handle exception
            jsonex.printStackTrace();
        }

        return result;
    }

    /*
     * putJSonObj method helps in converting 
     * a json array to json object added to a node
     * Added by Samy on 11-07-2013
     * Reviewed by Siddarth
     */
    public static JSONObject putJSonObj(JSONObject responseObj, String nodeName, JSONArray inputArr) {

        try {
//			responseObj = new JSONObject();
            responseObj.put(nodeName, inputArr);

        } catch (JSONException jsonex) {
            jsonex.printStackTrace();
        }
        return responseObj;
    }

    /*
     * putJSonObj method helps in adding
     * a nodevalue with nodeKey to json object
     * Added by Samy on 30-07-2013
     * Reviewed by Siddarth
     */
    public static JSONObject putJSonObj(JSONObject responseObj, String nodeName, String nodeValue) {

        try {
//			responseObj = new JSONObject();
            responseObj.put(nodeName, nodeValue);

        } catch (JSONException jsonex) {
            jsonex.printStackTrace();
        }
        return responseObj;
    }
        /*
     * putJSonObj method helps in adding
     * a nodevalue with nodeKey to json object
     * Added by Samy on 10-10-2013
     * Reviewed by Siddarth
     */
    public static JSONObject putJSonObj(JSONObject responseObj, String nodeName, Object nodeValue) {

        try {
//			responseObj = new JSONObject();
            responseObj.put(nodeName, nodeValue);

        } catch (JSONException jsonex) {
            jsonex.printStackTrace();
        }
        return responseObj;
    }
    /*
     * getOutputString method helps in converting 
     * a json array to json object added to a node
     * Added by Samy on 11-07-2013
     * Reviewed by Siddarth
     */

    public static String getOutputString(JSONObject bodyJson,
            Map<String, String> headerMap) {

        JSONObject outputobj = new JSONObject();

        try {

            outputobj.put("appzillonHeader", headerMap);
            outputobj.put("appzillonBody", bodyJson);

        } catch (JSONException jsone) {

            jsone.printStackTrace();

        }

        return outputobj.toString();

    }

    /*
     * getJsonArrayFromString method helps in converting 
     * a input JSON String to json Array
     * Added by Samy on 23-07-2013
     * Reviewed by Siddarth
     */
    public static JSONArray getJsonArrayFromString(String p_inputJsonString) {
        JSONArray l_respJsonArray = null;
        try {
            l_respJsonArray = new JSONArray(p_inputJsonString);

        } catch (JSONException jsone) {
            jsone.printStackTrace();
        }
        return l_respJsonArray;
    }

    public static JSONObject StringtoJsonObj(String inputJson) {

        JSONObject json = null;

        try {

            json = new JSONObject(inputJson);

        } catch (JSONException jsonex) {
            jsonex.printStackTrace();
        }
        return json;
    }

    public static String[] jsonNodestoStringArr(JSONArray nodeNames) {
        String nodes[] = null;
        try {
            nodes = new String[nodeNames.length()];
            for (int i = 0; i < nodeNames.length(); i++) {
                nodes[i] = nodeNames.get(i).toString();
            }
        } catch (JSONException jsonex) {
            jsonex.printStackTrace();
        }
        return nodes;
    }
    
    
	public static String getKeyValue(String tempJSON, String node) {
		// TODO Auto-generated method stub
		String l_outputString="";
		try {
			JSONObject obj =new JSONObject(tempJSON);
			Iterator<String> it=obj.keys();
			while(it.hasNext()){
			String key=it.next();
			
				Object nodeValue=obj.get(key);
				if(node.equals(key)){
					l_outputString=nodeValue.toString();
				}else if(nodeValue instanceof JSONObject){
					l_outputString=getKeyValue(nodeValue.toString(),node);
				}else if(nodeValue instanceof JSONArray){
					JSONArray array=(JSONArray)nodeValue;
					int i=0;
					while(i<array.length()){
						JSONObject ob=array.getJSONObject(i);
						if("".equals(l_outputString))
							l_outputString=getKeyValue(ob.toString(),node);
						else
						l_outputString=l_outputString+","+getKeyValue(ob.toString(),node);
						i++;
					}
				}
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l_outputString;
	}
}
