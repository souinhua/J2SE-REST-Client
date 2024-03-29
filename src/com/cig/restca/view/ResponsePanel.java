/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cig.restca.view;

import com.cig.restca.controller.RESTClientController;
import com.cig.restca.json.JSONData;
import com.cig.restca.model.RESTClientResponse;
import java.awt.Color;
import java.net.HttpURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author User
 */
public class ResponsePanel extends javax.swing.JPanel {

    private final RESTClientResponse model;
    private final RESTClientController controller;

    public ResponsePanel(RESTClientResponse model, RESTClientController controller) {
        this.model = model;
        this.controller = controller;
        
        initComponents();
        renderModel();
    }
    
    private void renderModel() {
        String rawResponse = model.getResponse();

        if (model.getResponseCode() != HttpURLConnection.HTTP_OK) {
            this.responseTextArea.setForeground(Color.RED);
        } else {
            this.responseTextArea.setForeground(Color.BLACK);
        }
        
        if(JSONData.isJSON(rawResponse)) {
            if(JSONData.isJSONArray(rawResponse)) {
                JSONArray arr = new JSONArray(rawResponse);
                responseTextArea.setText(arr.toString(6));
            }
            else if(JSONData.isJSONObject(rawResponse)) {
                JSONObject obj = new JSONObject(rawResponse);
                responseTextArea.setText(obj.toString(6));
            }
            this.tabularFormBtn.setEnabled(true);
        }
        else {
            responseTextArea.setText(rawResponse);
        }

        this.responseFieldTable.setModel(controller.toResponseFieldTableModel(model));
        
    }
    
    public String getResponseText() {
        return this.responseTextArea.getText();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        saveBtn = new javax.swing.JButton();
        openHtml = new javax.swing.JButton();
        responseFormatComboBox = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        responseTextArea = new javax.swing.JTextArea();
        tabularFormBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        responseFieldTable = new javax.swing.JTable();

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Response"));

        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cig/restca/img/glyphicon/small/glyphicons_443_floppy_disk.png"))); // NOI18N
        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        openHtml.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cig/restca/img/glyphicon/small/glyphicons_117_embed.png"))); // NOI18N
        openHtml.setText("Open HTML");
        openHtml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openHtmlActionPerformed(evt);
            }
        });

        responseFormatComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "JSON", "Plain Text", "XML", "HTML" }));
        responseFormatComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                responseFormatComboBoxItemStateChanged(evt);
            }
        });

        responseTextArea.setColumns(20);
        responseTextArea.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        responseTextArea.setRows(5);
        responseTextArea.setText("adsadsd");
        jScrollPane5.setViewportView(responseTextArea);

        tabularFormBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cig/restca/img/glyphicon/small/glyphicons_119_table.png"))); // NOI18N
        tabularFormBtn.setText("Tabular Form");
        tabularFormBtn.setEnabled(false);
        tabularFormBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabularFormBtnActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cig/restca/img/glyphicon/small/glyphicons_110_align_left.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(responseFormatComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tabularFormBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 298, Short.MAX_VALUE)
                        .addComponent(openHtml)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveBtn)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(openHtml, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tabularFormBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(responseFormatComboBox)))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Response Fields"));

        responseFieldTable.setAutoCreateRowSorter(true);
        responseFieldTable.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        responseFieldTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Field Name", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        responseFieldTable.setCellSelectionEnabled(true);
        jScrollPane4.setViewportView(responseFieldTable);
        responseFieldTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        String response = this.responseTextArea.getText();
        this.controller.saveAs(response);
    }//GEN-LAST:event_saveBtnActionPerformed

    private void openHtmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openHtmlActionPerformed
        String response = this.responseTextArea.getText();
        this.controller.openAsHTML(response);
    }//GEN-LAST:event_openHtmlActionPerformed

    private void responseFormatComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_responseFormatComboBoxItemStateChanged

    }//GEN-LAST:event_responseFormatComboBoxItemStateChanged

    private void tabularFormBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabularFormBtnActionPerformed
        String response = this.responseTextArea.getText();
        this.controller.openTabularFormDialog(response, model.getUrl());
    }//GEN-LAST:event_tabularFormBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton openHtml;
    private javax.swing.JTable responseFieldTable;
    private javax.swing.JComboBox responseFormatComboBox;
    private javax.swing.JTextArea responseTextArea;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton tabularFormBtn;
    // End of variables declaration//GEN-END:variables
}
