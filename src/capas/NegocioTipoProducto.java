/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capas;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author valde
 */
public class NegocioTipoProducto {
  private List<String> lista;

    public NegocioTipoProducto() {
        lista = new ArrayList<>();
    }

    public void registrar(String descripcion) {
        lista.add(descripcion);
    }

    

  
  
    
}
