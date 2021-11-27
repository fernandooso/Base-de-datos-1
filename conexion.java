
package prueba2;
import java.sql.*;
import javax.swing.JOptionPane;

public class conexion {

    static Connection conectar=null;
    static String BD="jdbc:postgresql://10.4.3.195:5432/colegio";
    static String usuario="colegio_dev";
    static String pass="aMgA5ka";
 
    public void conectpsql() {
        try {
            conectar =DriverManager.getConnection(BD,usuario,pass);
        } catch (Exception e) {
        }
    }   
    
    public void desconectar(){
        try {
            conectar.close();
        } catch (Exception e) {
        }
    }
            
    /////////////se podria hacer una pura funcion mandando el string insert como parametro en algunas, en las que solo se hace una
    ////////////consulta
    
    public void insertaconsultasimple(String insert) throws SQLException{
        Statement st=null;
        st= conectar.createStatement();
        st.executeUpdate(insert);
        st.close();
    }
    
    public void insertaconsultadoble(String insert1,String insert2) throws SQLException{
        Statement st=null;
        st= conectar.createStatement();
        st.executeUpdate(insert1);
        st.executeUpdate(insert2);
        st.close();
    }
    public void insertaconsultatriple(String insert1,String insert2,String insert3) throws SQLException{
        Statement st=null;
        st= conectar.createStatement();
        st.executeUpdate(insert1);
        st.executeUpdate(insert2);
        st.executeUpdate(insert3);
        st.close();
    }
}

