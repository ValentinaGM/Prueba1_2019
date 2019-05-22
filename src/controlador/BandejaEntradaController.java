/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.DAO.MensajeDAO;
import modelo.DAO.UsuarioDAO;
import modelo.Mensaje;
import modelo.Usuario;
import vista.BandejaEntrada;
import vista.NuevoMensaje;

/**
 *
 * @author Valentina Garcia
 */
public class BandejaEntradaController implements ActionListener {

    private BandejaEntrada vBandejaEntrada;

    public BandejaEntradaController(BandejaEntrada vBandejaEntrada) {
        this.vBandejaEntrada = vBandejaEntrada;
        DefaultTableModel d = (DefaultTableModel) vBandejaEntrada.getTabla().getModel();
        MensajeDAO mDAO = new MensajeDAO();
        UsuarioDAO uDAO = new UsuarioDAO();
        ArrayList<Mensaje> mensajesBD = mDAO.getMensajesUsuario(vBandejaEntrada.getIdUsuarioLogueado());
        for (int i = 0; i < mensajesBD.size(); i++) {
            Usuario emisor = uDAO.getUsuario(mensajesBD.get(i).getId_usr_emisor());
            Object[] mensaje = {emisor.getNombre(), mensajesBD.get(i).getContenido()};
            d.addRow(mensaje);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("nuevo")) {
            NuevoMensaje nuevo = new NuevoMensaje(vBandejaEntrada.getIdUsuarioLogueado());
            nuevo.setVisible(true);
        }
    }

}
