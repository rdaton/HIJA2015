/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prac3_daton_incompl;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author usuario_local
 */
public class tVentanaMatriz extends javax.swing.JFrame {
    
       private int _idJugador;
    /**
     * Creates new form tVentanaMatriz
     */
    public tVentanaMatriz(int j) {
        
        _idJugador=j;
        initComponents();        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        ComboPerso = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setRowSelectionAllowed(false);
        jTable1.setTableHeader(new javax.swing.table.JTableHeader());
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        inicializarLetras();

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Porcentaje Manual");
        jLabel1.setToolTipText("");
        jLabel1.setText(String.valueOf(VentanaPrincipal._unosControladores[_idJugador].porcentajeManual));
        jLabel1.repaint();

        jButton2.setText("Generar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.setText("% multiplo de 5");
        jTextField1.setMinimumSize(new java.awt.Dimension(200, 200));
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton3.setText("Perso.");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        ComboPerso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5%","10%","15%","20%","25%","30%","35%","40%","45%","50%","55%","60%","65%","70%","75%","80%","85%","90%","95%" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jButton2)))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(ComboPerso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton3))))))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(100, 100, 100))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(ComboPerso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 64, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowSelectionAllowed(false);
        jTable2.setTableHeader(new javax.swing.table.JTableHeader());
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        inicializarLetras2();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(382, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        this.jTextField1.setText("");
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int n= Integer.parseInt(jTextField1.getText());
        VentanaPrincipal._unosControladores[_idJugador].porcentajeBaker(n);
        jTable1.repaint();
        jLabel1.setText(String.valueOf(VentanaPrincipal._unosControladores[_idJugador].porcentajeManual));
        jLabel1.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        switch (_idJugador)
        {            
            case 0:
                VentanaPrincipal.jTextPane1.setText(VentanaPrincipal._unosControladores[_idJugador].dameCsvMatrizRangos());
                break;
            case 1:
                VentanaPrincipal.jTextPane2.setText(VentanaPrincipal._unosControladores[_idJugador].dameCsvMatrizRangos());
                break;
            case 2:
                VentanaPrincipal.jTextPane3.setText(VentanaPrincipal._unosControladores[_idJugador].dameCsvMatrizRangos());
                break;
            case 3:
                VentanaPrincipal.jTextPane4.setText(VentanaPrincipal._unosControladores[_idJugador].dameCsvMatrizRangos());
                break;    
            case 4:
                VentanaPrincipal.jTextPane5.setText(VentanaPrincipal._unosControladores[_idJugador].dameCsvMatrizRangos());
                break;
            case 5:
                VentanaPrincipal.jTextPane6.setText(VentanaPrincipal._unosControladores[_idJugador].dameCsvMatrizRangos());
                break;
            case 6:
                VentanaPrincipal.jTextPane7.setText(VentanaPrincipal._unosControladores[_idJugador].dameCsvMatrizRangos());
                break;
            case 7:
                VentanaPrincipal.jTextPane8.setText(VentanaPrincipal._unosControladores[_idJugador].dameCsvMatrizRangos());
                break;        
            case 8:
                VentanaPrincipal.jTextPane9.setText(VentanaPrincipal._unosControladores[_idJugador].dameCsvMatrizRangos());
                break;
            case 9:
                VentanaPrincipal.jTextPane10.setText(VentanaPrincipal._unosControladores[_idJugador].dameCsvMatrizRangos());
                break; 
            case 10:
                VentanaPrincipal.jTextPane11.setText(VentanaPrincipal._unosControladores[_idJugador].dameCsvMatrizRangos());
                break; 
            case 11:
                VentanaPrincipal.jTextPane12.setText(VentanaPrincipal._unosControladores[_idJugador].dameCsvMatrizRangos());
                break; 
         }
        
        
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int i= jTable1.getSelectedRow();
        int j= jTable1.getSelectedColumn();
        //System.out.println("celda seleccionada" + new Integer(i).toString() + new Integer(j).toString());
        VentanaPrincipal._unosControladores[_idJugador].matrizBool[i][j]=!VentanaPrincipal._unosControladores[_idJugador].matrizBool[i][j];
        VentanaPrincipal._unosControladores[_idJugador].calculaPorcentaje();
        jTable1.repaint();
        jLabel1.setText(String.valueOf(VentanaPrincipal._unosControladores[_idJugador].porcentajeManual));

        jLabel1.repaint();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int i= jTable2.getSelectedRow();
        int j= jTable2.getSelectedColumn();
        //System.out.println("celda seleccionada" + new Integer(i).toString() + new Integer(j).toString());  
        //cambio la celda sólo si es mía
        if (tBaraja.getInstance().esMia(i, j, _idJugador)) 
            tBaraja.getInstance().soltar(i, j, _idJugador);
        else 
                if (tBaraja.getInstance().esLibre(i, j))
                    tBaraja.getInstance().coger(i, j, _idJugador);
        
        jTable2.repaint();
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        tControlador.tablaBaker[ComboPerso.getSelectedIndex()]=VentanaPrincipal._unosControladores[_idJugador].dameCsvMatrizRangos();
        tControlador.escribeBaker();
        tControlador.parseaBaker();        
     
    }//GEN-LAST:event_jButton3ActionPerformed

    
    
    
//http://www.dreamincode.net/forums/topic/286338-change-background-color-of-jtable-column-heads/    
class MyRenderer extends DefaultTableCellRenderer {
    Color[] color = {Color.GREEN,Color.GRAY,  Color.RED};
    
    
    @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
              this.setValue(value);
              if (VentanaPrincipal._unosControladores[_idJugador].matrizBool[row][column])
                  setBackground(Color.YELLOW);
              else
                  setBackground(color[VentanaPrincipal._unosControladores[_idJugador].matrizColor[row][column]]);
              return this;
         }

}
    
//http://www.dreamincode.net/forums/topic/286338-change-background-color-of-jtable-column-heads/    
class MyRenderer2 extends DefaultTableCellRenderer {
    //Color[] color = {Color.GREEN,Color.GRAY,  Color.RED};
    
    
    @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
              this.setValue(value);
              if (tBaraja.getInstance().esMia(row,column,_idJugador))
                  setBackground(Color.YELLOW);
              else if (tBaraja.getInstance().esLibre(row,column))
                  setBackground(Color.WHITE);
              else if (tBaraja.getInstance().esNegra(row,column))                  
                 setBackground(Color.BLACK);
              else if (tBaraja.getInstance().esComun(row, column))
                 setBackground(Color.MAGENTA); 
              else //es de alguién
                 setBackground(Color.RED); 
              return this;
         }

}
      
