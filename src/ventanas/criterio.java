/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.control;
import clases.validar;
import javax.swing.JOptionPane;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class criterio extends javax.swing.JFrame {

         /**
          * Creates new form criterio
          */
         public criterio() {
                  initComponents();
                  control.fillTable2(tabla, "select * from criterio");
                  
                    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    setLocationRelativeTo(null);
         }

         /**
          * This method is called from within the constructor to
          * initialize the form. WARNING: Do NOT modify this code. The
          * content of this method is always regenerated by the Form
          * Editor.
          */
         @SuppressWarnings("unchecked")
         // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
         private void initComponents() {

                  jLabel1 = new javax.swing.JLabel();
                  jLabel2 = new javax.swing.JLabel();
                  nom = new javax.swing.JTextField();
                  jLabel3 = new javax.swing.JLabel();
                  jLabel4 = new javax.swing.JLabel();
                  min = new javax.swing.JTextField();
                  max = new javax.swing.JTextField();
                  jButton1 = new javax.swing.JButton();
                  jScrollPane1 = new javax.swing.JScrollPane();
                  tabla = new javax.swing.JTable();

                  setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                  getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                  jLabel1.setText("registrar  criterios de evaluacon");
                  getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 35, -1, -1));

                  jLabel2.setText("nombre del criterio");
                  getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 83, -1, -1));

                  nom.setName("nombre"); // NOI18N
                  getContentPane().add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 79, 301, -1));

                  jLabel3.setText("valor  minimo");
                  getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 135, -1, -1));

                  jLabel4.setText("valor maximo");
                  getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 190, -1, -1));

                  min.setName("minimo"); // NOI18N
                  min.addKeyListener(new java.awt.event.KeyAdapter() {
                           public void keyTyped(java.awt.event.KeyEvent evt) {
                                    minKeyTyped(evt);
                           }
                  });
                  getContentPane().add(min, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 131, 74, -1));

                  max.setName("maximo"); // NOI18N
                  max.addActionListener(new java.awt.event.ActionListener() {
                           public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    maxActionPerformed(evt);
                           }
                  });
                  max.addKeyListener(new java.awt.event.KeyAdapter() {
                           public void keyTyped(java.awt.event.KeyEvent evt) {
                                    maxKeyTyped(evt);
                           }
                  });
                  getContentPane().add(max, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 186, 74, -1));

                  jButton1.setText("agregar criterio");
                  jButton1.addActionListener(new java.awt.event.ActionListener() {
                           public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    jButton1ActionPerformed(evt);
                           }
                  });
                  getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 213, -1));

                  tabla.setModel(new javax.swing.table.DefaultTableModel(
                           new Object [][] {
                                    {null, null, null, null},
                                    {null, null, null, null},
                                    {null, null, null, null},
                                    {null, null, null, null}
                           },
                           new String [] {
                                    "Title 1", "Title 2", "Title 3", "Title 4"
                           }
                  ));
                  jScrollPane1.setViewportView(tabla);

                  getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 245, 533, 277));

                  pack();
         }// </editor-fold>//GEN-END:initComponents

         private void maxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxActionPerformed
                  // TODO add your handling code here:
         }//GEN-LAST:event_maxActionPerformed

         private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                  // TODO add your handling code here:

                  if (!validar.esCajaVacio(nom, min, max)) {
                           int num1 = Integer.parseInt(max.getText().trim());
                           int num2 = Integer.parseInt(min.getText().trim());
                           int res = num1 - num2;

                           if (res > 5) {

                                    String sql = String.format("insert into criterio values(null, '%s',%s,%s)",
                                            nom.getText().trim(), min.getText().trim(), max.getText().trim());
                                    if (control.update(sql) > 0) {
                                             JOptionPane.showMessageDialog(null, "se ingreso correctamente");
                                              control.fillTable2(tabla, "select * from criterio");
                                    } else {
                                             JOptionPane.showMessageDialog(null, "no se pudo ingresar");
                                    }

                           } else {
                                    JOptionPane.showMessageDialog(null, "el valor maximo debe ser mayor al  minimos por almenos por 5");
                           }

                  }
         }//GEN-LAST:event_jButton1ActionPerformed

         private void minKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_minKeyTyped
                  // TODO add your handling code here:
                  validar.Solonumeros(evt);
         }//GEN-LAST:event_minKeyTyped

         private void maxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_maxKeyTyped
                  // TODO add your handling code here:
                  validar.Solonumeros(evt);
         }//GEN-LAST:event_maxKeyTyped

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
                           java.util.logging.Logger.getLogger(criterio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                  } catch (InstantiationException ex) {
                           java.util.logging.Logger.getLogger(criterio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                  } catch (IllegalAccessException ex) {
                           java.util.logging.Logger.getLogger(criterio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                           java.util.logging.Logger.getLogger(criterio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                  }
                  //</editor-fold>

                  /* Create and display the form */
                  java.awt.EventQueue.invokeLater(new Runnable() {
                           public void run() {
                                    new criterio().setVisible(true);
                           }
                  });
         }

         // Variables declaration - do not modify//GEN-BEGIN:variables
         private javax.swing.JButton jButton1;
         private javax.swing.JLabel jLabel1;
         private javax.swing.JLabel jLabel2;
         private javax.swing.JLabel jLabel3;
         private javax.swing.JLabel jLabel4;
         private javax.swing.JScrollPane jScrollPane1;
         private javax.swing.JTextField max;
         private javax.swing.JTextField min;
         private javax.swing.JTextField nom;
         private javax.swing.JTable tabla;
         // End of variables declaration//GEN-END:variables
}
