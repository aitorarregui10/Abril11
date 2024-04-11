package com.softtek.presentacion;

import com.softtek.modelo.Empleado;
import com.softtek.persistencia.AccesoEmpleado;

import java.sql.SQLException;

public class ProbarUpdate {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Crear una instancia de AccesoEmpleado
        AccesoEmpleado accesoEmpleado = new AccesoEmpleado();

        // Crear un objeto Empleado con los valores necesarios
        Empleado e = new Empleado();
        e.setIdEmpleado(4); // Establecer el ID del empleado que quieres actualizar
        e.setJefe(5);       // Establecer el ID del nuevo jefe

        // Llamar al método update de AccesoEmpleado para actualizar el empleado
        boolean actualizacionExitosa = accesoEmpleado.update(e);

        // Verificar si la actualización fue exitosa
        if (actualizacionExitosa) {
            System.out.println("La actualización del empleado con ID " + e.getIdEmpleado() + " fue exitosa.");
        } else {
            System.out.println("La actualización del empleado con ID " + e.getIdEmpleado() + " falló.");
        }
    }
}