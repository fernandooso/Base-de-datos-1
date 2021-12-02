
package prueba2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JFrame;


public class Maincipal extends JFrame {
    private JFrame frame;
    
    public static void main(String args[]) throws SQLException{
        
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Maincipal window = new Maincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
        
        public Maincipal() {
		initialize();
	}
                private void initialize(){
		frame = new JFrame();//frame donde estaran los diferentes paneles y dialogos
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
                frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
//agrega o quita paneles--------------------------------------------------------------------------------

                ventanaMenu menu=new ventanaMenu(frame);
		menu.setMinimumSize(new Dimension(1000, 10000));
		menu.setBounds(0, 0, 800, 700);
		frame.getContentPane().add(menu);
	}
        
    }  

