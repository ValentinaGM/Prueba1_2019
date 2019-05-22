/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author Valentina Garcia
 */
public class UsuarioDAO {
    Conexion con;

    public UsuarioDAO() {
        this.con = new Conexion();
    }

    public ArrayList<Usuario> getUsuarios() {

        ArrayList<Usuario> usuarios = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try {
            String sql = "SELECT * FROM usuario";

            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);

            while (resultados.next()) {
                int id_usuario = resultados.getInt("id_usuario");
                String nombre = resultados.getString("nombre");                
                usuarios.add(new Usuario(id_usuario, nombre));
            }
            
            return usuarios;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }

    }
    
     public Usuario getUsuario(int id) {

        
        Connection accesoBD = con.getConexion();
        Usuario usu = new Usuario();
        try {
            String sql = "SELECT * FROM usuario WHERE id_usuario=" + id;

            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);

            while (resultados.next()) {
                int id_usuario = resultados.getInt("id_usuario");
                String nombre = resultados.getString("nombre");                
                usu = new Usuario(id_usuario,nombre);
            }
            
            return usu;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }

    }
}
