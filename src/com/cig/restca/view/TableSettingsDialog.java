package com.cig.restca.view;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Janssen Canturias
 */
public class TableSettingsDialog extends javax.swing.JDialog implements CenteredWindow{

    /**
     * Creates new form TableSettingsDialog
     * @param parent
     */
    private TableModel tableModel;
    
    public TableSettingsDialog(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
    }
    
    public TableModel changeTableModelSettings(TableModel tableModel) {
        this.tableModel = tableModel;
        
        extractTableModel();
        centerize();
        this.setVisible(true);
        return this.tableModel;
    }
    
    private void extractTableModel() {
        int count = tableModel.getColumnCount();
        String data[][] = new String[count][2];
        for(int i=0;i<count;i++) {
            String name = tableModel.getColumnName(i);
            String type = "String";
            
            data[i][0] = name;
            data[i][1] = type;
        }
        
        modelTable.setModel(new DefaultTableModel(data, new String[]{"Column Name","Type"}));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        modelTable = new javax.swing.JTable();
        removeBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Table Settings");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        modelTable.setAutoCreateRowSorter(true);
        modelTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Column", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        modelTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(modelTable);

        removeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cig/restca/img/glyphicon/small/glyphicons_192_circle_remove.png"))); // NOI18N
        removeBtn.setText("Remove");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cig/restca/img/glyphicon/small/glyphicons_443_floppy_disk.png"))); // NOI18N
        jButton2.setText("OK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(removeBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 313, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeBtn)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        int r = modelTable.getSelectedRow();
        ((DefaultTableModel)modelTable.getModel()).removeRow(r);
    }//GEN-LAST:event_removeBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable modelTable;
    private javax.swing.JButton removeBtn;
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
