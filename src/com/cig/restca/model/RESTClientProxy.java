/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cig.restca.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class RESTClientProxy {

    public RESTClientProxy() {

    }
    
    public RESTClientResponse get(URL url) {
        return this.get(url, null);
    }
    
    public RESTClientResponse get(URL url, Map<String, String> headerFields) {
        RESTClientResponse model = null;
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            if(headerFields!=null && !headerFields.isEmpty()) {
                for(String key: headerFields.keySet()) {
                    con.setRequestProperty(key, headerFields.get(key));
                }
            }
            con.setRequestMethod("GET");
            con.connect();
            
            String response = "";
            if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                response = this.readInputStream(con.getInputStream());
            }
            else {
                response = this.readInputStream(con.getErrorStream());
            }
            
            model = new RESTClientResponse(con.getResponseCode(), con.getResponseMessage(), response, con.getRequestMethod(), con.getHeaderFields(),url.toExternalForm());
            
        } catch (IOException ex) {
            Logger.getLogger(RESTClientProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
    
    public RESTClientResponse post(URL url) {
        return this.post(url, null, null);
    }
    
    public RESTClientResponse post(URL url, Map<String, String> headerFields) {
        return this.post(url, null, headerFields);
    }
    
    public RESTClientResponse post(URL url, String postData) {
        return this.post(url, postData, null);
    }
    
    public RESTClientResponse post(URL url, String postData, Map<String, String> headerFields) {
        RESTClientResponse model = null;
        
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();    
            if(headerFields!=null && !headerFields.isEmpty()) {
                for(String key: headerFields.keySet()) {
                    con.setRequestProperty(key, headerFields.get(key));
                }
            }
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.connect();
            
            if(postData!=null) {
                this.writeOutputStream(postData, con.getOutputStream());
            }
            
            String response = null;
            if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                response = this.readInputStream(con.getInputStream());
            }
            else {
                response = this.readInputStream(con.getErrorStream());
            }
            
            model = new RESTClientResponse(con.getResponseCode(), con.getResponseMessage(), response, con.getRequestMethod(), con.getHeaderFields(),url.toExternalForm());
        } catch (IOException ex) {
            Logger.getLogger(RESTClientProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return model;
    }
    
    public RESTClientResponse put(URL url) {
        return this.put(url, null, null);
    }
    
    public RESTClientResponse put(URL url, String postData) {
        return this.put(url, postData, null);
    }
    
    public RESTClientResponse put(URL url, Map<String, String> headerFields) {
        return this.put(url, null, headerFields);
    }
    
    public RESTClientResponse put(URL url, String postData, Map<String, String> headerFields) {
        RESTClientResponse model = null;
        
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();    
            if(headerFields!=null && !headerFields.isEmpty()) {
                for(String key: headerFields.keySet()) {
                    con.setRequestProperty(key, headerFields.get(key));
                }
            }
            con.setRequestMethod("PUT");
            con.setDoOutput(true);
            con.connect();
            
            if(postData!=null) {
                this.writeOutputStream(postData, con.getOutputStream());
            }
            
            String response = null;
            if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                response = this.readInputStream(con.getInputStream());
            }
            else {
                response = this.readInputStream(con.getErrorStream());
            }
            
            model = new RESTClientResponse(con.getResponseCode(), con.getResponseMessage(), response, con.getRequestMethod(), con.getHeaderFields(),url.toExternalForm());
        } catch (IOException ex) {
            Logger.getLogger(RESTClientProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return model;
    }
    
    public RESTClientResponse delete(URL url) {
        return this.delete(url, null);
    }
    
    public RESTClientResponse delete(URL url, Map<String, String> headerFields) {
        RESTClientResponse model = null;
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            if(headerFields!=null && !headerFields.isEmpty()) {
                for(String key: headerFields.keySet()) {
                    con.setRequestProperty(key, headerFields.get(key));
                }
            }
            con.setRequestMethod("DELETE");
            con.connect();
            
            String response = null;
            if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                response = this.readInputStream(con.getInputStream());
            }
            else {
                response = this.readInputStream(con.getErrorStream());
            }
            
            model = new RESTClientResponse(con.getResponseCode(), con.getResponseMessage(), response, con.getRequestMethod(), con.getHeaderFields(),url.toExternalForm());
        } catch (IOException ex) {
            Logger.getLogger(RESTClientProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }

    private void writeOutputStream(String content, OutputStream outputStream) {
        try {
            OutputStreamWriter wr = new OutputStreamWriter(outputStream);
            wr.write(content);
            wr.flush();
        } catch (IOException ex) {
            Logger.getLogger(RESTClientProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String readInputStream(InputStream inputStream) {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line, response = "";

        try {
            while ((line = br.readLine()) != null) {
                response += line;
            }
        } catch (IOException ex) {
            Logger.getLogger(RESTClientProxy.class.getName()).log(Level.SEVERE, null, ex);
        }

        return response;
    }

}
