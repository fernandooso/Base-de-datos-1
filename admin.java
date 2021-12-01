/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba2;

import javax.swing.JPanel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Font;
/**
 *
 * @author bodo
 */
public class admin extends JPanel{
    
    
    public admin(JFrame frame){
        JPanel estePanel=this;//este Jpanel es utilizado para referirse a si mismo
	this.setBackground(Color.WHITE);
	this.setLayout(null);
	setBounds(0, 0, 800, 700);
        
        
        JPanel opcionesadmin = new JPanel();
        opcionesadmin.setBackground(Color.WHITE);
	opcionesadmin.setBounds(0, 0, 800, 700);
        opcionesadmin.setLayout(null);
	add(opcionesadmin);
	
        
        JLabel label= new JLabel("Que desea agregar");
        label.setBounds(300, 100, 200, 20);
        label.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        opcionesadmin.add(label);
        
        JButton apoderado = new JButton("Apoderado");
	apoderado.setBounds(300, 152, 161, 45);
        apoderado.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	opcionesadmin.add(apoderado);
        
        JButton alumno = new JButton("Alumno");
	alumno.setBounds(300, 230, 161, 45);
        alumno.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	opcionesadmin.add(alumno);
        
        JButton profe= new JButton("Profesor");
	profe.setBounds(300, 308, 161, 45);
        profe.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	opcionesadmin.add(profe);
        
        JButton volver= new JButton("volver");
	volver.setBounds(50, 550, 161, 45);
        volver.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	opcionesadmin.add(volver);
        
        JPanel p = new JPanel();
        p.setBackground(new Color(72, 209, 204));
        p.setBounds(0, 0, 290, 700);
      	opcionesadmin.add(p);
        p.setLayout(null);
        
        JLabel l= new JLabel();
        l.setIcon(new ImageIcon("C:\\Users\\Faoc_\\Documents\\NetBeansProjects\\prueba2\\src\\imagenes\\colegio.jpg"));
        l.setBounds(0, 0, 290, 700);
        p.add(l);
                
        JPanel p2 = new JPanel();
        p2.setBackground(new Color(72, 209, 204));
        p2.setBounds(470, 0, 350, 700);
      	opcionesadmin.add(p2);
        p2.setLayout(null);
        
        JLabel l2=new JLabel();
        l2.setIcon(new ImageIcon("C:\\Users\\Faoc_\\Documents\\NetBeansProjects\\prueba2\\src\\imagenes\\azul.jpg"));
        l2.setBounds(0, 0, 350, 700);
        p2.add(l2);
        
        
        
        
        apoderado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               ingresoapoderado pia = new ingresoapoderado(frame);
               frame.setSize(800,700);
               limpiarEscritorio(pia, frame);
            }
        });
        
        alumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingresoalumno pial= new ingresoalumno(frame);
                frame.setSize(800, 700);
                limpiarEscritorio(pial, frame);
            }
        });
        
        
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                //volver al ventana
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
