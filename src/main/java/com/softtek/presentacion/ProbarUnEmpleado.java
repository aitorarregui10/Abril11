package com.softtek.presentacion;

import com.softtek.persistencia.AccesoEmpleado;

import java.sql.SQLException;

public class ProbarUnEmpleado {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        unEmpleado (1);
    }
    public static void unEmpleado(int employee_id) throws SQLException, ClassNotFoundException {

        AccesoEmpleado empleado = new AccesoEmpleado();
        System.out.print(empleado.unEmpleado(employee_id));
    }
}
