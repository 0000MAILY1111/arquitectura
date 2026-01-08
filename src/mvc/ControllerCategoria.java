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
public class ControllerCategoria {
     private ModelProducto model;
    private ViewProducto view ;
    

    public ControllerCategoria() {
        this.model = new ModelProducto ();
        this.view = new ViewProducto ();
    }
    
    public void showForm (){
        this.view.setVisible(true);
    }
    public void cargarTipoProducto (){
    
    }
}
