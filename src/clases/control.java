/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.io.File;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.util.HashMap;
import java.util.Map;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import jdk.dynalink.linker.support.Guards;
import net.sf.jasperreports.engine.JRException;

public class control {

         public static final Connection connection = getConnetion();

         public static Connection getConnetion() {
                  Connection conec = null;
                  try {
                           Class.forName("com.mysql.cj.jdbc.Driver");
                           /// conec = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_materiales", "root", "mysql");
                           conec = DriverManager.getConnection("jdbc:mysql://localhost:3306/evaluacion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "mysql");
                           Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                  } catch (Exception e) {
                           System.out.println(" fallo en la conexion");
                           JOptionPane.showMessageDialog(null, e.getMessage());
                           e.printStackTrace();

                  }
                  return conec;

         }

         public static void fillCombo(JComboBox<String> comboBox, String sql) {
                  try ( Statement statement = connection.createStatement()) {
                           try ( ResultSet resultSet = statement.executeQuery(sql)) {
                                    comboBox.removeAllItems();
                                    while (resultSet.next()) {
                                             comboBox.addItem(resultSet.getString(1));
                                    }
                           }
                  } catch (SQLException ex) {
                           System.out.println(" fallo en llenar el combo");
                           ex.printStackTrace();
                           JOptionPane.showMessageDialog(null, ex.getMessage());
                  }
                  comboBox.setSelectedIndex(-1);            
         }

         /**
          * Remueve todas las filas de la tabla
          */
         public static void limTable(DefaultTableModel tableModel) {
                  while (tableModel.getRowCount() > 0) {
                           tableModel.removeRow(0);
                  }
         }
         
         /**
          * Rellena la tabla con la consulta sql
          */
         public static void fillTable(DefaultTableModel tableModel, String sql, int n) {
                  limTable(tableModel);
                  try ( Statement statement = connection.createStatement()) {
                           try ( ResultSet resultSet = statement.executeQuery(sql)) {
                                    String[] data = new String[n];
                                    while (resultSet.next()) {
                                             for (int i = 0; i <= n - 1; i++) {
                                                      data[i] = resultSet.getString(i + 1);
                                             }
                                             tableModel.addRow(data);
                                    }
                           }
                  } catch (SQLException ex) {
                           System.out.println(" fallo en llenar la tabla");
                           ex.printStackTrace();
                           JOptionPane.showMessageDialog(null, ex.getMessage());
                  }
         }

         /**
          * Rellena la lista con la consulta sql
          */
         public static void fillList(DefaultListModel<String> listModel, String sql) {
                  try ( Statement st = connection.createStatement()) {
                           try ( ResultSet rs = st.executeQuery(sql)) {
                                    listModel.removeAllElements();
                                    while (rs.next()) {
                                             listModel.addElement(rs.getString(1));
                                    }
                           }
                  } catch (SQLException ex) {
                           System.out.println("fallo al llenar la lista ");
                           ex.printStackTrace();
                           JOptionPane.showMessageDialog(null, ex.getMessage());
                  }
         }

         /**
          * @param sql comando SQL a ejecutar
          * @return retorna una cadena con el valor de la primera
          * columna de la primera fila
          */
         public static String returnData(String sql) {
                  String data = "";
                  try ( Statement statement = connection.createStatement()) {
                           try ( ResultSet resultSet = statement.executeQuery(sql)) {
                                    resultSet.next();
                                    data = resultSet.getString(1);
                           }
                  } catch (SQLException ex) {
                           System.out.println(" error al retornar   un dato");
                      ex.printStackTrace();
                           JOptionPane.showMessageDialog(null, ex.getMessage());
                  }
                  return data;
         }

         /**
          * Retorna TRUE si la consulta retorna al menos una fila
          * Retorna FALSE si la consulta falla o no retorna nada
          */
         public static boolean checkQuery(String sql) {
                  boolean check = false;
                  try ( Statement statement = connection.createStatement()) {
                           try ( ResultSet resultset = statement.executeQuery(sql)) {
                                    check = resultset.next();
                           }
                  } catch (SQLException ex) {
                           System.out.println(" error al verificar consulta ");
                           ex.printStackTrace();
                           JOptionPane.showMessageDialog(null, ex.getMessage());
                  }
                  return check;
         }

         /**
          * Metodo para realizar un DELETE,UPDATE o INSERT con una
          * consulta SQL Retorna un INTEGER con valor del n�mero de
          * filas afectadas por la consulta
          */
         public static int update(String sql) {
                  int rowsAffected = 0;

                  // Un try with resources, el problema de que ocurra una exception en esta function es que la connexion
                  // sera creada y no podrá ser recogida por el garbage collector, lo cual genera un memory leak
                  // El try with resources en caso de una exception va a cerrar automáticamente la connexion y no se producirá
                  // el memory leak
                  try ( Statement statement = connection.createStatement()) {
                           rowsAffected = statement.executeUpdate(sql);
                  } catch (SQLException ex) {
                           if (ex.getErrorCode() == 1451) {
                                    JOptionPane.showMessageDialog(null, "no se puede procesar la peticion por la restricción de llaves foráneas", "alerta", JOptionPane.ERROR_MESSAGE);
                           } else {
                                    JOptionPane.showMessageDialog(null, ex.getMessage());
                           }
                           System.out.println("error en update ");
                           ex.printStackTrace();

                  }
                  return rowsAffected;
         }

         public static ResultSet returnResultset(String sql) {
                  Statement statement;
                  ResultSet resultSet = null;
                  try {
                           statement = connection.createStatement();
                           resultSet = statement.executeQuery(sql);
                  } catch (SQLException ex) {

                           java.util.logging.Logger.getLogger(control.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                           JOptionPane.showMessageDialog(null, ex.getMessage());
                  }

                  return resultSet;

         }

         public static void fillTable2(JTable tabla, String sql) {

                  try {

 
                           ResultSet resultSet = control.returnResultset(sql);

                           int cantidadFila = llenarEncabezadoTabla(tabla, resultSet);
                           DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                           limTable(modelo);
                           Object[] fila = new Object[cantidadFila];

                           while (resultSet.next()) {
                                    for (int i = 0; i < cantidadFila; i++) {

                                             fila[i] = resultSet.getString(i + 1);

                                    }

                                    modelo.addRow(fila);

                           }

                  } catch (Exception e) {
                           System.out.println(" error al llenar tabla 2");
                           e.printStackTrace();
                           JOptionPane.showMessageDialog(null, e.getMessage());
                  }
         }

         private static int llenarEncabezadoTabla(JTable tabla, ResultSet res) {
                  String[] cabecera;
                  ResultSetMetaData meta;
                  int cant = 0;
                  try {
                           meta = res.getMetaData();
                           cant = meta.getColumnCount();
                           cabecera = new String[cant];
                           int i = 0;

                           //bucle para obtener el nombre de las columnas de los registros
                           for (i = i; i < cant; i++) {
                                    cabecera[i] = meta.getColumnName(i + 1);
                           }

                           tabla.setModel(new DefaultTableModel(new Object[][]{}, cabecera) {
                                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                                             return false;
                                    }
                           });

                  } catch (SQLException ex) {
                           System.out.println("error al llenar el encabezado ");
                           ex.printStackTrace();
                           JOptionPane.showMessageDialog(null, ex.getMessage());
                  }

                  return cant;

         }


         public static JasperViewer showReport(String nombreR, HashMap parameters) {
                  try {
                           String rta = System.getProperties().getProperty("user.dir") + "/src/" + nombreR;
                           JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(rta);
                           JasperPrint jprint = JasperFillManager.fillReport(reporte, parameters, control.getConnetion());
                           if (jprint.getPages().size() != 0) {
                                    JasperViewer view = new JasperViewer(jprint, false);
                                    view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                                    view.setVisible(true);
                                    return view;
                           } else {
                                    JOptionPane.showMessageDialog(null, "no hay registros");
                                    return null;
                           }

                  } catch (JRException ex) {
                           ex.printStackTrace();
                           return null;
                  }
         }
         
}
