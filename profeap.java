/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba2;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author bodo
 */
class profeap extends JPanel {
    
    public profeap(JFrame frame){
        JPanel estePanel=this;//este Jpanel es utilizado para referirse a si mismo
	this.setBackground(Color.WHITE);
	this.setLayout(null);
	setBounds(0, 0, 800, 700);
        
        JPanel opcionesap = new JPanel();
        opcionesap.setBackground(Color.WHITE);
	opcionesap.setBounds(0, 0, 800, 700);
        opcionesap.setLayout(null);
	add(opcionesap);
        
        
        JLabel label= new JLabel("Que desea hacer");
        label.setBounds(300, 100, 200, 20);
        label.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        opcionesap.add(label);
        
        JButton notas = new JButton("Ver notas");
	notas.setBounds(300, 152, 161, 45);
        notas.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	opcionesap.add(notas);
        
        JButton notaciones = new JButton("Ver anotaciones");
	notaciones.setBounds(300, 230, 161, 45);
        notaciones.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	opcionesap.add(notaciones);
        
        JButton asistencia= new JButton("Ver asistencia");
	asistencia.setBounds(300, 308, 161, 45);
        asistencia.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	opcionesap.add(asistencia);
        
        JButton volver= new JButton("volver");
	volver.setBounds(50, 550, 161, 45);
        volver.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	opcionesap.add(volver);
        
        notas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelopcionesnotas pn= new panelopcionesnotas(frame);
                frame.setSize(800, 700);
                limpiarEscritorio(pn,frame);
            }
        });
        
        notaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelanotaciones pn= new panelanotaciones(frame);
                frame.setSize(800, 700);
                limpiarEscritorio(pn,frame);
            }
        });
        
        asistencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelasistencia pn= new panelasistencia(frame);
                frame.setSize(800, 700);
                limpiarEscritorio(pn,frame);
            }
        });
        
        
         volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaMenu admin=new ventanaMenu(frame);
                frame.setSize(800, 700);
                limpiarEscritorio(admin,frame);
            }
        });
        
        
    }
    private void limpiarEscritorio(JPanel nuevoPanel,JFrame frame) {
	frame.getContentPane().removeAll();//remueve todo del panel
	frame.getContentPane().repaint();//lo re-dibuja
	frame.getContentPane().add(nuevoPanel);//añade el nuevo panel al frame
	frame.getContentPane().validate();//valida los datos
    }
    
}
