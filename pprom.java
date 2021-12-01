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
class pprom extends JPanel {
    public pprom (JFrame frame){
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
        scrol.setBounds(100, 120, 500, 200);
        opcionesn.add(scrol);
        cone.desconectar();
        
        
        
        
        JLabel label= new JLabel("Ver promedio por RUT");
        label.setBounds(300, 30, 200, 20);
        label.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        opcionesn.add(label);
        
        JLabel label2= new JLabel("El promedio es:");
        label2.setBounds(250, 400, 200, 20);
        label2.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        opcionesn.add(label2);
        
        JLabel label3= new JLabel();
        label3.setBounds(400, 400, 200, 20);
        label3.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        opcionesn.add(label3);
        
        JButton volver= new JButton("volver");
	volver.setBounds(50, 550, 161, 45);
        volver.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	opcionesn.add(volver);
        
        JLabel inom= new JLabel("Ingrese el rut");
        inom.setBounds(100, 50, 161, 45);
        inom.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        opcionesn.add(inom);
        JTextField trut=new JTextField();
        trut.setBounds(320, 60, 200, 25);
        opcionesn.add(trut);
        
        
        
        JButton ingresar= new JButton("Buscar resultado");
        ingresar.setBounds(300, 550, 161, 65);
        ingresar.setFont(new Font("Lucida Fax", Font.BOLD, 11));
        opcionesn.add(ingresar);
        
        
        ingresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rut=trut.getText();
                conexion cone=new conexion();
                cone.conectpsql();
                String consult1="select * from cursa where estudiante='"+rut+"';";
                String consulta2="select avg(notas) from cursa where estudiante='"+rut+"';";
                DefaultTableModel modelo=cone.consultanr(consult1);
                double avg=0;
                try {
                    avg=cone.consultar(consulta2);
                } catch (SQLException ex) {
                    Logger.getLogger(pprom.class.getName()).log(Level.SEVERE, null, ex);
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
