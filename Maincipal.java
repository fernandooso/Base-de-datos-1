
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
		//frame.getContentPane().setBackground(new Color(178, 34, 34));
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
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                //Scanner in = new Scanner(System.in);
        //new venatan().setVisible(true);
       //new frameprueba().setVisible(true);
       
        /*int op=1;
        menuprincipal unmenup= new menuprincipal();
        menuadmin unmenu = new menuadmin();
        menuprofe unmenupr=new menuprofe();
        menuprofeap unmenupap=new menuprofeap();
        
        while(op!=0){
            op=unmenup.principal();
            if(op==1){
                while(op!=0){
                    op=unmenu.admin();      
                        if(op==1){
                            unmenu.alumno();
                        }
                        if(op==2){
                            unmenu.apoderado();
                        }
                        if(op==3){
                            unmenu.profesor();
                    }
                }
            }
            if(op==2){
                while(op!=10){
                    op=unmenupr.profe();      
                        if(op==1){
                            unmenupr.ponernota();
                        }
                        if(op==2){
                            unmenupr.poneranotacion();
                        }
                        if(op==3){
                            unmenupr.ponerasistencia();
                    }
                }
            }
            if(op==3){
                while(op!=11){
                    op=unmenupap.profeap();      
                        if(op==1){
                            unmenupap.vernota();
                        }
                        if(op==2){
                            unmenupap.veranotacion();
                        }
                        if(op==3){
                            unmenupap.verasistencia();
                    }
                }
                
            }
        }*/
    }  

