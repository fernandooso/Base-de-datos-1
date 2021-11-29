/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba2;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author bodo
 */
public class menuprofeap {
    
     public int profeap() {
        Scanner in = new Scanner(System.in);
        System.out.println("que desea agregar");
        System.out.println("1-ver nota: ");
        ///sacar promedio
        System.out.println("2-ver anotacion");
        System.out.println("3-ver asistencia");
        System.out.println("11-salir");
        int op = in.nextInt();
        return op;   
    }
     
     public void vernota() throws SQLException{
         Scanner in = new Scanner(System.in);
         System.out.println("ingrese el rut del alumno: ");
         String rutal= in.nextLine();
         System.out.println("ingrese codigo de asignatura: ");
         String codas=in.nextLine(); 
        conexion con= new conexion();
        con.conectpsql();
        String consulta="select * from cursa where estudiante='"+rutal+"' and materia='"+codas+"';";
        con.consultanotas(consulta);
        con.desconectar();
        
     }
     
     public void veranotacion() throws SQLException{
         Scanner in = new Scanner(System.in);
         System.out.println("ingrese el rut del alumno: ");
         String rutal= in.nextLine();
         conexion con= new conexion();
        con.conectpsql();
        String consulta="select * from anotaciones where anotado='"+rutal+"';";
        con.consultanotaciones(consulta);
        con.desconectar();
     }
    
    public void verasistencia() throws SQLException{
        Scanner in = new Scanner(System.in);
        System.out.println("ingrese el rut del alumno: ");
        String rutal= in.nextLine();
        conexion con= new conexion();
        con.conectpsql();
        String consulta="select * from asistencia where alumnoa='"+rutal+"';";
        con.consultasistencia(consulta);
        con.desconectar();
        
     }
     
     
}
