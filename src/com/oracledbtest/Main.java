package com.oracledbtest;

import java.util.Scanner;

/**
 *
 * @author Gabriel Serrano
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner print = new Scanner(System.in);

        while (true) {
            System.out.println("Biblioteca - Gestión de Libros");
            System.out.println("1. Ver libros");
            System.out.println("2. Agregar libro");
            System.out.println("3. Actualizar libro");
            System.out.println("4. Eliminar libro");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = print.nextInt();
            print.nextLine();

            switch (opcion) {
                case 1:
                    Biblioteca.mostrarLibros();
                    break;
                case 2:
                    Biblioteca.agregarLibro();
                    break;
                case 3:
                    Biblioteca.actualizarLibro();
                    break;
                case 4:
                    Biblioteca.eliminarLibro();
                    break;
                case 5:
                    System.out.println("¡Hasta pronto!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

}
