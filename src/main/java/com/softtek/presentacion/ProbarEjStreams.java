package com.softtek.presentacion;

import com.softtek.persistencia.AccesoEmpleado;
import com.softtek.persistencia.AccesoProducto;
import com.softtek.persistencia.EjStreams;

import java.sql.SQLException;

public class ProbarEjStreams {

    public static void main(String[] args) {
        AccesoProducto ap1 = new AccesoProducto();
        AccesoEmpleado ap2 = new AccesoEmpleado();

        try {
            //EjStreams.obtenerCategoria2(ap1);
            //EjStreams.obtenerComienzo(ap1);
            //EjStreams.ordenarAsc(ap1);
            //EjStreams.promedioPreciosProductos(ap1);
            //EjStreams.obtenerCategoriaYCantidad(ap1);
            EjStreams.precioMax(ap1);
            //EjStreams.findByEdad(ap2);
            //EjStreams.findCities(ap2);

        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            System.err.println("No se pudo encontrar la clase necesaria: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
