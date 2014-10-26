/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cig.restca.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONString;

/**
 *
 * @author User
 */
public class RESTClientResponse implements JSONString{
    
    private int responseCode;
    private String responseMessage;
    private String response;
    private String requestMethod;
    private Map<String, List<String>> headerFields;
    private String url;

    public RESTClientResponse(int responseCode, String responseMessage, String response, String requestMethod, Map<String, List<String>> headerFields,String url) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.response = response;
        this.requestMethod = requestMethod;
        this.headerFields = headerFields;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public String getResponse() {
        return response;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public Map<String, List<String>> getHeaderFields() {
        return headerFields;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.responseCode;
        hash = 17 * hash + Objects.hashCode(this.responseMessage);
        hash = 17 * hash + Objects.hashCode(this.response);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RESTClientResponse other = (RESTClientResponse) obj;
        if (this.responseCode != other.responseCode) {
            return false;
        }
        if (!Objects.equals(this.responseMessage, other.responseMessage)) {
            return false;
        }
        if (!Objects.equals(this.response, other.response)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RESTClientModel{" + "responseCode=" + responseCode + ", responseMessage=" + responseMessage + ", response=" + response + ", requestMethod=" + requestMethod + '}';
    }

    @Override
    public String toJSONString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
