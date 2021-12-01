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
class panelopcionesnotas extends JPanel {
    
    public panelopcionesnotas(JFrame frame){
        JPanel estePanel=this;//este Jpanel es utilizado para referirse a si mismo
	this.setBackground(Color.WHITE);
	this.setLayout(null);
	setBounds(0, 0, 800, 700);
        
        JPanel opcionesn = new JPanel();
        opcionesn.setBackground(Color.WHITE);
	opcionesn.setBounds(0, 0, 800, 700);
        opcionesn.setLayout(null);
	add(opcionesn);
       
        
        JButton notas = new JButton("Ver notas por rut");
	notas.setBounds(300, 152, 161, 45);
        notas.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	opcionesn.add(notas);
        
        JButton notasnom = new JButton("Ver notas por nombre");
	notasnom.setBounds(300, 230, 161, 45);
        notasnom.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	opcionesn.add(notasnom);
        
        JButton asignatura= new JButton("Ver notas por asignatura");
	asignatura.setBounds(281, 308, 200, 45);
        asignatura.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	opcionesn.add(asignatura);
        
        JButton prom= new JButton("Ver promedio por rut");
	prom.setBounds(281, 386, 200, 45);
        prom.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	opcionesn.add(prom);
        
        JButton proma= new JButton("Ver promedio por asignatura");
	proma.setBounds(281, 464, 200, 45);
        proma.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	opcionesn.add(proma);
        
        JButton volver= new JButton("volver");
	volver.setBounds(50, 550, 161, 45);
        volver.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	opcionesn.add(volver);
        
        notas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                pnotasrut pap= new pnotasrut(frame);
                frame.setSize(800, 700);
                limpiarEscritorio(pap,frame);
            }
        });
        
        notasnom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
               pnotasnombre pap= new pnotasnombre(frame);
                frame.setSize(800, 700);
                limpiarEscritorio(pap,frame); 
            }
        });
        
        asignatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                pnotasasign pap= new pnotasasign(frame);
                frame.setSize(800, 700);
                limpiarEscritorio(pap,frame);
            }
        });
        
        prom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                pprom pap= new pprom(frame);
                frame.setSize(800, 700);
                limpiarEscritorio(pap,frame);
            }
        });
        
        proma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                proma pap= new proma(frame);
                frame.setSize(800, 700);
                limpiarEscritorio(pap,frame);
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
