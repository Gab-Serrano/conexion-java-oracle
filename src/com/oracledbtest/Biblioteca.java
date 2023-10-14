package com.oracledbtest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class Biblioteca {

    public Biblioteca() {
    }

    public static void mostrarLibros() throws Exception {
        String sql = "SELECT * FROM LIBRO";
        try (Connection connection = Conexion.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String titulo = resultSet.getString("TITULO");
                String autor = resultSet.getString("AUTOR");
                Date fechaPublicacion = resultSet.getDate("FECHA_PUBLICACION");
                String disponible = resultSet.getString("DISPONIBLE");
                System.out.println("ID: " + id + ", Título: " + titulo + ", Autor: " + autor + ", Fecha de Publicación: " + fechaPublicacion + ", Disponible: " + (disponible.equals("Y") ? "Sí" : "No"));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener la lista de libros: " + e.getMessage());
        }
    }

    public static void agregarLibro() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Fecha de Publicación (formato YYYY-MM-DD): ");
        String fecha = scanner.nextLine();
        System.out.print("¿Está disponible? (Y/N): ");
        String disponible = scanner.nextLine();

        try (Connection connection = Conexion.obtenerConexion()) {
            String sql = "INSERT INTO LIBRO (ID, TITULO, AUTOR, FECHA_PUBLICACION, DISPONIBLE) VALUES (LIBRO_SEQ.NEXTVAL, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, titulo);
            statement.setString(2, autor);
            statement.setString(3, fecha);
            statement.setString(4, disponible);
            statement.executeUpdate();

            System.out.println("Libro añadido exitosamente.");
            
        } catch (SQLException e) {
            System.err.println("Error al agregar el libro: " + e.getMessage());
        }
    }

    public static void actualizarLibro() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID del libro a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        System.out.print("Nuevo título (dejar en blanco para no cambiar): ");
        String titulo = scanner.nextLine();
        System.out.print("Nuevo autor (dejar en blanco para no cambiar): ");
        String autor = scanner.nextLine();
        System.out.print("Nueva fecha de publicación (formato YYYY-MM-DD o dejar en blanco para no cambiar): ");
        String fecha = scanner.nextLine();
        System.out.print("¿Está disponible? (Y/N o dejar en blanco para no cambiar): ");
        String disponible = scanner.nextLine();

        try (Connection connection = Conexion.obtenerConexion()) {
            String sql = "UPDATE LIBRO SET TITULO = COALESCE(?, TITULO), AUTOR = COALESCE(?, AUTOR), FECHA_PUBLICACION = COALESCE(TO_DATE(?, 'YYYY-MM-DD'), FECHA_PUBLICACION), DISPONIBLE = COALESCE(?, DISPONIBLE) WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, titulo.isEmpty() ? null : titulo);
            statement.setString(2, autor.isEmpty() ? null : autor);
            statement.setString(3, fecha.isEmpty() ? null : fecha);
            statement.setString(4, disponible.isEmpty() ? null : disponible);
            statement.setInt(5, id);
            statement.executeUpdate();

            System.out.println("Libro actualizado exitosamente.");
            
        } catch (SQLException e) {
            System.err.println("Error al actualizar el libro: " + e.getMessage());
        }
    }

    public static void eliminarLibro() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID del libro a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        try (Connection connection = Conexion.obtenerConexion()) {
            String sql = "DELETE FROM LIBRO WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();

            System.out.println("Libro eliminado exitosamente.");
            
        } catch (SQLException e) {
            System.err.println("Error al eliminar el libro: " + e.getMessage());
        }
    }
}