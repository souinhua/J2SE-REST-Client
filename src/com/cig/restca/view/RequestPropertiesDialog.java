/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cig.restca.view;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class RequestPropertiesDialog extends javax.swing.JDialog implements CenteredWindow {

    private Map<String, String> requestProperties;

    public RequestPropertiesDialog(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
    }

    @Override
    public void setVisible(boolean value) {
        throw new UnsupportedOperationException();
    }

    public Map<String, String> updateRequestProperties(Map<String, String> requestProperties) {
        this.requestPropertiesTable.setModel(this.toTableModel(requestProperties));
        this.requestProperties = requestProperties;
        this.centerize();
        super.setVisible(true);
        return this.requestProperties;
    }

    private DefaultTableModel toTableModel(Map<String, String> requestProperties) {
        String data[][] = new String[requestProperties.size()][2];
        int i = 0;
        for (String key : requestProperties.keySet()) {
            data[i][0] = key;
            data[i][1] = requestProperties.get(key);
            i++;
        }
        return new DefaultTableModel(data, new String[]{"Field", "Value"});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        requestPropertiesTable = new javax.swing.JTable();
        saveBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        removeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Request Properties");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        requestPropertiesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Field", "Value"
            }
        ));
        requestPropertiesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(requestPropertiesTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cig/restca/img/glyphicon/small/glyphicons_443_floppy_disk.png"))); // NOI18N
        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cig/restca/img/glyphicon/small/glyphicons_190_circle_plus.png"))); // NOI18N
        addBtn.setText("Add Field");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        removeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cig/restca/img/glyphicon/small/glyphicons_192_circle_remove.png"))); // NOI18N
        removeBtn.setText("Remove Field");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(addBtn)
                    .addComponent(removeBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        DefaultTableModel model = (DefaultTableModel) this.requestPropertiesTable.getModel();
        model.addRow(new String[]{"", ""});
    }//GEN-LAST:event_addBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        Map<String, String> newMap = new HashMap();
        int rowCount = requestPropertiesTable.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            String field = (String) requestPropertiesTable.getValueAt(i, 0);
            String value = (String) requestPropertiesTable.getValueAt(i, 1);
            if (field != null) {
                newMap.put(field, value);
            }
        }
        this.requestProperties = newMap;
        super.setVisible(false);
    }//GEN-LAST:event_saveBtnActionPerformed

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        int row=this.requestPropertiesTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) this.requestPropertiesTable.getModel();
        model.removeRow(row);
        this.requestPropertiesTable.setModel(model);
    }//GEN-LAST:event_removeBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeBtn;
    private javax.swing.JTable requestPropertiesTable;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables

    @Override
    public void centerize() {
        int parentWidth = this.getParent().getWidth();
        int parentHeight = this.getParent().getHeight();

        int width = this.getWidth();
        int height = this.getHeight();

        int pX = this.getParent().getX();
        int pY = this.getParent().getY();

        this.setLocation(pX + ((parentWidth / 2) - (width / 2)), pY + ((parentHeight / 2) - (height / 2)));
    }
}