    void inicializarLetras2()
    {
        MyRenderer2 mr = new MyRenderer2();
        //VentanaPrincipal._unControlador.matrizBool[2][3]=true;
        for (int i=0;i<tRango.enumRango.toArrayChar().length;i++)
        {
            for (int j=0;j<tPalo.enumPalo.toArrayChar().length;j++)
            {               
                jTable2.getModel().setValueAt( tBaraja.getInstance().dameCartaString(i, j),i, j);                
                jTable2.getColumnModel().getColumn(j).setCellRenderer(mr);
            }
        }
        

    }
    void inicializarLetras()
    {
        MyRenderer mr = new MyRenderer();
        //VentanaPrincipal._unControlador.matrizBool[2][3]=true;
        for (int i=0;i<13;i++)
        {
            for (int j=0;j<13;j++)
            {               
                jTable1.getModel().setValueAt( VentanaPrincipal._unosControladores[_idJugador].matrizRangos[i][j],i, j);                
                jTable1.getColumnModel().getColumn(i).setCellRenderer(mr);
            }
        }
        jLabel1.setText(String.valueOf(VentanaPrincipal._unosControladores[_idJugador].porcentajeManual));
        jLabel1.repaint();

    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tVentanaMatriz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tVentanaMatriz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tVentanaMatriz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tVentanaMatriz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
           
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboPerso;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
