package prueba2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class panel_poner_anotaciones extends JPanel {

	 public panel_poner_anotaciones(JFrame frame) {
		 
		
	        JPanel estePanel=this;//este Jpanel es utilizado para referirse a si mismo
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		setBounds(0, 0, 800, 700);
	        
		JPanel poneranotacion = new JPanel();
		poneranotacion.setBackground(Color.WHITE);
		poneranotacion.setBounds(0, 0, 800, 700);
		poneranotacion.setLayout(null);
	    add(poneranotacion);
     
		  JLabel a_rut= new JLabel("Ingrese el RUT del Alumno");
		  a_rut.setBounds(100, 50, 380, 45);
		  a_rut.setFont(new Font("Lucida Fax", Font.BOLD, 15));
	     poneranotacion.add(a_rut);
	     JTextField rutal=new JTextField();
	     rutal.setBounds(400, 60, 200, 25);
	     poneranotacion.add(rutal);
	     
	     JLabel rut_p= new JLabel("Ingrese el RUT del Profesor");
	     rut_p.setBounds(100, 100, 380, 45);
	     rut_p.setFont(new Font("Lucida Fax", Font.BOLD, 15));
	     poneranotacion.add(rut_p);
	     JTextField p_rut=new JTextField();
	     p_rut.setBounds(400, 110, 200, 25);
	     poneranotacion.add(p_rut);
	     
	     JLabel Janota= new JLabel("Ingrese la Anotacion");
	     Janota.setBounds(100, 150, 200, 45);
	     Janota.setFont(new Font("Lucida Fax", Font.BOLD, 15));
	     poneranotacion.add(Janota);
	     JTextField anota=new JTextField();
	     anota.setBounds(400, 160, 200, 25);
	     poneranotacion.add(anota);
	     
	     JLabel T_anotacion= new JLabel("Ingrese el tipo de anotacion");
	     T_anotacion.setBounds(100, 200, 200, 45);
	     T_anotacion.setFont(new Font("Lucida Fax", Font.BOLD, 15));
	     poneranotacion.add(T_anotacion);
	     JTextField tipo_a=new JTextField();
	     tipo_a.setBounds(400, 210, 200, 25);
	     poneranotacion.add(tipo_a);
	     
	     JLabel Fecha= new JLabel("Ingrese la Fecha");
	     Fecha.setBounds(100, 250, 200, 45);
	     Fecha.setFont(new Font("Lucida Fax", Font.BOLD, 15));
	     poneranotacion.add(Fecha);
	     JTextField Fechaa=new JTextField();
	     Fechaa.setBounds(400, 260, 200, 25);
	     poneranotacion.add(Fechaa);
	     
	      JButton ingresar= new JButton("Ingresar anotacion");
	     ingresar.setBounds(300, 550, 161, 65);
	     ingresar.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	     poneranotacion.add(ingresar);
	        
	      JButton volver= new JButton("volver");
		  volver.setBounds(50, 550, 161, 45);
	       volver.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	       poneranotacion.add(volver);
	        
	       JPanel p = new JPanel();
	        p.setBackground(new Color(72, 209, 204));
	        p.setBounds(0, 0, 50, 700);
	        poneranotacion.add(p);
	        p.setLayout(null);

	        JLabel l= new JLabel();
	        l.setIcon(new ImageIcon("C:\\Users\\Faoc_\\Documents\\NetBeansProjects\\prueba2\\src\\imagenes\\azul.jpg"));
	        l.setBounds(0, 0, 290, 700);
	        p.add(l);

	        JPanel p2 = new JPanel();
	        p2.setBackground(new Color(72, 209, 204));
	        p2.setBounds(530, 0, 350, 700);
	        poneranotacion.add(p2);
	        p2.setLayout(null);

	        JLabel l2=new JLabel();
	        l2.setIcon(new ImageIcon("C:\\Users\\Faoc_\\Documents\\NetBeansProjects\\prueba2\\src\\imagenes\\azul.jpg"));
	        l2.setBounds(0, 0, 350, 700);
	        p2.add(l2);
		 
	        
	        volver.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	profe pap= new profe(frame);
	                frame.setSize(800, 700);
	                limpiarEscritorio(pap,frame);
	            }
	        });
	          
	        ingresar.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String rut=rutal.getText();
	                String rutpr=p_rut.getText();
	                String anotacion=anota.getText();
	                String tipo=tipo_a.getText();
	                String fecha=Fechaa.getText();
	                conexion cone=new conexion();
	                cone.conectpsql();
	                String insert="insert into anotaciones(anotado,anotante,comentario,tipo,fecha) values"+
	                        "('"+rut+"','"+rutpr+"','"+anotacion+"','"+tipo+"','"+fecha+"');";
	                        try {
								cone.insertaconsultasimple(insert);
							} catch (SQLException e1) {
								// TODO Bloque catch generado autom�ticamente
								e1.printStackTrace();
							}
	                cone.desconectar();
                        rutal.setText("");
	                p_rut.setText("");
	                anota.setText("");
	                tipo_a.setText("");
	                Fechaa.setText("");
	                
                        
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
