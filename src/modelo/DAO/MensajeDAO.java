/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Mensaje;

/**
 *
 * @author Valentina Garcia
 */
public class MensajeDAO {

    Conexion con;

    public MensajeDAO() {
        this.con = new Conexion();
    }
    
    public boolean añadirMensaje(Mensaje m) {
        boolean respuesta = false;
        Connection accesoBD = con.getConexion();
        try {
            Statement st = accesoBD.createStatement();
            String sql = "INSERT INTO mensaje VALUES (NULL, '" + m.getContenido() + "', '" + m.getId_usr_emisor()+ "' , '" + m.getId_usr_receptor()+ "' ); ";
            st.executeUpdate(sql);
            respuesta = true;
        } catch (SQLException e) {
           System.out.println();
           System.out.println("Error al obtener");
           e.printStackTrace();            
        } finally {
            return respuesta;
        }
    }

    public ArrayList<Mensaje> getMensajesUsuario(int id) {

        ArrayList<Mensaje> mensajes = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try {
            String sql = "SELECT * FROM mensaje WHERE id_usr_receptor=" + id;

            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);

            while (resultados.next()) {
                int id_mensaje = resultados.getInt("id_mensaje");
                String contenido = resultados.getString("contenido");
                int id_usr_emisor = resultados.getInt("id_usr_emisor");
                int id_usr_receptor = resultados.getInt("id_usr_receptor");
                mensajes.add(new Mensaje(id_mensaje, id_usr_emisor, id_usr_receptor, contenido));
            }
            
            return mensajes;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }

    }
}
