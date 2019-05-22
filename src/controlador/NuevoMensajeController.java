/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.DAO.MensajeDAO;
import modelo.DAO.UsuarioDAO;
import modelo.Mensaje;
import modelo.Usuario;
import vista.NuevoMensaje;

/**
 *
 * @author Valentina Garcia
 */
public class NuevoMensajeController implements ActionListener {

    private NuevoMensaje vNuevoMensaje;

    public NuevoMensajeController(NuevoMensaje vNuevoMensaje) {
        this.vNuevoMensaje = vNuevoMensaje;
        UsuarioDAO uDAO = new UsuarioDAO();
        ArrayList<Usuario> usuariosBD = uDAO.getUsuarios();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (int i = 0; i < usuariosBD.size(); i++) {
            model.addElement(usuariosBD.get(i));
        }
        vNuevoMensaje.getDestinatarioCB().setModel(model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("enviar")) {
            MensajeDAO mDAO = new MensajeDAO();
            String contenido = vNuevoMensaje.getCuerpoMensajeTA().getText();
            int emisor = vNuevoMensaje.getIdUsuarioLogueado();
            Usuario receptor = (Usuario) vNuevoMensaje.getDestinatarioCB().getSelectedItem();
            Mensaje m = new Mensaje(0, emisor, receptor.getId_usuario(), contenido);
            if (mDAO.añadirMensaje(m)) {
                JOptionPane.showMessageDialog(vNuevoMensaje, "Mensaje enviado", "Enviar", JOptionPane.INFORMATION_MESSAGE);
            }
            vNuevoMensaje.dispose();
        }
    }
}
