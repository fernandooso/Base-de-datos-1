
package prueba2;

import java.sql.SQLException;
import java.util.Scanner;
public class Main {
    
    public static void main(String args[]) throws SQLException {
        Scanner in = new Scanner(System.in);
        
        int op=1;
        menuprincipal unmenup= new menuprincipal();
        menuadmin unmenu = new menuadmin();
        menuprofe unmenupr=new menuprofe();
        
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
                while(op!=0){
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
                /*while(op!=0){
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
                }*/
                
            }
        }
    }  
}
