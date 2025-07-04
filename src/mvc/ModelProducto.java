/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import capas.Database;

/**
 *
 * @author valde
 */
public class ModelProducto {
     private String id;
    private String codigo;
    private String nombre;
    private double precio;
    
    private String tipo_producto_id;
    
    private Database database;

    public ModelProducto() {
        this.id = " ";
        this.codigo = " ";
        this.nombre = " ";
        this.precio = 0;
        this.tipo_producto_id = " ";
        this.database = new Database ();
    }
    
}
