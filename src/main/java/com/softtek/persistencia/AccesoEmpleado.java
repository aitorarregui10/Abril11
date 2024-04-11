package com.softtek.persistencia;

import com.softtek.modelo.Empleado;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccesoEmpleado extends Conexion {

    public boolean alta(Empleado e) throws SQLException, ClassNotFoundException{
        //Declarar variables
        PreparedStatement sentencia;
        int resultado = 0;
        String sql = "INSERT INTO employees (employee_id, last_name, first_name, report_to) values (?,?,?,?);";
        //Abrir Conexion
        abrirConexion();
        //Crear statement
        sentencia = miConexion.prepareStatement(sql);
        sentencia.setInt(1,e.getIdEmpleado());
        sentencia.setString(2,e.getApellidos());
        sentencia.setString(1,e.getNombre());
        sentencia.setInt(1,e.getJefe());

        //Actualizar
        resultado = sentencia.executeUpdate();

        //Devolver el resultado
        return resultado>0;

    }

        public Statement sentencia;
        public ResultSet resultado;

        public List<Empleado> todosEmpleados () throws SQLException, ClassNotFoundException {
            abrirConexion();
            String sql = "SELECT * FROM employees;";
            List<Empleado> empleado = new ArrayList<>();
            sentencia = miConexion.createStatement();
            resultado = sentencia.executeQuery(sql);
            while(resultado.next()){
                empleado.add(new Empleado(resultado.getInt("employee_id"),
                        resultado.getString("last_name"),
                        resultado.getString("first_name"),
                        resultado.getInt("reports_to")));
            }
            return empleado;
        }


        public Empleado unEmpleado(int employee_id) throws SQLException, ClassNotFoundException {
            abrirConexion();
            String query = "SELECT * FROM employees WHERE employee_id=?;";
            PreparedStatement ps = miConexion.prepareStatement(query);
            ps.setInt(1,employee_id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                int id = rs.getInt("employee_id");
                String nombre = rs.getString("last_name");
                String apellido = rs.getString("first_name");
                int jefe = rs.getInt("reports_to");
                return new Empleado(id, nombre, apellido, jefe);
            }
            return null;
        }

        public boolean update(Empleado e) throws SQLException, ClassNotFoundException {
            abrirConexion();
            String query = "UPDATE employees SET reports_to=? WHERE employee_id=?";
            PreparedStatement sentecia = miConexion.prepareStatement(query);
            sentecia.setString(1,e.getNombre());
            sentecia.setString(2, e.getApellidos());
            sentecia.setInt(3,e.getJefe());
            sentecia.setInt(3,e.getIdEmpleado());
            return sentecia.executeUpdate() >0;
        }

        public void delete(int employee_id) throws SQLException, ClassNotFoundException {
            abrirConexion();
            String query = "DELETE FROM employees WHERE employee_id=?;";
            PreparedStatement ps = miConexion.prepareStatement(query);
            ps.setInt(1,employee_id);
            ps.executeUpdate();
        }
        
    }
