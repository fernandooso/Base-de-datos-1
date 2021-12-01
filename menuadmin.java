/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba2;
import java.sql.SQLException;
import java.util.Scanner;

public class menuadmin {
    
    public int admin() {
        Scanner in = new Scanner(System.in);
        System.out.println("que desea agregar");
        System.out.println("1-alumno");
        System.out.println("2-apoderado");
        System.out.println("3-profesor");
        System.out.println("10-salir");
        int op = in.nextInt();
        return op;   
    }
    
    public void alumno() throws SQLException{
        Scanner in = new Scanner(System.in);
        System.out.println("ingrese rut: ");
        String rut = in.nextLine();
        System.out.println("ingrese nombre: ");
        String nombre = in.nextLine();
        System.out.println("ingrese segundo nombre: ");
        String s_nombre = in.nextLine();
        System.out.println("ingrese apellido paterno: ");
        String ap = in.nextLine();
        System.out.println("ingrese apellido materno: ");
        String am = in.nextLine();
        System.out.println("ingrese direccion: ");
        String dir = in.nextLine();
        System.out.println("ingrese sexo: ");
        String sex = in.nextLine();
        System.out.println("ingrese fecha de nacimiento: ");
        String fnac = in.nextLine();
       conexion con= new conexion();
        con.conectpsql();
        String insert1="insert into persona"+
                "(rut, nombre, nombre_s, apellido_p,apellido_m,direccion,sexo,f_nac)"+
                " values ('"+rut+"','"+nombre+"','"+s_nombre+"','"+ap+"','"+am+"','"+dir+"','"+sex+"','"+fnac+"');"; 
        String insert2="insert into alumno(rut_alumno) values('"+rut+"')";
        con.insertaconsultadoble(insert1,insert2);
        con.desconectar();
    }
    
    public void apoderado() throws SQLException{
        Scanner in = new Scanner(System.in);
        System.out.println("ingrese rut: ");
        String rut = in.nextLine();
        System.out.println("ingrese nombre: ");
        String nombre = in.nextLine();
        System.out.println("ingrese segundo nombre: ");
        String s_nombre = in.nextLine();
        System.out.println("ingrese apellido paterno: ");
        String ap = in.nextLine();
        System.out.println("ingrese apellido materno: ");
        String am = in.nextLine();
        System.out.println("ingrese direccion: ");
        String dir = in.nextLine();
        System.out.println("ingrese sexo: ");
        String sex = in.nextLine();
        System.out.println("ingrese fecha de nacimiento: ");
        String fnac = in.nextLine(); 
        System.out.println("ingrese el tipo de apoderado(principal/suplente): ");
        String tipo = in.nextLine();

        conexion con= new conexion();
        con.conectpsql();
        String insert1="insert into persona"+
                "(rut, nombre, nombre_s, apellido_p,apellido_m,direccion,sexo,f_nac)"+
                " values ('"+rut+"','"+nombre+"','"+s_nombre+"','"+ap+"','"+am+"','"+dir+"','"+sex+"','"+fnac+"');"; 
        String insert2 ="insert into apoderado(rut_apoderado,tipo) values ('"+rut+"','"+tipo+"');";
        con.insertaconsultadoble(insert1, insert2);
        con.desconectar();
    }
    
    public void profesor() throws SQLException{
        Scanner in = new Scanner(System.in);
        System.out.println("ingrese rut: ");
        String rut = in.nextLine();
        System.out.println("ingrese nombre: ");
        String nombre = in.nextLine();
        System.out.println("ingrese segundo nombre: ");
        String s_nombre = in.nextLine();
        System.out.println("ingrese apellido paterno: ");
        String ap = in.nextLine();
        System.out.println("ingrese apellido materno: ");
        String am = in.nextLine();
        System.out.println("ingrese direccion: ");
        String dir = in.nextLine();
        System.out.println("ingrese sexo: ");
        String sex = in.nextLine();
        System.out.println("ingrese fecha de nacimiento: ");
        String fnac = in.nextLine(); 
        System.out.println("ingrese especialidad: ");
        String esp = in.nextLine();
        System.out.println("ingrese jefatura ");
        String jef = in.nextLine();
        System.out.println("ingrese fecha de jefatura: ");
        String fejef = in.nextLine(); 
        conexion con= new conexion();
        con.conectpsql();
        String insert1="insert into persona(rut, nombre, nombre_s, apellido_p,apellido_m,direccion,sexo,f_nac) values ('"+rut+"','"+nombre+"','"+s_nombre+"','"+ap+"','"+am+"','"+dir+"','"+sex+"','"+fnac+"');"; 
        String insert2="insert into profesor (rut_profesor, jefatura, especialidad, fecha_jefatura) values ('"+rut+"','"+jef+"','"+esp+"','"+fejef+"')";
        con.insertaconsultadoble(insert1, insert2);
        con.desconectar();
    }
    
}
