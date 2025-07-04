/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capas;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author valde
 */
public class Database {
    private int primaryKey;
    private Map<String, Object[]> rows;
    
    public Database() {
        this.primaryKey = 0;
        this.rows = new HashMap<>();
    }
    
    /**
     * Almacena un registro en la base de datos
     * @param data Array de objetos que representa una fila
     * @return El registro almacenado con su clave primaria
     */
    public Object[] store(Object[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Los datos no pueden ser nulos o vacíos");
        }
        
        // Si la primera posición está vacía, asignar nueva clave primaria
        if (data[0] == null || data[0].toString().isEmpty()) {
            this.primaryKey++;
            data[0] = this.primaryKey;
        }
        
        // Almacenar la fila usando la clave primaria como key del Map
        String key = data[0].toString();
        this.rows.put(key, data.clone()); // Clonar para evitar modificaciones externas
        
        return data;
    }
    
    /**
     * Busca un registro por su clave primaria
     * @param key Clave primaria del registro
     * @return El registro encontrado o null si no existe
     */
    public Object[] find(String key) {
        return this.rows.get(key);
    }
    
    /**
     * Busca un registro por su clave primaria (versión con entero)
     * @param key Clave primaria del registro
     * @return El registro encontrado o null si no existe
     */
    public Object[] find(int key) {
        return find(String.valueOf(key));
    }
    
    /**
     * Actualiza un registro existente
     * @param key Clave primaria del registro a actualizar
     * @param data Nuevos datos del registro
     * @return true si se actualizó correctamente, false si no se encontró
     */
    public boolean update(String key, Object[] data) {
        if (this.rows.containsKey(key)) {
            // Mantener la clave primaria original
            data[0] = key;
            this.rows.put(key, data.clone());
            return true;
        }
        return false;
    }
    
    /**
     * Elimina un registro por su clave primaria
     * @param key Clave primaria del registro a eliminar
     * @return true si se eliminó correctamente, false si no se encontró
     */
    public boolean delete(String key) {
        return this.rows.remove(key) != null;
    }
    
    /**
     * Elimina un registro por su clave primaria (versión con entero)
     * @param key Clave primaria del registro a eliminar
     * @return true si se eliminó correctamente, false si no se encontró
     */
    public boolean delete(int key) {
        return delete(String.valueOf(key));
    }
    
    /**
     * Obtiene todos los registros
     * @return Lista con todos los registros
     */
    public List<Object[]> findAll() {
        return new ArrayList<>(this.rows.values());
    }
    
    /**
     * Obtiene el número total de registros
     * @return Cantidad de registros almacenados
     */
    public int size() {
        return this.rows.size();
    }
    
    /**
     * Verifica si la base de datos está vacía
     * @return true si está vacía, false en caso contrario
     */
    public boolean isEmpty() {
        return this.rows.isEmpty();
    }
    
    /**
     * Elimina todos los registros
     */
    public void clear() {
        this.rows.clear();
        this.primaryKey = 0;
    }
    
    /**
     * Verifica si existe un registro con la clave dada
     * @param key Clave primaria a verificar
     * @return true si existe, false en caso contrario
     */
    public boolean exists(String key) {
        return this.rows.containsKey(key);
    }
    
    /**
     * Obtiene la siguiente clave primaria que se asignaría
     * @return La próxima clave primaria
     */
    public int getNextPrimaryKey() {
        return this.primaryKey + 1;
    }
    
    /**
     * Representa la base de datos como String para depuración
     * @return Representación en String de todos los registros
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Database{");
        sb.append("primaryKey=").append(primaryKey);
        sb.append(", records=").append(this.rows.size());
        sb.append(", data=").append(this.rows);
        sb.append('}');
        return sb.toString();
    }
}