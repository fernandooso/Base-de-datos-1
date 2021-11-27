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
public class menuprincipal {
    
        public int principal() {
        Scanner in = new Scanner(System.in);
        System.out.println("como desea ingresar");
        System.out.println("1-administrador");///agrega todo
        System.out.println("2-profesor");//pone notas anotaciones asistencia etc
        System.out.println("3-profesor-apoderado");//revisa notas anotaciones asistecia del alumno
        System.out.println("0-salir");
        int op = in.nextInt();
        return op;   
    }
}
