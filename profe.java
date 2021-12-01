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
class profe extends JPanel {
    
    public profe(JFrame frame){
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
        
        JButton notas = new JButton("Poner notas");
	notas.setBounds(300, 152, 161, 45);
        notas.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	opcionesap.add(notas);
        
        JButton notaciones = new JButton("Poner anotaciones");
	notaciones.setBounds(300, 230, 161, 45);
        notaciones.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	opcionesap.add(notaciones);
        
        JButton asistencia= new JButton("Poner asistencia");
	asistencia.setBounds(300, 308, 161, 45);
        asistencia.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	opcionesap.add(asistencia);
        
        JButton volver= new JButton("volver");
	volver.setBounds(50, 550, 161, 45);
        volver.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	opcionesap.add(volver);
        
        JPanel p = new JPanel();
        p.setBackground(new Color(72, 209, 204));
        p.setBounds(0, 0, 290, 700);
      	opcionesap.add(p);
        p.setLayout(null);
        
        JLabel l= new JLabel();
        l.setIcon(new ImageIcon("C:\\Users\\Faoc_\\Documents\\NetBeansProjects\\prueba2\\src\\imagenes\\colegio.jpg"));
        l.setBounds(0, 0, 290, 700);
        p.add(l);
                
        JPanel p2 = new JPanel();
        p2.setBackground(new Color(72, 209, 204));
        p2.setBounds(470, 0, 350, 700);
      	opcionesap.add(p2);
        p2.setLayout(null);
        
        JLabel l2=new JLabel();
        l2.setIcon(new ImageIcon("C:\\Users\\Faoc_\\Documents\\NetBeansProjects\\prueba2\\src\\imagenes\\azul.jpg"));
        l2.setBounds(0, 0, 350, 700);
        p2.add(l2);
        
        notas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel_poner_notas pn= new panel_poner_notas(frame);
                frame.setSize(800, 700);
                limpiarEscritorio(pn,frame);
            }
        });
        
        notaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel_poner_anotaciones pn= new  panel_poner_anotaciones(frame);
                frame.setSize(800, 700);
                limpiarEscritorio(pn,frame);
            }
        });
        
        asistencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel_poner_asistencia pn= new panel_poner_asistencia (frame);
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