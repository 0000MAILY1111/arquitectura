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
        this.database = new Database();
        this.id = "";
        this.descripcion = "";
    }
}
