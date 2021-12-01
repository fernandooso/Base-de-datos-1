
package prueba2;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
    
    public void consultanotas(String consulta) throws SQLException{
        Statement st= conectar.createStatement();
        ResultSet rs;
        try {
            rs=st.executeQuery(consulta);
            while(rs.next()){ 
               System.out.println("alumno:"+rs.getString("estudiante"));
               System.out.println("asignatura:"+rs.getString("materia"));
               System.out.println("nota:"+rs.getString("notas"));
               System.out.println("");
           }
        } catch (Exception e) {
            System.out.println("no pasa na compa");
        }
        st.close();
    }
    
        public void consultasistencia(String consulta) throws SQLException{
        Statement st= conectar.createStatement();
        ResultSet rs;
        try {
            rs=st.executeQuery(consulta);
            while(rs.next()){ 
               System.out.println("alumno:"+rs.getString("alumnoa"));
               System.out.println("curso:"+rs.getString("curso"));
               System.out.println("asistencia:"+rs.getString("asistencia"));
               System.out.println("fecha:"+rs.getString("fecha"));
               System.out.println("");
           }
        } catch (Exception e) {
            System.out.println("no pasa na compa");
        }
                
        st.close();
    }
        public void consultanotaciones(String consulta) throws SQLException{
        Statement st= conectar.createStatement();
        ResultSet rs;
        try {
            rs=st.executeQuery(consulta);
            while(rs.next()){ 
               System.out.println("alumno:"+rs.getString("anotado"));
               System.out.println("profesor:"+rs.getString("anotante"));
               System.out.println("anotacion:"+rs.getString("comentario"));
               System.out.println("tipo:"+rs.getString("tipo"));
               System.out.println("fecha:"+rs.getString("fecha"));
               System.out.println("");
           }
        } catch (Exception e) {
            System.out.println("no pasa na compa");
        }
                
        st.close();
    }
        
    public DefaultTableModel consultanr(String consulta){
       Statement st;
       ResultSet rs;
       
       String []  nombresColumnas = {"Nombre","Materia","Notas"};
       String [] registros = new String[3];
       DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas); 
        try {
            st=conectar.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                registros[0] = rs.getString("estudiante");
                registros[1] = rs.getString("materia");  
                registros[2] = rs.getString("notas");
                modelo.addRow(registros);  
            }
        } catch (Exception e) {
        }
        return modelo;
    }   
    
       public DefaultTableModel consultan(String consulta){
       Statement st;
       ResultSet rs;
       
       String []  nombresColumnas = {"Nombre","Materia","Notas"};
       String [] registros = new String[3];
       DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas); 
        try {
            st=conectar.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                registros[0] = rs.getString("estudiante");
                registros[1] = rs.getString("materia");  
                registros[2] = rs.getString("notas");
                modelo.addRow(registros);  
            }
        } catch (Exception e) {
        }
        return modelo;
    }  
        
        public double consultar(String consulta) throws SQLException{
        Statement st= conectar.createStatement();
        ResultSet rs;
        double avg=0;
        try {
            rs=st.executeQuery(consulta);
            while(rs.next()){ 
                avg=(rs.getDouble("avg"));
           }
        } catch (Exception e) {
            System.out.println("no pasa na compa");
        }
        st.close();
        return avg;
    }   
        
    public DefaultTableModel consultaan(String consulta){
       Statement st;
       ResultSet rs;
       String []  nombresColumnas = {"Nombre","Profesor","Anotaciones","Tipo","Fecha"};
       String [] registros = new String[5];
       DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas); 
        try {
            st=conectar.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                registros[0] = rs.getString("anotado");
                registros[1] = rs.getString("anotante");  
                registros[2] = rs.getString("comentario");
                registros[3] = rs.getString("tipo");
                registros[4] = rs.getString("fecha");
                modelo.addRow(registros);  
            }
        } catch (Exception e) {
        }
        return modelo;
    }     

    DefaultTableModel consultaas(String consult1) {
       Statement st;
       ResultSet rs;
       String []  nombresColumnas = {"Nombre","Curso","Asistencia","Fecha"};
       String [] registros = new String[4];
       DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas); 
        try {
            st=conectar.createStatement();
            rs=st.executeQuery(consult1);
            while(rs.next()){
                registros[0] = rs.getString("alumnoa");
                registros[1] = rs.getString("curso");  
                registros[2] = rs.getString("asistencia");
                registros[3] = rs.getString("fecha");
                
                modelo.addRow(registros);  
            }
        } catch (Exception e) {
        }
        return modelo;
    }
     
    
 
       
        
}

