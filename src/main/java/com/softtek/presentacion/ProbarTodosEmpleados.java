package com.softtek.presentacion;

import com.softtek.modelo.Cliente;
import com.softtek.modelo.Empleado;
import com.softtek.persistencia.AccesoEmpleado;
import com.softtek.presentacion.ProbarStream;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ProbarTodosEmpleados {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        todosEmpleados();
        AccesoEmpleado empleado = new AccesoEmpleado();
    }
    public static void todosEmpleados() throws SQLException, ClassNotFoundException {
        AccesoEmpleado empleado = new AccesoEmpleado();
        System.out.print(empleado.todosEmpleados());
    }
}
