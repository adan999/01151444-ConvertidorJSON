package com.edu.mx.practica.uno.GUI;

import com.edu.mx.practica.uno.Convertidor.Convertidor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame {

    Convertidor convertidor = new Convertidor();
    private JTextArea ta1,ta2;
    private JButton b1;
    private  JComboBox cb1;
    public Interfaz() {
        //Tamaño
        this.setSize(790, 400);
        //Centrar el frame
        this.setLocationRelativeTo(null);
        //Terminar Proceso sl cerrar el Frame
        this.setDefaultCloseOperation(3);
        //Layout
        this.setLayout(null);
        //Ventana de un solo tamaño
        this.setResizable(false);

        //TextArea 1
        ta1 = new JTextArea();
        ta1.setSize(300, 250);
        ta1.setLocation(20, 50);
        ta1.setLineWrap(true);
        ta1.setWrapStyleWord(true);

        //TextArea 2
        ta2 = new JTextArea();
        ta2.setSize(300, 250);
        ta2.setLocation(450, 50);
        ta2.setLineWrap(true);
        ta2.setWrapStyleWord(true);
        ta2.setEditable(false);

        //ComboBox
        cb1 = new JComboBox();
        cb1.setSize(110, 30);
        cb1.setLocation(100, 320);
        cb1.addItem("XML");
        cb1.addItem("Java");

        //Boton
        b1 = new JButton("Convertir");
        b1.setLocation(335, 150);
        b1.setSize(100, 30);
        //Agregar Listener
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                int index = cb1.getSelectedIndex();
                String texto = ta1.getText();
                //Condicion para saber si hay informacion en el TextArea
                if(texto.trim().length() == 0){
                    JOptionPane.showMessageDialog(b1,"No hay Texto","Texto Vacio!!!",JOptionPane.WARNING_MESSAGE);
                }
                else{
                    switch(index){
                        case 0:
                            String xml = convertidor.convertirXmlToJson(texto);
                            ta2.setText(xml);
                            break;
                        case 1:
                            String clase = convertidor.convertirClaseToJson(texto);
                            ta2.setText(clase);
                            break;
                    }
                }
            }
        });

        //Agregar Componentes al Frame
        this.add(ta1);
        this.add(ta2);
        this.add(b1);
        this.add(cb1);
    }

    public static void main(String[] args) {
        //Instancia de la interfaz
        Interfaz i = new Interfaz();
        //Visibilidad del frame
        i.setVisible(true);
    }
}
