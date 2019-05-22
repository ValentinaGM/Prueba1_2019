/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Marcelo Esperguel
 */
public class Mensaje {
    
    private int id_mensaje;
    private int id_usr_emisor;
    private int id_usr_receptor;
    private String contenido;

    public Mensaje(int id_mensaje, int id_usr_emisor, int id_usr_receptor, String contenido) {
        this.id_mensaje = id_mensaje;
        this.id_usr_emisor = id_usr_emisor;
        this.id_usr_receptor = id_usr_receptor;
        this.contenido = contenido;
    }

    public Mensaje() {
    }

    public int getId_mensaje() {
        return id_mensaje;
    }

    public void setId_mensaje(int id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public int getId_usr_emisor() {
        return id_usr_emisor;
    }

    public void setId_usr_emisor(int id_usr_emisor) {
        this.id_usr_emisor = id_usr_emisor;
    }

    public int getId_usr_receptor() {
        return id_usr_receptor;
    }

    public void setId_usr_receptor(int id_usr_receptor) {
        this.id_usr_receptor = id_usr_receptor;
    }    

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    
    
    
}
