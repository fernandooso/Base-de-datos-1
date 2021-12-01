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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bodo
 */
class proma extends JPanel{
    public proma(JFrame frame){
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
        
        
        
        JLabel label= new JLabel("Ver promedio por asignatura");
        label.setBounds(300, 30, 250, 20);
        label.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        opcionesn.add(label);
        
        JLabel label2= new JLabel("El promedio es:");
        label2.setBounds(250, 410, 200, 20);
        label2.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        opcionesn.add(label2);
        
        JLabel label3= new JLabel();
        label3.setBounds(400, 410, 200, 20);
        label3.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        opcionesn.add(label3);
        
   
        
        JButton volver= new JButton("volver");
	volver.setBounds(50, 550, 161, 45);
        volver.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	opcionesn.add(volver);
        
        JButton ingresar= new JButton("Buscar resultado");
        ingresar.setBounds(300, 550, 161, 65);
        ingresar.setFont(new Font("Lucida Fax", Font.BOLD, 11));
        opcionesn.add(ingresar);
        
        JLabel irut= new JLabel("Ingrese el RUT");
        irut.setBounds(100, 50, 161, 45);
        irut.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        opcionesn.add(irut);
        JTextField trut=new JTextField();
        trut.setBounds(320, 60, 200, 25);
        opcionesn.add(trut);
        
        JLabel iasig= new JLabel("Ingrese el codas");
        iasig.setBounds(100, 100, 161, 45);
        iasig.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        opcionesn.add(iasig);
        JTextField tasig=new JTextField();
        tasig.setBounds(320, 110, 200, 25);
        opcionesn.add(tasig);
        
        JPanel p = new JPanel();
        p.setBackground(new Color(72, 209, 204));
        p.setBounds(0, 0, 50, 700);
      	opcionesn.add(p);
        p.setLayout(null);
        
        JLabel l= new JLabel();
        l.setIcon(new ImageIcon("C:\\Users\\Faoc_\\Documents\\NetBeansProjects\\prueba2\\src\\imagenes\\azul.jpg"));
        l.setBounds(0, 0, 290, 700);
        p.add(l);
        
        
        JPanel p2 = new JPanel();
        p2.setBackground(new Color(72, 209, 204));
        p2.setBounds(610, 0, 350, 700);
      	opcionesn.add(p2);
        p2.setLayout(null);
        
        JLabel l2=new JLabel();
        l2.setIcon(new ImageIcon("C:\\Users\\Faoc_\\Documents\\NetBeansProjects\\prueba2\\src\\imagenes\\azul.jpg"));
        l2.setBounds(0, 0, 350, 700);
        p2.add(l2);
        
        ingresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codas=tasig.getText();
                String rut=trut.getText();
                
                conexion cone=new conexion();
                cone.conectpsql();
                String consult1="select * from cursa where estudiante='"+rut+"' and materia='"+codas+"';";
                DefaultTableModel modelo=cone.consultanr(consult1);
                String consulta2="select avg(notas) from cursa where estudiante='"+rut+"' and materia='"+codas+"';";
                double avg=0;
                try {
                    avg=cone.consultar(consulta2);
                } catch (SQLException ex) {
                    Logger.getLogger(proma.class.getName()).log(Level.SEVERE, null, ex);
                }
                String uwu = String.valueOf(avg);
                label3.setText(uwu);
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
