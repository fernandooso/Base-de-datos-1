/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author bodo
 */
class panelanotaciones extends JPanel {
    
    public panelanotaciones(JFrame frame){
        JPanel estePanel=this;//este Jpanel es utilizado para referirse a si mismo
	this.setBackground(Color.WHITE);
	this.setLayout(null);
	setBounds(0, 0, 800, 700);
        
        JPanel anotaciones = new JPanel();
        anotaciones.setBackground(Color.WHITE);
	anotaciones.setBounds(0, 0, 800, 700);
        anotaciones.setLayout(null);
	add(anotaciones);
        
        JLabel label= new JLabel("Ver anotaciones por RUT");
        label.setBounds(300, 30, 200, 20);
        label.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        anotaciones.add(label);
        
        
        JLabel irut= new JLabel("Ingrese el RUT");
        irut.setBounds(100, 50, 161, 45);
        irut.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        anotaciones.add(irut);
        JTextField trut=new JTextField();
        trut.setBounds(320, 60, 200, 25);
        anotaciones.add(trut);
        
        JTable tabla=new JTable();  
        tabla.setBounds(100, 200, 500, 300);
        conexion cone=new conexion();
        cone.conectpsql();
        String consult1="select * from cursa where estudiante=' ';";
        DefaultTableModel modelo=cone.consultaan(consult1);
        tabla.setModel(modelo);
        anotaciones.add(new JScrollPane(tabla),BorderLayout.CENTER);
        JScrollPane scrol=new JScrollPane(tabla);
        scrol.setBounds(50, 120, 700, 200);
        anotaciones.add(scrol);
        cone.desconectar();
        
        JButton volver= new JButton("volver");
	volver.setBounds(50, 550, 161, 45);
        volver.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	anotaciones.add(volver);
        
        JButton ingresar= new JButton("Buscar resultado");
        ingresar.setBounds(300, 550, 161, 65);
        ingresar.setFont(new Font("Lucida Fax", Font.BOLD, 11));
        anotaciones.add(ingresar);
        
        JPanel p = new JPanel();
        p.setBackground(new Color(72, 209, 204));
        p.setBounds(0, 0, 50, 700);
      	anotaciones.add(p);
        p.setLayout(null);
        
        JLabel l= new JLabel();
        l.setIcon(new ImageIcon("C:\\Users\\Faoc_\\Documents\\NetBeansProjects\\prueba2\\src\\imagenes\\azul.jpg"));
        l.setBounds(0, 0, 290, 700);
        p.add(l);
        
        
        ingresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rut=trut.getText();
                
                conexion cone=new conexion();
                cone.conectpsql();
                String consult1="select * from anotaciones where anotado='"+rut+"';";
                DefaultTableModel modelo=cone.consultaan(consult1);
                tabla.setModel(modelo);
                cone.desconectar();
            }
        }); 
        
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profeap pap= new profeap(frame);
                frame.setSize(800, 700);
                limpiarEscritorio(pap,frame);
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
