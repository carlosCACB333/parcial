/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.control;
import javax.swing.JOptionPane;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class login extends javax.swing.JFrame {

         int contador = 0;

         /**
          * Creates new form login
          */
         public login() {
                  initComponents();
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
                  usu = new javax.swing.JTextField();
                  jButton1 = new javax.swing.JButton();
                  lb_intento = new javax.swing.JLabel();
                  clave = new javax.swing.JPasswordField();

                  setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                  jLabel1.setText("usuario");

                  jLabel2.setText("clave");

                  jButton1.setText("ir");
                  jButton1.addActionListener(new java.awt.event.ActionListener() {
                           public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    jButton1ActionPerformed(evt);
                           }
                  });

                  lb_intento.setText("quedan  4 intentos");

                  javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                  getContentPane().setLayout(layout);
                  layout.setHorizontalGroup(
                           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addGroup(layout.createSequentialGroup()
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(97, 97, 97))
                           .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                             .addGroup(layout.createSequentialGroup()
                                                      .addGap(144, 144, 144)
                                                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                               .addComponent(jLabel1)
                                                               .addComponent(jLabel2))
                                                      .addGap(40, 40, 40)
                                                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                               .addGroup(layout.createSequentialGroup()
                                                                        .addGap(6, 6, 6)
                                                                        .addComponent(clave))
                                                               .addComponent(usu, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                             .addGroup(layout.createSequentialGroup()
                                                      .addGap(234, 234, 234)
                                                      .addComponent(lb_intento)))
                                    .addContainerGap(224, Short.MAX_VALUE))
                  );
                  layout.setVerticalGroup(
                           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addGroup(layout.createSequentialGroup()
                                    .addGap(49, 49, 49)
                                    .addComponent(lb_intento)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                             .addComponent(jLabel1)
                                             .addComponent(usu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                             .addGroup(layout.createSequentialGroup()
                                                      .addGap(18, 18, 18)
                                                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                               .addComponent(jLabel2)
                                                               .addComponent(clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                      .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                                                      .addComponent(jButton1)
                                                      .addGap(92, 92, 92))))
                  );

                  pack();
         }// </editor-fold>//GEN-END:initComponents

         private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                  // TODO add your handling code here:
                  if (usu.getText().trim().length() != 0 && clave.getPassword().length != 0) {

                           String sql = String.format("call login('%s','%s');", usu.getText().trim(), new String(clave.getPassword()));
                           String res = control.returnData(sql);
                           if (!res.equalsIgnoreCase("-1")) {

                                    sql = String.format("select * from usuario where nomus='%s' and clavusr=md5('%s')", usu.getText().trim(), new String(clave.getPassword()));

                                    String usuario_id = control.returnData(sql);

                                    JOptionPane.showMessageDialog(jButton1, "permitido");
                                    this.setVisible(false);
                                    (new principal(usuario_id)).setVisible(true);

                           } else {
                                    JOptionPane.showMessageDialog(jButton1, "acceso denegado!");
                                    contador++;
                                    int i = 4 - contador;
                                    if (i == 0) {
                                             System.exit(0);
                                    }

                                    lb_intento.setText("quedan " + i + " intento ");

                           }

                  } else {
                           JOptionPane.showMessageDialog(null, "llenene todo los campos");
                  }
         }//GEN-LAST:event_jButton1ActionPerformed

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
                           java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                  } catch (InstantiationException ex) {
                           java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                  } catch (IllegalAccessException ex) {
                           java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                           java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                  }
                  //</editor-fold>

                  /* Create and display the form */
                  java.awt.EventQueue.invokeLater(new Runnable() {
                           public void run() {
                                    new login().setVisible(true);
                           }
                  });
         }

         // Variables declaration - do not modify//GEN-BEGIN:variables
         private javax.swing.JPasswordField clave;
         private javax.swing.JButton jButton1;
         private javax.swing.JLabel jLabel1;
         private javax.swing.JLabel jLabel2;
         private javax.swing.JLabel lb_intento;
         private javax.swing.JTextField usu;
         // End of variables declaration//GEN-END:variables
}
