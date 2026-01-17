/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capas;

/**
 *
 * @author valde
 */
public class DatoProducto {
    private String id;
    private String codigo;
    private String nombre;
    private double precio;
    
    private String tipo_producto_id;
    
    private Database database;

    public DatoProducto() {
        this.id = " ";
        this.codigo = " ";
        this.nombre = " ";
        this.precio = 0;
        this.tipo_producto_id = " ";
        this.database = new Database ();
    }
   
    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Precio: $" + precio;
    }

    // ✅ MAIN PARA PRUEBAS
    public static void main(String[] args) {
        DatoProducto producto = new DatoProducto();
        System.out.println(producto);
    }
    
}
