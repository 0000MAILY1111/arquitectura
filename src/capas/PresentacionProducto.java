/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capas;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author valde
 */
public class PresentacionProducto extends javax.swing.JFrame {
    private NegocioProducto negocio;
    private NegocioTipoProducto negocioTipoProducto;
    /**
     * Creates new form PresentacionProducto
     */
    public PresentacionProducto() {
        initComponents();
        // Inicializar negocio para evitar NullPointerException al guardar
        negocio = new NegocioProducto();
        // Limpiar campos de texto
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
    }
    
    private void guardar(){
        Map<String, Object> data = leerDatos();
        negocio.cargarDatos(data);
    }
    private void cargarTipoProducto (Object[] tipoProductos){
        if (tipoProductos == null) return;
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(tipoProductos));
    }
    public void setNegocioTipoProducto(NegocioTipoProducto negocioTipoProducto) {
        this.negocioTipoProducto = negocioTipoProducto;
        // Si negocioTipoProducto puede listar tipos, podemos cargar aquí:
        // Object[] tipos = negocioTipoProducto.listarTipos().toArray();
        // cargarTipoProducto(tipos);
    }
    private Map<String, Object> leerDatos() {
        Map<String, Object> data = new HashMap<>();

    String id = jTextField1.getText().trim();
    String nombre = jTextField2.getText().trim();
    String codigo = jTextField3.getText().trim();
    String precioStr = jTextField4.getText().trim();
    Object tipoProducto = jComboBox1.getSelectedItem(); // Puede ser String o un objeto si usas modelos personalizados

    // Validaciones
    if (nombre.isEmpty() || codigo.isEmpty() || precioStr.isEmpty()) {
        throw new IllegalArgumentException("Nombre, Código y Precio son obligatorios");
    }

    // Validar número
    try {
        Double.parseDouble(precioStr);
    } catch (NumberFormatException e) {
        throw new IllegalArgumentException("El precio debe ser un número válido");
    }

    // Guardar en mapa
    data.put("id", id);
    data.put("nombre", nombre);
    data.put("codigo", codigo);
    data.put("precio", precioStr); // o Double.parseDouble(precioStr) si tu negocio espera Double
    data.put("tipoProducto", tipoProducto);

        return data;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Limpiar campos para nuevo registro
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jComboBox1.setSelectedIndex(0);
        jTextField2.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if (negocio == null) {
                negocio = new NegocioProducto(); // por seguridad, inicializar si es null
            }
            guardar();
            JOptionPane.showMessageDialog(this, "Guardado con éxito");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            List<?> productos = negocio.listar(); // Asume que NegocioProducto tiene listar()
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Nombre");
            model.addColumn("Código");
            model.addColumn("Precio");
            model.addColumn("Tipo Producto");
            
            for (Object producto : productos) {
                // Ajusta según la estructura de tu clase Producto
                // model.addRow(new Object[]{...});
            }
            jTable1.setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al listar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
