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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author bodo
 */
class ingresoalumno extends JPanel {
    
    public ingresoalumno(JFrame frame){
        JPanel estePanel=this;//este Jpanel es utilizado para referirse a si mismo
	this.setBackground(Color.WHITE);
	this.setLayout(null);
	setBounds(0, 0, 800, 700);
        
        JPanel ingresoap= new JPanel();
        ingresoap.setBackground(Color.WHITE);
	ingresoap.setBounds(0, 0, 800, 700);
        ingresoap.setLayout(null);
	add(ingresoap);
        
        JButton ingresar= new JButton("Ingresar");
        ingresar.setBounds(300, 550, 161, 65);
        ingresar.setFont(new Font("Lucida Fax", Font.BOLD, 11));
        ingresoap.add(ingresar);
        
        
        JLabel irut= new JLabel("Ingrese el RUT");
        irut.setBounds(100, 50, 161, 45);
        irut.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        ingresoap.add(irut);
        JTextField trut=new JTextField();
        trut.setBounds(320, 60, 200, 25);
        ingresoap.add(trut);
        
        JLabel inombre= new JLabel("Ingrese el nombre");
        inombre.setBounds(100, 100, 161, 45);
        inombre.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        ingresoap.add(inombre);
        JTextField tnom=new JTextField();
        tnom.setBounds(320, 110, 200, 25);
        ingresoap.add(tnom);
        
        JLabel isn= new JLabel("Ingrese el segundo nombre");
        isn.setBounds(100, 150, 200, 45);
        isn.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        ingresoap.add(isn);
        JTextField tsn=new JTextField();
        tsn.setBounds(320, 160, 200, 25);
        ingresoap.add(tsn);
        
        JLabel iap= new JLabel("Ingrese apellido paterno");
        iap.setBounds(100, 200, 200, 45);
        iap.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        ingresoap.add(iap);
        JTextField tap=new JTextField();
        tap.setBounds(320, 210, 200, 25);
        ingresoap.add(tap);
        
        JLabel iam= new JLabel("Ingrese apellido materno");
        iam.setBounds(100, 250, 200, 45);
        iam.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        ingresoap.add(iam);
        JTextField tam=new JTextField();
        tam.setBounds(320, 260, 200, 25);
        ingresoap.add(tam);
        
        JLabel idir= new JLabel("Ingrese direccion");
        idir.setBounds(100, 300, 200, 45);
        idir.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        ingresoap.add(idir);
        JTextField tdir=new JTextField();
        tdir.setBounds(320, 310, 200, 25);
        ingresoap.add(tdir);
        
        JLabel isex= new JLabel("Ingrese el sexo");
        isex.setBounds(100, 350, 200, 45);
        isex.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        ingresoap.add(isex);
        JTextField tsex=new JTextField();
        tsex.setBounds(320, 360, 200, 25);
        ingresoap.add(tsex);
        
        JLabel ifnac= new JLabel("Ingrese fecha de nacimiento");
        ifnac.setBounds(100, 400, 200, 45);
        ifnac.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        ingresoap.add(ifnac);
        JTextField tfnac=new JTextField();
        tfnac.setBounds(320, 410, 200, 25);
        ingresoap.add(tfnac);
        
        JLabel ira= new JLabel("Ingrese Rut del apoderado:");
        ira.setBounds(100, 450, 200, 45);
        ira.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        ingresoap.add(ira);
        JTextField tira=new JTextField();
        tira.setBounds(320, 460, 200, 25);
        ingresoap.add(tira);
        
        JButton volver= new JButton("volver");
	volver.setBounds(50, 550, 161, 45);
        volver.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	ingresoap.add(volver);
        
        JPanel p = new JPanel();
        p.setBackground(new Color(72, 209, 204));
        p.setBounds(0, 0, 50, 700);
      	ingresoap.add(p);
        p.setLayout(null);
        
        JLabel l= new JLabel();
        l.setIcon(new ImageIcon("C:\\Users\\Faoc_\\Documents\\NetBeansProjects\\prueba2\\src\\imagenes\\azul.jpg"));
        l.setBounds(0, 0, 290, 700);
        p.add(l);
                
        JPanel p2 = new JPanel();
        p2.setBackground(new Color(72, 209, 204));
        p2.setBounds(530, 0, 350, 700);
      	ingresoap.add(p2);
        p2.setLayout(null);
        
        JLabel l2=new JLabel();
        l2.setIcon(new ImageIcon("C:\\Users\\Faoc_\\Documents\\NetBeansProjects\\prueba2\\src\\imagenes\\azul.jpg"));
        l2.setBounds(0, 0, 350, 700);
        p2.add(l2);
        
        
        ingresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rut=trut.getText();
                String nom=tnom.getText();
                String sn=tsn.getText();
                String ap=tap.getText();
                String am=tam.getText();
                String dir=tdir.getText();
                String fnac=tfnac.getText();
                String sex=tsex.getText();
                String rap=tira.getText();
                conexion con= new conexion();
                con.conectpsql();
                
                String insert1 ="insert into persona (rut, nombre, nombre_s, apellido_p, apellido_m,direccion,sexo,f_nac)"+
                " values" +
                "('"+rut+"','"+nom+"','"+sn+"','"+ap+"','"+am+"','"+dir+"','"+sex+"','"+fnac+"');";
                
                String insert2="insert into alumno(rut_alumno) values ('"+rut+"');";
                
                String insert3="insert into a_cargo(niño,apoderado,fecha_a_cargo) values "+
                        "('"+rut+"','"+rap+"','2021-03-01');";
                
                
                
                try {
                    con.insertaconsultadoble(insert1, insert2);//inreso de las consultas
                    con.insertaconsultasimple(insert3);
                } catch (SQLException ex) {
                    Logger.getLogger(ingresoalumno.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                trut.setText("");
                tnom.setText("");
                tsn.setText("");
                tap.setText("");
                tam.setText("");
                tdir.setText("");
                tfnac.setText("");
                tsex.setText("");
                tira.setText("");
                
            }
        });
        //boton para volver
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                admin admin=new admin(frame);
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
