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
public class ciudad extends javax.swing.JFrame {

         /**
          * Creates new form ciudad
          */
         public ciudad() {
                  initComponents();
                  control.fillTable2(tabla, "select * from ciudad");
                  validar.ocultarColumna(tabla, 0);
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
                  ciudad = new javax.swing.JTextField();
                  jButton1 = new javax.swing.JButton();
                  jButton2 = new javax.swing.JButton();
                  jButton3 = new javax.swing.JButton();
                  jScrollPane1 = new javax.swing.JScrollPane();
                  tabla = new javax.swing.JTable();
                  jLabel2 = new javax.swing.JLabel();
                  buscar = new javax.swing.JTextField();

                  setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                  jLabel1.setText("ciudad");

                  jButton1.setText("ingresar");
                  jButton1.addActionListener(new java.awt.event.ActionListener() {
                           public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    jButton1ActionPerformed(evt);
                           }
                  });

                  jButton2.setText("actualizar");
                  jButton2.addActionListener(new java.awt.event.ActionListener() {
                           public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    jButton2ActionPerformed(evt);
                           }
                  });

                  jButton3.setText("eliminar");
                  jButton3.addActionListener(new java.awt.event.ActionListener() {
                           public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    jButton3ActionPerformed(evt);
                           }
                  });

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
                  tabla.addMouseListener(new java.awt.event.MouseAdapter() {
                           public void mousePressed(java.awt.event.MouseEvent evt) {
                                    tablaMousePressed(evt);
                           }
                  });
                  jScrollPane1.setViewportView(tabla);

                  jLabel2.setText("registrar ciudades");

                  buscar.addKeyListener(new java.awt.event.KeyAdapter() {
                           public void keyTyped(java.awt.event.KeyEvent evt) {
                                    buscarKeyTyped(evt);
                           }
                  });

                  javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                  getContentPane().setLayout(layout);
                  layout.setHorizontalGroup(
                           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                             .addGroup(layout.createSequentialGroup()
                                                      .addGap(115, 115, 115)
                                                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                               .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(33, 33, 33)
                                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(32, 32, 32)
                                                                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                               .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel1)
                                                                        .addGap(28, 28, 28)
                                                                        .addComponent(ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                             .addGroup(layout.createSequentialGroup()
                                                      .addGap(310, 310, 310)
                                                      .addComponent(jLabel2)))
                                    .addContainerGap(309, Short.MAX_VALUE))
                           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                             .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
                                             .addComponent(buscar))
                                    .addGap(46, 46, 46))
                  );
                  layout.setVerticalGroup(
                           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addGroup(layout.createSequentialGroup()
                                    .addGap(63, 63, 63)
                                    .addComponent(jLabel2)
                                    .addGap(26, 26, 26)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                             .addComponent(ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                             .addComponent(jLabel1))
                                    .addGap(66, 66, 66)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                             .addComponent(jButton1)
                                             .addComponent(jButton2)
                                             .addComponent(jButton3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(70, 70, 70))
                  );

                  pack();
         }// </editor-fold>//GEN-END:initComponents

         private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                  // TODO add your handling code here:
                  if (ciudad.getText().trim().length() != 0) {
                           if (tabla.getSelectedRowCount() == 1) {
                                    String sql = String.format("update ciudad set nomciud='%s' where idciudad=%s", ciudad.getText().trim(), tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
                                    if (control.update(sql) > 0) {
                                             JOptionPane.showMessageDialog(null, "se actualizo de manera correcta");
                                             control.fillTable2(tabla, "select * from ciudad");
                                             validar.ocultarColumna(tabla, 0);
                                    } else {
                                             JOptionPane.showMessageDialog(null, "no se pudo actualixar");
                                    }
                           } else {
                                    JOptionPane.showMessageDialog(null, "seleccione una fila");
                           }
                  } else {
                           JOptionPane.showMessageDialog(null, "campo vacio");
                  }
         }//GEN-LAST:event_jButton2ActionPerformed

         private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                  // TODO add your handling code here:
                  if (ciudad.getText().trim().length() != 0) {
                           String sql = String.format("insert into  ciudad values( null,'%s')", ciudad.getText().trim());
                           if (control.update(sql) > 0) {
                                    JOptionPane.showMessageDialog(null, "se ingreso correctamente");
                                    control.fillTable2(tabla, "select * from ciudad");
                                    validar.ocultarColumna(tabla, 0);
                           } else {
                                    JOptionPane.showMessageDialog(null, "no se pudo ingresar");
                           }

                  } else {
                           JOptionPane.showMessageDialog(null, "campo vacio");
                  }
         }//GEN-LAST:event_jButton1ActionPerformed

         private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                  // TODO add your handling code here:
                  if (tabla.getSelectedRowCount() == 1) {
                           String sql = String.format("delete from ciudad where idciudad=%s",
                                   tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
                           if (control.update(sql) > 0) {
                                    JOptionPane.showMessageDialog(null, "se borro correctamente");
                                    control.fillTable2(tabla, "select * from ciudad");
                                    validar.ocultarColumna(tabla, 0);
                           } else {
                                    JOptionPane.showMessageDialog(null, "no se pudo borrar");

                           }
                  } else {
                           JOptionPane.showMessageDialog(null, "seleccionar una fila de la tabla");
                  }
         }//GEN-LAST:event_jButton3ActionPerformed

         private void tablaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMousePressed
                  // TODO add your handling code here:
                  ciudad.setText(tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
         }//GEN-LAST:event_tablaMousePressed

         private void buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyTyped
                  // TODO add your handling code here:
                  int pos = buscar.getCaretPosition();
                  String parametro = (buscar.getText().substring(0, pos) + evt.getKeyChar() + buscar.getText().substring(pos)).trim();

                  if (parametro.trim().length() == 0) {
                           control.fillTable2(tabla, "select * from ciudad");
                           validar.ocultarColumna(tabla, 0);
                  } else {

                           String sql = "select * from ciudad where nomciud like '%" + parametro + "%'";
                           control.fillTable2(tabla, sql);
                           validar.ocultarColumna(tabla, 0);

                  }
         }//GEN-LAST:event_buscarKeyTyped

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
                           java.util.logging.Logger.getLogger(ciudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                  } catch (InstantiationException ex) {
                           java.util.logging.Logger.getLogger(ciudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                  } catch (IllegalAccessException ex) {
                           java.util.logging.Logger.getLogger(ciudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                           java.util.logging.Logger.getLogger(ciudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                  }
                  //</editor-fold>

                  /* Create and display the form */
                  java.awt.EventQueue.invokeLater(new Runnable() {
                           public void run() {
                                    new ciudad().setVisible(true);
                           }
                  });
         }

         // Variables declaration - do not modify//GEN-BEGIN:variables
         private javax.swing.JTextField buscar;
         private javax.swing.JTextField ciudad;
         private javax.swing.JButton jButton1;
         private javax.swing.JButton jButton2;
         private javax.swing.JButton jButton3;
         private javax.swing.JLabel jLabel1;
         private javax.swing.JLabel jLabel2;
         private javax.swing.JScrollPane jScrollPane1;
         private javax.swing.JTable tabla;
         // End of variables declaration//GEN-END:variables
}
