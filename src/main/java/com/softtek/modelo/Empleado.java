package com.softtek.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Empleado {
    private int idEmpleado;
    private String Nombre;
    private String Apellidos;
    private int jefe;
    //private int fechaNacimiento;

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", Nombre='" + Nombre + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", jefe=" + jefe +
                '}';
    }
}