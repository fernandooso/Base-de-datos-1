/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba2;

import javax.swing.JFrame;
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
import javax.swing.JTextField;
/**
 *
 * @author bodo
 */
public class ingresoapoderado extends JPanel{

    public ingresoapoderado(JFrame frame) {
        
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
        
        JButton volver= new JButton("volver");
	volver.setBounds(50, 550, 161, 45);
        volver.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	ingresoap.add(volver);
        
        
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
