package com.Mercado.Ventana;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdmEncargadoLocal {
    private JPanel PanelAdmEncarg;
    private JButton btnAdmEmp;
    private JButton btnAdmData;
    private JButton btnAdmInven;
    private JPanel PanelAdmEmpFondo;
    private JLabel labelTitulo;


    public AdmEncargadoLocal() {
        btnAdmEmp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //super.mouseClicked(e);
                //System.out.println("Hiciste click en "+e);
                /*
                JFrame frame = new JFrame("Administracion");
                frame.setContentPane(new AdmEncargadoLocal().getPanelAdmEmpFondo());
                frame.setSize(500,500);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                */
            }
        });
    }

    public JPanel getPanelAdmEncarg() {
        return PanelAdmEncarg;
    }

    public JButton getBtnAdmEmp() {
        return btnAdmEmp;
    }

    public JButton getBtnAdmData() {
        return btnAdmData;
    }

    public JButton getBtnAdmInven() {
        return btnAdmInven;
    }

    public JPanel getPanelAdmEmpFondo() {
        return PanelAdmEmpFondo;
    }

    public JLabel getLabelTitulo() {
        return labelTitulo;
    }
}
