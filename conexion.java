/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba2;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author bodo
 */
public class conexion {

    static Connection conectar=null;
    static String BD="jdbc:postgresql://10.4.3.195:5432/colegio";
    static String usuario="colegio_dev";
    static String pass="aMgA5ka";
 
    public void conectpsql() {//conexion con el jdbc
        try {
            conectar =DriverManager.getConnection(BD,usuario,pass);
        } catch (Exception e) {
        }
    }   
    
    public void desconectar(){//metodo para desconectar
        try {
            conectar.close();
        } catch (Exception e) {
        }
    }
       
    public void insertaconsultasimple(String insert) throws SQLException{//inserta una consulta
        Statement st=null;
        st= conectar.createStatement();
        st.executeUpdate(insert);
        st.close();
    }
    
    public void insertaconsultadoble(String insert1,String insert2) throws SQLException{//inserta dos consultas
        Statement st=null;
        st= conectar.createStatement();
        st.executeUpdate(insert1);
        st.executeUpdate(insert2);
        st.close();
    }
    
    public void insertaconsultatriple(String insert1,String insert2,String insert3) throws SQLException{//inserta tres consultas
        Statement st=null;
        st= conectar.createStatement();
        st.executeUpdate(insert1);
        st.executeUpdate(insert2);
        st.executeUpdate(insert3);
        st.close();
    }
    
    public String consultapass(String consulta) throws SQLException{//metodo que realiza una consulta que recibe el password
        Statement st= conectar.createStatement();                   //desde la base de datos y lo retorna para comparar
        ResultSet rs;
        String respuesta="";
        try {
            rs=st.executeQuery(consulta);
            while(rs.next()){ 
               respuesta=(rs.getString("pass"));

           }
        } catch (Exception e) {
            
        }
        st.close();
        return respuesta;
    }
    
    public DefaultTableModel consultanr(String consulta){//metodo que recibe los datos de una consulta dada en este caso
       Statement st;                                    // de las notas de un alumno
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
     
        public double consultar(String consulta) throws SQLException{//metodo que obtiene el promedio y lo retorna
        Statement st= conectar.createStatement();
        ResultSet rs;
        double avg=0;
        try {
            rs=st.executeQuery(consulta);
            while(rs.next()){ 
                avg=(rs.getDouble("avg"));
           }
        } catch (Exception e) {
            
        }
        st.close();
        return avg;
    }   
        
    public DefaultTableModel consultaan(String consulta){//metodo que recibe los datos de una cosulta y crea la tabla en este caso anotaciones
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

    DefaultTableModel consultaas(String consult1) {//metodo que recibe los datos de una consulta y crea la tabla en este caso de asistencia
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

