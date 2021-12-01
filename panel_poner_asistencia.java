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

public class panel_poner_asistencia extends JPanel {

	 public panel_poner_asistencia(JFrame frame) {
	        JPanel estePanel=this;//este Jpanel es utilizado para referirse a si mismo
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		setBounds(0, 0, 800, 700);
	        
		JPanel ponerasistencia = new JPanel();
		ponerasistencia.setBackground(Color.WHITE);
		ponerasistencia.setBounds(0, 0, 800, 700);
		ponerasistencia.setLayout(null);
	add(ponerasistencia);
     
	  JLabel irut= new JLabel("Ingrese el RUT del Alumno");
     irut.setBounds(100, 50, 380, 45);
     irut.setFont(new Font("Lucida Fax", Font.BOLD, 15));
     ponerasistencia.add(irut);
     JTextField rutal=new JTextField();
     rutal.setBounds(400, 60, 200, 25);
     ponerasistencia.add(rutal);
     
     JLabel codigoasig= new JLabel("Ingrese el codigo de la asignatura");
     codigoasig.setBounds(100, 100, 380, 45);
     codigoasig.setFont(new Font("Lucida Fax", Font.BOLD, 15));
     ponerasistencia.add(codigoasig);
     JTextField coda=new JTextField();
     coda.setBounds(400, 110, 200, 25);
     ponerasistencia.add(coda);
     
     JLabel jasis= new JLabel("Ingrese la asistencia");
     jasis.setBounds(100, 150, 200, 45);
     jasis.setFont(new Font("Lucida Fax", Font.BOLD, 15));
     ponerasistencia.add(jasis);
     JTextField Asis=new JTextField();
     Asis.setBounds(400, 160, 200, 25);
     ponerasistencia.add(Asis);
     
     JLabel Fecha= new JLabel("Ingrese la Fecha");
     Fecha.setBounds(100, 200, 200, 45);
     Fecha.setFont(new Font("Lucida Fax", Font.BOLD, 15));
     ponerasistencia.add(Fecha);
     JTextField Fechaa=new JTextField();
     Fechaa.setBounds(400, 210, 200, 25);
     ponerasistencia.add(Fechaa);
     
      JButton ingresar= new JButton("Ingresar Asistencia");
     ingresar.setBounds(300, 550, 161, 65);
     ingresar.setFont(new Font("Lucida Fax", Font.BOLD, 11));
     ponerasistencia.add(ingresar);
     
	        
	        JButton volver= new JButton("volver");
		volver.setBounds(50, 550, 161, 45);
	        volver.setFont(new Font("Lucida Fax", Font.BOLD, 11));
	        ponerasistencia.add(volver);
	        
	        JPanel p = new JPanel();
	        p.setBackground(new Color(72, 209, 204));
	        p.setBounds(0, 0, 50, 700);
	        ponerasistencia.add(p);
	        p.setLayout(null);

	        JLabel l= new JLabel();
	        l.setIcon(new ImageIcon("E:\\Desktop\\ope\\azul.jpg"));
	        l.setBounds(0, 0, 290, 700);
	        p.add(l);

	        JPanel p2 = new JPanel();
	        p2.setBackground(new Color(72, 209, 204));
	        p2.setBounds(530, 0, 350, 700);
	        ponerasistencia.add(p2);
	        p2.setLayout(null);

	        JLabel l2=new JLabel();
	        l2.setIcon(new ImageIcon("E:\\\\Desktop\\\\ope\\\\azul.jpg"));
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
	                String cln=coda.getText();
	                String asistencia=Asis.getText();
	                String fecha=Fechaa.getText();
	                conexion cone=new conexion();
	                cone.conectpsql();
	                
	                String insert="insert into asistencia(alumnoa,curso,asistencia,fecha)values"+
	                        " ('"+rut+"','"+cln+"','"+asistencia+"','"+fecha+";')";
	                try {
						cone.insertaconsultasimple(insert);
					} catch (SQLException e1) {
						// TODO Bloque catch generado autom·ticamente
						e1.printStackTrace();
					}
	                
	                cone.desconectar();
	            }
	        });   
	             
	    }
	      private void limpiarEscritorio(JPanel nuevoPanel,JFrame frame) {
		frame.getContentPane().removeAll();//remueve todo del panel
		frame.getContentPane().repaint();//lo re-dibuja
		frame.getContentPane().add(nuevoPanel);//a√±ade el nuevo panel al frame
		frame.getContentPane().validate();//valida los datos
	    }

}
