/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cig.restca;

import com.cig.restca.controller.RESTClientController;
import com.cig.restca.view.RESTClientFrame;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author User
 */
public class RESTClientApp {

    /**
     * @param args the command line arguments
     */

    
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel());
        } catch (ParseException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(RESTClientFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RESTClientController().startApp();
            }
        });

    }
    
//    public static void main(String[] args) {
//        try {
//            URL url = new URL("http://");
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            con.setRequestMethod("GET");
//            con.connect();
//            
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(RESTClientApp.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(RESTClientApp.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
