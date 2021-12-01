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
class panelasistencia extends JPanel {
    public panelasistencia(JFrame frame){
        JPanel estePanel=this;//este Jpanel es utilizado para referirse a si mismo
	this.setBackground(Color.WHITE);
	this.setLayout(null);
	setBounds(0, 0, 800, 700);
        
        JPanel asistencia = new JPanel();
        asistencia.setBackground(Color.WHITE);
	asistencia.setBounds(0, 0, 800, 700);
        asistencia.setLayout(null);
	add(asistencia);
        
        JLabel label= new JLabel("Ver asistencia");
        label.setBounds(300, 30, 200, 20);
        label.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        asistencia.add(label);
        
        
        JLabel irut= new JLabel("Ingrese el RUT");
        irut.setBounds(100, 50, 161, 45);
        irut.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        asistencia.add(irut);
        JTextField trut=new JTextField();
        trut.setBounds(320, 60, 200, 25);
        asistencia.add(trut);
        
        JTable tabla=new JTable();  
        tabla.setBounds(100, 200, 500, 300);
        conexion cone=new conexion();
        cone.conectpsql();
        String consult1="select * from cursa where estudiante=' ';";
        DefaultTableModel modelo=cone.consultaas(consult1);
        tabla.setModel(modelo);
        asistencia.add(new JScrollPane(tabla),BorderLayout.CENTER);
        JScrollPane scrol=new JScrollPane(tabla);
        scrol.setBounds(50, 120, 700, 200);
        asistencia.add(scrol);
        cone.desconectar();
        
        
        JButton volver= new JButton("volver");
	volver.setBounds(50, 550, 161, 45);
        volver.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	asistencia.add(volver);
        
        JButton ingresar= new JButton("Buscar resultado");
        ingresar.setBounds(300, 550, 161, 65);
        ingresar.setFont(new Font("Lucida Fax", Font.BOLD, 11));
        asistencia.add(ingresar);
        
        
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profeap pap= new profeap(frame);
                frame.setSize(800, 700);
                limpiarEscritorio(pap,frame);
            }
        });
        
        ingresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rut=trut.getText();
                
                conexion cone=new conexion();
                cone.conectpsql();
                String consult1="select * from asistencia where alumnoa='"+rut+"';";
                DefaultTableModel modelo=cone.consultaas(consult1);
                tabla.setModel(modelo);
                cone.desconectar();
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
