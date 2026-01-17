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
public class DatoTipoProducto {
    private String id;
    private String descripcion;
    private Database database;
    
    public DatoTipoProducto() {
    id = " ";
    descripcion = " ";
    database = new Database();
    }

    public DatoTipoProducto(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.database = database ;
    }

    
    public static void main(String[] args) {
        DatoProducto producto = new DatoProducto();
        System.out.println(producto);
    }

}
