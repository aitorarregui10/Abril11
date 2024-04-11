package com.softtek.presentacion;

import com.softtek.persistencia.AccesoEmpleado;

import java.sql.SQLException;

public class ProbarEliminar {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        delete (1);
    }
    public static void delete(int employee_id) throws SQLException, ClassNotFoundException {

        AccesoEmpleado empleado = new AccesoEmpleado();
        empleado.delete(employee_id);
        System.out.println("El empleado con id :" + employee_id + " ha sido borrado");
    }
}