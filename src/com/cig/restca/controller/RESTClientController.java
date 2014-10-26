package com.cig.restca.controller;

import com.cig.restca.model.RESTClientResponse;
import com.cig.restca.model.RESTClientProxy;
import com.cig.restca.view.PostPutDialog;
import com.cig.restca.view.RESTClientFrame;
import com.cig.restca.view.RequestPropertiesDialog;
import com.cig.restca.view.TableFormFrame;
import com.cig.restca.view.TableSettingsDialog;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author User
 */
public class RESTClientController {

    private final RESTClientFrame clientFrame;
    private Map<String, String> requestProperties;
    private final RESTClientProxy proxy;
    private final PostPutDialog postPutDialog;
    private final RequestPropertiesDialog propertiesDialog;

    public RESTClientController() {
        this.clientFrame = new RESTClientFrame(this);
        this.proxy = new RESTClientProxy();
        this.postPutDialog = new PostPutDialog(clientFrame);
        this.propertiesDialog = new RequestPropertiesDialog(clientFrame);

        this.requestProperties = new HashMap<>();
        this.requestProperties.put("Content-type", "application/json");
    }

    public void startApp() {
        this.clientFrame.setVisible(true);
    }

    public void executeGet(final String url) {
        new SwingWorker() {

            @Override
            protected Object doInBackground() throws Exception {

                try {

                    URL realUrl = new URL(url);
                    clientFrame.setProgress(true, "<html>HTTP GET Request to <i style=\"color:#0088cc\">" + url + "</i> in progress...</html>");

                    RESTClientResponse model = proxy.get(realUrl);
                    clientFrame.addResponse(model);

                } catch (MalformedURLException | IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(clientFrame, "URL Error", "Invalid URL", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(RESTClientController.class.getName()).log(Level.SEVERE, null, ex);
                    clientFrame.setProgress(false, "<html>HTTP GET Request to <i style=\"color:#0088cc\">" + url + "</i> failed.</html>");
                } finally {
                    clientFrame.setProgress(false, "<html>HTTP GET Request to <i style=\"color:#0088cc\">" + url + "</i> done.</html>");
                }
                return null;
            }
        }.execute();
    }

    public void executePost(final String url) {
        final String data = postPutDialog.post(url);
        final String strURL = postPutDialog.getURL();
        if (data != null) {
            new SwingWorker() {

                @Override
                protected Object doInBackground() throws Exception {

                    try {

                        URL realUrl = new URL(strURL);
                        clientFrame.setProgress(true, "<html>HTTP POST Request to <i style=\"color:#0088cc\">" + strURL + "</i> in progress...</html>");
                        RESTClientResponse model = proxy.post(realUrl, data, requestProperties);
                        clientFrame.addResponse(model);

                        clientFrame.setProgress(false, "<html>HTTP POST Request to <i style=\"color:#0088cc\">" + strURL + "</i> done.</html>");

                    } catch (MalformedURLException | IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(clientFrame, "URL Error", "Invalid URL", JOptionPane.ERROR_MESSAGE);
                        Logger.getLogger(RESTClientController.class.getName()).log(Level.SEVERE, null, ex);
                        clientFrame.setProgress(false, "<html>HTTP POST Request to <i style=\"color:#0088cc\">" + strURL + "</i> failed.</html>");
                    }

                    return null;
                }
            }.execute();
        }
    }

    public void executePut(String url) {
        final String data = postPutDialog.post(url);
        final String strURL = postPutDialog.getURL();
        if (strURL.length() > 0 && data != null) {
            new SwingWorker() {

                @Override
                protected Object doInBackground() throws Exception {

                    try {

                        URL realUrl = new URL(strURL);
                        clientFrame.setProgress(true, "<html>HTTP PUT Request to <i style=\"color:#0088cc\">" + strURL + "</i> in progress...</html>");
                        RESTClientResponse model = proxy.put(realUrl, data, requestProperties);
                        clientFrame.addResponse(model);

                        clientFrame.setProgress(false, "<html>HTTP PUT Request to <i style=\"color:#0088cc\">" + strURL + "</i> done.</html>");

                    } catch (MalformedURLException | IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(clientFrame, "URL Error", "Invalid URL", JOptionPane.ERROR_MESSAGE);
                        Logger.getLogger(RESTClientController.class.getName()).log(Level.SEVERE, null, ex);

                        clientFrame.setProgress(false, "<html>HTTP PUT Request to <i style=\"color:#0088cc\">" + strURL + "</i> failed.</html>");
                    }

                    return null;
                }
            }.execute();
        }
    }

    public void executeDelete(final String url) {
        new SwingWorker() {

            @Override
            protected Object doInBackground() throws Exception {

                try {

                    URL urlReal = new URL(url);
                    int option = JOptionPane.showConfirmDialog(clientFrame, "Are you sure you want to execute a DELETE\n request to " + url + "?", "HTTP Delete Request", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        clientFrame.setProgress(true, "<html>HTTP DELETE Request to <i style=\"color:#0088cc\">" + url + "</i> in progress...</html>");

                        RESTClientResponse model = proxy.delete(urlReal, requestProperties);
                        clientFrame.addResponse(model);

                        clientFrame.setProgress(false, "<html>HTTP DELETE Request to <i style=\"color:#0088cc\">" + url + "</i> done.</html>");
                    }

                } catch (MalformedURLException | IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(clientFrame, "URL Error", "Invalid URL", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(RESTClientController.class.getName()).log(Level.SEVERE, null, ex);
                    clientFrame.setProgress(false, "<html>HTTP DELETE Request to <i style=\"color:#0088cc\">" + url + "</i> failed.</html>");
                }

                return null;
            }
        }.execute();
    }

    public void openAsHTML(String html) {
        Date date = new Date();
        String fileName = date.getTime() + ".html";
        File file = new File(fileName);
        file.deleteOnExit();
        try {
            try (FileWriter fw = new FileWriter(file)) {
                fw.write(html);
                fw.close();

                java.awt.Desktop.getDesktop().open(file);
            }

        } catch (IOException ex) {
            Logger.getLogger(RESTClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveAs(String content) {
        JFileChooser chooser = new JFileChooser();

        if (chooser.showSaveDialog(this.clientFrame) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                try (FileWriter fw = new FileWriter(file)) {
                    fw.write(content);
                    fw.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(RESTClientController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean isJSONObject(String data) {
        boolean value = true;
        try {
            JSONObject json = new JSONObject(data);
        } catch (JSONException exc) {
            value = false;
        }
        return value;
    }

    public boolean isJSONArray(String data) {
        boolean value = true;
        try {
            JSONArray json = new JSONArray(data);
        } catch (JSONException exc) {
            value = false;
        }
        return value;
    }

    public boolean isJSON(String data) {
        return this.isJSONArray(data) || this.isJSONObject(data);
    }

    public void updateRequestProperties() {
        Map<String, String> updateRequestProperties = this.propertiesDialog.updateRequestProperties(requestProperties);
        this.requestProperties = updateRequestProperties;
        System.out.println(updateRequestProperties);
    }

    public DefaultTableModel toResponseFieldTableModel(RESTClientResponse model) {
        Map<String, List<String>> map = model.getHeaderFields();

        String[][] data = new String[map.size() + 2][2];

        data[0][0] = "<html><b>Response Code</b></html>";
        String code = "";
        if (model.getResponseCode() == HttpURLConnection.HTTP_OK) {
            code = "<html><b style=\"color:green\">" + model.getResponseCode() + "</b></html>";
        } else if (model.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
            code = "<html><b style=\"color:red\">" + model.getResponseCode() + "</b></html>";
        } else {
            code = "<html><b style=\"color:orange\">" + model.getResponseCode() + "</b></html>";
        }
        data[0][1] = code;

        data[1][0] = "<html><b>Response Message</b></html>";
        data[1][1] = model.getResponseMessage();

        data[2][0] = "<html><b>URL</b></html>";
        data[2][1] = "<html><a style=\"color:#0088cc\">" + model.getUrl() + "</a></html>";
        
        int count = 3;
        for (String key : map.keySet()) {
            if (key != null && key.length() > 0) {
                data[count][0] = "<html><b>" + key + "</b></html>";
                data[count][1] = map.get(key).toString();
                count++;
            }
        }

        return new DefaultTableModel(data, new String[]{"Field", "Value"});
    }
    
    public DefaultTableModel toTableModel(JSONObject jObject) {
        String data[][] = new String[1][jObject.keySet().size()];
        int cnt = 0;
        for (String key : jObject.keySet()) {
            data[0][cnt++] = jObject.get(key).toString();

        }
        return new DefaultTableModel(data, jObject.keySet().toArray());
    }

    public DefaultTableModel toTableModel(JSONArray array) {
        String data[][] = new String[array.length()][array.getJSONObject(0).keySet().size()];
        for (int i = 0; i < array.length(); i++) {
            int cnt = 0;
            for (String key : array.getJSONObject(i).keySet()) {
                data[i][cnt++] = array.getJSONObject(i).get(key).toString();
            }
        }
        return new DefaultTableModel(data, array.getJSONObject(0).keySet().toArray());
    }
    
    public void openTabularFormDialog(String data, String title) {
        TableFormFrame dialog = new TableFormFrame(clientFrame, this);
        dialog.showTabularForm(data, title);
    }
    
    public DefaultTableModel changeTableSettings(TableModel model, JFrame parent) {
        DefaultTableModel defaultModel = new DefaultTableModel();
        
        TableSettingsDialog tableSettingsDialog = new TableSettingsDialog(parent);
        tableSettingsDialog.changeTableModelSettings(model);
        
        return defaultModel;
    }

}
