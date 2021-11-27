/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba2;

import java.util.Scanner;
import java.sql.SQLException;
/**
 *
 * @author bodo
 */
public class menuprofe {
    
    public int profe() {
        Scanner in = new Scanner(System.in);
        System.out.println("que desea agregar");
        System.out.println("1-poner nota");
        System.out.println("2-poner anotacion");
        System.out.println("3-poner asistencia");
        System.out.println("0-salir");
        int op = in.nextInt();
        return op;   
    }
    
    public void ponernota() throws SQLException{
        Scanner in = new Scanner(System.in);
        System.out.println("ingrese el RUT del alumno: ");
        String rutal= in.nextLine();
        System.out.println("ingrese el cdigo de la asignatura: ");
        String codas= in.nextLine();
        System.out.println("ingrese la nota: ");
        String nota= in.nextLine();
        conexion con= new conexion();
        con.conectpsql();
        String insert="insert into cursa(estudiante,materia,notas) values"+
        "('"+rutal+"','"+codas+"',"+nota+")";
        con.insertaconsultasimple(insert);
        con.desconectar();
        
    }
    
    public void poneranotacion() throws SQLException{
        Scanner in = new Scanner(System.in);
        System.out.println("ingrese el RUT del alumno que desea anotar: ");//tambien podria ser el nombre
        String rutal= in.nextLine();
        System.out.println("ingrese el tipo de anotacion(positiva/negativa): ");
        String tipo= in.nextLine();
        System.out.println("ingrese la anotacion: ");
        String anotacion= in.nextLine();
        System.out.println("ingrese la fecha actual: ");
        String fecha= in.nextLine();
        System.out.print("ingrese su RUT: ");
        String rutpr= in.nextLine();
        conexion con= new conexion();
        con.conectpsql();
        String insert="insert into anotaciones(anotado,anotante,comentario,tipo,fecha) values"+
        "('"+rutal+"','"+rutpr+"','"+anotacion+"','"+tipo+"','"+fecha+"');";
        con.insertaconsultasimple(insert);
        con.desconectar();
    }
    
    public void ponerasistencia() throws SQLException{
        Scanner in = new Scanner(System.in);
        System.out.println("ingrese el RUT del alumno: ");//tambien podria ser el nombre
        String rutal= in.nextLine();
        System.out.println("ingrese el curso del alumno: ");
        String cln= in.nextLine();
        System.out.println("ingrese la asistencia(si/no): ");
        String asistencia= in.nextLine();
        System.out.println("ingrese la fecha actual: ");
        String fecha= in.nextLine();  
        conexion con= new conexion();
        con.conectpsql();
        
        String insert="insert into asistencia(alumnoa,curso,asistencia,fecha)values"+
        " ('"+rutal+"','"+cln+"','"+asistencia+"','"+fecha+"')";
        con.insertaconsultasimple(insert);
        con.desconectar();
    }
    
}
