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
class pnotasnombre extends JPanel{
    public pnotasnombre(JFrame frame){
        JPanel estePanel=this;//este Jpanel es utilizado para referirse a si mismo
	this.setBackground(Color.WHITE);
	this.setLayout(null);
	setBounds(0, 0, 800, 700);
        
        JPanel opcionesn = new JPanel();
        opcionesn.setBackground(Color.WHITE);
	opcionesn.setBounds(0, 0, 800, 700);
        opcionesn.setLayout(null);
	add(opcionesn);
        
        JTable tabla=new JTable();  
        tabla.setBounds(100, 200, 500, 300);
        conexion cone=new conexion();
        cone.conectpsql();
        String consult1="select * from cursa where estudiante=' ';";
        DefaultTableModel modelo=cone.consultanr(consult1);
        tabla.setModel(modelo);
        opcionesn.add(new JScrollPane(tabla),BorderLayout.CENTER);
        JScrollPane scrol=new JScrollPane(tabla);
        scrol.setBounds(100, 200, 500, 200);
        opcionesn.add(scrol);
        cone.desconectar();
        
        
        
        JLabel label= new JLabel("Ver notas por nombre");
        label.setBounds(300, 30, 200, 20);
        label.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        opcionesn.add(label);
        
        JLabel inom= new JLabel("Ingrese el nombre");
        inom.setBounds(100, 50, 161, 45);
        inom.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        opcionesn.add(inom);
        JTextField tnom=new JTextField();
        tnom.setBounds(320, 60, 200, 25);
        opcionesn.add(tnom);
        
        JLabel iap= new JLabel("Ingrese apellido paterno");
        iap.setBounds(100, 100, 200, 45);
        iap.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        opcionesn.add(iap);
        JTextField tiap=new JTextField();
        tiap.setBounds(320, 110, 200, 25);
        opcionesn.add(tiap);
        
        JLabel iam= new JLabel("Ingrese apellido paterno");
        iam.setBounds(100, 150, 200, 45);
        iam.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        opcionesn.add(iam);
        JTextField tiam=new JTextField();
        tiam.setBounds(320, 160, 200, 25);
        opcionesn.add(tiam);
        
        JButton volver= new JButton("volver");
	volver.setBounds(50, 550, 161, 45);
        volver.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	opcionesn.add(volver);
        
        JButton ingresar= new JButton("Buscar resultado");
        ingresar.setBounds(300, 550, 161, 65);
        ingresar.setFont(new Font("Lucida Fax", Font.BOLD, 11));
        opcionesn.add(ingresar);
        
        ingresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre=tnom.getText();
                String ap=tiap.getText();
                String am=tiam.getText();
                
                conexion cone=new conexion();
                cone.conectpsql();
                String consult1="select * from cursa where estudiante="+
                        "(select rut from persona where nombre="+""
                        + "'"+nombre+"' and apellido_p='"+ap+"' and apellido_m='"+am+"');";
                DefaultTableModel modelo=cone.consultanr(consult1);
                tabla.setModel(modelo);
                cone.desconectar();
            }
        }); 
        
 volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelopcionesnotas pap= new panelopcionesnotas(frame);
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
