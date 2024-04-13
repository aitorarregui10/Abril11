package com.softtek.persistencia;

import com.softtek.modelo.Empleado;
import com.softtek.persistencia.AccesoEmpleado;
import com.softtek.modelo.Producto;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EjStreams {

    public static void obtenerCategoria2(AccesoProducto ap1) throws SQLException,ClassNotFoundException {

        Predicate<Producto> obtenerCategoria = x-> x.getCategoria() == 2;

        ap1.allProducts().stream()
                .filter(obtenerCategoria)
                .forEach(System.out::println);
    }

    public static void obtenerComienzo(AccesoProducto ap1) throws SQLException,ClassNotFoundException {

        Predicate<Producto> obtenerComienzo = x-> x.getNombreProducto().startsWith("N");

        ap1.allProducts().stream()
                .filter(obtenerComienzo)
                .forEach(System.out::println);
    }

    public static void precioMax(AccesoProducto ap1) throws SQLException, ClassNotFoundException {

        // Obtener el precio máximo de todos los productos
        double maxPrecio = ap1.allProducts().stream()
                .mapToDouble(Producto::getPrecioUnitario)
                .max()
                .orElse(0);

        // Filtrar los productos que tienen el precio máximo
        final double finalMaxPrecio = maxPrecio; // Crear una variable final para almacenar maxPrecio
        ap1.allProducts().stream()
                .filter(producto -> producto.getPrecioUnitario() == finalMaxPrecio)
                .forEach(System.out::println);
    }

    public static void ordenarAsc(AccesoProducto ap1) throws SQLException,ClassNotFoundException {

        List<Producto> productosOrdenados = ap1.allProducts().stream()
                        .sorted(Comparator.comparing(Producto::getNombreProducto))
                        .collect(Collectors.toList());

        productosOrdenados.forEach(System.out::println);
    }
    public static void promedioPreciosProductos(AccesoProducto ap1) throws SQLException,ClassNotFoundException {

        List<Producto> listaProductos = ap1.allProducts();

            double promedioPrecios = listaProductos.stream().mapToDouble(Producto::getPrecioUnitario).average().orElse(0);


        System.out.println(promedioPrecios);

    }
    public static void obtenerCategoriaYCantidad(AccesoProducto ap1) throws SQLException,ClassNotFoundException {

        List<Producto> listaProductos = ap1.allProducts();

        Map<Integer, Long> cantidadPorCategoria = listaProductos.stream()
                        .collect(Collectors.groupingBy(Producto::getCategoria, Collectors.counting()));
        cantidadPorCategoria.forEach((categoria, cantidad) ->
                System.out.println("Categoría " + categoria + ": " + cantidad + " productos"));

    }

/*
   public static void findByEdad(int edad) throws SQLException,ClassNotFoundException {

       List<Empleado> empleados = ap2.todosEmpleados;

       empleados = edad.read();

       LocalDate fechaLimite = LocalDate.now().minusYears(edad);

       Predicate<Empleado> jubilado = e -> {
           LocalDate fechaNac = LocalDate.parse(e.getAnyoNacimiento());
           if (fechaNac.isBefore(fechaLimite)) {
               return true;
           }
           return false;
       };
         /*
        Map<Integer, Long> cantidadPorCategoria = listaProductos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria, Collectors.counting()));
        cantidadPorCategoria.forEach((categoria, cantidad) ->
                System.out.println("Categoría " + categoria + ": " + cantidad + " productos"));

     }

       public static void findCities(AccesoEmpleado ap2) throws SQLException, ClassNotFoundException {
           List<String> ciudades = ap2.todosEmpleados(); // Obtener la lista de todas las ciudades

           System.out.println("\nDistintas ciudades: ");
           ciudades.stream()
                   .map(String::toUpperCase) // Convertir cada ciudad a mayúsculas
                   .distinct() // Eliminar duplicados
                   .forEach(System.out::println); // Imprimir cada ciudad
       }

 */
}
