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
class loginadmin extends JPanel {
    
    public loginadmin(JFrame frame){
        JPanel estePanel=this;//este Jpanel es utilizado para referirse a si mismo
	this.setBackground(Color.WHITE);
	this.setLayout(null);
	setBounds(0, 0, 800, 700);
        
        JPanel admin = new JPanel();
        admin.setBackground(Color.WHITE);
	admin.setBounds(0, 0, 800, 700);
        admin.setLayout(null);
	add(admin);
       
        
        JButton volver= new JButton("volver");
	volver.setBounds(300, 300, 161, 45);
        volver.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	admin.add(volver);
        
        JButton ingresar= new JButton("Ingresar");
        ingresar.setBounds(300, 210, 161, 65);
        ingresar.setFont(new Font("Lucida Fax", Font.BOLD, 11));
        admin.add(ingresar);
        
        JLabel irut= new JLabel("Ingrese usuario");
        irut.setBounds(320, 50, 161, 45);
        irut.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        admin.add(irut);
        
        JTextField tus=new JTextField();
        tus.setBounds(280, 90, 200, 25);
        admin.add(tus);
        
        JLabel inombre= new JLabel("Ingrese contraseña");
        inombre.setBounds(320, 130, 161, 45);
        inombre.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        admin.add(inombre);
        JPasswordField tpass=new JPasswordField();
        tpass.setBounds(280, 170, 200, 25);
        admin.add(tpass);
        
        JPanel p = new JPanel();
        p.setBackground(new Color(72, 209, 204));
        p.setBounds(0, 0, 290, 700);
      	admin.add(p);
        p.setLayout(null);
        
        JLabel l= new JLabel();
        l.setIcon(new ImageIcon("C:\\Users\\Faoc_\\Documents\\NetBeansProjects\\prueba2\\src\\imagenes\\colegio.jpg"));
        l.setBounds(0, 0, 290, 700);
        p.add(l);
                
        JPanel p2 = new JPanel();
        p2.setBackground(new Color(72, 209, 204));
        p2.setBounds(470, 0, 350, 700);
      	admin.add(p2);
        p2.setLayout(null);
        
        JLabel l2=new JLabel();
        l2.setIcon(new ImageIcon("C:\\Users\\Faoc_\\Documents\\NetBeansProjects\\prueba2\\src\\imagenes\\azul.jpg"));
        l2.setBounds(0, 0, 350, 700);
        p2.add(l2);
        
        JLabel login= new JLabel("Login Admin");
        login.setBounds(320, 20, 161, 45);
        login.setFont(new Font("Lucida Fax", Font.BOLD, 15));
        admin.add(login);
        
        ingresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                conexion con= new conexion();
                con.conectpsql();
                
                String user =tus.getText();
                String pass=String.valueOf(tpass.getPassword());
                
                String consulta="select pass from usardo where usuario='"+user+"';";
                String respuesta="";
                try {
                    respuesta=con.consultapass(consulta);
               
                } catch (SQLException ex) {
                    Logger.getLogger(loginadmin.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //System.out.println(respuesta);
             
                con.desconectar();
                if(user.equals("")){
                    JOptionPane.showMessageDialog(null,"Error usuario o contraseña incorrecto");
                }else{
                    if(pass.equals(respuesta)){
                        admin admin=new admin(frame);
                        frame.setSize(800, 700);
                        limpiarEscritorio(admin,frame);
                    }else{
                        tpass.setText("");
                        tus.setText("");
                        JOptionPane.showMessageDialog(null,"Error usuario o contraseña incorrecto");
                    }
                }
            }
            
        });
        
        
        
         volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                //volver al ventana
                ventanaMenu admin=new ventanaMenu(frame);
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
