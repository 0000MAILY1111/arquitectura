/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

/**
 *
 * @author valde
 */
public class ControllerProducto {
    private ModelProducto model;
    private ViewProducto view ;
    
    private ModelTipoProducto tipoProductModel;

    public ControllerProducto() {
        this.model = new ModelProducto ();
        this.view = new ViewProducto ();
        this.tipoProductModel = new ModelTipoProducto ();
    }
    
    public void showForm (){
        this.view.setVisible(true);
    }
    public void cargarTipoProducto (){
       
    }
}
