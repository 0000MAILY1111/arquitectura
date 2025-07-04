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
public class ModelTipoProducto {
 private String id;
    private String descripcion;
    
    private Database database;
    
    public ModelTipoProducto() {
        this.database = new Database();
        this.id = "";
        this.descripcion = "";
    }
}
