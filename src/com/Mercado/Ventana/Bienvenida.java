package com.Mercado.Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.Mercado.Ventana.AdmEncargadoLocal;

public class Bienvenida {
    private JButton btnIniciar;
    private JPanel PanelBienvenida;
    private JPanel PanelFondo;
    private JLabel labelTituloBienvenida;

    public Bienvenida() {
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null,"Hola Aaron");
                JFrame frame = new JFrame("Administracion");
                frame.setContentPane(new AdmEncargadoLocal().getPanelAdmEmpFondo());
                //frame.setSize(500,500);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mercado Camacho");
        frame.setContentPane(new Bienvenida().PanelBienvenida);
        //frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
