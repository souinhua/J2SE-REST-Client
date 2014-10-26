/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cig.restca.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author User
 */
public class JSONData {
    
    public static boolean isJSON(String string) {
        return JSONData.isJSONObject(string) || JSONData.isJSONArray(string);
    }
    
    public static boolean isJSONObject(String string) {
        boolean value = true;
        try {
            JSONObject json = new JSONObject(string);
        }
        catch(JSONException exception) {
            value = false;
        }
        return value;
    }
    
    public static boolean isJSONArray(String string) {
        boolean value = true;
        try {
            JSONArray json = new JSONArray(string);
        }
        catch(JSONException exception) {
            value = false;
        }
        return value;
    }
    
    public static String toJSONString(String string, int indent) {
        String jsonStr = string;
        if(JSONData.isJSON(string)) {
            if(JSONData.isJSONArray(string)) {
                jsonStr = new JSONArray(jsonStr).toString(indent);
            }
            else if(JSONData.isJSONObject(string)) {
                jsonStr = new JSONObject(jsonStr).toString(indent);
            }
        }
        else {
            throw new JSONException("Invalid string resource");
        }
        return jsonStr;
    }
    
}
