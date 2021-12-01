/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba2;

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
import java.awt.Image;
import java.net.URL;
/**
 *
 * @author bodo
 */
class ventanaMenu extends JPanel{
    
    
    
    public ventanaMenu(JFrame frame){
        JPanel estePanel=this;//este Jpanel es utilizado para referirse a si mismo
	this.setBackground(Color.WHITE);
	this.setLayout(null);
	setBounds(0, 0, 800, 700);
       
        JPanel panelOpcionesMenu = new JPanel();
	panelOpcionesMenu.setBackground(Color.WHITE);
	panelOpcionesMenu.setBounds(0, 0, 800, 700);
	add(panelOpcionesMenu);
	panelOpcionesMenu.setLayout(null);
        
        JLabel pregunta=new JLabel("Como desea ingresar");
        pregunta.setBounds(300, 100, 161, 45);
        pregunta.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        panelOpcionesMenu.add(pregunta);
        
       
        JButton admin = new JButton("Admnistrador");
	admin.setBounds(300, 152, 161, 45);
        admin.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	panelOpcionesMenu.add(admin);
        
        JButton profe = new JButton("Profesor");
	profe.setBounds(300, 230, 161, 45);
        profe.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	panelOpcionesMenu.add(profe);
        
        JButton profeap= new JButton("Profesor-Apoderado");
	profeap.setBounds(300, 308, 161, 45);
        profeap.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	panelOpcionesMenu.add(profeap);
	
       JPanel p = new JPanel();
        p.setBackground(new Color(72, 209, 204));
        p.setBounds(0, 0, 290, 700);
      	panelOpcionesMenu.add(p);
        p.setLayout(null);
        
        JLabel l= new JLabel();
        l.setIcon(new ImageIcon("C:\\Users\\Faoc_\\Documents\\NetBeansProjects\\prueba2\\src\\imagenes\\colegio.jpg"));
        l.setBounds(0, 0, 290, 700);
        p.add(l);
                
        JPanel p2 = new JPanel();
        p2.setBackground(new Color(72, 209, 204));
        p2.setBounds(470, 0, 350, 700);
      	panelOpcionesMenu.add(p2);
        p2.setLayout(null);
        
        JLabel l2=new JLabel();
        l2.setIcon(new ImageIcon("C:\\Users\\Faoc_\\Documents\\NetBeansProjects\\prueba2\\src\\imagenes\\azul.jpg"));
        l2.setBounds(0, 0, 350, 700);
        p2.add(l2);
        
        
        admin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //ventana login
                //admin admin=new admin(frame);
                loginadmin admin=new loginadmin(frame);
                frame.setSize(800, 700);
                limpiarEscritorio(admin,frame);
            }
            
        });
        
        profeap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //profeap profe=new profeap(frame);
                
                loginprofe profe=new loginprofe(frame);
                frame.setSize(800,700);
                limpiarEscritorio(profe, frame);
            }
        });
        
        profe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                            loginprofeprofe profe=new loginprofeprofe(frame);
				  //profe profe=new profe(frame);
	                frame.setSize(800,700);
	                limpiarEscritorio(profe, frame);
	            
				
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
