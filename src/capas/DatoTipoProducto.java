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
    
    public DatoTipoProducto() {}

    public DatoTipoProducto(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    // Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    // Convertir a array para Database (asumiendo que [id, descripcion])
    public Object[] toArray() {
        return new Object[]{id, descripcion};
    }

    // Crear desde array
    public static DatoTipoProducto fromArray(Object[] data) {
        if (data == null || data.length < 2) return null;
        return new DatoTipoProducto(data[0].toString(), data[1].toString());
    }

}
